package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TCustomerPhoneOrderDao;
import com.fb.dao.TCustomerPhoneOrderReceiptsDao;
import com.fb.dao.TCustomerPhoneOrderReceivableDao;
import com.fb.domain.po.TCustomerPhoneOrder;
import com.fb.domain.po.TCustomerPhoneOrderReceipts;
import com.fb.domain.po.TCustomerPhoneOrderReceivable;
import com.fb.service.SimpServiceAbstract;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月5日 下午4:10:18
 * 客户手机单据服务接口实现类
 */
@Service
public class CustomerPhoneOrderService extends SimpServiceAbstract implements com.fb.service.CustomerPhoneOrderService {
    
    @Autowired
    private TCustomerPhoneOrderDao orderDao;
    
    @Autowired
    private TCustomerPhoneOrderReceivableDao orderReceivableDao;
    
    @Autowired
    private TCustomerPhoneOrderReceiptsDao orderReceiptsDao;
    
    public int addPhoneOrder(TCustomerPhoneOrder phoneOrder) {
        return 0;
    }
    
    public int modPhoneOrder(TCustomerPhoneOrder phoneOrder) {
        return 0;
    }
    
    public int modPhoneOrderType(String uid, int itype) {
        return 0;
    }
    
    public int modPhoneOrderStatus(String uid, int istatus) {
        return 0;
    }
    
    public TCustomerPhoneOrder getPhoneOrder(String uid) {
        return null;
    }
    
    public List<TCustomerPhoneOrder> getPhoneOrderList(TCustomerPhoneOrder phoneOrder) {
        return null;
    }
    
    public int addPhoneOrderReceivable(TCustomerPhoneOrderReceivable receivable) {
        return 0;
    }
    
    public int modPhoneOrderReceivable(TCustomerPhoneOrderReceivable receivable) {
        return 0;
    }
    
    public int modPhoneOrderReceivableStatus(String uid, int istatus) {
        return 0;
    }
    
    public int delPhoneOrderReceivableByOrder(String uorderid) {
        return 0;
    }
    
    public int addPhoneOrderReceipts(TCustomerPhoneOrderReceipts receipts) {
        return 0;
    }
    
    public int delPhoneOrderReceipts(String uid) {
        return 0;
    }
    
    public int delPhoneOrderReceiptsByReceivable(String ureceivableid) {
        return 0;
    }
    
    public int modPhoneOrderReceipts(TCustomerPhoneOrderReceipts receipts) {
        return 0;
    }
    
    public int modPhoneOrderReceiptsStatus(String uid, int istatus) {
        return 0;
    }
    
    public TCustomerPhoneOrderReceipts getPhoneOrderReceipts(String uid) {
        return null;
    }
    
    public List<TCustomerPhoneOrderReceipts> getPhoneOrderReceiptsByReceivable(String ureceivableid) {
        return null;
    }
    
    public List<TCustomerPhoneOrderReceipts> getPhoneOrderReceiptsByOrder(String uorderid) {
        return null;
    }
    
    public List<TCustomerPhoneOrderReceipts> getPhoneOrderReceipts(TCustomerPhoneOrderReceipts receipts) {
        return null;
    }
    
    public int getPhoneOrderStatusNumByReceivable(String ureceivableid, int istatus) {
        return 0;
    }
    
    public int getPhoneOrderStatusNumByOrder(String uorderid, int istatus) {
        return 0;
    }
    
}
