package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCustomerPhoneOrderReceipts;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月2日 上午11:12:12
 * 客户手机单据的[应收/应付]对应的[实收/实付]接口
 */
public interface TCustomerPhoneOrderReceiptsDao {
    
    /**
     * 新增 实收实付信息
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int add(TCustomerPhoneOrderReceipts receipts);
    
    /**
     * 删除 实收实付信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public int del(String uid);
    
    /**
     * 删除 根据应收应付删除对应的实收实付信息
     * @param ureceivableid
     * @return
     * @author Liu bo
     */
    public int delByReceivable(String ureceivableid);
    
    /**
     * 修改 实收实付信息
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int mod(TCustomerPhoneOrderReceipts receipts);
    
    /**
     * 修改 实收实付信息状态
     * @param uid
     * @param istatus {@value 0=未结算/1=已结算}
     * @return
     * @author Liu bo
     */
    public int modStatus(String uid,int istatus);
    
    /**
     * 获取 实收实付信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public TCustomerPhoneOrderReceipts get(String uid);
    
    /**
     * 获取 根据单据获取对应的实收实付集合
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public List<TCustomerPhoneOrderReceipts> getByOrder(String uorderid);
    
    /**
     * 获取 根据应收应付获取对应的实收实付信息集合
     * @param ureceivableid
     * @return
     * @author Liu bo
     */
    public List<TCustomerPhoneOrderReceipts> getByReceivable(String ureceivableid);
    
    /**
     * 获取 根据应收应付获取指定状态下实收实付的数量
     * @param ureceivableid
     * @param istatus
     * @return
     * @author Liu bo
     */
    public int getStatusNumByReceivable(String ureceivableid,int istatus);
    
    /**
     * 获取 实收实付信息集合
     * @param receipts
     * @return
     * @author Liu bo
     */
    public List<TCustomerPhoneOrderReceipts> get(TCustomerPhoneOrderReceipts receipts);
}
