package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TCustomerDao;
import com.fb.domain.po.TCustomer;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午6:00:34 
* 类说明:
*/
@Service
public class TCustomerDaoImpl extends SimpMapper<TCustomer> implements TCustomerDao {

	public int add(TCustomer customer) {
		return super.save(customer);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TCustomer customer) {
		return super.update(customer);
	}

	public TCustomer get(String uid) {
		StringBuilder sql = new StringBuilder("select c.uid,c.ucustomertypeid,c.cname as ccustomertypename,c.uuserid,c.udeptid");
		sql.append(",c.cname,c.isex,c.ccontactnumber,c.caddress");
		sql.append(",c.cwechat,c.dbirthday,c.iintegral,c.ipaymentdays,c.drecorddate,c.dupdatedate");
		sql.append(" from t_customer as c left join t_customer_type as ct on ct.uid = c.ucustomertypeid");
		sql.append(" where c.uid = :uid");
		return super.get(sql, new QMap("uid",uid), TCustomer.class);
	}

	public List<TCustomer> getList(TCustomer customer) {
		StringBuilder sql = new StringBuilder("select c.uid,c.ucustomertypeid,ct.cname as ccustomertypename,c.uuserid,c.udeptid");
		sql.append(",c.cname,c.isex,c.ccontactnumber,c.caddress");
		sql.append(",c.cwechat,c.dbirthday,c.iintegral,c.ipaymentdays,c.drecorddate,c.dupdatedate");
		sql.append(" from t_customer as c left join t_customer_type as ct on ct.uid = c.ucustomertypeid where 1 = 1");
		QMap map = new QMap();
		if(DataUtils.isUid(customer.getUdeptid()))
		{
			sql.append(" and c.udeptid = :udeptid");
			map.put("udeptid", customer.getUdeptid());
		}
		if(DataUtils.isUid(customer.getUcustomertypeid()))
		{
			sql.append(" and c.ucustomertypeid = :ucustomertypeid");
			map.put("ucustomertypeid",customer.getUcustomertypeid());
		}
		if(!DataUtils.isNullOrEmpty(customer.getCname()))
		{
			sql.append(" and c.cname like '%" + customer.getCname() + "%'");
		}
		if(customer.getIsex() != null && customer.getIsex() != -1)
		{
			sql.append(" and c.isex = :isex");
			map.put("isex", customer.getIsex());
		}
		if(!DataUtils.isNullOrEmpty(customer.getCcontactnumber()))
		{
			sql.append(" and c.ccontactnumber like '%" + customer.getCcontactnumber() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(customer.getCwechat()))
		{
			sql.append(" and c.cwechat like '%" + customer.getCwechat() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(customer.getDbirthdayStrMin()))
		{
			sql.append(" and c.dbirthday >= :dbirthdayStrMin");
			map.put("dbirthdayStrMin", customer.getDbirthdayStrMin());
		}
		if(!DataUtils.isNullOrEmpty(customer.getDbirthdayStrMax()))
		{
			sql.append(" and c.dbirthday <= :dbirthdayStrMax");
			map.put("dbirthdayStrMax", customer.getDbirthdayStrMax());
		}
		if(customer.getIintegralMin() != null)
		{
			sql.append(" and c.iintegral >= :iintegralMin");
			map.put("iintegralMin", customer.getIintegralMin());
		}
		if(customer.getIintegralMax() != null)
		{
			sql.append(" and c.iintegral <= :iintegralMax");
			map.put("iintegralMax", customer.getIintegralMax());
		}
		if(customer.getIpaymentdaysMin() != null)
		{
			sql.append(" and c.ipaymentdays >= :ipaymentdaysMin");
			map.put("ipaymentdaysMin", customer.getIpaymentdaysMin());
		}
		if(customer.getIpaymentdaysMax() != null)
		{
			sql.append(" and c.ipaymentdays <= :ipaymentdaysMax");
			map.put("ipaymentdaysMax", customer.getIpaymentdaysMax());
		}
		if(!DataUtils.isNullOrEmpty(customer.getDrecorddateStrMin()))
		{
			sql.append(" and c.drecorddate >= '" + customer.getDrecorddateStrMin() + " 00:00:00'");
		}
		if(!DataUtils.isNullOrEmpty(customer.getDrecorddateStrMax()))
		{
			sql.append(" and c.drecorddate <= '" + customer.getDrecorddateStrMax() + " 00:00:00'");
		}
		sql.append(" order by c.ucustomertypeid,c.cname asc");
		return super.findList(sql, map);
	}

	public int getPhoneBusinessNumber(String ucustomerid) {
		String sql = "select count(*) from t_phone_inventory where ucustomerid = :ucustomerid";
		return super.getInt(sql, new QMap("ucustomerid",ucustomerid));
	}

	public int getOtherBusinessNumber(String ucustomerid) {
		String sql = "select count(*) from t_customer_order where ucustomerid = :ucustomerid";
		return super.getInt(sql, new QMap("ucustomerid",ucustomerid));
	}

}
