package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.core.utils.DataUtils;
import com.fb.dao.TOtherGoodsDao;
import com.fb.dao.TOtherGoodsPriceRecordDao;
import com.fb.domain.po.TOtherGoods;
import com.fb.domain.po.TOtherGoodsPriceRecord;
import com.fb.service.OtherGoodsService;
import com.fb.service.SimpServiceAbstract;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 下午4:43:18 
* 类说明:其它商品服务接口实现类
*/
@Service
public class OtherGoodsServiceImpl extends SimpServiceAbstract implements OtherGoodsService {
	
	@Autowired
	private TOtherGoodsDao otherGoodsDao;
	
	@Autowired
	private TOtherGoodsPriceRecordDao otherGoodsPriceRecordDao;
	
	@Transactional
	public int addOtherGoods(TOtherGoods otherGoods) {
		TOtherGoodsPriceRecord record = new TOtherGoodsPriceRecord();
		record.setUid(DataUtils.newUUID());
		record.setUuserid(otherGoods.getUuserid());
		record.setUothergoodsid(otherGoods.getUid());
		record.setNcostprice(otherGoods.getNcostprice());
		record.setNretailprice(otherGoods.getNretailprice());
		record.setDrecorddate(otherGoods.getDrecorddate());
		record.setIstatus(0);
		int addOtherGoodsCount = otherGoodsDao.add(otherGoods);
		int addPriceRecordCount = otherGoodsPriceRecordDao.add(record);
		return addOtherGoodsCount + addPriceRecordCount;
	}

	public int getBusinessNumber(String uid) {
		int customerBusinessNumber = otherGoodsDao.getCustomerBusinessNumber(uid);
		int supplierBusinessNumber = otherGoodsDao.getSupplierBusinessNumber(uid);
		return customerBusinessNumber + supplierBusinessNumber;
	}

	@Transactional
	public int deleteOtherGoods(String uid) {
		int delPriceRecordCount = otherGoodsPriceRecordDao.delByUOtherGoodsId(uid);
		int delGoodsCount = otherGoodsDao.del(uid);
		return delPriceRecordCount + delGoodsCount;
	}

	@Transactional
	public int modifyOtherGoods(TOtherGoods otherGoods) {
		int modifyGoodsCount = otherGoodsDao.mod(otherGoods);
		int modifyRecordCount = otherGoodsPriceRecordDao.modPriceRecordStatusByUOtherGoodsId(otherGoods.getUid(), 1);
		TOtherGoodsPriceRecord record = new TOtherGoodsPriceRecord();
		record.setUid(DataUtils.newUUID());
		record.setUuserid(otherGoods.getUuserid());
		record.setUothergoodsid(otherGoods.getUid());
		record.setNcostprice(otherGoods.getNcostprice());
		record.setNretailprice(otherGoods.getNretailprice());
		record.setDrecorddate(otherGoods.getDupdatedate());
		record.setIstatus(0);
		int addRecordCount = otherGoodsPriceRecordDao.add(record);
		return modifyGoodsCount + modifyRecordCount + addRecordCount;
	}

	public TOtherGoods getOtherGoods(String uid) {
		return otherGoodsDao.get(uid);
	}

	public List<TOtherGoods> getOtherGoodsList(TOtherGoods otherGoods) {
		return otherGoodsDao.getList(otherGoods);
	}

	public List<TOtherGoodsPriceRecord> getListByUOtherGoodsId(String uothergoodsid) {
		return otherGoodsPriceRecordDao.getListByUOtherGoodsId(uothergoodsid);
	}

}
