package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCustomerPhoneOrderReceivable;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月2日 上午11:11:42
 * 客户手机单据对应的应收/实付接口
 */
public interface TCustomerPhoneOrderReceivableDao {
    
    /**
     * 新增 客户手机单据[应收/应付]
     * @param receivable
     * @return
     * @author Liu bo
     */
    public int add(TCustomerPhoneOrderReceivable receivable);
    
    /**
     * 删除 客户手机单据对应的[应收/应付]
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public int delByOrder(String uorderid);
    
    /**
     * 修改 客户手机单据[应收/应付]
     * @param receivable
     * @return
     * @author Liu bo
     */
    public int mod(TCustomerPhoneOrderReceivable receivable);
    
    /**
     * 修改 客户手机单据[应收/应付]状态
     * @param uid
     * @param istatus
     * @return
     * @author Liu bo
     */
    public int modStatus(String uid,int istatus);
    
    /**
     * 获取 客户手机单据对应的[应收/应付]集合
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public List<TCustomerPhoneOrderReceivable> getByOrder(String uorderid);
    
    /**
     * 获取 客户手机单据对应的[应收/应付]集合
     * @param receivable
     * @return
     * @author Liu bo
     */
    public List<TCustomerPhoneOrderReceivable> get(TCustomerPhoneOrderReceivable receivable);
}
