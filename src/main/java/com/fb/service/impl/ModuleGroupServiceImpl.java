package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TModuleGroupDao;
import com.fb.domain.po.TModuleGroup;
import com.fb.service.ModuleGroupService;
import com.fb.service.SimpServiceAbstract;

@Service
public class ModuleGroupServiceImpl extends SimpServiceAbstract implements ModuleGroupService {
    
    @Autowired
    private TModuleGroupDao moduleGroupDao;
    
    @Transactional
    public synchronized int add(TModuleGroup moduleGroup) {
        return moduleGroupDao.add(moduleGroup);
    }
    
    @Transactional
    public synchronized int del(String uid) {
        return moduleGroupDao.del(uid);
    }
    
    @Transactional
    public synchronized int modify(TModuleGroup moduleGroup) {
        return moduleGroupDao.modify(moduleGroup);
    }
    
    public List<TModuleGroup> getModuleGroupJSON() {
        return moduleGroupDao.getModuleGroupJSON();
    }
    
}
