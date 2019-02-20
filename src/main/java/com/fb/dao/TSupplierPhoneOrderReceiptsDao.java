package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TSupplierPhoneOrderReceipts;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月19日 上午9:04:19
 * 供应商手机单据实收实付表操作接口
 */
public interface TSupplierPhoneOrderReceiptsDao {
    
    /**
     * 新增 供应商手机单据实收实付
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int add(TSupplierPhoneOrderReceipts receipts);
    
    /**
     * 删除 供应商手机单据实收实付
     * @param uid
     * @return
     * @author Liu bo
     */
    public int del(String uid);
    
    /**
     * 修改 供应商手机单据实收实付
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int mod(TSupplierPhoneOrderReceipts receipts);
    
    /**
     * 修改 供应商手机单据实收实付状态
     * @param uid
     * @param istatus
     * @return
     * @author Liu bo
     */
    public int modStatus(String uid,int istatus);
    
    /**
     * 获取 供应商手机单据实收实付
     * @param uid
     * @return
     * @author Liu bo
     */
    public TSupplierPhoneOrderReceipts get(String uid);
    
    /**
     * 获取 供应商手机单据实收实付集合
     * @param receitps
     * @return 集合
     * @author Liu bo
     */
    public List<TSupplierPhoneOrderReceipts> get(TSupplierPhoneOrderReceipts receipts);
    
    /**
     * 获取 供应商手机单据的实收实付量
     * @param imei
     * @return
     * @author Liu bo
     */
    public int getReceiptsNum(String imei);
    
    /**
     * 获取 供应商手机单据实收实付集合
     * @param ureceivableid
     * @return
     * @author Liu bo
     */
    public List<TSupplierPhoneOrderReceipts> getByUreceivableid(String ureceivableid);
}
