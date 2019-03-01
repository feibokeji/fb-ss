package com.fb.service;

import java.util.List;

import com.fb.domain.po.TCounterPartsPhoneReceipts;

/**
 * @author 作者：Liu Bo
 * @version 创建时间：2019年2月24日 下午2:48:37
 * 同行手机单据实收实付服务接口
 */
public interface CounterPartsPhoneReceiptsService {
    
    /**
     * 新增 实收实付信息
     * @param receipts
     * @return
     * @author Liu Bo
     */
    public int add(TCounterPartsPhoneReceipts receipts);
    
    /**
     * 删除 实收实付信息
     * @param uid
     * @return
     * @author Liu Bo
     */
    public int del(String uid);
    
    /**
     * 删除 应收应付对应的实收实付信息
     * @param ureceivableid
     * @return
     * @author Liu Bo
     */
    public int delByUreceivableid(String ureceivableid);
    
    /**
     * 修改 实收实付信息
     * @param receipts
     * @return
     * @author Liu Bo
     */
    public int mod(TCounterPartsPhoneReceipts receipts);
    
    /**
     * 修改 实收实付状态
     * @param uid
     * @param istatus
     * @return
     * @author Liu Bo
     */
    public int modStatus(String uid,int istatus);
    
    /**
     * 获取 实收实付信息
     * @param uid
     * @return
     * @author Liu Bo
     */
    public TCounterPartsPhoneReceipts get(String uid);
    
    /**
     * 获取 根据应收应付获取实收实付信息集合
     * @param ureceivableid
     * @return
     * @author Liu Bo
     */
    public List<TCounterPartsPhoneReceipts> getByUreceivableid(String ureceivableid);
    
    /**
     * 获取 实收实付信息集合
     * @param receipts
     * @return
     * @author Liu Bo
     */
    public List<TCounterPartsPhoneReceipts> get(TCounterPartsPhoneReceipts receipts);
    
    /**
     * 获取 单据实收实付数量
     * @param uorderid
     * @return
     * @author Liu Bo
     */
    public int getOrderReceiptsNum(String uorderid);
}
