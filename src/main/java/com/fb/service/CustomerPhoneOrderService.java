package com.fb.service;

import java.util.List;

import com.fb.domain.po.TCustomerPhoneOrder;
import com.fb.domain.po.TCustomerPhoneOrderReceipts;
import com.fb.domain.po.TCustomerPhoneOrderReceivable;
import com.fb.domain.po.TUser;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月4日 下午8:15:42
 * 客户手机单据服务接口
 */
public interface CustomerPhoneOrderService {
    
    /**
     * 新增 客户手机单据
     * @param phoneOrder
     * @return
     * @author Liu bo
     */
    public int addPhoneOrder(TCustomerPhoneOrder phoneOrder,TUser user,String ip,String url);
    
    /**
     * 修改 客户手机单据
     * @param phoneOrder
     * @return
     * @author Liu bo
     */
    public int modPhoneOrder(TCustomerPhoneOrder phoneOrder);
    
    /**
     * 修改 客户手机单据类型
     * @param uid 
     * @param itype{@value 2=销售/3=退货}
     * @return
     * @author Liu bo
     */
    public int modPhoneOrderType(String uid,int itype);
    
    /**
     * 修改 客户手机单据状态
     * @param uid
     * @param istatus{@value 0=未审核/1=已审核}
     * @return
     * @author Liu bo
     */
    public int modPhoneOrderStatus(String uid,int istatus);
    
    /**
     * 获取 客户手机单据信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public TCustomerPhoneOrder getPhoneOrder(String uid);
    
    /**
     * 获取 客户手机单据信息集合
     * @param phoneOrder
     * @return
     * @author Liu bo
     */
    public List<TCustomerPhoneOrder> getPhoneOrderList(TCustomerPhoneOrder phoneOrder);
    
    /**
     * 新增 客户手机单据对应的（应收应付）信息
     * @param receivable
     * @return
     * @author Liu bo
     */
    public int addPhoneOrderReceivable(TCustomerPhoneOrderReceivable receivable);
    
    /**
     * 修改 客户手机单据对应的（应收应付）信息
     * @param receivable
     * @return
     * @author Liu bo
     */
    public int modPhoneOrderReceivable(TCustomerPhoneOrderReceivable receivable);
    
    /**
     * 修改 客户手机单据对应的（应收应付）状态
     * @param uid
     * @param istatus{@value 0=未结算/1=已结算}
     * @return
     * @author Liu bo
     */
    public int modPhoneOrderReceivableStatus(String uid,int istatus);
    
    /**
     * 删除 客户手机单据对应的（应收应付）信息
     * @param uorderid 客户手机单据外键
     * @return
     * @author Liu bo
     */
    public int delPhoneOrderReceivableByOrder(String uorderid);
    
    /**
     * 新增 客户手机单据对应的（实收实付）信息
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int addPhoneOrderReceipts(TCustomerPhoneOrderReceipts receipts);
    
    /**
     * 删除 客户手机单据对应的（实收实付）信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public int delPhoneOrderReceipts(String uid);
    
    /**
     * 删除 客户手机单据对应的（实收实付）信息
     * @param ureceivableid 客户手机单据对应的（应收应付）表外键
     * @return
     * @author Liu bo
     */
    public int delPhoneOrderReceiptsByReceivable(String ureceivableid);
    
    /**
     * 修改 客户手机单据对应的（实收实付）信息
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int modPhoneOrderReceipts(TCustomerPhoneOrderReceipts receipts);
    
    /**
     * 修改 客户手机单据对应的（实收实付）状态
     * @param uid
     * @param istatus {@value 0=未结算/1=已结算}
     * @return
     * @author Liu bo
     */
    public int modPhoneOrderReceiptsStatus(String uid,int istatus);
    
    /**
     * 获取 客户手机单据对应的（实收实付）信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public TCustomerPhoneOrderReceipts getPhoneOrderReceipts(String uid);
    
    /**
     * 获取 客户手机单据对应的（实收实付）信息集合
     * @param ureceivableid 客户手机单据对应的（应收应付）表外键
     * @return
     * @author Liu bo
     */
    public List<TCustomerPhoneOrderReceipts> getPhoneOrderReceiptsByReceivable(String ureceivableid);
    
    /**
     * 获取 客户手机单据对应的（实收实付）信息集合
     * @param uorderid 客户手机单据表外键
     * @return
     * @author Liu bo
     */
    public List<TCustomerPhoneOrderReceipts> getPhoneOrderReceiptsByOrder(String uorderid);
    
    /**
     * 获取 客户手机单据对应的（实收实付）信息集合
     * @param receipts
     * @return
     * @author Liu bo
     */
    public List<TCustomerPhoneOrderReceipts> getPhoneOrderReceipts(TCustomerPhoneOrderReceipts receipts);
    
    /**
     * 获取 客户手机单据对应（实收实付）指定状态下的量
     * @param ureceivableid 客户手机单据对应的（应收应付）表外键
     * @param istatus {@value 0=未结算/1=已结算/-1=全部}
     * @return
     * @author Liu bo
     */
    public int getPhoneOrderStatusNumByReceivable(String ureceivableid,int istatus);
    
    /**
     * 获取 客户手机单据对应（实收实付）指定状态下的量
     * @param uorderid 客户手机单据表外键
     * @param istatus {@value 0=未结算/1=已结算/-1=全部}
     * @return
     * @author Liu bo
     */
    public int getPhoneOrderStatusNumByOrder(String uorderid,int istatus);
}
