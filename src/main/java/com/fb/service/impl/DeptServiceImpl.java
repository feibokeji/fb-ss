package com.fb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TDeptDao;
import com.fb.domain.po.TDept;
import com.fb.service.DeptService;
import com.fb.service.SimpServiceAbstract;

@Service
public class DeptServiceImpl extends SimpServiceAbstract implements DeptService {
    
    @Autowired
    private TDeptDao deptDao;
    
    public TDept getDeptByUid(String uid) {
        return deptDao.getDeptByUid(uid);
    }
    
}
