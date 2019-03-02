package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCustomerReceivable;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月1日 下午7:51:31
 * 客户商品应收应付接口
 */
public interface TCustomerReceivableDao {
    
    /**
     * 新增 客户商品单据应收应付款
     * @param receivable
     * @return
     * @author Liu bo
     */
    public int add(TCustomerReceivable receivable);
    
    /**
     * 删除 客户商品单据应收应付款
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public int delOrderReceivable(String uorderid);
    
    /**
     * 修改 客户商品单据应收应付款
     * @param receivable
     * @return
     * @author Liu bo
     */
    public int mod(TCustomerReceivable receivable);
    
    /**
     * 修改 客户商品单据应收应付款状态
     * @param uid
     * @param istatus {@value 0=未结算/1=已结算}
     * @return
     * @author Liu bo
     */
    public int modStatus(String uid,int istatus);
    
    /**
     * 获取 客户商品单据的应收应付款集合
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public List<TCustomerReceivable> getOrderReceivable(String uorderid);
    
    /**
     * 获取 客户商品的应收应付集合
     * @param receivable
     * @return
     * @author Liu bo
     */
    public List<TCustomerReceivable> getReceivable(TCustomerReceivable receivable);
}
