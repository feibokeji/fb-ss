package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TAccountOrder;

/**
 * 账务单据操作
 * @since 2016年4月11日 下午5:47:11
 * @author Liu bo
 */
public interface TAccountOrderDao {
    
    
    /**
     * 新增账务单据
     * @param accountOrder
     * @return
     * @author Liu bo
     */
    public int addAccountOrder(TAccountOrder accountOrder);
    
    /**
     * 修改账务单据
     * @param accountOrder
     * @return
     * @author Liu bo
     */
    public int updateAccountOrder(TAccountOrder accountOrder);
    
    /**
     * 获取账务单据
     * @param uid
     * @return
     * @author Liu bo
     */
    public TAccountOrder getAccountOrder(String uid);
    
    /**
     * 获取单据数量
     * @param accountOrder
     * @return
     * @author Liu bo
     */
    public int getAccountOrderCount(TAccountOrder accountOrder);
    
    /**
     * 获取单据分页数据
     * @param accountOrder
     * @param startRow
     * @param pageSize
     * @return
     * @author Liu bo
     */
    public List<TAccountOrder> getAccountOrderListPage(TAccountOrder accountOrder, int startRow, int pageSize);
}
