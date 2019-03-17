package com.fb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.FormatUtils;
import com.fb.dao.TSupplierOrderDao;
import com.fb.dao.TSupplierOrderDetailDao;
import com.fb.dao.TSupplierReceiptsDao;
import com.fb.dao.TSupplierReceivableDao;
import com.fb.domain.po.TSupplierOrder;
import com.fb.domain.po.TSupplierOrderDetail;
import com.fb.domain.po.TSupplierReceipts;
import com.fb.domain.po.TSupplierReceivable;
import com.fb.service.SimpServiceAbstract;
import com.fb.service.SupplierOrderService;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月28日 上午10:41:31 
* 类说明:供应商单据服务接口实现类
*/
@Service
public class SupplierOrderServiceImpl extends SimpServiceAbstract implements SupplierOrderService {
	
	@Autowired
	private TSupplierOrderDao supplierOrderDao;
	
	@Autowired
	private TSupplierOrderDetailDao supplierOrderDetailDao;
	
	@Autowired
	private TSupplierReceivableDao supplierReceivableDao;
	
	@Autowired
	private TSupplierReceiptsDao supplierReceiptsDao;

	@Transactional
	public int addSupplierOrder(TSupplierOrder supplierOrder) {
		String cno = "GYS" + FormatUtils.formatDate(new Date(),"yyyyMMddHHmmss");
		Date date = new Date();
		supplierOrder.setUid(DataUtils.newUUID());
		supplierOrder.setCno(cno);
		supplierOrder.setDrecorddate(FormatUtils.toDate(supplierOrder.getDrecorddateStr()));
		supplierOrder.setDupdatedate(date);
		List<TSupplierOrderDetail> detailList = new ArrayList<TSupplierOrderDetail>();
		double totalNamount = 0.00;
		for (TSupplierOrderDetail detail : supplierOrder.getOrderDetailList()) {
			if(DataUtils.isUid(detail.getUothergoodsid()) && detail.getNquantity() != null && detail.getNprice() != null && detail.getNamount() != null) {
				detail.setUid(DataUtils.newUUID());
				detail.setUorderid(supplierOrder.getUid());
				detail.setUuserid(supplierOrder.getUuserid());
				detail.setUdeptid(supplierOrder.getUdeptid());
				detail.setDrecorddate(date);
				detail.setDupdatedate(date);
				detailList.add(detail);
				totalNamount += detail.getNamount();
			}
		}
		int count = 0;
		count += supplierOrderDao.add(supplierOrder);
		int isort = 1;
		for(TSupplierOrderDetail detail : detailList) {
			detail.setIsort(isort);
			count += supplierOrderDetailDao.add(detail);
			isort++;
		}
		if(supplierOrder.getIstatus() == 0) {
		    if(supplierOrder.getItype() == 0 || supplierOrder.getItype() == 1){
		        TSupplierReceivable receivable = new TSupplierReceivable();
	            receivable.setUid(DataUtils.newUUID());
	            receivable.setUsupplierid(supplierOrder.getUsupplierid());
	            receivable.setUorderid(supplierOrder.getUid());
	            receivable.setUuserid(supplierOrder.getUuserid());
	            receivable.setUdeptid(supplierOrder.getUdeptid());
		        switch(supplierOrder.getItype()){
                    case 0:
                        receivable.setCtype("AP");
                        break;
                    case 1:
                        receivable.setCtype("AR");
                        break;
                    default:
                        receivable.setCtype("AP");
                        break;
                }
		        receivable.setNactualamount(totalNamount);
	            receivable.setNdiscount(1.00);
	            receivable.setNamount(totalNamount);
	            receivable.setIstatus(0);
	            receivable.setDrecorddate(date);
	            receivable.setDupdatedate(date);
	            count += supplierReceivableDao.add(receivable); 
		    }
		}
		return count;
	}

	public List<TSupplierOrder> getSupplierOrder(TSupplierOrder supplierOrder) {
		return supplierOrderDao.getList(supplierOrder);
	}

	public List<TSupplierOrderDetail> getSupplierOrderDetail(String uorderid) {
		return supplierOrderDetailDao.getList(uorderid);
	}

	public List<TSupplierReceivable> getSupplierReceivable(String uorderid) {
		return supplierReceivableDao.getList(uorderid);
	}

    public TSupplierOrder getSupplierOrder(String uid) {
        return supplierOrderDao.get(uid);
    }
    
    @Transactional
    public int modifySupplierOrder(TSupplierOrder supplierOrder) {
        Date date = new Date();
        supplierOrder.setDrecorddate(FormatUtils.toDate(supplierOrder.getDrecorddateStr()));
        supplierOrder.setDupdatedate(date);
        List<TSupplierOrderDetail> detailList = new ArrayList<TSupplierOrderDetail>();
        double totalNamount = 0.00;
        for (TSupplierOrderDetail detail : supplierOrder.getOrderDetailList()) {
            if(DataUtils.isUid(detail.getUothergoodsid()) && detail.getNquantity() != null && detail.getNprice() != null && detail.getNamount() != null) {
                detail.setUid(DataUtils.newUUID());
                detail.setUorderid(supplierOrder.getUid());
                detail.setUuserid(supplierOrder.getUuserid());
                detail.setUdeptid(supplierOrder.getUdeptid());
                detail.setDrecorddate(date);
                detail.setDupdatedate(date);
                detailList.add(detail);
                totalNamount += detail.getNamount();
            }
        }
        int count = 0;
        count += supplierOrderDao.mod(supplierOrder);
        count += supplierOrderDetailDao.del(supplierOrder.getUid());
        count += supplierReceivableDao.del(supplierOrder.getUid());
        int isort = 1;
        for(TSupplierOrderDetail detail : detailList) {
            detail.setIsort(isort);
            count += supplierOrderDetailDao.add(detail);
            isort++;
        }
        if(supplierOrder.getIstatus() == 0) {
            if(supplierOrder.getItype() == 0 || supplierOrder.getItype() == 1){
                TSupplierReceivable receivable = new TSupplierReceivable();
                receivable.setUid(DataUtils.newUUID());
                receivable.setUsupplierid(supplierOrder.getUsupplierid());
                receivable.setUorderid(supplierOrder.getUid());
                receivable.setUuserid(supplierOrder.getUuserid());
                receivable.setUdeptid(supplierOrder.getUdeptid());
                switch(supplierOrder.getItype()){
                    case 0:
                        receivable.setCtype("AP");
                        break;
                    case 1:
                        receivable.setCtype("AR");
                    default:
                        receivable.setCtype("AP");
                        break;
                }
                receivable.setNactualamount(totalNamount);
                receivable.setNdiscount(1.00);
                receivable.setNamount(totalNamount);
                receivable.setIstatus(0);
                receivable.setDrecorddate(date);
                receivable.setDupdatedate(date);
                count += supplierReceivableDao.add(receivable); 
            }
        }
        return count;
    }

    public int getSupplierReceiptsNumber(String uorderid) {
        return supplierReceiptsDao.getOrderReceiptsNumber(uorderid, -1);
    }

    @Transactional
    public int deleteSupplierOrder(String uid) {
        int count = 0;
        count += supplierReceivableDao.del(uid);
        count += supplierOrderDetailDao.del(uid);
        count += supplierOrderDao.del(uid);
        return count;
    }

    @Transactional
    public int auditSupplierOrder(String uid,String uuserid,String udeptid) {
        TSupplierOrder order = supplierOrderDao.get(uid);
        int count = 0;
        count += supplierOrderDao.modStatus(uid, 0);
        supplierReceivableDao.del(uid);
        if(order.getItype() == 0 || order.getItype() == 1){
            double totalNamount = 0.00;
            for (TSupplierOrderDetail detail : supplierOrderDetailDao.getList(uid)) {
                if(DataUtils.isUid(detail.getUothergoodsid()) && detail.getNquantity() != null && detail.getNprice() != null && detail.getNamount() != null) {
                    totalNamount += detail.getNamount();
                }
            }
            Date date = new Date();
            TSupplierReceivable receivable = new TSupplierReceivable();
            receivable.setUid(DataUtils.newUUID());
            receivable.setUsupplierid(order.getUsupplierid());
            receivable.setUorderid(uid);
            receivable.setUuserid(uuserid);
            receivable.setUdeptid(udeptid);
            switch(order.getItype()){
                case 0:
                    receivable.setCtype("AP");
                    break;
                case 1:
                    receivable.setCtype("AR");
                default:
                    receivable.setCtype("AP");
                    break;
            }
            receivable.setNactualamount(totalNamount);
            receivable.setNdiscount(1.00);
            receivable.setNamount(totalNamount);
            receivable.setIstatus(0);
            receivable.setDrecorddate(date);
            receivable.setDupdatedate(date);
            count += supplierReceivableDao.add(receivable);   
        } 
        return count;
    }

    @Transactional
    public int unAuditSupplierOrder(String uid, String uuserid, String udeptid) {
        TSupplierOrder order = supplierOrderDao.get(uid);
        int count = 0;
        count += supplierOrderDao.modStatus(uid, 1);
        supplierReceivableDao.del(uid);
        if(order.getItype() == 0 || order.getItype() == 1){
            count += supplierReceivableDao.del(uid);
        }
        return count;
    }

    public List<TSupplierReceipts> getSupplierOrderReceipts(String uorderid) {
        return supplierReceiptsDao.getReceiptsListByOrder(uorderid);
    }

}
