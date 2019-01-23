package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TBrandDao;
import com.fb.domain.po.TBrand;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午2:12:26 
* 类说明:
* 品牌类接口实现类
*/
@Service
public class TBrandDaoImpl extends SimpMapper<TBrand> implements TBrandDao {

	public int add(TBrand brand) {
		return super.save(brand);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TBrand brand) {
		return super.update(brand);
	}

	public TBrand get(String uid) {
		return super.get(uid);
	}

	public List<TBrand> getList(TBrand brand) {
		StringBuilder sql = new StringBuilder("select uid,cname,clogo,curl,cdesc,isort from t_brand where 1 = 1");
		if(!DataUtils.isNullOrEmpty(brand.getCname()))
		{
			sql.append(" and cname like '%" + brand.getCname() + "%'");
		}
		sql.append("order by isort");
		return super.findList(sql, null);
	}

	public int getPhoneBusinessNumber(String ubrandid) {
		String sql = "select count(*) from t_phone_model where ubrandid = :ubrandid";
		return super.getInt(sql, new QMap("ubrandid",ubrandid));
	}

	public int getOtherBusinessNumber(String ubrandid) {
		String sql = "select count(*) from t_other_goods where ubrandid = :ubrandid";
		return super.getInt(sql, new QMap("ubrandid",ubrandid));
	}

}
