package com.fb.service;

import java.util.List;

import com.fb.domain.po.TSupplierPhoneOrderReceipts;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月19日 上午10:07:36
 * 供应商手机单据实收实付服务接口
 */
public interface SupplierPhoneOrderReceiptsService {
    
    /**
     * 新增 供应商手机单据实收实付
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int addSupplierPhoneOrderReceipts(TSupplierPhoneOrderReceipts receipts);
    
    /**
     * 删除 供应商手机单据实收实付
     * @param uid
     * @return
     * @author Liu bo
     */
    public int delSupplierPhoneOrderReceipts(String uid);
    
    /**
     * 修改 供应商手机单据实收实付
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int modSupplierPhoneOrderReceipts(TSupplierPhoneOrderReceipts receipts);
    
    /**
     * 修改 供应商手机单据实收实付状态
     * @param uid
     * @param istatus
     * @return
     * @author Liu bo
     */
    public int modSupplierPhoneOrderReceiptsStatus(String uid,int istatus);
    
    /**
     * 获取 供应商手机单据实收实付
     * @param uid
     * @return
     * @author Liu bo
     */
    public TSupplierPhoneOrderReceipts getSupplierPhoneOrderReceipts(String uid);
    
    /**
     * 获取 供应商手机单据实收实付集合
     * @param receitps
     * @return 集合
     * @author Liu bo
     */
    public List<TSupplierPhoneOrderReceipts> getSupplierPhoneOrderReceipts(TSupplierPhoneOrderReceipts receipts);
    
    /**
     * 获取 供应商手机单据的实收实付量
     * @param imei
     * @return
     * @author Liu bo
     */
    public int getSupplierPhoneOrderReceiptsNum(String imei);
}
