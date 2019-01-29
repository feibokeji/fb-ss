package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TPhoneModelPriceRecord;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月24日 下午7:20:26 
* 类说明:手机型号价格记录类操作接口
*/
public interface TPhoneModelPriceRecordDao {
	/**
	 * 新增：手机型号价格记录
	 * @param phoneModelPriceRecord
	 * @return 受影响行数
	 */
	public int add(TPhoneModelPriceRecord phoneModelPriceRecord);
	/**
	 * 删除：手机型号价格记录
	 * @param uphonemodelid
	 * @return 受影响行数
	 */
	public int delByUPhoneModelId(String uphonemodelid);
	/**
	 * 修改：手机型号价格记录状态
	 * @param uphonemodelid
	 * @param istatus
	 * @return 受影响行数
	 */
	public int modIStatusByUPhoneModelId(String uphonemodelid,int istatus);
	/**
	 * 获取：手机型号价格记录集合
	 * @param uphonemodelid
	 * @return 价格记录集合
	 */
	public List<TPhoneModelPriceRecord> getListByUPhoneModelId(String uphonemodelid);
}
