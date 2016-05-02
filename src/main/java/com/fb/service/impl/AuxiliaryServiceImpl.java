package com.fb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.AuxiliaryDao;
import com.fb.service.AuxiliaryService;
import com.fb.service.SimpServiceAbstract;

@Service
public class AuxiliaryServiceImpl extends SimpServiceAbstract implements AuxiliaryService {
    
    @Autowired
    private AuxiliaryDao auxiliaryDao;
    
    public synchronized Boolean checkDataRepeat(String table, String column, String value) {
        int count = auxiliaryDao.checkDataRepeat(table, column, value);
        if (count > 0)
            return true;
        else
            return false;
    }
    
}
