package com.fb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.FormatUtils;
import com.fb.dao.TOperateLogDao;
import com.fb.dao.TOrderDao;
import com.fb.dao.TOrderMaterialDao;
import com.fb.dao.TOrderProductDao;
import com.fb.domain.po.TOperateLog;
import com.fb.domain.po.TOrder;
import com.fb.domain.po.TOrderMaterial;
import com.fb.domain.po.TOrderProduct;
import com.fb.domain.po.TUser;
import com.fb.service.OrderService;
import com.fb.service.SimpServiceAbstract;

@Service
public class OrderServiceImpl extends SimpServiceAbstract implements OrderService {
    
    @Autowired
    private TOrderDao orderDao;
    
    @Autowired
    private TOrderMaterialDao orderMaterialDao;
    
    @Autowired
    private TOrderProductDao orderProductDao;
    
    @Autowired
    private TOperateLogDao operateLogDao;
    
    @Transactional
    public synchronized boolean addOrderMaterial(TOrder order, TUser user, TOperateLog log) {
        order.setUid(DataUtils.newUUID());
        String cno = FormatUtils.formatDate(order.getDordertime(), "yyyyMMdd") + FormatUtils.formatDate(new Date(), "HHmmss");
        order.setCno(cno);
        order.setCtype("00");
        order.setDcreatetime(new Date());
        order.setDupdatetime(new Date());
        log.setCtype("新增");
        log.setClinktable("t_order");
        log.setUlinktableid(order.getUid());
        log.setCstatus(order.getCstatus());
        log.setCmemo("新增物料入库数据");
        List<TOrderMaterial> list = new ArrayList<TOrderMaterial>();
        int i = 0;
        for (TOrderMaterial item : order.getOrderMaterialDetailList()) {
            if (DataUtils.isUid(item.getUmaterialid()) && !DataUtils.isNullOrEmpty(item.getCmaterialname())) {
                i++;
                item.setUid(DataUtils.newUUID());
                item.setUorderid(order.getUid());
                System.out.println("----" + item.getNprice());
                item.setIsort(i);
                list.add(item);
            }
        }
        try {
            orderDao.addOrder(order);
            for (TOrderMaterial item : list) {
                orderMaterialDao.addOrderMaterial(item);
            }
            operateLogDao.addOperateLog(log);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Transactional
    public synchronized boolean updateOrderMaterial(TOrder order, TUser user, TOperateLog log) {
        order.setDupdatetime(new Date());
        log.setCtype("修改");
        log.setClinktable("t_order");
        log.setUlinktableid(order.getUid());
        log.setCstatus(order.getCstatus());
        log.setCmemo("修改物料入库数据");
        List<TOrderMaterial> addList = new ArrayList<TOrderMaterial>();
        int i = 0;
        for (TOrderMaterial item : order.getOrderMaterialDetailList()) {
            if (DataUtils.isUid(item.getUmaterialid()) && !DataUtils.isNullOrEmpty(item.getCmaterialname())) {
                i++;
                item.setUid(DataUtils.newUUID());
                item.setUorderid(order.getUid());
                item.setIsort(i);
                addList.add(item);
            }
        }
        try {
            orderDao.updateOrder(order);
            orderMaterialDao.deleteOrderMaterialByUOrderId(order.getUid());
            for (TOrderMaterial item : addList) {
                orderMaterialDao.addOrderMaterial(item);
            }
            operateLogDao.addOperateLog(log);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Transactional
    public synchronized boolean addOrderProduct(TOrder order, TUser user, TOperateLog log) {
        order.setUid(DataUtils.newUUID());
        String cno = FormatUtils.formatDate(new Date(), "yyyyMMddHHmmss");
        order.setCno(cno);
        order.setCtype("00");
        order.setCstatus("00");
        order.setDcreatetime(new Date());
        order.setDupdatetime(new Date());
        log.setCtype("00");
        log.setClinktable("t_order");
        log.setUlinktableid(order.getUid());
        log.setCstatus("00");
        log.setCmemo("新增产品入库数据");
        List<TOrderProduct> list = new ArrayList<TOrderProduct>();
        int i = 0;
        for(TOrderProduct item : order.getOrderProductDetailList()){
            if (DataUtils.isUid(item.getUproductid()) && !DataUtils.isNullOrEmpty(item.getCproductname())) {
                i++;
                item.setUid(DataUtils.newUUID());
                item.setUorderid(order.getUid());
                item.setIsort(i);
                list.add(item);
            }
        }
        try {
            orderDao.addOrder(order);
            for (TOrderProduct item : list) {
                orderProductDao.addOrderProduct(item);
            }
            operateLogDao.addOperateLog(log);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Transactional
    public synchronized int deleteOrder(String uid) {
        return orderDao.deleteOrder(uid);
    }
    
    @Transactional
    public synchronized int updateOrder(TOrder order) {
        return orderDao.updateOrder(order);
    }
    
    public TOrder getOrder(String uid) {
        return orderDao.getOrder(uid);
    }
    
    public List<TOrder> getOrderList(TOrder order) {
        return orderDao.getOrderList(order);
    }

    @Transactional
    public synchronized int auditOrder(String uid, String cstatus) {
        return orderDao.auditOrder(uid, cstatus);
    }
    
}
