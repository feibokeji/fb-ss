package com.fb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.FormatUtils;
import com.fb.dao.TOperateLogDao;
import com.fb.dao.TSupplierPhoneOrderDao;
import com.fb.dao.TSupplierPhoneOrderReceiptsDao;
import com.fb.dao.TSupplierPhoneOrderReceivableDao;
import com.fb.dao.TSupplierPhoneOrderStatusDao;
import com.fb.domain.po.TOperateLog;
import com.fb.domain.po.TSupplierPhoneOrder;
import com.fb.domain.po.TSupplierPhoneOrderReceipts;
import com.fb.domain.po.TSupplierPhoneOrderReceivable;
import com.fb.domain.po.TSupplierPhoneOrderStatus;
import com.fb.domain.po.TUser;
import com.fb.domain.vo.SupplierPhoneOrder;
import com.fb.service.SimpServiceAbstract;
import com.fb.service.SupplierPhoneOrderService;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月16日 下午4:59:53
 * 供应商手机单据服务接口实现类
 */
@Service
public class SupplierPhoneOrderServiceImpl extends SimpServiceAbstract implements SupplierPhoneOrderService {
    
    @Autowired
    private TSupplierPhoneOrderDao orderDao;
    
    @Autowired
    private TSupplierPhoneOrderStatusDao orderStatusDao;
    
    @Autowired
    private TSupplierPhoneOrderReceivableDao orderReceivableDao;
    
    @Autowired
    private TSupplierPhoneOrderReceiptsDao orderReceiptsDao;
    
    @Autowired
    private TOperateLogDao logDao;

    @Transactional
    public boolean addSupplierPhoneOrder(SupplierPhoneOrder order, TUser user,String ip,String url) {
        List<TSupplierPhoneOrder> orderList = new ArrayList<TSupplierPhoneOrder>();
        List<TSupplierPhoneOrderStatus> orderStatusList = new ArrayList<TSupplierPhoneOrderStatus>();
        List<TSupplierPhoneOrderReceivable> orderReceivableList = new ArrayList<TSupplierPhoneOrderReceivable>();
        List<TOperateLog> logList = new ArrayList<TOperateLog>();
        Date date = new Date();
        for(TSupplierPhoneOrder detail : order.getOrderDetailList()){
            if(!DataUtils.isNullOrEmpty(detail.getImei()) && DataUtils.isUid(detail.getUphonemodelid()) && DataUtils.isUid(detail.getUcolorid())){
                detail.setUsupplierid(order.getUsupplierid());
                detail.setUuserid(user.getUid());
                detail.setUdeptid(user.getUdeptid());
                detail.setIstatus(order.getIstatus());
                detail.setDrecorddate(FormatUtils.toDate(order.getDrecorddateStr()));
                detail.setDupdatedate(date);
                orderList.add(detail);
                TSupplierPhoneOrderStatus status = new TSupplierPhoneOrderStatus();
                status.setUid(DataUtils.newUUID());
                status.setImei(detail.getImei());
                status.setItype(order.getItype());
                status.setIstatus(1);
                status.setUuserid(user.getUid());
                status.setDrecorddate(date);
                orderStatusList.add(status);
                if(order.getIstatus() == 1){
                    TSupplierPhoneOrderReceivable receivable = new TSupplierPhoneOrderReceivable();
                    receivable.setUid(DataUtils.newUUID());
                    receivable.setUsupplierid(order.getUsupplierid());
                    receivable.setImei(detail.getImei());
                    receivable.setUuserid(user.getUid());
                    receivable.setUdeptid(user.getUdeptid());
                    switch(order.getItype()){
                        case 0:
                            receivable.setCtype("AP");
                            break;
                        case 1:
                            receivable.setCtype("AR");
                            break;
                    }
                    receivable.setNactualamount(detail.getNcostprice());
                    receivable.setNdiscount(1.00);
                    receivable.setNamount(detail.getNcostprice());
                    receivable.setIstatus(0);
                    receivable.setDrecorddate(date);
                    receivable.setDupdatedate(date);
                    orderReceivableList.add(receivable);
                }
                TOperateLog log = new TOperateLog();
                log.setUid(DataUtils.newUUID());
                log.setCtype("新增");
                log.setCoperateip(ip);
                log.setCoperateurl(url);
                log.setClinktable("t_supplier_phone_order");
                log.setUlinktableid(DataUtils.newUUID());
                log.setCstatus(detail.getItypeStr());
                log.setCmemo("新增供应商手机单据成功");
                log.setUuserid(user.getUid());
                log.setDoperatetime(date);
                logList.add(log);
            }
        }
        int allQuantity = orderList.size() + orderStatusList.size() + orderReceivableList.size() + logList.size();
        int orderAffectedQuantity = 0,orderStatusAffectedQuantity = 0,orderReceivableAffectedQuantity = 0,logAffectedQuantity = 0;
        for(TSupplierPhoneOrder detail : orderList){
            orderAffectedQuantity += orderDao.add(detail);
        }
        for(TSupplierPhoneOrderStatus status : orderStatusList){
            orderStatusAffectedQuantity += orderStatusDao.add(status);
        }
        for(TSupplierPhoneOrderReceivable receivable : orderReceivableList){
            orderReceivableAffectedQuantity += orderReceivableDao.add(receivable);
        }
        for(TOperateLog log : logList){
            logAffectedQuantity += logDao.addOperateLog(log);
        }
        if(allQuantity == orderAffectedQuantity + orderStatusAffectedQuantity + orderReceivableAffectedQuantity + logAffectedQuantity)
            return true;
        return false;
    }

    public List<TSupplierPhoneOrder> getSupplierPhoneOrderList(TSupplierPhoneOrder order) {
        return orderDao.get(order);
    }

    public List<TSupplierPhoneOrderReceivable> getSupplierPhoneOrderReceivableList(String imei) {
        return orderReceivableDao.getByIMEI(imei);
    }

    public List<TSupplierPhoneOrderStatus> getSupplierPhoneOrderStatusList(String imei) {
        return orderStatusDao.get(imei);
    }

    public TSupplierPhoneOrder getSupplierPhoneOrder(String imei) {
        return orderDao.get(imei);
    }
    
    @Transactional
    public boolean returnSupplierPhoneOrder(String imei, TUser user, String ip, String url) {
        List<TSupplierPhoneOrderReceivable> receivableList = orderReceivableDao.getByIMEI(imei);
        List<TSupplierPhoneOrderReceipts> receiptsList = new ArrayList<TSupplierPhoneOrderReceipts>();
        
        for(TSupplierPhoneOrderReceivable receivable : receivableList){
            TSupplierPhoneOrderReceipts receipts = orderReceiptsDao.get(receivable.getUid());
            if(receipts != null){
                if(receipts.getIstatus() == 1)
                    receiptsList.add(receipts);
            }
        }
        
        double totalPrice = 0.00;
        for(TSupplierPhoneOrderReceipts receipts : receiptsList){
            totalPrice += receipts.getNamount();
        }
        int count = 0;
        Date date = new Date();
        String usupplierid = null;
        
        TSupplierPhoneOrderStatus status = new TSupplierPhoneOrderStatus();
        status.setUid(DataUtils.newUUID());
        status.setImei(imei);
        status.setItype(1);
        status.setIstatus(1);
        status.setUuserid(user.getUid());
        status.setDrecorddate(date);
        orderStatusDao.modStatus(imei, 0);
        count += orderStatusDao.add(status);
        
        for(TSupplierPhoneOrderReceivable receivable : receivableList){
            count += orderReceivableDao.modStatus(receivable.getUid(), 1, date);
            usupplierid = receivable.getUsupplierid();
        }
        if(totalPrice > 0){
            TSupplierPhoneOrderReceivable receivable = new TSupplierPhoneOrderReceivable();
            receivable.setUid(DataUtils.newUUID());
            receivable.setUsupplierid(usupplierid);
            receivable.setImei(imei);
            receivable.setUuserid(user.getUid());
            receivable.setUdeptid(user.getUdeptid());
            receivable.setCtype("AR");
            receivable.setNactualamount(totalPrice);
            receivable.setNdiscount(1.00);
            receivable.setNamount(totalPrice);
            receivable.setIstatus(0);
            receivable.setDrecorddate(date);
            receivable.setDupdatedate(date);
            count += orderReceivableDao.add(receivable);
        }
        
        TOperateLog log = new TOperateLog();
        log.setUid(DataUtils.newUUID());
        log.setCtype("退库");
        log.setCoperateip(ip);
        log.setCoperateurl(url);
        log.setClinktable("t_supplier_phone_order");
        log.setUlinktableid(DataUtils.newUUID());
        log.setCstatus("成功");
        log.setCmemo("供应商手机单据退库成功");
        log.setUuserid(user.getUid());
        log.setDoperatetime(date);
        count += logDao.addOperateLog(log);
        if(count >= receivableList.size() + 2)
            return true;
        return false;
    };
    
    @Transactional
    public boolean auditSupplierPhoneOrder(String imei, TUser user, String ip, String url) {
        clearRP(imei);
        TSupplierPhoneOrder order = orderDao.get(imei);
        int count = orderDao.modStatus(imei, 1);
        Date date = new Date();
        TSupplierPhoneOrderReceivable receivable = new TSupplierPhoneOrderReceivable();
        receivable.setUid(DataUtils.newUUID());
        receivable.setUsupplierid(order.getUsupplierid());
        receivable.setImei(order.getImei());
        receivable.setUuserid(user.getUid());
        receivable.setUdeptid(user.getUdeptid());
        receivable.setCtype("AP");
        receivable.setNactualamount(order.getNcostprice());
        receivable.setNdiscount(1.00);
        receivable.setNamount(order.getNcostprice());
        receivable.setIstatus(0);
        receivable.setDrecorddate(date);
        receivable.setDupdatedate(date);
        count += orderReceivableDao.add(receivable);
        TOperateLog log = new TOperateLog();
        log.setUid(DataUtils.newUUID());
        log.setCtype("审核");
        log.setCoperateip(ip);
        log.setCoperateurl(url);
        log.setClinktable("t_supplier_phone_order");
        log.setUlinktableid(DataUtils.newUUID());
        log.setCstatus(order.getItypeStr());
        log.setCmemo("审核供应商手机单据成功");
        log.setUuserid(user.getUid());
        log.setDoperatetime(date);
        count += logDao.addOperateLog(log);
        if(count >= 3)
            return true;
        return false;
    }

    @Transactional
    public boolean reverseAuditSupplierPhoneOrder(String imei, TUser user, String ip, String url) {
        clearRP(imei);
        int count = orderDao.modStatus(imei, 0);
        TOperateLog log = new TOperateLog();
        log.setUid(DataUtils.newUUID());
        log.setCtype("反审核");
        log.setCoperateip(ip);
        log.setCoperateurl(url);
        log.setClinktable("t_supplier_phone_order");
        log.setUlinktableid(DataUtils.newUUID());
        log.setCstatus("成功");
        log.setCmemo("反审核供应商手机单据成功");
        log.setUuserid(user.getUid());
        log.setDoperatetime(new Date());
        count += logDao.addOperateLog(log);
        if(count >= 2)
            return true;
        return false;
    }

    @Transactional
    public boolean deleteSupplierPhoneOrder(String imei, TUser user, String ip, String url) {
        clearRP(imei);
        int count = orderStatusDao.delByIMEI(imei);
        count += orderDao.del(imei);
        TOperateLog log = new TOperateLog();
        log.setUid(DataUtils.newUUID());
        log.setCtype("删除");
        log.setCoperateip(ip);
        log.setCoperateurl(url);
        log.setClinktable("t_supplier_phone_order");
        log.setUlinktableid(DataUtils.newUUID());
        log.setCstatus("成功");
        log.setCmemo("删除供应商手机单据成功");
        log.setUuserid(user.getUid());
        log.setDoperatetime(new Date());
        count += logDao.addOperateLog(log);
        if(count >= 3)
            return true;
        return false;
    }
    
    /**
     * 清除 收付款信息
     * @param imei
     * @author Liu bo
     */
    private void clearRP(String imei){
        List<TSupplierPhoneOrderReceivable> receivableList = orderReceivableDao.getByIMEI(imei);
        for(TSupplierPhoneOrderReceivable receivable : receivableList){
            List<TSupplierPhoneOrderReceipts> receiptsList = orderReceiptsDao.getByUreceivableid(receivable.getUid());
            for(TSupplierPhoneOrderReceipts receipts : receiptsList)
                orderReceiptsDao.del(receipts.getUid());
            orderReceivableDao.del(receivable.getUid());
        }
    }
}
