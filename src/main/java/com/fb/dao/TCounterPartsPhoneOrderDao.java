package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCounterPartsPhoneOrder;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月20日 下午5:49:12
 * 同行手机单据接口
 */
public interface TCounterPartsPhoneOrderDao {
    
    /**
     * 新增 同行手机单据
     * @param order
     * @return
     * @author Liu bo
     */
    public int add(TCounterPartsPhoneOrder order);
    
    /**
     * 删除 同行手机单据
     * @param uid
     * @return
     * @author Liu bo
     */
    public int del(String uid);
    
    /**
     * 修改 同行手机单据
     * @param order
     * @return
     * @author Liu bo
     */
    public int mod(TCounterPartsPhoneOrder order);
    
    /**
     * 修改 同行手机单据状态
     * @param uid
     * @param istatus {@value 0 = 未审核}{@value 1 = 已审核}
     * @return
     * @author Liu bo
     */
    public int modStatus(String uid,Integer istatus);
    
    /**
     * 获取 同行手机单据信息
     * @param uid
     * @return
     * @author Liu Bo
     */
    public TCounterPartsPhoneOrder get(String uid);
    
    /**
     * 获取 同行手机单据信息集合
     * @param order
     * @return
     * @author Liu Bo
     */
    public List<TCounterPartsPhoneOrder> get(TCounterPartsPhoneOrder order);
}
