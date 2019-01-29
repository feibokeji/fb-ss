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
import com.fb.dao.TSupplierReceivableDao;
import com.fb.domain.po.TSupplierOrder;
import com.fb.domain.po.TSupplierOrderDetail;
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
			TSupplierReceivable receivable = new TSupplierReceivable();
			receivable.setUid(DataUtils.newUUID());
			receivable.setUsupplierid(supplierOrder.getUsupplierid());
			receivable.setUorderid(supplierOrder.getUid());
			receivable.setUuserid(supplierOrder.getUuserid());
			receivable.setUdeptid(supplierOrder.getUdeptid());
			receivable.setCtype("AP");
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

	public List<TSupplierOrder> getSupplierOrder(TSupplierOrder supplierOrder) {
		return supplierOrderDao.getList(supplierOrder);
	}

	public List<TSupplierOrderDetail> getSupplierOrderDetail(String uorderid) {
		return supplierOrderDetailDao.getList(uorderid);
	}

	public List<TSupplierReceivable> getSupplierReceivable(String uorderid) {
		return supplierReceivableDao.getList(uorderid);
	}

}
