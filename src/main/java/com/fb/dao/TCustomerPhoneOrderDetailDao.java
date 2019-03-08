package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCustomerPhoneOrderDetail;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月8日 下午2:59:08
 * 客户手机单据明细接口
 */
public interface TCustomerPhoneOrderDetailDao {
    
    /**
     * 新增 客户手机单据明细
     * @param detail
     * @return
     * @author Liu bo
     */
    public int add(TCustomerPhoneOrderDetail detail);
    
    /**
     * 删除 客户手机单据明细
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public int delByOrder(String uorderid);
    
    /**
     * 获取 客户手机单据明细
     * @param uid
     * @return
     * @author Liu bo
     */
    public TCustomerPhoneOrderDetail get(String uid);
    
    /**
     * 获取 客户手机单据明细
     * @param uorderid 手机单据表外键
     * @return
     * @author Liu bo
     */
    public List<TCustomerPhoneOrderDetail> getByOrder(String uorderid);
    
    /**
     * 获取 客户手机单据明细
     * @param detail 查询条件类
     * @return
     * @author Liu bo
     */
    public List<TCustomerPhoneOrderDetail> get(TCustomerPhoneOrderDetail detail);
}
