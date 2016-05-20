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
     * 根据单据类别获取单据列表数据
     * @param ctype
     * @return
     * @author Liu bo
     */
    public List<TAccountOrder> getAccountOrderList(String ctype);
    
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
    
    /**
     * 根据条件查询单据
     * @param accountOrder
     * @return
     * @author Liu bo
     */
    public List<TAccountOrder> getAccountOrderList(TAccountOrder accountOrder);
    
    /**
     * 获取指定类型的财务单据数量
     * @param uid
     * @return
     * @author Liu bo
     */
    public int getAccountOrderByType(String uaccounttypeid);
    
    /**
     * 删除财务单据
     * @param uid
     * @return
     * @author Liu bo
     */
    public int deleteAccountOrder(String uid);
    
    /**
     * 审核/反审核财务单据
     * @param uid
     * @param iaudit
     * @return
     * @author Liu bo
     */
    public int auditAccountOrder(String uid, int iaudit);
    
    /**
     * 获取账户下单据数量
     * @param uaccountid
     * @return
     * @author Liu bo
     */
    public int getAccountOrderByUAccountId(String uaccountid);
}
