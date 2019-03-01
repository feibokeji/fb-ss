package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCounterPartsPhoneReceivable;

/**
 * @author 作者：Liu Bo
 * @version 创建时间：2019年2月24日 上午11:15:47
 * 同行手机单据应收应付表接口
 */
public interface TCounterPartsPhoneReceivableDao {
    
    /**
     * 新增 应收应付信息
     * @param receivable
     * @return
     * @author Liu Bo
     */
    public int add(TCounterPartsPhoneReceivable receivable);
    
    /**
     * 删除 应收应付信息
     * @param uorderid 单据表外检
     * @return
     * @author Liu Bo
     */
    public int del(String uorderid);
    
    /**
     * 修改 应收应付信息
     * @param receivable
     * @return
     * @author Liu Bo
     */
    public int mod(TCounterPartsPhoneReceivable receivable);
    
    /**
     * 修改 应收应付信息状态
     * @param uid
     * @param istatus
     * @return
     * @author Liu Bo
     */
    public int modStatus(String uid,int istatus);
    
    /**
     * 获取 应收应付信息
     * @param uid
     * @return
     * @author Liu Bo
     */
    public TCounterPartsPhoneReceivable get(String uid);
    
    /**
     * 获取 单据应收应付集合
     * @param uorderid
     * @return
     * @author Liu Bo
     */
    public List<TCounterPartsPhoneReceivable> getByUorderid(String uorderid);
    
    /**
     * 获取 应收应付信息集合
     * @param receivable
     * @return
     * @author Liu Bo
     */
    public List<TCounterPartsPhoneReceivable> get(TCounterPartsPhoneReceivable receivable);
}
