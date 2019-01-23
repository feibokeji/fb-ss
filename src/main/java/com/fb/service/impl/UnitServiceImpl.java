package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TUnitDao;
import com.fb.domain.po.TUnit;
import com.fb.service.SimpServiceAbstract;
import com.fb.service.UnitService;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月22日 下午8:29:03 
* 类说明:单位类操作接口实现类
*/
@Service
public class UnitServiceImpl extends SimpServiceAbstract implements UnitService {
	
	@Autowired
	private TUnitDao unitDao;

	public int addUnit(TUnit unit) {
		return unitDao.add(unit);
	}
	
	public int getUseNumber(String uunitid) {
		return unitDao.getUseNumber(uunitid);
	}

	@Transactional
	public int deleteUnit(String uid) {
		return unitDao.del(uid);
	}

	@Transactional
	public int modifyUnit(TUnit unit) {
		return unitDao.mod(unit);
	}

	public TUnit getUnit(String uid) {
		return unitDao.get(uid);
	}

	public List<TUnit> getUnitList() {
		return unitDao.getList();
	}

}
