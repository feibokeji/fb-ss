package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TSupplierReceivableDao;
import com.fb.domain.po.TSupplierReceivable;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月27日 下午5:27:14 
* 类说明:供应商应收或应付类操作接口实现类
*/
@Service
public class TSupplierReceivableDaoImpl extends SimpMapper<TSupplierReceivable> implements TSupplierReceivableDao {

	public int add(TSupplierReceivable supplierReceivable) {
		return super.save(supplierReceivable);
	}

	public int del(String uorderid) {
		String sql = "delete from t_supplier_receivable where uorderid = :uorderid";
		return super.execute(sql, new QMap("uorderid",uorderid));
	}

	public int modStatus(String uid, int istatus) {
		String sql = "update t_supplier_receivable set istatus = :istatus where uid = :uid";
		QMap map = new QMap();
		map.put("istatus", istatus);
		map.put("uid", uid);
		return super.execute(sql, map);
	}

	public int mod(TSupplierReceivable supplierReceivable) {
		return super.update(supplierReceivable);
	}

	public TSupplierReceivable get(String uid) {
		StringBuilder sql = new StringBuilder("select sr.uid,sr.usupplierid,s.cname as csuppliername,sr.uorderid,so.cno as corderno");
		sql.append(",sr.uuserid,u.cname as cusername,sr.udeptid,sr.ctype,sr.nactualamount,sr.ndiscount");
		sql.append(",sr.namount,sr.istatus,sr.drecorddate,sr.dupdatedate");
		sql.append(" from t_supplier_receivable as sr");
		sql.append(" left join t_supplier as s on s.uid = sr.usupplierid");
		sql.append(" left join t_supplier_order as so on so.uid = sr.uorderid");
		sql.append(" left join t_user as u on u.uid = sr.uuserid");
		sql.append(" where sr.uid = :uid");
		return super.get(sql, new QMap("uid",uid), TSupplierReceivable.class);
	}

	public List<TSupplierReceivable> getList(TSupplierReceivable supplierReceivable) {
		QMap map = new QMap();
		StringBuilder sql = new StringBuilder("select sr.uid,sr.usupplierid,s.cname as csuppliername,sr.uorderid,so.cno as corderno");
		sql.append(",sr.uuserid,u.cname as cusername,sr.udeptid,sr.ctype,sr.nactualamount,sr.ndiscount");
		sql.append(",sr.namount,sr.istatus,sr.drecorddate,sr.dupdatedate");
		sql.append(" from t_supplier_receivable as sr");
		sql.append(" left join t_supplier as s on s.uid = sr.usupplierid");
		sql.append(" left join t_supplier_order as so on so.uid = sr.uorderid");
		sql.append(" left join t_user as u on u.uid = sr.uuserid");
		sql.append(" where 1 = 1");
		if(DataUtils.isUid(supplierReceivable.getUsupplierid())) {
			sql.append(" and sr.usupplierid = :usupplierid");
			map.put("usupplierid", supplierReceivable.getUsupplierid());
		}
		if(!DataUtils.isNullOrEmpty(supplierReceivable.getCorderno())) {
			sql.append(" and so.cno like :cno");
			map.put("cno", "%" + supplierReceivable.getCorderno() + "%");
		}
		if(DataUtils.isUid(supplierReceivable.getUdeptid())) {
			sql.append(" and sr.udeptid = :udeptid");
			map.put("udeptid", supplierReceivable.getUdeptid());
		}
		if(!DataUtils.isNullOrEmpty(supplierReceivable.getCtype())) {
			sql.append(" and sr.ctype = :ctype");
			map.put("ctype", supplierReceivable.getCtype());
		}
		if(supplierReceivable.getIstatus() != null && supplierReceivable.getIstatus() > 0) {
			sql.append(" and sr.istatus = :istatus");
			map.put("istatus", supplierReceivable.getIstatus());
		}
		if(!DataUtils.isNullOrEmpty(supplierReceivable.getDrecorddateStrMin())) {
			sql.append(" and sr.drecorddate >= :drecorddateStrMin");
			map.put("drecorddateStrMin", supplierReceivable.getDrecorddateStrMin() + " 00:00:00");
		}
		if(!DataUtils.isNullOrEmpty(supplierReceivable.getDrecorddateStrMax())) {
			sql.append(" and sr.drecorddate <= :drecorddateStrMax");
			map.put("drecorddateStrMax", supplierReceivable.getDrecorddateStrMax() + " 23:59:59");
		}
		return super.findList(sql, map);
	}

	public List<TSupplierReceivable> getList(String uorderid) {
		StringBuilder sql = new StringBuilder("select sr.uid,sr.usupplierid,s.cname as csuppliername,sr.uorderid,so.cno as corderno");
		sql.append(",sr.uuserid,u.cname as cusername,sr.udeptid,sr.ctype,sr.nactualamount,sr.ndiscount");
		sql.append(",sr.namount,sr.istatus,sr.drecorddate,sr.dupdatedate");
		sql.append(" from t_supplier_receivable as sr");
		sql.append(" left join t_supplier as s on s.uid = sr.usupplierid");
		sql.append(" left join t_supplier_order as so on so.uid = sr.uorderid");
		sql.append(" left join t_user as u on u.uid = sr.uuserid");
		sql.append(" where sr.uorderid = :uorderid");
		return super.findList(sql, new QMap("uorderid",uorderid));
	}

}
