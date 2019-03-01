package com.fb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.core.utils.DataUtils;
import com.fb.dao.TCounterPartsPhoneOrderDao;
import com.fb.dao.TCounterPartsPhoneReceiptsDao;
import com.fb.dao.TCounterPartsPhoneReceivableDao;
import com.fb.dao.TOperateLogDao;
import com.fb.dao.TSupplierPhoneOrderDao;
import com.fb.dao.TSupplierPhoneOrderStatusDao;
import com.fb.domain.po.TCounterPartsPhoneOrder;
import com.fb.domain.po.TCounterPartsPhoneReceivable;
import com.fb.domain.po.TOperateLog;
import com.fb.domain.po.TSupplierPhoneOrder;
import com.fb.domain.po.TSupplierPhoneOrderStatus;
import com.fb.domain.po.TUser;
import com.fb.service.CounterPartsPhoneOrderService;
import com.fb.service.SimpServiceAbstract;


/**
 * @author 作者：Liu Bo
 * @version 创建时间：2019年2月23日 下午1:23:08
 * 同行手机单据服务接口实现类
 */
@Service
public class CounterPartsPhoneOrderServiceImpl extends SimpServiceAbstract implements CounterPartsPhoneOrderService {
    
    @Autowired
    private TCounterPartsPhoneOrderDao orderDao;
    
    @Autowired
    private TCounterPartsPhoneReceivableDao receivableDao;
    
    @Autowired
    private TCounterPartsPhoneReceiptsDao receiptsDao;
    
    @Autowired
    private TSupplierPhoneOrderDao phoneOrderDao;
    
    @Autowired
    private TSupplierPhoneOrderStatusDao phoneOrderStatusDao;
    
    @Autowired
    private TOperateLogDao logDao;
    
    public int addPhoneOrder(TCounterPartsPhoneOrder order) {
        return orderDao.add(order);
    }
    
    public int delPhoneOrder(String uid) {
        return orderDao.del(uid);
    }
    
    public int modPhoneOrder(TCounterPartsPhoneOrder order) {
        return orderDao.mod(order);
    }
    
    public int modPhoneOrderStatus(String uid, Integer istatus) {
        return orderDao.modStatus(uid, istatus);
    }
    
    public TCounterPartsPhoneOrder getPhoneOrder(String uid) {
        return orderDao.get(uid);
    }
    
    public List<TCounterPartsPhoneOrder> getPhoneOrder(TCounterPartsPhoneOrder order) {
        return orderDao.get(order);
    }
    
    @Transactional
    public boolean executePhoneOut(String ucounterpartsid, String imei, TUser user, String ip, String url) {
        Date date = new Date();
        TSupplierPhoneOrder phoneOrder = phoneOrderDao.get(imei);
        TCounterPartsPhoneOrder order = new TCounterPartsPhoneOrder();
        order.setUid(DataUtils.newUUID());
        order.setUcounterpartsid(ucounterpartsid);
        order.setImei(imei);
        order.setUuserid(user.getUid());
        order.setUdeptid(user.getUdeptid());
        order.setItype(4);
        order.setIstatus(0);
        order.setNamount(phoneOrder.getNcostprice());
        order.setDrecorddate(date);
        order.setDupdatedate(date);
        phoneOrderStatusDao.modStatus(imei, 0);
        TSupplierPhoneOrderStatus phoneOrderStatus = new TSupplierPhoneOrderStatus();
        phoneOrderStatus.setUid(DataUtils.newUUID());
        phoneOrderStatus.setImei(imei);
        phoneOrderStatus.setItype(order.getItype());
        phoneOrderStatus.setIstatus(1);
        phoneOrderStatus.setUuserid(user.getUid());
        phoneOrderStatus.setDrecorddate(date);
        TOperateLog log = new TOperateLog();
        log.setUid(DataUtils.newUUID());
        log.setCtype("新增");
        log.setCoperateip(ip);
        log.setCoperateurl(url);
        log.setClinktable("t_counterparts_phone_order");
        log.setUlinktableid(order.getUid());
        log.setCstatus(order.getItypeStr());
        log.setCmemo("新增同行手机调出单");
        log.setUuserid(user.getUid());
        log.setDoperatetime(date);
        int count = phoneOrderStatusDao.add(phoneOrderStatus);
        count += orderDao.add(order);
        count += logDao.addOperateLog(log);
        if(count == 3)
            return true;
        return false;
    }

    @Transactional
    public boolean auditOrder(String uid, TUser user, String ip, String url) {
        Date date = new Date();
        TCounterPartsPhoneOrder order = orderDao.get(uid);
        TCounterPartsPhoneReceivable receivable = new TCounterPartsPhoneReceivable();
        receivable.setUid(DataUtils.newUUID());
        receivable.setUcounterpartsid(order.getUcounterpartsid());
        receivable.setUcounterpartsorderid(order.getUid());
        receivable.setUuserid(user.getUid());
        receivable.setUdeptid(user.getUdeptid());
        switch(order.getItype()){
            case 4:
                receivable.setCtype("AR");
                break;
            case 5:
                receivable.setCtype("AP");
                break;
        }
        receivable.setNactualamount(order.getNamount());
        receivable.setNdiscount(1.00);
        receivable.setNamount(order.getNamount());
        receivable.setIstatus(0);
        receivable.setDrecorddate(date);
        receivable.setDupdatedate(date);
        TOperateLog log = new TOperateLog();
        log.setUid(DataUtils.newUUID());
        log.setCtype("审核");
        log.setCoperateip(ip);
        log.setCoperateurl(url);
        log.setClinktable("t_counterparts_phone_order");
        log.setUlinktableid(order.getUid());
        log.setCstatus(order.getItypeStr());
        log.setCmemo("审核同行手机调出单");
        log.setUuserid(user.getUid());
        log.setDoperatetime(date);
        int count = orderDao.modStatus(uid, 1);
        count += receivableDao.add(receivable);
        count += logDao.addOperateLog(log);
        if(count == 3)
            return true;
        return false;
    }

    @Transactional
    public boolean reverseAuditOrder(String uid, TUser user, String ip, String url) {
        List<TCounterPartsPhoneReceivable> receivableList = receivableDao.getByUorderid(uid);
        for(TCounterPartsPhoneReceivable receivable : receivableList){
            receiptsDao.delByUreceivableid(receivable.getUid());
        }
        receivableDao.del(uid);
        Date date = new Date();
        TOperateLog log = new TOperateLog();
        log.setUid(DataUtils.newUUID());
        log.setCtype("反审核");
        log.setCoperateip(ip);
        log.setCoperateurl(url);
        log.setClinktable("t_counterparts_phone_order");
        log.setUlinktableid(uid);
        log.setCstatus("成功");
        log.setCmemo("反审核同行手机调出单");
        log.setUuserid(user.getUid());
        log.setDoperatetime(date);
        int count = orderDao.modStatus(uid, 0);
        count += logDao.addOperateLog(log);
        if(count == 2)
            return true;
        return false;
    }
    
    @Transactional
    public boolean executePhoneIn(String uorderid, TUser user, String ip, String url) {
        Date date = new Date();
        TCounterPartsPhoneOrder order = orderDao.get(uorderid);
        order.setItype(5);
        order.setIstatus(0);
        order.setDupdatedate(date);
        TOperateLog log = new TOperateLog();
        log.setUid(DataUtils.newUUID());
        log.setCtype("调入");
        log.setCoperateip(ip);
        log.setCoperateurl(url);
        log.setClinktable("t_counterparts_phone_order");
        log.setUlinktableid(uorderid);
        log.setCstatus("成功");
        log.setCmemo("同行手机调入单");
        log.setUuserid(user.getUid());
        log.setDoperatetime(date);
        int count = orderDao.mod(order);
        count += logDao.addOperateLog(log);
        if(count == 2)
            return true;
        return false;
    }
    
}
