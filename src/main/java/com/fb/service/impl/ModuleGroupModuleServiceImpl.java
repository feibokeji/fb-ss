package com.fb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TModuleGroupModuleDao;
import com.fb.service.ModuleGroupModuleService;
import com.fb.service.SimpServiceAbstract;

@Service
public class ModuleGroupModuleServiceImpl extends SimpServiceAbstract implements ModuleGroupModuleService {
	
	@Autowired
	private TModuleGroupModuleDao moduleGroupModuleDao;
	
	public int getModuleGroupModuleCountByUModuleId(String umoduleid) {
		return moduleGroupModuleDao.getModuleGroupModuleCountByUModuleId(umoduleid);
	}

}
