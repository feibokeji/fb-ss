package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TOtherGoodsPriceRecordDao;
import com.fb.domain.po.TOtherGoodsPriceRecord;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 下午4:35:57 
* 类说明:其它商品价格记录操作接口实现类
*/
@Service
public class TOtherGoodsPriceRecordDaoImpl extends SimpMapper<TOtherGoodsPriceRecord>
		implements TOtherGoodsPriceRecordDao {

	public int add(TOtherGoodsPriceRecord otherGoodsPriceRecord) {
		return super.save(otherGoodsPriceRecord);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int delByUOtherGoodsId(String uothergoodsid) {
		String sql = "delete from t_other_goods_price_record where uothergoodsid = :uothergoodsid";
		return super.execute(sql, new QMap("uothergoodsid",uothergoodsid));
	}

	public int mod(TOtherGoodsPriceRecord otherGoodsPriceRecord) {
		return super.update(otherGoodsPriceRecord);
	}

	public TOtherGoodsPriceRecord get(String uid) {
		StringBuilder sql = new StringBuilder("select ogpr.uid,ogpr.uuserid,u.cname as cusername,ogpr.uothergoodsid,ogpr.ncostprice,ogpr.nretailprice,ogpr.drecorddate,ogpr.istatus");
		sql.append(" from t_other_goods_price_record as ogpr");
		sql.append(" left join t_user as u on u.uid = ogpr.uuserid");
		sql.append(" where ogpr.uid = :uid");
		return super.get(sql, new QMap("uid",uid), TOtherGoodsPriceRecord.class);
	}

	public List<TOtherGoodsPriceRecord> getListByUOtherGoodsId(String uothergoodsid) {
		StringBuilder sql = new StringBuilder("select ogpr.uid,ogpr.uuserid,u.cname as cusername,ogpr.uothergoodsid,ogpr.ncostprice,ogpr.nretailprice,ogpr.drecorddate,ogpr.istatus");
		sql.append(" from t_other_goods_price_record as ogpr");
		sql.append(" left join t_user as u on u.uid = ogpr.uuserid");
		sql.append(" where uothergoodsid = :uothergoodsid order by ogpr.istatus");
		return super.findList(sql, new QMap("uothergoodsid",uothergoodsid));
	}

	public int modPriceRecordStatusByUOtherGoodsId(String uothergoodsid, int istatus) {
		String sql = "update t_other_goods_price_record set istatus = :istatus where uothergoodsid = :uothergoodsid";
		QMap map = new QMap();
		map.put("istatus", istatus);
		map.put("uothergoodsid", uothergoodsid);
		return super.execute(sql, map);
	}

}
