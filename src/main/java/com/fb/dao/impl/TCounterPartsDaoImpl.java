package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.dao.TCounterPartsDao;
import com.fb.domain.po.TCounterParts;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午6:05:56 
* 类说明:
*/
@Service
public class TCounterPartsDaoImpl extends SimpMapper<TCounterParts> implements TCounterPartsDao {

	public int add(TCounterParts counterParts) {
		return super.save(counterParts);
	}

	public int del(String uid) {
		return super.delete(uid);
	}

	public int mod(TCounterParts counterParts) {
		return super.update(counterParts);
	}

	public TCounterParts get(String uid) {
		return super.get(uid);
	}

	public List<TCounterParts> getList() {
		String sql = "select uid,uuserid,udeptid,cshopname,coperator,ctelephone,cwechat,caddress,cbusinessscope,ibusinessstatus,ipaymentdays,drecorddate,dupdatedate from t_counter_parts order by cshopname";
		return super.findList(sql, null);
	}

}
