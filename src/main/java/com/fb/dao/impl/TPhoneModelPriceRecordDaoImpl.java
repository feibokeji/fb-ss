package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TPhoneModelPriceRecordDao;
import com.fb.domain.po.TPhoneModelPriceRecord;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月24日 下午7:26:43 
* 类说明:手机型号价格记录类操作接口实现类
*/
@Service
public class TPhoneModelPriceRecordDaoImpl extends SimpMapper<TPhoneModelPriceRecord>
		implements TPhoneModelPriceRecordDao {

	public int add(TPhoneModelPriceRecord phoneModelPriceRecord) {
		return super.save(phoneModelPriceRecord);
	}

	public int delByUPhoneModelId(String uphonemodelid) {
		String sql = "delete from t_phone_model_price_record where uphonemodelid = :uphonemodelid";
		return super.execute(sql, new QMap("uphonemodelid",uphonemodelid));
	}

	public int modIStatusByUPhoneModelId(String uphonemodelid, int istatus) {
		String sql = "update t_phone_model_price_record set istatus = :istatus where uphonemodelid = :uphonemodelid";
		QMap map = new QMap();
		map.put("istatus", istatus);
		map.put("uphonemodelid", uphonemodelid);
		return super.execute(sql, map);
	}

	public List<TPhoneModelPriceRecord> getListByUPhoneModelId(String uphonemodelid) {
		StringBuilder sql = new StringBuilder("select pmpr.uid,pmpr.uuserid,u.cname as cusername,pmpr.uphonemodelid,pmpr.ncostprice,pmpr.nretailprice,pmpr.drecorddate,pmpr.istatus");
		sql.append(" from t_phone_model_price_record as pmpr left join t_user as u on u.uid = pmpr.uuserid");
		sql.append(" where pmpr.uphonemodelid = :uphonemodelid order by pmpr.istatus");
		return super.findList(sql, new QMap("uphonemodelid",uphonemodelid));
	}

}
