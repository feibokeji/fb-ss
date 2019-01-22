package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TCustomerDao;
import com.fb.domain.po.TCustomer;
import com.fb.service.CustomerService;
import com.fb.service.SimpServiceAbstract;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月20日 下午6:45:24 
* 类说明:客户信息操作接口实现类
*/
@Service
public class CustomerServiceImpl extends SimpServiceAbstract implements CustomerService {
	
	@Autowired
	private TCustomerDao customerDao;

	public int addCustomer(TCustomer customer) {
		return customerDao.add(customer);
	}

	public int getCustomerBusinessNumber(String ucustomerid) {
		int phoneBusinessNumber = customerDao.getPhoneBusinessNumber(ucustomerid);
		int otherBusinessNumber = customerDao.getOtherBusinessNumber(ucustomerid);
		return phoneBusinessNumber + otherBusinessNumber;
	}
	
	@Transactional
	public int deleteCustomer(String uid) {
		return customerDao.del(uid);
	}

	@Transactional
	public int modifyCustomer(TCustomer customer) {
		return customerDao.mod(customer);
	}

	public List<TCustomer> getCustomerList(TCustomer customer) {
		return customerDao.getList(customer);
	}

	public TCustomer getCustomer(String uid) {
		return customerDao.get(uid);
	}

}
