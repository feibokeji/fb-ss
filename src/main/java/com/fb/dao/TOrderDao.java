package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TOrder;

/**
 * 订单操作类
 * @since 2016年5月6日 下午4:24:05
 * @author Liu bo
 */
public interface TOrderDao {
    
    /**
     * 新增订单
     * @param order
     * @return
     * @author Liu bo
     */
    public int addOrder(TOrder order);
    
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
}
