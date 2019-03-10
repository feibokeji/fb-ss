package com.fb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.core.utils.DataUtils;
import com.fb.dao.TCustomerPhoneOrderDao;
import com.fb.dao.TCustomerPhoneOrderDetailDao;
import com.fb.dao.TCustomerPhoneOrderReceiptsDao;
import com.fb.dao.TCustomerPhoneOrderReceivableDao;
import com.fb.dao.TOperateLogDao;
import com.fb.dao.TPaymentMethodDao;
import com.fb.dao.TSupplierPhoneOrderStatusDao;
import com.fb.domain.po.TCustomerPhoneOrder;
import com.fb.domain.po.TCustomerPhoneOrderDetail;
import com.fb.domain.po.TCustomerPhoneOrderReceipts;
import com.fb.domain.po.TCustomerPhoneOrderReceivable;
import com.fb.domain.po.TOperateLog;
import com.fb.domain.po.TPaymentMethod;
import com.fb.domain.po.TSupplierPhoneOrderStatus;
import com.fb.domain.po.TUser;
import com.fb.service.SimpServiceAbstract;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月5日 下午4:10:18
 * 客户手机单据服务接口实现类
 */
@Service
public class CustomerPhoneOrderServiceImpl extends SimpServiceAbstract implements com.fb.service.CustomerPhoneOrderService {
    
    @Autowired
    private TCustomerPhoneOrderDao orderDao;
    
    @Autowired
    private TCustomerPhoneOrderDetailDao orderDetailDao;
    
    @Autowired
    private TCustomerPhoneOrderReceivableDao orderReceivableDao;
    
    @Autowired
    private TCustomerPhoneOrderReceiptsDao orderReceiptsDao;
    
    @Autowired
    private TPaymentMethodDao paymentMethodDao;
    
    @Autowired
    private TSupplierPhoneOrderStatusDao supplierPhoneOrderStatusDao;
    
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
    public int addPhoneOrder(TCustomerPhoneOrder phoneOrder,TUser user,String ip,String url) {
        Date date = new Date();
        phoneOrder.setUid(DataUtils.newUUID());
        phoneOrder.setUuserid(user.getUid());
        phoneOrder.setUdeptid(user.getUdeptid());
        phoneOrder.setDrecorddate(date);
        phoneOrder.setDupdatedate(date);
        List<TCustomerPhoneOrderDetail> detailList = new ArrayList<TCustomerPhoneOrderDetail>();
        int isort = 1;
        for(TCustomerPhoneOrderDetail detail : phoneOrder.getOrderDetailList()){
            if(!DataUtils.isNullOrEmpty(detail.getImei())){
                detail.setUid(DataUtils.newUUID());
                detail.setUorderid(phoneOrder.getUid());
                detail.setNdiscount(1.00);
                detail.setNamount(detail.getNprice());
                detail.setUuserid(user.getUid());
                detail.setUdeptid(user.getUdeptid());
                detail.setDrecorddate(date);
                detail.setDupdatedate(date);
                detail.setIsort(isort);
                isort++;
                detailList.add(detail);
            }
        }
        phoneOrder.getOrderReceivable().setUid(DataUtils.newUUID());
        phoneOrder.getOrderReceivable().setUcustomerid(phoneOrder.getUcustomerid());
        phoneOrder.getOrderReceivable().setUcustomerphoneorderid(phoneOrder.getUid());
        phoneOrder.getOrderReceivable().setUuserid(user.getUid());
        phoneOrder.getOrderReceivable().setUdeptid(user.getUdeptid());
        phoneOrder.getOrderReceivable().setDrecorddate(date);
        phoneOrder.getOrderReceivable().setDupdatedate(date);
        phoneOrder.getOrderReceipts().setUid(DataUtils.newUUID());
        phoneOrder.getOrderReceipts().setUreceivableid(phoneOrder.getOrderReceivable().getUid());
        phoneOrder.getOrderReceipts().setUuserid(user.getUid());
        phoneOrder.getOrderReceipts().setUdeptid(user.getUdeptid());
        phoneOrder.getOrderReceipts().setIstatus(1);
        phoneOrder.getOrderReceipts().setDrecorddate(date);
        phoneOrder.getOrderReceipts().setDupdatedate(date);
        boolean isCREDIT = false;
        TPaymentMethod paymentMethod = paymentMethodDao.get(phoneOrder.getOrderReceipts().getUpaymentmethodid());
        if(paymentMethod.getCname().equals("挂账")){
            phoneOrder.getOrderReceivable().setIstatus(0);
            isCREDIT = true;
        }else{
            double receivableNamount = phoneOrder.getOrderReceivable().getNamount();
            double receiptsNamount = phoneOrder.getOrderReceipts().getNamount();
            if(receivableNamount != receiptsNamount)
                phoneOrder.getOrderReceivable().setIstatus(0);
            else
                phoneOrder.getOrderReceivable().setIstatus(1);
        }
        List<TSupplierPhoneOrderStatus> statusList = new ArrayList<TSupplierPhoneOrderStatus>();
        for(TCustomerPhoneOrderDetail detail : detailList){
            TSupplierPhoneOrderStatus status = new TSupplierPhoneOrderStatus();
            status.setUid(DataUtils.newUUID());
            status.setImei(detail.getImei());
            status.setItype(2);
            status.setIstatus(1);
            status.setUuserid(user.getUid());
            status.setDrecorddate(date);
            statusList.add(status);
        }
        int count = 0;
        count += orderDao.add(phoneOrder);
        for(TCustomerPhoneOrderDetail detail : detailList)
            count += orderDetailDao.add(detail);
        count += orderReceivableDao.add(phoneOrder.getOrderReceivable());
        if(!isCREDIT)
            count += orderReceiptsDao.add(phoneOrder.getOrderReceipts());
        for(TSupplierPhoneOrderStatus status : statusList){
            supplierPhoneOrderStatusDao.modStatus(status.getImei(), 0);
            supplierPhoneOrderStatusDao.add(status);
        }
        saveLog(user, "新增", ip, url, "t_customer_phone_order", phoneOrder.getUid(), "成功", "新增客户手机销售单据！");
        return count;
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
