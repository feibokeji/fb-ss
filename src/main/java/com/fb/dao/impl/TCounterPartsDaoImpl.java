package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TCounterPartsDao;
import com.fb.domain.po.TCounterParts;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午6:05:56 
* 类说明:
*/
@Service
public class TCounterPartsDaoImpl extends SimpMapper<TCounterParts> implements TCounterPartsDao {

	public int add(TCounterParts counterParts) {
		return super.save(counterParts);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TCounterParts counterParts) {
		return super.update(counterParts);
	}

	public TCounterParts get(String uid) {
		return super.get(uid);
	}

	public List<TCounterParts> getList(TCounterParts counterParts) {
		StringBuilder sql = new StringBuilder("select uid,uuserid,udeptid,cshopname,coperator,ctelephone,cwechat,caddress,cbusinessscope,ibusinessstatus,ipaymentdays,drecorddate,dupdatedate from t_counterparts where 1 = 1");
		QMap map = new QMap();
		if(DataUtils.isUid(counterParts.getUdeptid()))
		{
			sql.append(" and udeptid = :udeptid");
			map.put("udeptid", counterParts.getUdeptid());
		}
		if(!DataUtils.isNullOrEmpty(counterParts.getCshopname()))
		{
			sql.append(" and cshopname like '%" + counterParts.getCshopname() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(counterParts.getCoperator()))
		{
			sql.append(" and coperator like '%" + counterParts.getCoperator() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(counterParts.getCtelephone()))
		{
			sql.append(" and ctelephone like '%" + counterParts.getCtelephone() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(counterParts.getCwechat()))
		{
			sql.append(" and cwechat like '%" + counterParts.getCwechat() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(counterParts.getCbusinessscope()))
		{
			sql.append(" and cbusinessscope like '%" + counterParts.getCbusinessscope() + "%'");
		}
		if(counterParts.getIbusinessstatus() != null && counterParts.getIbusinessstatus() != -1)
		{
			sql.append(" and ibusinessstatus = :ibusinessstatus");
			map.put("ibusinessstatus", counterParts.getIbusinessstatus());
		}
		if(counterParts.getIpaymentdaysMin() != null)
		{
			sql.append(" and ipaymentdays >= :ipaymentdaysMin");
			map.put("ipaymentdaysMin", counterParts.getIpaymentdaysMin());
		}
		if(counterParts.getIpaymentdaysMax() != null)
		{
			sql.append(" and ipaymentdays <= :ipaymentdaysMax");
			map.put("ipaymentdaysMax", counterParts.getIpaymentdaysMax());
		}
		if(!DataUtils.isNullOrEmpty(counterParts.getDrecorddateStrMin()))
		{
			sql.append(" and drecorddate >= :drecorddateStrMin");
			map.put("drecorddateStrMin", counterParts.getDrecorddateStrMin() + " 00:00:00");
		}
		if(!DataUtils.isNullOrEmpty(counterParts.getDrecorddateStrMax()))
		{
			sql.append(" and drecorddate <= :drecorddateStrMax");
			map.put("drecorddateStrMax", counterParts.getDrecorddateStrMax() + " 23:59:59");
		}
		sql.append(" order by cshopname");
		return super.findList(sql, map);
	}

	public int getPhoneBusinessNumber(String ucounterpartsid) {
		String sql = "select count(*) from t_counterparts_phone_order where ucounterpartsid = :ucounterpartsid";
		return super.getInt(sql, new QMap("ucounterpartsid",ucounterpartsid));
	}

}
