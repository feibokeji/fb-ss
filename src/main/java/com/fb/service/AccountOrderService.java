package com.fb.service;

import com.fb.core.utils.Page;
import com.fb.domain.po.TAccountOrder;

/**
 * 账务单据
 * @since 2016年4月12日 下午4:32:08
 * @author Liu bo
 */
public interface AccountOrderService {
    
    
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
     * 获取账务单据分页
     * @param accountOrder
     * @param currentPage
     * @return
     * @author Liu bo
     */
    public Page<TAccountOrder> getAccountOrderPage(TAccountOrder accountOrder, int currentPage);
}
