package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TCustomerTypeDao;
import com.fb.domain.po.TCustomerType;
import com.fb.service.CustomerTypeService;
import com.fb.service.SimpServiceAbstract;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月20日 下午7:26:06 
* 类说明:客户类型信息操作接口实现类
*/
@Service
public class CustomerTypeServiceImpl extends SimpServiceAbstract implements CustomerTypeService {
	
	@Autowired
	private TCustomerTypeDao customerTypeDao;

	public int addCustomerType(TCustomerType customerType) {
		return customerTypeDao.add(customerType);
	}

	public int getCustomerNumber(String uid) {
		return customerTypeDao.getCustomerNumber(uid);
	}

	@Transactional
	public int deleteCustomerType(String uid) {
		return customerTypeDao.del(uid);
	}
	
	@Transactional
	public int modifyCustomerType(TCustomerType customerType) {
		return customerTypeDao.mod(customerType);
	}

	public List<TCustomerType> getCustomerTypeList() {
		return customerTypeDao.getList();
	}

	public TCustomerType getCustomerType(String uid) {
		return customerTypeDao.get(uid);
	}

}
