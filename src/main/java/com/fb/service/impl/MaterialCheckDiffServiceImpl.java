package com.fb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TMaterialCheckDiffDao;
import com.fb.domain.po.TMaterialCheckDiff;
import com.fb.service.MaterialCheckDiffService;
import com.fb.service.SimpServiceAbstract;

@Service
public class MaterialCheckDiffServiceImpl extends SimpServiceAbstract implements MaterialCheckDiffService {
    
    @Autowired
    private TMaterialCheckDiffDao materialCheckDiffDao;
    
    public int addMaterialCheckDiff(TMaterialCheckDiff diff) {
        return materialCheckDiffDao.addMaterialCheckDiff(diff);
    }

    public int getMaterialCheckDiffByUOrderId(String uorderid) {
        return materialCheckDiffDao.getMaterialCheckDiffByUOrderId(uorderid);
    }
    
}
