package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TPaymentMethodDao;
import com.fb.domain.po.TPaymentMethod;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午3:00:23 
* 类说明:
* 付款方式类操作接口实现类
*/
@Service
public class TPaymentMethodDaoImpl extends SimpMapper<TPaymentMethod> implements TPaymentMethodDao {

	public int add(TPaymentMethod paymentMethod) {
		return super.save(paymentMethod);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TPaymentMethod paymentMethod) {
		return super.update(paymentMethod);
	}

	public int mod(String uid, String cname, String ccode, String cdesc) {
		String sql = "update t_payment_method set cname = :cname,ccode = :ccode,cdesc = :cdesc where uid = :uid";
		QMap map = new QMap();
		map.put("cname", cname);
		map.put("ccode", ccode);
		map.put("cdesc", cdesc);
		map.put("uid", uid);
		return super.execute(sql, map);
	}

	public TPaymentMethod get(String uid) {
		return super.get(uid);
	}

	public List<TPaymentMethod> getList() {
		String sql = "select uid,cname,ccode,cdesc from t_payment_method order by ccode";
		return super.findList(sql, null);
	}

	public int getCounterPartsBusinessNumber(String upaymentmethodid) {
		String sql = "select count(*) from t_counterparts_phone_receipts where upaymentmethodid = :upaymentmethodid";
		return super.getInt(sql, new QMap("upaymentmethodid",upaymentmethodid));
	}

	public int getCustomerBusinessNumber(String upaymentmethodid) {
		String sql = "select count(*) from t_customer_receipts where upaymentmethodid = :upaymentmethodid";
		return super.getInt(sql, new QMap("upaymentmethodid",upaymentmethodid));
	}

	public int getPhoneBusinessNumber(String upaymentmethodid) {
		String sql = "select count(*) from t_phone_inventory_receipts where upaymentmethodid = :upaymentmethodid";
		return super.getInt(sql, new QMap("upaymentmethodid",upaymentmethodid));
	}

	public int getSupplierBusinessNumber(String upaymentmethodid) {
		String sql = "select count(*) from t_supplier_receipts where upaymentmethodid = :upaymentmethodid";
		return super.getInt(sql, new QMap("upaymentmethodid",upaymentmethodid));
	}

}
