package com.fb.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.FormatUtils;
import com.fb.dao.TCategoryDao;
import com.fb.dao.TOperateLogDao;
import com.fb.dao.TOrderDao;
import com.fb.dao.TOrderMaterialDao;
import com.fb.dao.TOrderProductDao;
import com.fb.dao.TProductDao;
import com.fb.domain.po.TCategory;
import com.fb.domain.po.TOperateLog;
import com.fb.domain.po.TOrder;
import com.fb.domain.po.TOrderMaterial;
import com.fb.domain.po.TOrderProduct;
import com.fb.domain.po.TProduct;
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
    
    @Autowired
    private TProductDao productDao;
    
    @Autowired
    private TCategoryDao categoryDao;
    
    @Transactional
    public synchronized boolean addOrderMaterial(TOrder order, TUser user, TOperateLog log) {
        order.setUid(DataUtils.newUUID());
        String cno = FormatUtils.formatDate(order.getDordertime(), "yyyy-MM-dd") + "-" + FormatUtils.formatDate(new Date(), "HH-mm-ss");
        order.setCno(cno);
        //order.setCtype("00");
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
        order.setCno(FormatUtils.formatDate(new Date(), "yyyy-MM-dd-HH-mm-ss"));
        order.setUuserid(user.getUid());
        order.setCusername(user.getCname());
        order.setCtype("01");
        order.setCstatus("00");
        order.setDcreatetime(new Date());
        order.setDupdatetime(new Date());
        
        log.setCtype("新增");
        log.setClinktable("t_order");
        log.setUlinktableid(order.getUid());
        log.setCstatus("00");
        log.setCmemo("新增产品入库数据");
        
        // 存储需要插入数据库的数据
        List<TCategory> categoryList = new ArrayList<TCategory>();
        List<TProduct> productList = new ArrayList<TProduct>();
        List<TOrderProduct> list = new ArrayList<TOrderProduct>();
        
        int categoryNo = 1;
        for (TOrderProduct item : order.getOrderProductDetailList()) {
            if (!DataUtils.isNullOrEmpty(item.getCproductname())) {
                
                List<TProduct> p_list = this.productDao.getProductByName(item.getCproductname());
                
                if (p_list != null && p_list.size() > 0) {// 已经更新过此软件数据库产品数据
                    TProduct p = null;
                    for (TProduct product : p_list) {
                        if (item.getCproductno().equals(product.getCno())) {
                            p = product;
                        }
                    }
                    if (p == null) {
                        for (TProduct product : p_list) {
                            for (TOrderProduct t : list) {
                                if (!product.getCno().equals(t.getCproductno())) {
                                    p = product;
                                }
                            }
                        }
                        item.setUid(DataUtils.newUUID());
                        item.setUorderid(order.getUid());
                        item.setUproductid(p.getUid());
                        list.add(item);
                    } else {
                        item.setUid(DataUtils.newUUID());
                        item.setUorderid(order.getUid());
                        item.setUproductid(p.getUid());
                        list.add(item);
                    }
                } else {// 未更新此软件数据库产品数据
                    TProduct newProduct = new TProduct();
                    newProduct.setUid(DataUtils.newUUID());
                    newProduct.setCno(item.getCproductno());
                    newProduct.setCname(item.getCproductname());
                    
                    TCategory _category = categoryDao.getCategoryByName(item.getCcategoryname());
                    if (_category != null) {
                        newProduct.setUcategoryid(_category.getUid());
                    } else {
                        boolean isC = false;
                        String ucategoryid = "";
                        for (TCategory c : categoryList) {
                            if (item.getCcategoryname().equals(c.getCname())) {
                                isC = true;
                                ucategoryid = c.getUid();
                            }
                        }
                        if (!isC) {
                            _category = new TCategory();
                            _category.setUid(DataUtils.newUUID());
                            String[] c_k = {"0","00","000","0000","00000","000000","0000000","00000000","000000000","0000000000"};
                            int max = 5;
                            String c_no = c_k[max-String.valueOf(categoryNo).length()] + FormatUtils.formatDate(new Date(), "yyMMdd") + String.valueOf(categoryNo);
                            _category.setCno(c_no);
                            _category.setCname(item.getCcategoryname());
                            newProduct.setUcategoryid(_category.getUid());
                            categoryList.add(_category);
                        } else {
                            newProduct.setUcategoryid(ucategoryid);
                        }
                    }
                    
                    newProduct.setCcategoryname(item.getCcategoryname());
                    double _price = item.getNsamount() / item.getNsqty();
                    newProduct.setNprice((new BigDecimal(_price)).setScale(0, BigDecimal.ROUND_UP).doubleValue());
                    productList.add(newProduct);
                    
                    item.setUid(DataUtils.newUUID());
                    item.setUorderid(order.getUid());
                    item.setUproductid(newProduct.getUid());
                    list.add(item);
                }
            }
            categoryNo++;
        }
        try {
            orderDao.addOrder(order);
            for (TCategory item : categoryList) {
                categoryDao.add(item);
            }
            for (TProduct item : productList) {
                productDao.addProduct(item);
            }
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
        orderMaterialDao.deleteOrderMaterialByUOrderId(uid);
        orderProductDao.deleteOrderProductByUOrderId(uid);
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
