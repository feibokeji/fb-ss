package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TPhoneModelColorDao;
import com.fb.domain.po.TPhoneModelColor;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月24日 下午7:37:04 
* 类说明:手机型号颜色类操作接口实现类
*/
@Service
public class TPhoneModelColorDaoImpl extends SimpMapper<TPhoneModelColor> implements TPhoneModelColorDao {

	public int add(TPhoneModelColor phoneModelColor) {
		return super.save(phoneModelColor);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int delByUPhoneModelId(String uphonemodelid) {
		String sql = "delete from t_phone_model_color where uphonemodelid = :uphonemodelid";
		return super.execute(sql, new QMap("uphonemodelid",uphonemodelid));
	}

	public List<TPhoneModelColor> getListByUPhoneModelId(String uphonemodelid) {
		StringBuilder sql = new StringBuilder("select pmc.uid,pmc.uphonemodelid,pmc.ucolorid,c.cname as ccolorname");
		sql.append(" from t_phone_model_color as pmc left join t_color as c on c.uid = pmc.ucolorid");
		sql.append(" where pmc.uphonemodelid = :uphonemodelid");
		return super.findList(sql, new QMap("uphonemodelid",uphonemodelid));
	}

	public int getUseNumber(String uphonemodelid, String ucolorid) {
		String sql = "select count(*) from t_phone_inventory where uphonemodelid = :uphonemodelid and ucolorid = :ucolorid";
		QMap map = new QMap();
		map.put("uphonemodelid", uphonemodelid);
		map.put("ucolorid", ucolorid);
		return super.getInt(sql, map);
	}

	public TPhoneModelColor get(String uid) {
		return super.get(uid);
	}

}
