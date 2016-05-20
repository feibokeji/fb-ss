package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TModuleDao;
import com.fb.domain.po.TModule;
import com.fb.service.ModuleService;
import com.fb.service.SimpServiceAbstract;
@Service
public class ModuleServiceImpl extends SimpServiceAbstract implements ModuleService {
	
	@Autowired
	private TModuleDao moduleDao;
	
	@Transactional
	public synchronized int addModule(TModule module) {
		return moduleDao.addModule(module);
	}

	public TModule getModuleByUid(String uid) {
		return moduleDao.getModuleByUid(uid);
	}

	public List<TModule> getModuleList() {
		List<TModule> moduleList = moduleDao.getModuleList();
		return moduleList;
	}
	
	@Transactional
	public synchronized int deleteModule(String uid) {
		return moduleDao.deleteModule(uid);
	}

    public List<TModule> getModuleListJSON(String umodulegroupid) {
        return moduleDao.getModuleListJSON(umodulegroupid);
    }

    public TModule getParentModuleByCCode(String ccode) {
        return moduleDao.getParentModuleByCCode(ccode);
    }

}
