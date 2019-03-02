package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TSupplierPhoneOrderStatus;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月16日 上午10:21:36
 * 供应商手机单据状态操作接口
 */
public interface TSupplierPhoneOrderStatusDao {
    
    /**
     * 新增 手机状态
     * @param supplierPhoneOrderStatus
     * @return 受影响行数
     * @author Liu bo
     */
    public int add(TSupplierPhoneOrderStatus supplierPhoneOrderStatus);
    
    /**
     * 删除 手机状态
     * @param imei
     * @return
     * @author Liu bo
     */
    public int delByIMEI(String imei);
    
    /**
     * 修改 手机状态
     * @param supplierPhoneOrderStatus
     * @return 受影响行数
     * @author Liu bo
     */
    public int mod(TSupplierPhoneOrderStatus supplierPhoneOrderStatus);
    
    /**
     * 修改 手机状态是否启用
     * @param imei 串号
     * @param istatus 状态{@value 0 = 禁用}{@value 1 = 启用}
     * @return 受影响行数
     * @author Liu bo
     */
    public int modStatus(String imei,int istatus);
    
    /**
     * 获取 供应商手机单据当前状态
     * @param IMEI 手机串号
     * @return 当前状态
     * @author Liu bo
     */
    public int getCurrentType(String imei);
    
    /**
     * 获取 手机状态集合
     * @param imei
     * @return 状态集合
     * @author Liu bo
     */
    public List<TSupplierPhoneOrderStatus> get(String imei);
    
    /**
     * 获取 手机以前的状态用于反审核功能
     * @param imei
     * @return
     * @author Liu bo
     */
    public TSupplierPhoneOrderStatus getBeforeStatus(String imei);
}
