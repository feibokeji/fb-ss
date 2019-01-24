package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TPaymentMethodDao;
import com.fb.domain.po.TPaymentMethod;
import com.fb.service.PaymentMethodService;
import com.fb.service.SimpServiceAbstract;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 上午11:07:12 
* 类说明:付款方式服务接口实现类
*/
@Service
public class PaymentMethodServiceImpl extends SimpServiceAbstract implements PaymentMethodService {
	
	@Autowired
	private TPaymentMethodDao paymentMethodDao;

	public int addPaymentMethod(TPaymentMethod paymentMethod) {
		return paymentMethodDao.add(paymentMethod);
	}

	public int getPaymentMethodUseNumber(String upaymentmethodid) {
		int counterPartsBusinessNumber = paymentMethodDao.getCounterPartsBusinessNumber(upaymentmethodid);
		int customerBusinessNumber = paymentMethodDao.getCustomerBusinessNumber(upaymentmethodid);
		int phoneBusinessNumber = paymentMethodDao.getPhoneBusinessNumber(upaymentmethodid);
		int supplierBusinessNumber = paymentMethodDao.getSupplierBusinessNumber(upaymentmethodid);
		return counterPartsBusinessNumber + customerBusinessNumber + phoneBusinessNumber + supplierBusinessNumber;
	}
	
	@Transactional
	public int deletePaymentMethod(String uid) {
		return paymentMethodDao.del(uid);
	}
	
	@Transactional
	public int modifyPaymentMethod(TPaymentMethod paymentMethod) {
		return paymentMethodDao.mod(paymentMethod);
	}

	public TPaymentMethod getPaymentMethod(String uid) {
		return paymentMethodDao.get(uid);
	}

	public List<TPaymentMethod> getPaymentMethodList() {
		return paymentMethodDao.getList();
	}

}
