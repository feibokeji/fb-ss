package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TSupplierOrderDetailDao;
import com.fb.domain.po.TSupplierOrderDetail;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月27日 下午5:06:26 
* 类说明:供应商单据明细类操作接口实现类
*/
@Service
public class TSupplierOrderDetailDaoImpl extends SimpMapper<TSupplierOrderDetail> implements TSupplierOrderDetailDao {

	public int add(TSupplierOrderDetail supplierOrderDetail) {
		return super.save(supplierOrderDetail);
	}

	public int del(String uorderid) {
		String sql = "delete from t_supplier_order_detail where uorderid = :uorderid";
		return super.execute(sql, new QMap("uorderid",uorderid));
	}

	public List<TSupplierOrderDetail> getList(String uorderid) {
		StringBuilder sql = new StringBuilder("select sod.uid,sod.uorderid,sod.uothergoodsid,sod.uuserid,u.cname as cusername,sod.udeptid,og.cno,og.cbarcode,b.cname as cbrandname");
		sql.append(",c.cname as ccategoryname,og.cname,unit.cname as cunitname,sod.nquantity,sod.nprice,sod.namount");
		sql.append(",sod.drecorddate,sod.dupdatedate,sod.isort from t_supplier_order_detail as sod");
		sql.append(" left join t_other_goods as og on og.uid = sod.uothergoodsid");
		sql.append(" left join t_user as u on u.uid = sod.uuserid");
		sql.append(" left join t_brand as b on b.uid = og.ubrandid");
		sql.append(" left join t_category as c on c.uid = og.ucategoryid");
		sql.append(" left join t_unit as unit on unit.uid = og.uunitid");
		sql.append(" where sod.uorderid = :uorderid order by sod.isort");
		return super.findList(sql, new QMap("uorderid",uorderid));
	}

}
