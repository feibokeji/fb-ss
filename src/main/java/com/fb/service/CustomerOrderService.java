package com.fb.service;

import java.util.List;

import com.fb.domain.po.TCustomerOrder;
import com.fb.domain.po.TCustomerReceipts;
import com.fb.domain.po.TCustomerReceivable;
import com.fb.domain.po.TUser;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月4日 下午8:15:19
 * 客户商品单据服务接口
 */
public interface CustomerOrderService {
    
    /**
     * 新增 客户商品单据信息
     * @param order
     * @return
     * @author Liu bo
     */
    public int addOrder(TCustomerOrder order,TUser user,String ip,String url);
    
    /**
     * 删除 客户商品单据信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public int delOrder(String uid);
    
    /**
     * 删除 客户商品单据明细信息
     * @param uorderid 客户商品单据表外键
     * @return
     * @author Liu bo
     */
    public int delOrderDetail(String uorderid);
    
    /**
     * 修改 客户商品单据信息
     * @param order
     * @return
     * @author Liu bo
     */
    public int modOrder(TCustomerOrder order);
    
    /**
     * 修改 客户商品单据状态
     * @param uid
     * @param istatus{@value 0=未审核/1=已审核}
     * @return
     * @author Liu bo
     */
    public int modOrderStatus(String uid,int istatus);
    
    /**
     * 获取 客户商品单据信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public TCustomerOrder getOrder(String uid);
    
    /**
     * 获取 客户商品单据信息集合
     * @param order
     * @return
     * @author Liu bo
     */
    public List<TCustomerOrder> getOrder(TCustomerOrder order);
    
    /**
     * 新增 客户商品单据(应收应付)信息
     * @param receivable
     * @return
     * @author Liu bo
     */
    public int addOrderReceivable(TCustomerReceivable receivable);
    
    /**
     * 删除 客户商品单据(应收应付)信息
     * @param uorderid 客户商品单据外键
     * @return
     * @author Liu bo
     */
    public int delOrderReceivable(String uorderid);
    
    /**
     * 修改 客户商品单据(应收应付)信息
     * @param receivable
     * @return
     * @author Liu bo
     */
    public int modOrderReceivable(TCustomerReceivable receivable);
    
    /**
     * 修改 客户商品单据(应收应付)状态
     * @param uid
     * @param istatus{@value 0=未结算/1=已结算}
     * @return
     * @author Liu bo
     */
    public int modOrderReceivableStatus(String uid,int istatus);
    
    /**
     * 获取 客户商品单据(应收应付)集合
     * @param uorderid 客户商品单据外键
     * @return
     * @author Liu bo
     */
    public List<TCustomerReceivable> getOrderReceivableList(String uorderid);
    
    /**
     * 新增 客户商品单据(实收实付)信息
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int addOrderReceipts(TCustomerReceipts receipts);
    
    /**
     * 删除 客户商品单据(实收实付)信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public int delOrderReceipts(String uid);
    
    /**
     * 删除 客户商品单据(实收实付)集合
     * @param ureceivableid 客户单据应收应付表外键
     * @return
     * @author Liu bo
     */
    public int delOrderReceiptsList(String ureceivableid);
    
    /**
     * 修改 客户商品单据(实收实付)信息
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int modOrderReceipts(TCustomerReceipts receipts);
    
    /**
     * 修改 客户商品单据(实收实付)状态
     * @param uid
     * @param istatus{@value 0=未结算/1=已结算}
     * @return
     * @author Liu bo
     */
    public int modOrderReceiptsStatus(String uid,int istatus);
    
    /**
     * 获取 客户商品单据(应收应付)对应的指定状态下的(实收实付)量
     * @param ureceivableid 客户商品单据应收应付表外键
     * @param istatus{@value 0=未结算/1=已结算/-1=全部查询}
     * @return
     * @author Liu bo
     */
    public int getReceiptsStatusNumByReceivable(String ureceivableid,int istatus);
    
    /**
     * 获取 客户商品单据对应的(实收实付)指定状态下的数量
     * @param uorderid 客户商品单据外键
     * @param istatus{@value 0=未结算/1=已结算/-1=全部查询}
     * @return
     * @author Liu bo
     */
    public int getReceiptsStatusNumByOrder(String uorderid,int istatus);
    
    /**
     * 获取 客户商品单据对应的(实收实付)信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public TCustomerReceipts getOrderReceipts(String uid);
    
    /**
     * 获取 客户商品单据对应的(实收实付)信息集合
     * @param uorderid 客户商品单据表外键
     * @return
     * @author Liu bo
     */
    public List<TCustomerReceipts> getOrderReceiptsListByOrder(String uorderid);
    
    /**
     * 获取 客户商品单据(应收应付)对应的(实收实付)信息集合
     * @param ureceivableid 客户商品单据对应应收应付表外键
     * @return
     * @author Liu bo
     */
    public List<TCustomerReceipts> getOrderReceiptsListByReceivable(String ureceivableid);
    
    /**
     * 获取 客户商品单据对应(实收实付)信息集合
     * @param receipts
     * @return
     * @author Liu bo
     */
    public List<TCustomerReceipts> getOrderReceiptsList(TCustomerReceipts receipts);
}
