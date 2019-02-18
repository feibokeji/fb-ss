package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TSupplierPhoneOrder;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月15日 下午8:04:23
 * 供应商手机单据操作接口
 */
public interface TSupplierPhoneOrderDao {
    /**
     * 新增 供应商手机单据
     * @param supplierPhoneOrder
     * @return 受影响行数
     * @author Liu bo
     */
    public int add(TSupplierPhoneOrder supplierPhoneOrder);
    /**
     * 删除 供应商手机单据
     * @param imei
     * @return 受影响行数
     * @author Liu bo
     */
    public int del(String imei);
    /**
     * 修改 供应商手机单据
     * @param supplierPhoneOrder
     * @return 受影响行数
     * @author Liu bo
     */
    public int mod(TSupplierPhoneOrder supplierPhoneOrder);
    /**
     * 修改 供应商手机单据状态
     * @param IMEI
     * @param istatus {@value 0 = 未结算}{@value 1 = 已结算}
     * @return 受影响行数
     * @author Liu bo
     */
    public int modStatus(String imei,int istatus);
    /**
     * 获取 供应商手机单据
     * @param IMEI
     * @return 供应商手机单据
     * @author Liu bo
     */
    public TSupplierPhoneOrder get(String imei);
    /**
     * 获取 供应商手机单据集合
     * @param supplierPhoneOrder
     * @return 供应商手机单据集合
     * @author Liu bo
     */
    public List<TSupplierPhoneOrder> get(TSupplierPhoneOrder supplierPhoneOrder);
}
