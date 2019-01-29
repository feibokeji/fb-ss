package com.fb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.core.utils.DataUtils;
import com.fb.dao.TPhoneModelColorDao;
import com.fb.dao.TPhoneModelDao;
import com.fb.dao.TPhoneModelPriceRecordDao;
import com.fb.domain.po.TPhoneModel;
import com.fb.domain.po.TPhoneModelColor;
import com.fb.domain.po.TPhoneModelPriceRecord;
import com.fb.service.PhoneModelService;
import com.fb.service.SimpServiceAbstract;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月24日 下午9:04:12 
* 类说明:手机型号服务接口实现类
*/
@Service
public class PhoneModelServiceImpl extends SimpServiceAbstract implements PhoneModelService {
	
	@Autowired
	private TPhoneModelDao phoneModelDao;
	
	@Autowired
	private TPhoneModelColorDao phoneModelColorDao;
	
	@Autowired
	private TPhoneModelPriceRecordDao phoneModelPriceRecordDao;
	
	@Transactional
	public int addPhoneModel(TPhoneModel phoneModel) {
		TPhoneModelPriceRecord record = new TPhoneModelPriceRecord();
		record.setUid(DataUtils.newUUID());
		record.setUuserid(phoneModel.getUuserid());
		record.setUphonemodelid(phoneModel.getUid());
		record.setNcostprice(phoneModel.getNcostprice());
		record.setNretailprice(phoneModel.getNretailprice());
		record.setDrecorddate(phoneModel.getDrecorddate());
		record.setIstatus(0);
		int addPhoneModelCount = phoneModelDao.add(phoneModel);
		List<TPhoneModelColor> list = getAddPhoneModelColorList(phoneModel.getUid(), phoneModel.getPhoneModelColorIds());;
		int addPhoneModelColorCount = 0;
		for (TPhoneModelColor tPhoneModelColor : list) {
			addPhoneModelColorCount += phoneModelColorDao.add(tPhoneModelColor);
		}
		int addPhoneModelPriceRecordCount = phoneModelPriceRecordDao.add(record);
		return addPhoneModelCount + addPhoneModelColorCount + addPhoneModelPriceRecordCount;
	}

	public int getUseNumber(String uphonemodelid) {
		return phoneModelDao.getUseNumber(uphonemodelid);
	}
	
	@Transactional
	public int deletePhoneModel(String uid) {
		int deletePhoneModelColorCount = phoneModelColorDao.delByUPhoneModelId(uid);
		int deletePhoneModelPriceRecordCount = phoneModelPriceRecordDao.delByUPhoneModelId(uid);
		int deletePhoneModelCount = phoneModelDao.del(uid);
		return deletePhoneModelColorCount + deletePhoneModelPriceRecordCount + deletePhoneModelCount;
	}
	
	@Transactional
	public int deletePhoneModelColor(String uid) {
		return phoneModelColorDao.del(uid);
	}
	
	@Transactional
	public int modifyPhoneModel(TPhoneModel phoneModel) {
		int modifyPhoneModelPriceRecordIstatusCount = phoneModelPriceRecordDao.modIStatusByUPhoneModelId(phoneModel.getUid(), 1);
		int deletePhoneModelColorCount = phoneModelColorDao.delByUPhoneModelId(phoneModel.getUid());
		int modifyPhoneModelCount = phoneModelDao.mod(phoneModel);
		TPhoneModelPriceRecord record = new TPhoneModelPriceRecord();
		record.setUid(DataUtils.newUUID());
		record.setUuserid(phoneModel.getUuserid());
		record.setUphonemodelid(phoneModel.getUid());
		record.setNcostprice(phoneModel.getNcostprice());
		record.setNretailprice(phoneModel.getNretailprice());
		record.setDrecorddate(phoneModel.getDupdatedate());
		record.setIstatus(0);
		int addPhoneModelPriceRecordCount = phoneModelPriceRecordDao.add(record);
		List<TPhoneModelColor> list = getAddPhoneModelColorList(phoneModel.getUid(), phoneModel.getPhoneModelColorIds());
		int addPhoneModelColorCount = 0;
		for (TPhoneModelColor tPhoneModelColor : list) {
			addPhoneModelColorCount += phoneModelColorDao.add(tPhoneModelColor);
		}
		return modifyPhoneModelPriceRecordIstatusCount + deletePhoneModelColorCount + modifyPhoneModelCount + addPhoneModelPriceRecordCount + addPhoneModelColorCount;
	}

	public TPhoneModel getPhoneModel(String uid) {
		return phoneModelDao.get(uid);
	}

	public List<TPhoneModel> getPhoneModelList(TPhoneModel phoneModel) {
		return phoneModelDao.getList(phoneModel);
	}

	public List<TPhoneModelColor> getPhoneModelColorList(String uphonemodelid) {
		return phoneModelColorDao.getListByUPhoneModelId(uphonemodelid);
	}

	public List<TPhoneModelPriceRecord> getPhoneModelPriceRecordList(String uphonemodelid) {
		return phoneModelPriceRecordDao.getListByUPhoneModelId(uphonemodelid);
	}
	
	private List<TPhoneModelColor> getAddPhoneModelColorList(String uphonemodelid,String ids){
		List<TPhoneModelColor> list = new ArrayList<TPhoneModelColor>();
		if(!DataUtils.isNullOrEmpty(ids)) {
			if(ids.contains(";")) {
				String[] ucolorids = ids.split(";");
				for(int i = 0; i < ucolorids.length; i++) {
					TPhoneModelColor phoneModelColor = new TPhoneModelColor();
					phoneModelColor.setUid(DataUtils.newUUID());
					phoneModelColor.setUphonemodelid(uphonemodelid);
					phoneModelColor.setUcolorid(ucolorids[i]);
					list.add(phoneModelColor);
				}
			}else {
				TPhoneModelColor phoneModelColor = new TPhoneModelColor();
				phoneModelColor.setUid(DataUtils.newUUID());
				phoneModelColor.setUphonemodelid(uphonemodelid);
				phoneModelColor.setUcolorid(ids);
				list.add(phoneModelColor);
			}
		}
		return list;
	}

	public int getPhoneModelColorUseNumber(String uphonemodelid, String ucolorid) {
		return phoneModelColorDao.getUseNumber(uphonemodelid, ucolorid);
	}

	public TPhoneModelColor getPhoneModelColor(String uid) {
		return phoneModelColorDao.get(uid);
	}

}
