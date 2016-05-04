package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TMaterialDao;
import com.fb.domain.po.TMaterial;
import com.fb.service.MaterialService;
import com.fb.service.SimpServiceAbstract;

/**
 * 物料类控制
 * @since 2016年5月3日 下午4:30:23
 * @author Liu bo
 */
@Service
public class MaterialServiceImpl extends SimpServiceAbstract implements MaterialService {
    
    @Autowired
    private TMaterialDao materialDao;
    
    @Transactional
    public synchronized int add(TMaterial material) {
        return materialDao.add(material);
    }
    
    @Transactional
    public synchronized int delete(String uid) {
        return materialDao.delete(uid);
    }
    
    @Transactional
    public synchronized int update(TMaterial material) {
        return materialDao.update(material);
    }
    
    public List<TMaterial> getMaterialList() {
        return materialDao.getMaterialList();
    }
    
}
