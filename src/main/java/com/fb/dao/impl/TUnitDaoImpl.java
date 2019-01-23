package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TUnitDao;
import com.fb.domain.po.TUnit;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午2:59:15 
* 类说明:
* 单位类操作接口实现类
*/
@Service
public class TUnitDaoImpl extends SimpMapper<TUnit> implements TUnitDao {

	public int add(TUnit unit) {
		return super.save(unit);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TUnit unit) {
		return super.update(unit);
	}

	public int mod(String uid, String cname) {
		String sql = "update t_unit set cname = :cname where uid = :uid";
		QMap map = new QMap();
		map.put("cname", cname);
		map.put("uid", uid);
		return super.execute(sql, map);
	}

	public TUnit get(String uid) {
		return super.get(uid);
	}

	public List<TUnit> getList() {
		String sql = "select uid,cname from t_unit order by cname";
		return super.findList(sql, null);
	}

	public int getUseNumber(String uunitid) {
		String sql = "select count(*) from t_other_goods where uunitid = :uunitid";
		return super.getInt(sql, new QMap("uunitid",uunitid));
	}

}
