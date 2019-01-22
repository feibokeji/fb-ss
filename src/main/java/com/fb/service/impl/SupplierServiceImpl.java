package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TSupplierDao;
import com.fb.domain.po.TSupplier;
import com.fb.service.SimpServiceAbstract;
import com.fb.service.SupplierService;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午7:20:21 
* 类说明:
*/
@Service
public class SupplierServiceImpl extends SimpServiceAbstract implements SupplierService {
	
	@Autowired
	private TSupplierDao supplierDao;

	public List<TSupplier> getSupplierList(TSupplier supplier) {
		return supplierDao.getList(supplier);
	}
	
	public int addSupplier(TSupplier supplier) {
		return supplierDao.add(supplier);
	}
	
	@Transactional
	public int modifySupplier(TSupplier supplier) {
		return supplierDao.mod(supplier);
	}

	public TSupplier getSupplier(String uid) {
		return supplierDao.get(uid);
	}

	public int getSupplierBusinessNumber(String uid) {
		int phoneBusinessNumber = supplierDao.getPhoneBusinessNumber(uid);
		int otherBusinessNumber = supplierDao.getOtherBusinessNumber(uid);
		return phoneBusinessNumber + otherBusinessNumber;
	}
	
	@Transactional
	public int deleteSupplier(String uid) {
		return supplierDao.del(uid);
	}

}
