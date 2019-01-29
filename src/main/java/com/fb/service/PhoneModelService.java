package com.fb.service;

import java.util.List;

import com.fb.domain.po.TPhoneModel;
import com.fb.domain.po.TPhoneModelColor;
import com.fb.domain.po.TPhoneModelPriceRecord;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月24日 下午8:49:58 
* 类说明:手机型号服务接口
*/
public interface PhoneModelService {
	/**
	 * 新增：手机型号
	 * @param phoneModel
	 * @return 受影响行数
	 */
	public int addPhoneModel(TPhoneModel phoneModel);
	/**
	 * 获取：手机型号使用量
	 * @param uphonemodelid
	 * @return 受影响行数
	 */
	public int getUseNumber(String uphonemodelid);
	/**
	 * 删除：手机型号
	 * @param uid
	 * @return 受影响行数
	 */
	public int deletePhoneModel(String uid);
	/**
	 * 删除：手机型号颜色
	 * @param uid
	 * @return 受影响行数
	 */
	public int deletePhoneModelColor(String uid);
	/**
	 * 修改：手机型号
	 * @param phoneModel
	 * @return 受影响行数
	 */
	public int modifyPhoneModel(TPhoneModel phoneModel);
	/**
	 * 获取：手机型号
	 * @param uid
	 * @return 手机型号
	 */
	public TPhoneModel getPhoneModel(String uid);
	/**
	 * 获取：手机型号集合
	 * @param phoneModel
	 * @return 手机型号集合
	 */
	public List<TPhoneModel> getPhoneModelList(TPhoneModel phoneModel);
	/**
	 * 获取：手机型号颜色集合
	 * @param uphonemodelid
	 * @return 手机型号颜色集合
	 */
	public List<TPhoneModelColor> getPhoneModelColorList(String uphonemodelid);
	/**
	 * 获取：手机型号价格记录集合
	 * @param uphonemodelid
	 * @return 手机型号价格记录集合
	 */
	public List<TPhoneModelPriceRecord> getPhoneModelPriceRecordList(String uphonemodelid);
	/**
	 * 获取：手机型号颜色使用量
	 * @param uphonemodelid
	 * @param ucolorid
	 * @return 使用量
	 */
	public int getPhoneModelColorUseNumber(String uphonemodelid,String ucolorid);
	/**
	 * 获取：手机型号颜色信息
	 * @param uid
	 * @return 颜色信息
	 */
	public TPhoneModelColor getPhoneModelColor(String uid);
}
