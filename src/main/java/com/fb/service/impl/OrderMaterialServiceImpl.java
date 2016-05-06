package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TOrderMaterialDao;
import com.fb.domain.po.TOrderMaterial;
import com.fb.service.SimpServiceAbstract;

@Service
public class OrderMaterialServiceImpl extends SimpServiceAbstract implements com.fb.service.OrderMaterialService {
    
    @Autowired
    private TOrderMaterialDao orderMaterialDao;
    
    @Transactional
    public synchronized int addOrderMaterial(TOrderMaterial orderMaterial) {
        return orderMaterialDao.addOrderMaterial(orderMaterial);
    }
    
    @Transactional
    public synchronized int deleteOrderMaterialByUid(String uid) {
        return orderMaterialDao.deleteOrderMaterialByUid(uid);
    }
    
    @Transactional
    public synchronized int deleteOrderMaterialByUOrderId(String uorderid) {
        return orderMaterialDao.deleteOrderMaterialByUOrderId(uorderid);
    }
    
    @Transactional
    public synchronized int updateOrderMaterial(TOrderMaterial orderMaterial) {
        return orderMaterialDao.updateOrderMaterial(orderMaterial);
    }
    
    public TOrderMaterial getOrderMaterial(String uid) {
        return orderMaterialDao.getOrderMaterial(uid);
    }
    
    public List<TOrderMaterial> getOrderMaterialList(String uorderid) {
        return orderMaterialDao.getOrderMaterialList(uorderid);
    }
    
}
