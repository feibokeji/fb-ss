package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TWarrantyDao;
import com.fb.domain.po.TWarranty;
import com.fb.service.SimpServiceAbstract;
import com.fb.service.WarrantyService;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 上午11:12:28 
* 类说明:保修政策服务接口实现类
*/
@Service
public class WarrantyServiceImpl extends SimpServiceAbstract implements WarrantyService {
	
	@Autowired
	private TWarrantyDao warrantyDao;

	public int addWarranty(TWarranty warranty) {
		return warrantyDao.add(warranty);
	}

	public int getWarrantyUseNumber(String uwarrantyid) {
		int otherUseNumber = warrantyDao.getOtherUseNumber(uwarrantyid);
		int phoneUseNumber = warrantyDao.getPhoneUseNumber(uwarrantyid);
		return otherUseNumber + phoneUseNumber;
	}

	@Transactional
	public int deleteWarranty(String uid) {
		return warrantyDao.del(uid);
	}

	@Transactional
	public int modifyWarranty(TWarranty warranty) {
		return warrantyDao.mod(warranty);
	}

	public TWarranty getWarranty(String uid) {
		return warrantyDao.get(uid);
	}

	public List<TWarranty> getWarrantyList() {
		return warrantyDao.getList();
	}

}
