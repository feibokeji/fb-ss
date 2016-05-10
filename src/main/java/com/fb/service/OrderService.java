package com.fb.service;

import java.util.List;

import com.fb.domain.po.TOperateLog;
import com.fb.domain.po.TOrder;
import com.fb.domain.po.TUser;

/**
 * 订单操作
 * @since 2016年5月6日 下午5:26:23
 * @author Liu bo
 */
public interface OrderService {
    
    /**
     * 新增物料订单
     * @param order
     * @return
     * @author Liu bo
     */
    public boolean addOrderMaterial(TOrder order, TUser user, TOperateLog log);
    
    /**
     * 修改物料订单
     * @param order
     * @return
     * @author Liu bo
     */
    public boolean updateOrderMaterial(TOrder order, TUser user, TOperateLog log);
    
    /**
     * 新增产品订单
     * @param order
     * @return
     * @author Liu bo
     */
    public boolean addOrderProduct(TOrder order, TUser user, TOperateLog log);
    
    /**
     * 删除订单
     * @param uid
     * @return
     * @author Liu bo
     */
    public int deleteOrder(String uid);
    
    /**
     * 更新订单
     * @param order
     * @return
     * @author Liu bo
     */
    public int updateOrder(TOrder order);
    
    /**
     * 获取订单
     * @param uid
     * @return
     * @author Liu bo
     */
    public TOrder getOrder(String uid);
    
    /**
     * 获取订单列表
     * @param order
     * @return
     * @author Liu bo
     */
    public List<TOrder> getOrderList(TOrder order);
    
    /**
     * @param uid
     * @param cstatus
     * @return
     * @author Liu bo
     */
    public int auditOrder(String uid, String cstatus);
}
