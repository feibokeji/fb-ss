package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TOrderProductDao;
import com.fb.domain.po.TOrderProduct;
import com.fb.service.SimpServiceAbstract;

@Service
public class OrderProductServiceImpl extends SimpServiceAbstract implements com.fb.service.OrderProductService {
    
    @Autowired
    private TOrderProductDao orderProductDao;
    
    @Transactional
    public synchronized int addOrderProduct(TOrderProduct orderProduct) {
        return orderProductDao.addOrderProduct(orderProduct);
    }
    
    @Transactional
    public synchronized int deleteOrderProductByUid(String uid) {
        return orderProductDao.deleteOrderProductByUid(uid);
    }
    
    @Transactional
    public synchronized int deleteOrderProductByUOrderId(String uorderid) {
        return orderProductDao.deleteOrderProductByUOrderId(uorderid);
    }
    
    @Transactional
    public synchronized int updateOrderProduct(TOrderProduct orderProduct) {
        return orderProductDao.updateOrderProduct(orderProduct);
    }
    
    public TOrderProduct getOrderProduct(String uid) {
        return orderProductDao.getOrderProduct(uid);
    }
    
    public List<TOrderProduct> getOrderProductList(String uorderid) {
        return orderProductDao.getOrderProductList(uorderid);
    }
    
}
