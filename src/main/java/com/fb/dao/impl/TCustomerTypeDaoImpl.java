package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TCustomerTypeDao;
import com.fb.domain.po.TCustomerType;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午5:49:52 
* 类说明:
* 客户类型类操作接口实现类
*/
@Service
public class TCustomerTypeDaoImpl extends SimpMapper<TCustomerType> implements TCustomerTypeDao {
	
	public int add(TCustomerType customerType) {
		return super.save(customerType);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TCustomerType customerType) {
		return super.update(customerType);
	}

	public TCustomerType get(String uid) {
		return super.get(uid);
	}

	public List<TCustomerType> getList() {
		String sql = "select uid,cno,cname,ipaymentdays from t_customer_type order by cno";
		return super.findList(sql, null);
	}

	public int getCustomerNumber(String uid) {
		String sql = "select count(*) from t_customer where ucustomertypeid = :uid";
		return super.getInt(sql, new QMap("uid",uid));
	}

}
