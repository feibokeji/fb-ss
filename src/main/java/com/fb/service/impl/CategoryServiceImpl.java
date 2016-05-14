package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TCategoryDao;
import com.fb.domain.po.TCategory;
import com.fb.service.CategoryService;
import com.fb.service.SimpServiceAbstract;

@Service
public class CategoryServiceImpl extends SimpServiceAbstract implements CategoryService {
    
    @Autowired
    private TCategoryDao categoryDao;
    
    @Transactional
    public synchronized int add(TCategory category) {
        return categoryDao.add(category);
    }
    
    @Transactional
    public synchronized int delete(String uid) {
        return categoryDao.delete(uid);
    }
    
    @Transactional
    public synchronized int update(TCategory category) {
        return categoryDao.update(category);
    }
    
    public List<TCategory> getCategoryList() {
        return categoryDao.getCategoryList();
    }

    public TCategory getCategoryByName(String cname) {
        return categoryDao.getCategoryByName(cname);
    }
    
}
