package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCustomerPhoneOrder;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月2日 上午11:10:45
 * 客户手机单据接口
 */
public interface TCustomerPhoneOrderDao {
    
    /**
     * 新增 客户手机单据
     * @param order
     * @return
     * @author Liu bo
     */
    public int add(TCustomerPhoneOrder order);
    
    /**
     * 删除 客户手机单据
     * @param uid
     * @return
     * @author Liu bo
     */
    public int del(String uid);
    
    /**
     * 修改 客户手机单据
     * @param order
     * @return
     * @author Liu bo
     */
    public int mod(TCustomerPhoneOrder order);
    
    /**
     * 修改 客户手机单据状态
     * @param uid
     * @param istatus {@value 0=未审核/1=已审核}
     * @return
     * @author Liu bo
     */
    public int modStatus(String uid,int istatus);
    
    /**
     * 获取 客户手机单据
     * @param uid
     * @return
     * @author Liu bo
     */
    public TCustomerPhoneOrder get(String uid);
    
    /**
     * 获取 客户手机单据集合
     * @param order
     * @return
     * @author Liu bo
     */
    public List<TCustomerPhoneOrder> get(TCustomerPhoneOrder order);
}
