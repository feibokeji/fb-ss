package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TBrandDao;
import com.fb.domain.po.TBrand;
import com.fb.service.BrandService;
import com.fb.service.SimpServiceAbstract;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月22日 下午5:46:25 
* 类说明:品牌类操作接口实现类
*/
@Service
public class BrandServiceImpl extends SimpServiceAbstract implements BrandService {
	
	@Autowired
	private TBrandDao brandDao;

	public int addBrand(TBrand brand) {
		return brandDao.add(brand);
	}

	public int getPhoneBusinessNumber(String ubrandid) {
		return brandDao.getPhoneBusinessNumber(ubrandid);
	}

	public int getOtherBusinessNumber(String ubrandid) {
		return brandDao.getOtherBusinessNumber(ubrandid);
	}
	
	@Transactional
	public int deleteBrand(String uid) {
		return brandDao.del(uid);
	}
	
	@Transactional
	public int modifyBrand(TBrand brand) {
		return brandDao.mod(brand);
	}

	public TBrand getBrand(String uid) {
		return brandDao.get(uid);
	}

	public List<TBrand> getBrandList(TBrand brand) {
		return brandDao.getList(brand);
	}

}
