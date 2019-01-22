package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TSupplierDao;
import com.fb.domain.po.TSupplier;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午5:35:18 
* 类说明:
* 供应商类操作接口实现类
*/
@Service
public class TSupplierDaoImpl extends SimpMapper<TSupplier> implements TSupplierDao {

	public int add(TSupplier supplier) {
		return super.save(supplier);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TSupplier supplier) {
		return super.update(supplier);
	}

	public TSupplier get(String uid) {
		return super.get(uid);
	}

	public List<TSupplier> getList(TSupplier supplier) {
		StringBuilder sql = new StringBuilder("select uid,uuserid,udeptid,cno,cname,cbusinessscope,caddress,cfixedtelephone,clinkman,ccontactnumber,cemail,cqq,cwechat,copenbank,cbankcardnumber,ipaymentdays,drecorddate,dupdatedate from t_supplier where 1 = 1");
		QMap map = new QMap();
		if(!DataUtils.isNullOrEmpty(supplier.getUdeptid()) && DataUtils.isUid(supplier.getUdeptid()))
		{
			sql.append(" and udeptid = :udeptid");
			map.put("udeptid", supplier.getUdeptid());
		}
		if(!DataUtils.isNullOrEmpty(supplier.getCname()))
		{
			sql.append(" and cname like '%" + supplier.getCname() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(supplier.getCfixedtelephone()))
		{
			sql.append(" and cfixedtelephone like '%" + supplier.getCfixedtelephone() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(supplier.getClinkman()))
		{
			sql.append(" and clinkman like '%" + supplier.getClinkman() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(supplier.getCcontactnumber()))
		{
			sql.append(" and ccontactnumber like '%" + supplier.getCcontactnumber() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(supplier.getCwechat()))
		{
			sql.append(" and cwechat like '%" + supplier.getCwechat() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(supplier.getCbankcardnumber()))
		{
			sql.append(" and cbankcardnumber like '%" + supplier.getCbankcardnumber() + "%'");
		}
		if(supplier.getIpaymentdaysMin() != null)
		{
			sql.append(" and ipaymentdays >= :ipaymentdaysMin");
			map.add("ipaymentdaysMin", supplier.getIpaymentdaysMin());
		}
		if(supplier.getIpaymentdaysMax() != null)
		{
			sql.append(" and ipaymentdays <= :ipaymentdaysMax");
			map.put("ipaymentdaysMax", supplier.getIpaymentdaysMax());
		}
		if(!DataUtils.isNullOrEmpty(supplier.getDrecorddateMin()))
		{
			sql.append(" and drecorddate >= '" + supplier.getDrecorddateMin() + " 00:00:00'");
		}
		if(!DataUtils.isNullOrEmpty(supplier.getDrecorddateMax()))
		{
			sql.append(" and drecorddate <= '" + supplier.getDrecorddateMax() + " 23:59:59'");
		}
		sql.append(" order by cno");
		return super.findList(sql, map);
	}

	public int getPhoneBusinessNumber(String usupplierid) {
		String sql = "select count(*) from t_phone_inventory where usupplierid = :usupplierid";
		return super.getInt(sql, new QMap("usupplierid",usupplierid));
	}

	public int getOtherBusinessNumber(String usupplierid) {
		String sql = "select count(*) from t_supplier_order where usupplierid = :usupplierid";
		return super.getInt(sql, new QMap("usupplierid",usupplierid));
	}

}
