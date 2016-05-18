package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.dao.TModuleGroupDao;
import com.fb.domain.po.TModuleGroup;

@Service
public class TModuleGroupDaoImpl extends SimpMapper<TModuleGroup>implements TModuleGroupDao {
    
    public int add(TModuleGroup moduleGroup) {
        return super.save(moduleGroup);
    }
    
    public int del(String uid) {
        return super.delete(uid);
    }
    
    public int modify(TModuleGroup moduleGroup) {
        return super.update(moduleGroup);
    }
    
    public List<TModuleGroup> getModuleGroupJSON() {
        String sql = "select * from t_module_group";
        return findList(sql, null);
    }
    
}
