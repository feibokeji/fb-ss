package com.fb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.core.utils.DataUtils;
import com.fb.dao.TCustomerOrderDao;
import com.fb.dao.TCustomerOrderDetailDao;
import com.fb.dao.TCustomerReceiptsDao;
import com.fb.dao.TCustomerReceivableDao;
import com.fb.dao.TOperateLogDao;
import com.fb.dao.TPaymentMethodDao;
import com.fb.domain.po.TCustomerOrder;
import com.fb.domain.po.TCustomerOrderDetail;
import com.fb.domain.po.TCustomerReceipts;
import com.fb.domain.po.TCustomerReceivable;
import com.fb.domain.po.TOperateLog;
import com.fb.domain.po.TPaymentMethod;
import com.fb.domain.po.TUser;
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
    
    @Autowired
    private TPaymentMethodDao paymentMethodDao;
    
    @Autowired
    private TOperateLogDao logDao;
    
    /**
     * 保存日志
     * @param user
     * @param ctype
     * @param ip
     * @param url
     * @param table
     * @param uid
     * @param cstatus
     * @param cmemo
     * @author Liu bo
     */
    private void saveLog(TUser user,String ctype,String ip,String url,String table,String uid,String cstatus,String cmemo){
        TOperateLog log = new TOperateLog();
        log.setUid(DataUtils.newUUID());
        log.setCtype(ctype);
        log.setCoperateip(ip);
        log.setCoperateurl(url);
        log.setClinktable(table);
        log.setUlinktableid(uid);
        log.setCstatus(cstatus);
        log.setCmemo(cmemo);
        log.setUuserid(user.getUid());
        log.setDoperatetime(new Date());
        logDao.addOperateLog(log);
    }
    
    @Transactional
    public int addOrder(TCustomerOrder order,TUser user,String ip,String url) {
        Date date = new Date();
        order.setUid(DataUtils.newUUID());
        order.setUuserid(user.getUid());
        order.setUdeptid(user.getUdeptid());
        order.setDrecorddate(date);
        order.setDupdatedate(date);
        List<TCustomerOrderDetail> detailList = new ArrayList<TCustomerOrderDetail>();
        int isort = 1;
        for(TCustomerOrderDetail detail : order.getOrderDetailList()){
            if(DataUtils.isUid(detail.getUothergoodsid())){
                detail.setUid(DataUtils.newUUID());
                detail.setUorderid(order.getUid());
                detail.setUuserid(user.getUid());
                detail.setUdeptid(user.getUdeptid());
                detail.setDrecorddate(date);
                detail.setDupdatedate(date);
                detail.setIsort(isort);
                isort++;
                detailList.add(detail);
            }
        }
        order.getOrderReceivable().setUid(DataUtils.newUUID());
        order.getOrderReceivable().setUcustomerid(order.getUcustomerid());
        order.getOrderReceivable().setUorderid(order.getUid());
        order.getOrderReceivable().setUuserid(user.getUid());
        order.getOrderReceivable().setUdeptid(user.getUdeptid());
        order.getOrderReceivable().setDrecorddate(date);
        order.getOrderReceivable().setDupdatedate(date);
        
        order.getOrderReceipts().setUid(DataUtils.newUUID());
        order.getOrderReceipts().setUreceivableid(order.getOrderReceivable().getUid());
        order.getOrderReceipts().setUuserid(user.getUid());
        order.getOrderReceipts().setUdeptid(user.getUdeptid());
        order.getOrderReceipts().setIstatus(1);
        order.getOrderReceipts().setDrecorddate(date);
        order.getOrderReceipts().setDupdatedate(date);
        boolean isCREDIT = false;
        TPaymentMethod paymentMethod = paymentMethodDao.get(order.getOrderReceipts().getUpaymentmethodid());
        if(paymentMethod.getCname().equals("挂账")){
            order.getOrderReceivable().setIstatus(0);
            isCREDIT = true;
        }else{
            double receivableNamount = order.getOrderReceivable().getNamount();
            double receiptsNamount = order.getOrderReceipts().getNamount();
            if(receivableNamount != receiptsNamount)
                order.getOrderReceivable().setIstatus(0);
            else
                order.getOrderReceivable().setIstatus(1);
        }
        int count = 0;
        count += orderDao.add(order);
        for(TCustomerOrderDetail detail : detailList)
            count += orderDetailDao.add(detail);
        count += orderReceivableDao.add(order.getOrderReceivable());
        if(!isCREDIT)
            count += orderReceiptsDao.add(order.getOrderReceipts());
        saveLog(user, "新增", ip, url, "t_customer_order", order.getUid(), "成功", "新增客户单据！");
        return count;
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
        return orderDao.get(uid);
    }
    
    public List<TCustomerOrder> getOrder(TCustomerOrder order) {
        return orderDao.get(order);
    }
    
    public List<TCustomerOrderDetail> getOrderDetailList(String uorderid){
        return orderDetailDao.getOrderList(uorderid);
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
        return orderReceivableDao.getOrderReceivable(uorderid);
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
        return orderReceiptsDao.getReceiptsByOrder(uorderid);
    }
    
    public List<TCustomerReceipts> getOrderReceiptsListByReceivable(String ureceivableid) {
        return null;
    }
    
    public List<TCustomerReceipts> getOrderReceiptsList(TCustomerReceipts receipts) {
        return null;
    }
    
}
