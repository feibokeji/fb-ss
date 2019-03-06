package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCustomerReceipts;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月1日 下午7:51:47
 * 客户商品实收实付接口
 */
public interface TCustomerReceiptsDao {
    
    /**
     * 新增 [实收/实付]
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int add(TCustomerReceipts receipts);
    
    /**
     * 删除 [实收/实付]
     * @param uid
     * @return
     * @author Liu bo
     */
    public int del(String uid);
    
    /**
     * 删除 客户商品单据[应收/应付]对应的[实收/实付]
     * @param ureceivableid
     * @return
     * @author Liu bo
     */
    public int delByReceivable(String ureceivableid);
    
    /**
     * 修改 [实收/实付]
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int mod(TCustomerReceipts receipts);
    
    /**
     * 修改 [实收/实付]状态
     * @param uid
     * @param istatus
     * @return
     * @author Liu bo
     */
    public int modStatus(String uid,int istatus);
    
    /**
     * 获取 客户商品单据[应收/应付]对应的[实收/实付]
     * @param ureceivableid
     * @return
     * @author Liu bo
     */
    public List<TCustomerReceipts> getByReceivable(String ureceivableid);
    
    /**
     * 获取 根据单据获取对应的实收实付集合
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public List<TCustomerReceipts> getReceiptsByOrder(String uorderid);
    
    /**
     * 获取 [实收/实付]
     * @param receipts
     * @return
     * @author Liu bo
     */
    public List<TCustomerReceipts> getReceipts(TCustomerReceipts receipts);
}
