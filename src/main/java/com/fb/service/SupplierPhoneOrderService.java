package com.fb.service;

import java.util.List;
import com.fb.domain.po.TSupplierPhoneOrder;
import com.fb.domain.po.TSupplierPhoneOrderReceivable;
import com.fb.domain.po.TSupplierPhoneOrderStatus;
import com.fb.domain.po.TUser;
import com.fb.domain.vo.SupplierPhoneOrder;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月16日 下午4:57:16
 * 供应商手机单据操作接口
 */
public interface SupplierPhoneOrderService {
    
    /**
     * 新增 供应商手机单据
     * @param order
     * @param user
     * @return
     * @author Liu bo
     */
    public boolean addSupplierPhoneOrder(SupplierPhoneOrder order,TUser user,String ip,String url);
    
    /**
     * 获取 供应商手机单据集合
     * @param order
     * @return 集合
     * @author Liu bo
     */
    public List<TSupplierPhoneOrder> getSupplierPhoneOrderList(TSupplierPhoneOrder order);
    
    /**
     * 获取 供应商手机单据应收应付集合
     * @param imei
     * @return
     * @author Liu bo
     */
    public List<TSupplierPhoneOrderReceivable> getSupplierPhoneOrderReceivableList(String imei);
    
    /**
     * 获取 供应商手机单据状态集合
     * @param imei
     * @return
     * @author Liu bo
     */
    public List<TSupplierPhoneOrderStatus> getSupplierPhoneOrderStatusList(String imei);
    
    /**
     * 获取 手机单据
     * @param imei
     * @return
     * @author Liu bo
     */
    public TSupplierPhoneOrder getSupplierPhoneOrder(String imei);
    
    /**
     * 退库 手机单据
     * @param imei
     * @param user
     * @param ip
     * @param url
     * @return
     * @author Liu bo
     */
    public boolean returnSupplierPhoneOrder(String imei,TUser user,String ip,String url);
    
    /**
     * 审核 手机单据
     * @param imei
     * @param user
     * @param ip
     * @param url
     * @return
     * @author Liu bo
     */
    public boolean auditSupplierPhoneOrder(String imei,TUser user,String ip,String url);
    
    /**
     * 反审核 手机单据
     * @param imei
     * @param user
     * @param ip
     * @param url
     * @return
     * @author Liu bo
     */
    public boolean reverseAuditSupplierPhoneOrder(String imei,TUser user,String ip,String url);
    
    /**
     * 删除 手机单据
     * @param imei
     * @param user
     * @param ip
     * @param url
     * @return
     * @author Liu bo
     */
    public boolean deleteSupplierPhoneOrder(String imei,TUser user,String ip,String url);
}
