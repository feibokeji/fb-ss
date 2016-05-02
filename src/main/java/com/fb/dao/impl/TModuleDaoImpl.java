package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
