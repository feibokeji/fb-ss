package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TColorDao;
import com.fb.domain.po.TColor;
import com.fb.service.ColorService;
import com.fb.service.SimpServiceAbstract;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 上午11:02:55 
* 类说明:颜色信息服务类接口实现
*/
@Service
public class ColorServiceImpl extends SimpServiceAbstract implements ColorService {
	
	@Autowired
	private TColorDao colorDao;
	
	public int addColor(TColor color) {
		return colorDao.add(color);
	}

	public int getColorUseNumber(String ucolorid) {
		return colorDao.getUseNumber(ucolorid);
	}
	
	@Transactional
	public int deleteColor(String uid) {
		return colorDao.del(uid);
	}
	
	@Transactional
	public int modifyColor(TColor color) {
		return colorDao.mod(color);
	}

	public TColor getColor(String uid) {
		return colorDao.get(uid);
	}

	public List<TColor> getColorList() {
		return colorDao.getList();
	}

}
