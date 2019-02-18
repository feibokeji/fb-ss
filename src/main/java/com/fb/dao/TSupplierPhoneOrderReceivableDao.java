package com.fb.dao;

import java.util.Date;
import java.util.List;

import com.fb.domain.po.TSupplierPhoneOrderReceivable;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月16日 上午11:38:12
 * 供应商手机单据应收应付操作接口
 */
public interface TSupplierPhoneOrderReceivableDao {
    
    /**
     * 新增 供应商手机单据应收应付
     * @param receivable
     * @return 受影响行数
     * @author Liu bo
     */
    public int add(TSupplierPhoneOrderReceivable receivable);
    
    /**
     * 删除 供应商手机单据应收应付
     * @param uid
     * @return
     * @author Liu bo
     */
    public int del(String uid);
    
    /**
     * 删除 供应商手机单据应收应付
     * @param imei
     * @return 受影响行数
     * @author Liu bo
     */
    public int delByIMEI(String imei);
    
    /**
     * 修改 供应商手机单据应收应付
     * @param receivable
     * @return 受影响行数
     * @author Liu bo
     */
    public int mod(TSupplierPhoneOrderReceivable receivable);
    
    /**
     * 修改 供应商手机单据应收应付状态
     * @param uid 主键
     * @param istatus 状态{@value 0 = 未结算}{@value 1 = 已结算}
     * @param dupdatedate 更新日期
     * @return
     * @author Liu bo
     */
    public int modStatus(String uid,int istatus,Date dupdatedate);
    
    /**
     * 获取 供应商手机单据应收应付
     * @param uid
     * @return
     * @author Liu bo
     */
    public TSupplierPhoneOrderReceivable get(String uid);
    
    /**
     * 获取 供应商手机对应的应收应付集合
     * @param imei 手机串号
     * @return
     * @author Liu bo
     */
    public List<TSupplierPhoneOrderReceivable> getByIMEI(String imei);
    
    /**
     * 获取 供应商手机单据应收应付集合
     * @param receivable
     * @return
     * @author Liu bo
     */
    public List<TSupplierPhoneOrderReceivable> get(TSupplierPhoneOrderReceivable receivable);
}
