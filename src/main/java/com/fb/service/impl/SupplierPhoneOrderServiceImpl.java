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
import com.fb.dao.TSupplierPhoneOrderReceivableDao;
import com.fb.dao.TSupplierPhoneOrderStatusDao;
import com.fb.domain.po.TOperateLog;
import com.fb.domain.po.TSupplierPhoneOrder;
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
                TSupplierPhoneOrderStatus status = new TSupplierPhoneOrderStatus();
                status.setUid(DataUtils.newUUID());
                status.setImei(detail.getImei());
                status.setItype(order.getItype());
                status.setIstatus(1);
                status.setDrecorddate(date);
                orderList.add(detail);
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
}
