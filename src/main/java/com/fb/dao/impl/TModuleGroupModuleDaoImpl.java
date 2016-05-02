package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TModuleGroupModuleDao;
import com.fb.domain.po.TModuleGroupModule;

@Service
public class TModuleGroupModuleDaoImpl extends SimpMapper<TModuleGroupModule>implements TModuleGroupModuleDao {

	public int addModuleGroupModule(TModuleGroupModule moduleGroupModule) {
		return save(moduleGroupModule);
	}

	public List<TModuleGroupModule> getModuleGroupModuleByModuleGroupId(String umodulegroupid) {
		String sql = "select * from t_module_group_module where umodulegroupid = :umodulegroupid";
		return findList(sql, new QMap("umodulegroupid", umodulegroupid));
	}

	public int getModuleGroupModuleCountByUModuleId(String umoduleid) {
		String sql = "select count(*) from t_module_group_module where umoduleid = :umoduleid";
		return getInt(sql, new QMap("umoduleid",umoduleid));
	}

}
