package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TModuleDao;
import com.fb.domain.po.TModule;

@Service
public class TModuleDaoImpl extends SimpMapper<TModule>implements TModuleDao {

	public int addModule(TModule module) {
		return save(module);
	}

	public TModule getModuleByUid(String uid) {
		return get(uid);
	}

	public List<TModule> getModuleList() {
		String sql = "select * from t_module order by ccodepath asc,ctype";
		return findList(sql, null);
	}

	public int deleteModule(String uid) {
		return delete(uid);
	}

    public List<TModule> getModuleListJSON(String umodulegroupid) {
        String sql = "select t.uid,t.ctype,t.ccode,t.cname,t.cparent,t.ilevel,t.isort,t.ccodepath,t.caddr,(select count(*) from t_module_group_module mgm where mgm.umoduleid = t.uid and mgm.umodulegroupid = :umodulegroupid) as haveGroup from t_module t order by t.ccodepath asc,t.ctype";
        return findList(sql, new QMap("umodulegroupid",umodulegroupid));
    }

}
