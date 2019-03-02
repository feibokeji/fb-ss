package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCustomerOrder;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月1日 下午7:50:41
 * 客户商品单据接口
 */
public interface TCustomerOrderDao {
    
    /**
     * 新增 客户商品单据
     * @param order
     * @return
     * @author Liu bo
     */
    public int add(TCustomerOrder order);
    
    /**
     * 删除 客户商品单据
     * @param uid
     * @return
     * @author Liu bo
     */
    public int del(String uid);
    
    /**
     * 修改 客户商品单据
     * @param order
     * @return
     * @author Liu bo
     */
    public int mod(TCustomerOrder order);
    
    /**
     * 修改 客户商品单据状态
     * @param uid
     * @param istatus
     * @return
     * @author Liu bo
     */
    public int modStatus(String uid,int istatus);
    
    /**
     * 获取 客户商品单据
     * @param uid
     * @return
     * @author Liu bo
     */
    public TCustomerOrder get(String uid);
    
    /**
     * 获取 客户商品单据集合
     * @param order
     * @return
     * @author Liu bo
     */
    public List<TCustomerOrder> get(TCustomerOrder order);
}
