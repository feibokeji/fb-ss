package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TColorDao;
import com.fb.domain.po.TColor;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午2:27:45 
* 类说明:
* 颜色信息接口实现类
*/
@Service
public class TColorDaoImpl extends SimpMapper<TColor> implements TColorDao {

	public int add(TColor color) {
		return super.save(color);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TColor color) {
		return super.update(color);
	}

	public int mod(String uid, String cname) {
		String sql = "update t_color set cname = :cname where uid = :uid";
		QMap map = new QMap();
		map.put("cname", cname);
		map.put("uid", uid);
		return super.execute(sql, map);
	}

	public TColor get(String uid) {
		return super.get(uid);
	}

	public List<TColor> getList() {
		String sql = "select uid,cname from t_color order by cname";
		return super.findList(sql, null);
	}

}
