package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TWarrantyDao;
import com.fb.domain.po.TWarranty;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午2:42:23 
* 类说明:
* 保修政策类操作接口实现类
*/
@Service
public class TWarrantyDaoImpl extends SimpMapper<TWarranty> implements TWarrantyDao {

	public int add(TWarranty warranty) {
		return super.save(warranty);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TWarranty warranty) {
		return super.update(warranty);
	}

	public int mod(String uid, int iday, String ccontent) {
		String sql = "update t_warranty set iday = :iday,ccontent = :ccontent where uid = :uid";
		QMap map = new QMap();
		map.put("iday", iday);
		map.put("ccontent", ccontent);
		map.put("uid", uid);
		return super.execute(sql, map);
	}

	public TWarranty get(String uid) {
		return super.get(uid);
	}

	public List<TWarranty> getList() {
		String sql = "select uid,iday,ccontent from t_warranty order by iday";
		return super.findList(sql, null);
	}

	public int getOtherUseNumber(String uwarrantyid) {
		String sql = "select count(*) from t_other_goods where uwarrantyid = :uwarrantyid";
		return super.getInt(sql, new QMap("uwarrantyid",uwarrantyid));
	}

	public int getPhoneUseNumber(String uwarrantyid) {
		String sql = "select count(*) from t_phone_model where uwarrantyid = :uwarrantyid";
		return super.getInt(sql, new QMap("uwarrantyid",uwarrantyid));
	}

}
