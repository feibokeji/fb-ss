package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TSupplierOrderDao;
import com.fb.domain.po.TSupplierOrder;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月27日 下午4:01:59 
* 类说明:供应商单据类操作接口实现类
*/
@Service
public class TSupplierOrderDaoImpl extends SimpMapper<TSupplierOrder> implements TSupplierOrderDao {

	public int add(TSupplierOrder supplierOrder) {
		return super.save(supplierOrder);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TSupplierOrder supplierOrder) {
		return super.update(supplierOrder);
	}

	public TSupplierOrder get(String uid) {
		StringBuilder sql = new StringBuilder("select so.uid,so.usupplierid,s.cname as csuppliername,so.uuserid,u.cname as cusername");
		sql.append(",so.udeptid,so.cno,so.itype,so.istatus,so.drecorddate,so.dupdatedate from t_supplier_order as so");
		sql.append(" left join t_supplier as s on s.uid = so.usupplierid");
		sql.append(" left join t_user as u on u.uid = so.uuserid");
		sql.append(" where so.uid = :uid");
		return super.get(sql, new QMap("uid",uid), TSupplierOrder.class);
	}

	public List<TSupplierOrder> getList(TSupplierOrder supplierOrder) {
		QMap map = new QMap();
		StringBuilder sql = new StringBuilder("select so.uid,so.usupplierid,s.cname as csuppliername,so.uuserid,u.cname as cusername");
		sql.append(",so.udeptid,so.cno,so.itype,so.istatus,so.drecorddate,so.dupdatedate from t_supplier_order as so");
		sql.append(" left join t_supplier as s on s.uid = so.usupplierid");
		sql.append(" left join t_user as u on u.uid = so.uuserid");
		sql.append(" where 1 = 1");
		if(DataUtils.isUid(supplierOrder.getUdeptid())){
			sql.append(" and so.udeptid = :udeptid");
			map.put("udeptid", supplierOrder.getUdeptid());
		}
		if(DataUtils.isUid(supplierOrder.getUsupplierid())) {
			sql.append(" and so.usupplierid = :usupplierid");
			map.put("usupplierid", supplierOrder.getUsupplierid());
		}
		if(DataUtils.isUid(supplierOrder.getUuserid())) {
			sql.append(" and so.uuserid = :uuserid");
			map.put("uuserid", supplierOrder.getUuserid());
		}
		if(!DataUtils.isNullOrEmpty(supplierOrder.getCno())) {
			sql.append(" and so.cno like :cno");
			map.put("cno", "%" + supplierOrder.getCno() + "%");
		}
		if(supplierOrder.getItype() != null && supplierOrder.getItype() > 0) {
			sql.append(" and so.itype = :itype");
			map.put("itype", supplierOrder.getItype());
		}
		if(supplierOrder.getIstatus() != null && supplierOrder.getIstatus() > 0) {
			sql.append(" and so.istatus = :istatus");
			map.put("istatus", supplierOrder.getIstatus());
		}
		if(!DataUtils.isNullOrEmpty(supplierOrder.getDrecorddateStrMin())) {
			sql.append(" and so.drecorddate >= :drecorddateStrMin");
			map.put("drecorddateStrMin", supplierOrder.getDrecorddateStrMin() + " 00:00:00");
		}
		if(!DataUtils.isNullOrEmpty(supplierOrder.getDrecorddateStrMax())) {
			sql.append(" and so.drecorddate <= :drecorddateStrMax");
			map.put("drecorddateStrMax", supplierOrder.getDupdatedateStrMax() + " 23:59:59");
		}
		if(!DataUtils.isNullOrEmpty(supplierOrder.getDupdatedateStrMin())) {
			sql.append(" and so.dupdatedate >= :dupdatedateStrMin");
			map.put("dupdatedateStrMin", supplierOrder.getDupdatedateStrMin() + " 00:00:00");
		}
		if(!DataUtils.isNullOrEmpty(supplierOrder.getDupdatedateStrMax())) {
			sql.append(" and so.dupdatedate <= :dupdatedateStrMax");
			map.put("dupdatedateStrMax", supplierOrder.getDupdatedateStrMax() + " 23:59:59");
		}
		sql.append(" order by so.drecorddate desc");
		return findList(sql, map);
	}

	public int getAuditReceiptsNumber(String uid) {
		StringBuilder sql = new StringBuilder("select COUNT(*) from t_supplier_receipts as srp");
		sql.append(" left join t_supplier_receivable as srb on srb.uid = srp.ureceivableid");
		sql.append(" where srb.uorderid = :uorderid and srp.istatus = 1");
		return getInt(sql, new QMap("uorderid",uid));
	}

    public int modStatus(String uid, int istatus) {
        QMap map = new QMap();
        String sql = "update t_supplier_order set istatus = :istatus where uid = :uid";
        map.put("istatus", istatus);
        map.put("uid", uid);
        return super.execute(sql, map);
    }

}
