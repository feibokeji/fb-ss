package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TCounterPartsDao;
import com.fb.domain.po.TCounterParts;
import com.fb.service.CounterPartsService;
import com.fb.service.SimpServiceAbstract;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月22日 上午10:22:24 
* 类说明:同行信息类操作接口实现类
*/
@Service
public class CounterPartsServiceImpl extends SimpServiceAbstract implements CounterPartsService {
	
	@Autowired
	private TCounterPartsDao counterPartsDao;

	public int addCounterParts(TCounterParts counterParts) {
		return counterPartsDao.add(counterParts);
	}

	public int getPhoneBusinessNumber(String ucounterpartsid) {
		return counterPartsDao.getPhoneBusinessNumber(ucounterpartsid);
	}
	
	@Transactional
	public int deleteCounterParts(String uid) {
		return counterPartsDao.del(uid);
	}
	
	@Transactional
	public int modifyCounterParts(TCounterParts counterParts) {
		return counterPartsDao.mod(counterParts);
	}

	public TCounterParts getCounterParts(String uid) {
		return counterPartsDao.get(uid);
	}

	public List<TCounterParts> getCounterPartsList(TCounterParts counterParts) {
		return counterPartsDao.getList(counterParts);
	}

}
