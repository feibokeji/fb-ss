package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TOtherGoodsDao;
import com.fb.domain.po.TOtherGoods;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 下午3:42:47 
* 类说明:其它商品操作接口实现类
*/
@Service
public class TOtherGoodsDaoImpl extends SimpMapper<TOtherGoods> implements TOtherGoodsDao {

	public int add(TOtherGoods otherGoods) {
		return super.save(otherGoods);
	}

	public int getCustomerBusinessNumber(String uothergoodsid) {
		String sql = "select count(*) from t_customer_order_detail where uothergoodsid = :uothergoodsid";
		return super.getInt(sql, new QMap("uothergoodsid",uothergoodsid));
	}

	public int getSupplierBusinessNumber(String uothergoodsid) {
		String sql = "select count(*) from t_supplier_order_detail where uothergoodsid = :uothergoodsid";
		return super.getInt(sql, new QMap("uothergoodsid",uothergoodsid));
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TOtherGoods otherGoods) {
		return super.update(otherGoods);
	}

	public TOtherGoods get(String uid) {
	    StringBuilder sql = new StringBuilder("select og.uid,og.ucategoryid,c.cname as ccategoryname");
        sql.append(",og.ubrandid,b.cname as cbrandname,og.uunitid,u.cname as cunitname");
        sql.append(",og.uwarrantyid,w.iday as iwarrantyday,w.ccontent as cwarrantycontent");
        sql.append(",og.uuserid,og.udeptid,og.cno,og.cbarcode,og.cname,og.cfullname,og.cmnemoniccode");
        sql.append(",og.cspecifications,og.iintegral,og.drecorddate,og.dupdatedate");
        sql.append(",(select top 1 ogpr.ncostprice from t_other_goods_price_record as ogpr where ogpr.uothergoodsid = og.uid and ogpr.istatus = 0) as ncostprice");
        sql.append(",(select top 1 ogpr.nretailprice from t_other_goods_price_record as ogpr where ogpr.uothergoodsid = og.uid and ogpr.istatus = 0) as nretailprice");
        sql.append(",(select top 1 ogpr.drecorddate from t_other_goods_price_record as ogpr where ogpr.uothergoodsid = og.uid and ogpr.istatus = 0) as priceRecordDate");
        sql.append(",(select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 0 and so.istatus = 0 and sod.uothergoodsid = og.uid) as inQuantity,");
        sql.append("(select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 1 and so.istatus = 0 and sod.uothergoodsid = og.uid) as backQuantity,");
        sql.append("(select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 2 and so.istatus = 0 and sod.uothergoodsid = og.uid) as lossQuantity,");
        sql.append("(select ISNULL(SUM(cod.nquantity),0) from t_customer_order_detail as cod left join t_customer_order as co");
        sql.append(" on co.uid = cod.uorderid where co.itype = 0 and co.istatus = 1 and cod.uothergoodsid = og.uid) as sellQuantity,");
        sql.append("(select ISNULL(SUM(cod.nquantity),0) from t_customer_order_detail as cod left join t_customer_order as co");
        sql.append(" on co.uid = cod.uorderid where co.itype = 1 and co.istatus = 1 and cod.uothergoodsid = og.uid) as returnQuantity,");
        sql.append("((select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 0 and so.istatus = 0 and sod.uothergoodsid = og.uid) -");
        sql.append("(select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 1 and so.istatus = 0 and sod.uothergoodsid = og.uid) -");
        sql.append("(select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 2 and so.istatus = 0 and sod.uothergoodsid = og.uid) -");
        sql.append("(select ISNULL(SUM(cod.nquantity),0) from t_customer_order_detail as cod left join t_customer_order as co");
        sql.append(" on co.uid = cod.uorderid where co.itype = 0 and co.istatus = 1 and cod.uothergoodsid = og.uid) +");
        sql.append("(select ISNULL(SUM(cod.nquantity),0) from t_customer_order_detail as cod left join t_customer_order as co");
        sql.append(" on co.uid = cod.uorderid where co.itype = 1 and co.istatus = 1 and cod.uothergoodsid = og.uid)");
        sql.append(") as inventoryQuantity");
        sql.append(" from t_other_goods as og");
        sql.append(" left join t_category as c on c.uid = og.ucategoryid");
        sql.append(" left join t_brand as b on b.uid = og.ubrandid");
        sql.append(" left join t_unit as u on u.uid = og.uunitid");
        sql.append(" left join t_warranty as w on w.uid = og.uwarrantyid");
        sql.append(" where og.uid = :uid");
		return super.get(sql, new QMap("uid",uid), TOtherGoods.class);
	}

	public List<TOtherGoods> getList(TOtherGoods otherGoods) {
		QMap map = new QMap();
		StringBuilder sql = new StringBuilder("select og.uid,og.ucategoryid,c.cname as ccategoryname");
		sql.append(",og.ubrandid,b.cname as cbrandname,og.uunitid,u.cname as cunitname");
		sql.append(",og.uwarrantyid,w.iday as iwarrantyday,w.ccontent as cwarrantycontent");
		sql.append(",og.uuserid,og.udeptid,og.cno,og.cbarcode,og.cname,og.cfullname,og.cmnemoniccode");
		sql.append(",og.cspecifications,og.iintegral,og.drecorddate,og.dupdatedate");
		sql.append(",(select top 1 ogpr.ncostprice from t_other_goods_price_record as ogpr where ogpr.uothergoodsid = og.uid and ogpr.istatus = 0) as ncostprice");
		sql.append(",(select top 1 ogpr.nretailprice from t_other_goods_price_record as ogpr where ogpr.uothergoodsid = og.uid and ogpr.istatus = 0) as nretailprice");
		sql.append(",(select top 1 ogpr.drecorddate from t_other_goods_price_record as ogpr where ogpr.uothergoodsid = og.uid and ogpr.istatus = 0) as priceRecordDate");
		sql.append(" from t_other_goods as og");
		sql.append(" left join t_category as c on c.uid = og.ucategoryid");
		sql.append(" left join t_brand as b on b.uid = og.ubrandid");
		sql.append(" left join t_unit as u on u.uid = og.uunitid");
		sql.append(" left join t_warranty as w on w.uid = og.uwarrantyid");
		sql.append(" where 1 = 1");
		if(DataUtils.isUid(otherGoods.getUdeptid()))
		{
			sql.append(" and og.udeptid = :udeptid");
			map.put("udeptid", otherGoods.getUdeptid());
		}
		if(DataUtils.isUid(otherGoods.getUcategoryid()))
		{
			sql.append(" and og.ucategoryid = :ucategoryid");
			map.put("ucategoryid", otherGoods.getUcategoryid());
		}
		if(DataUtils.isUid(otherGoods.getUbrandid()))
		{
			sql.append(" and og.ubrandid = :ubrandid");
			map.put("ubrandid", otherGoods.getUbrandid());
		}
		if(!DataUtils.isNullOrEmpty(otherGoods.getCno()))
		{
			sql.append(" and og.cno like '%" + otherGoods.getCno() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(otherGoods.getCbarcode()))
		{
			sql.append(" and og.cbarcode like '%" + otherGoods.getCbarcode() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(otherGoods.getCname()))
		{
			sql.append(" and (og.cname like '%" + otherGoods.getCname() + "%'");
			sql.append(" or og.cfullname like :cfullname)");
			map.put("cfullname", "%" + otherGoods.getCname() + "%");
		}
		if(!DataUtils.isNullOrEmpty(otherGoods.getCmnemoniccode()))
		{
			sql.append(" and og.cmnemoniccode like '%" + otherGoods.getCmnemoniccode() + "%'");
		}
		if(!DataUtils.isNullOrEmpty(otherGoods.getDrecorddateStrMin()))
		{
			sql.append(" and og.drecorddate >= :drecorddateStrMin");
			map.put("drecorddateStrMin", otherGoods.getDrecorddateStrMin() + " 00:00:00");
		}
		if(!DataUtils.isNullOrEmpty(otherGoods.getDrecorddateStrMax()))
		{
			sql.append(" and og.drecorddate <= :drecorddateStrMax");
			map.put("drecorddateStrMax", otherGoods.getDrecorddateStrMax() + " 23:59:59");
		}
		return findList(sql, map);
	}

    public List<TOtherGoods> getInventory(TOtherGoods otherGoods) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select og.uid,og.ucategoryid,c.cname as ccategoryname");
        sql.append(",og.ubrandid,b.cname as cbrandname,og.uunitid,u.cname as cunitname");
        sql.append(",og.uwarrantyid,w.iday as iwarrantyday,w.ccontent as cwarrantycontent");
        sql.append(",og.uuserid,og.udeptid,og.cno,og.cbarcode,og.cname,og.cfullname,og.cmnemoniccode");
        sql.append(",og.cspecifications,og.iintegral,og.drecorddate,og.dupdatedate");
        sql.append(",(select top 1 ogpr.ncostprice from t_other_goods_price_record as ogpr where ogpr.uothergoodsid = og.uid and ogpr.istatus = 0) as ncostprice");
        sql.append(",(select top 1 ogpr.nretailprice from t_other_goods_price_record as ogpr where ogpr.uothergoodsid = og.uid and ogpr.istatus = 0) as nretailprice");
        sql.append(",(select top 1 ogpr.drecorddate from t_other_goods_price_record as ogpr where ogpr.uothergoodsid = og.uid and ogpr.istatus = 0) as priceRecordDate");
        sql.append(",(select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 0 and so.istatus = 0 and sod.uothergoodsid = og.uid) as inQuantity,");
        sql.append("(select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 1 and so.istatus = 0 and sod.uothergoodsid = og.uid) as backQuantity,");
        sql.append("(select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 2 and so.istatus = 0 and sod.uothergoodsid = og.uid) as lossQuantity,");
        sql.append("(select ISNULL(SUM(cod.nquantity),0) from t_customer_order_detail as cod left join t_customer_order as co");
        sql.append(" on co.uid = cod.uorderid where co.itype = 0 and co.istatus = 1 and cod.uothergoodsid = og.uid) as sellQuantity,");
        sql.append("(select ISNULL(SUM(cod.nquantity),0) from t_customer_order_detail as cod left join t_customer_order as co");
        sql.append(" on co.uid = cod.uorderid where co.itype = 1 and co.istatus = 1 and cod.uothergoodsid = og.uid) as returnQuantity,");
        sql.append("((select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 0 and so.istatus = 0 and sod.uothergoodsid = og.uid) -");
        sql.append("(select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 1 and so.istatus = 0 and sod.uothergoodsid = og.uid) -");
        sql.append("(select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 2 and so.istatus = 0 and sod.uothergoodsid = og.uid) -");
        sql.append("(select ISNULL(SUM(cod.nquantity),0) from t_customer_order_detail as cod left join t_customer_order as co");
        sql.append(" on co.uid = cod.uorderid where co.itype = 0 and co.istatus = 1 and cod.uothergoodsid = og.uid) +");
        sql.append("(select ISNULL(SUM(cod.nquantity),0) from t_customer_order_detail as cod left join t_customer_order as co");
        sql.append(" on co.uid = cod.uorderid where co.itype = 1 and co.istatus = 1 and cod.uothergoodsid = og.uid)");
        sql.append(") as inventoryQuantity");
        sql.append(" from t_other_goods as og");
        sql.append(" left join t_category as c on c.uid = og.ucategoryid");
        sql.append(" left join t_brand as b on b.uid = og.ubrandid");
        sql.append(" left join t_unit as u on u.uid = og.uunitid");
        sql.append(" left join t_warranty as w on w.uid = og.uwarrantyid");
        sql.append(" where ((select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 0 and so.istatus = 0 and sod.uothergoodsid = og.uid) -");
        sql.append("(select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 1 and so.istatus = 0 and sod.uothergoodsid = og.uid) -");
        sql.append("(select ISNULL(SUM(sod.nquantity),0) from t_supplier_order_detail as sod left join t_supplier_order as so");
        sql.append(" on so.uid = sod.uorderid where so.itype = 2 and so.istatus = 0 and sod.uothergoodsid = og.uid) -");
        sql.append("(select ISNULL(SUM(cod.nquantity),0) from t_customer_order_detail as cod left join t_customer_order as co");
        sql.append(" on co.uid = cod.uorderid where co.itype = 0 and co.istatus = 1 and cod.uothergoodsid = og.uid) +");
        sql.append("(select ISNULL(SUM(cod.nquantity),0) from t_customer_order_detail as cod left join t_customer_order as co");
        sql.append(" on co.uid = cod.uorderid where co.itype = 1 and co.istatus = 1 and cod.uothergoodsid = og.uid)");
        sql.append(") > 0");
        if(DataUtils.isUid(otherGoods.getUdeptid()))
        {
            sql.append(" and og.udeptid = :udeptid");
            map.put("udeptid", otherGoods.getUdeptid());
        }
        if(DataUtils.isUid(otherGoods.getUcategoryid()))
        {
            sql.append(" and og.ucategoryid = :ucategoryid");
            map.put("ucategoryid", otherGoods.getUcategoryid());
        }
        if(DataUtils.isUid(otherGoods.getUbrandid()))
        {
            sql.append(" and og.ubrandid = :ubrandid");
            map.put("ubrandid", otherGoods.getUbrandid());
        }
        if(!DataUtils.isNullOrEmpty(otherGoods.getCno()))
        {
            sql.append(" and og.cno like '%" + otherGoods.getCno() + "%'");
        }
        if(!DataUtils.isNullOrEmpty(otherGoods.getCbarcode()))
        {
            sql.append(" and og.cbarcode like '%" + otherGoods.getCbarcode() + "%'");
        }
        if(!DataUtils.isNullOrEmpty(otherGoods.getCname()))
        {
            sql.append(" and (og.cname like '%" + otherGoods.getCname() + "%'");
            sql.append(" or og.cfullname like :cfullname)");
            map.put("cfullname", "%" + otherGoods.getCname() + "%");
        }
        if(!DataUtils.isNullOrEmpty(otherGoods.getCmnemoniccode()))
        {
            sql.append(" and og.cmnemoniccode like '%" + otherGoods.getCmnemoniccode() + "%'");
        }
        return findList(sql, map);
    }

}
