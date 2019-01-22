package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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

	public int mod(String uid, String cname, String clogo, String curl, String cdesc, int isort) {
		String sql = "update t_brand set cname = :cname,clogo = :clogo,curl = :curl,cdesc = :cdesc,isort = :isort where uid = :uid";
		QMap map = new QMap();
		map.put("cname", cname);
		map.put("clogo", clogo);
		map.put("curl", curl);
		map.put("cdesc", cdesc);
		map.put("isort", isort);
		map.put("uid", uid);
		return super.execute(sql, map);
	}

	public TBrand get(String uid) {
		return super.get(uid);
	}

	public List<TBrand> getList() {
		String sql = "select uid,cname,clogo,curl,cdesc,isort from t_brand order by isort";
		return super.findList(sql, null);
	}

}
