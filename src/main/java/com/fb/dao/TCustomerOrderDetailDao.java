package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCustomerOrderDetail;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月1日 下午7:51:03
 * 客户商品单据明细接口
 */
public interface TCustomerOrderDetailDao {
    /**
     * 新增 单据明细
     * @param detail
     * @return
     * @author Liu bo
     */
    public int add(TCustomerOrderDetail detail);
    /**
     * 删除 单据所有明细
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public int delOrderDetail(String uorderid);
    /**
     * 获取 单据明细集合
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public List<TCustomerOrderDetail> getOrderList(String uorderid);
}
