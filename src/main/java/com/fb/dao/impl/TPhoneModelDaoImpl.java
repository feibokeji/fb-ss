package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.domain.po.TPhoneModel;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月24日 下午8:08:12 
* 类说明:手机类型类操作接口实现类
*/
@Service
public class TPhoneModelDaoImpl extends SimpMapper<TPhoneModel> implements com.fb.dao.TPhoneModelDao {

	public int add(TPhoneModel phoneModel) {
		return super.save(phoneModel);
	}

	public int getUseNumber(String uphonemodelid) {
		String sql = "select count(*) from t_phone_inventory where uphonemodelid = :uphonemodelid";
		return super.getInt(sql, new QMap("uphonemodelid",uphonemodelid));
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TPhoneModel phoneModel) {
		return super.update(phoneModel);
	}

	public TPhoneModel get(String uid) {
		StringBuilder sql = new StringBuilder("select pm.uid,pm.ubrandid,b.cname as cbrandname,pm.uwarrantyid,w.iday as iwarrantyday,w.ccontent as cwarrantycontent,");
		sql.append("pm.cname,pm.cram,pm.crom,pm.ccpu,pm.cscreen,pm.ccamera,pm.cbattery,pm.cnetwork,");
		sql.append("pm.chighlightdesc,pm.drecorddate,pm.dupdatedate");
		sql.append(",(select top 1 pmpr.ncostprice from t_phone_model_price_record as pmpr where pmpr.uphonemodelid = pm.uid and pmpr.istatus = 0) as ncostprice");
		sql.append(",(select top 1 pmpr.nretailprice from t_phone_model_price_record as pmpr where pmpr.uphonemodelid = pm.uid and pmpr.istatus = 0) as nretailprice");
		sql.append(" from t_phone_model as pm");
		sql.append(" left join t_brand as b on b.uid = pm.ubrandid");
		sql.append(" left join t_warranty as w on w.uid = pm.uwarrantyid");
		sql.append(" where pm.uid = :uid");
		return get(sql, new QMap("uid",uid), TPhoneModel.class);
	}

	public List<TPhoneModel> getList(TPhoneModel phoneModel) {
		QMap map = new QMap();
		StringBuilder sql = new StringBuilder("select pm.uid,pm.ubrandid,b.cname as cbrandname,pm.uwarrantyid,w.iday as iwarrantyday,w.ccontent as cwarrantycontent,");
		sql.append("pm.cname,pm.cram,pm.crom,pm.ccpu,pm.cscreen,pm.ccamera,pm.cbattery,pm.cnetwork,");
		sql.append("pm.chighlightdesc,pm.drecorddate,pm.dupdatedate");
		sql.append(",(select top 1 pmpr.ncostprice from t_phone_model_price_record as pmpr where pmpr.uphonemodelid = pm.uid and pmpr.istatus = 0) as ncostprice");
		sql.append(",(select top 1 pmpr.nretailprice from t_phone_model_price_record as pmpr where pmpr.uphonemodelid = pm.uid and pmpr.istatus = 0) as nretailprice");
		sql.append(" from t_phone_model as pm");
		sql.append(" left join t_brand as b on b.uid = pm.ubrandid");
		sql.append(" left join t_warranty as w on w.uid = pm.uwarrantyid");
		sql.append(" where 1 = 1");
		if(DataUtils.isUid(phoneModel.getUbrandid())) {
			sql.append(" and pm.ubrandid = :ubrandid");
			map.put("ubrandid", phoneModel.getUbrandid());
		}
		if(!DataUtils.isNullOrEmpty(phoneModel.getCname())) {
			sql.append(" and pm.cname like '%" + phoneModel.getCname() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(phoneModel.getCram())) {
			sql.append(" and pm.cram like '%" + phoneModel.getCram() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(phoneModel.getCrom())) {
			sql.append(" and pm.crom like '%" + phoneModel.getCrom() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(phoneModel.getCcpu())) {
			sql.append(" and pm.ccpu like '%" + phoneModel.getCcpu() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(phoneModel.getCscreen())) {
			sql.append(" and pm.cscreen like '%" + phoneModel.getCscreen() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(phoneModel.getCcamera())) {
			sql.append(" and pm.ccamera like '%" + phoneModel.getCcamera() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(phoneModel.getCbattery())) {
			sql.append(" and pm.cbattery like '%" + phoneModel.getCbattery() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(phoneModel.getCnetwork())) {
			sql.append(" and pm.cnetwork like '%" + phoneModel.getCnetwork() + "%'");
		}
		return findList(sql, map);
	}

}
