package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TCustomerOrderDao;
import com.fb.dao.TCustomerOrderDetailDao;
import com.fb.dao.TCustomerReceiptsDao;
import com.fb.dao.TCustomerReceivableDao;
import com.fb.domain.po.TCustomerOrder;
import com.fb.domain.po.TCustomerReceipts;
import com.fb.domain.po.TCustomerReceivable;
import com.fb.service.CustomerOrderService;
import com.fb.service.SimpServiceAbstract;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月5日 下午4:04:34
 * 客户手机单据服务接口实现类
 */
@Service
public class CustomerOrderServiceImpl extends SimpServiceAbstract implements CustomerOrderService {
    
    @Autowired
    private TCustomerOrderDao orderDao;
    
    @Autowired
    private TCustomerOrderDetailDao orderDetailDao;
    
    @Autowired
    private TCustomerReceivableDao orderReceivableDao;
    
    @Autowired
    private TCustomerReceiptsDao orderReceiptsDao;
    
    public int addOrder(TCustomerOrder order) {
        return 0;
    }
    
    public int delOrder(String uid) {
        return 0;
    }
    
    public int delOrderDetail(String uorderid) {
        return 0;
    }
    
    public int modOrder(TCustomerOrder order) {
        return 0;
    }
    
    public int modOrderStatus(String uid, int istatus) {
        return 0;
    }
    
    public TCustomerOrder getOrder(String uid) {
        return null;
    }
    
    public List<TCustomerOrder> getOrder(TCustomerOrder order) {
        return null;
    }
    
    public int addOrderReceivable(TCustomerReceivable receivable) {
        return 0;
    }
    
    public int delOrderReceivable(String uorderid) {
        return 0;
    }
    
    public int modOrderReceivable(TCustomerReceivable receivable) {
        return 0;
    }
    
    public int modOrderReceivableStatus(String uid, int istatus) {
        return 0;
    }
    
    public List<TCustomerReceivable> getOrderReceivableList(String uorderid) {
        return null;
    }
    
    public int addOrderReceipts(TCustomerReceipts receipts) {
        return 0;
    }
    
    public int delOrderReceipts(String uid) {
        return 0;
    }
    
    public int delOrderReceiptsList(String ureceivableid) {
        return 0;
    }
    
    public int modOrderReceipts(TCustomerReceipts receipts) {
        return 0;
    }
    
    public int modOrderReceiptsStatus(String uid, int istatus) {
        return 0;
    }
    
    public int getReceiptsStatusNumByReceivable(String ureceivableid, int istatus) {
        return 0;
    }
    
    public int getReceiptsStatusNumByOrder(String uorderid, int istatus) {
        return 0;
    }
    
    public TCustomerReceipts getOrderReceipts(String uid) {
        return null;
    }
    
    public List<TCustomerReceipts> getOrderReceiptsListByOrder(String uorderid) {
        return null;
    }
    
    public List<TCustomerReceipts> getOrderReceiptsListByReceivable(String ureceivableid) {
        return null;
    }
    
    public List<TCustomerReceipts> getOrderReceiptsList(TCustomerReceipts receipts) {
        return null;
    }
    
}
