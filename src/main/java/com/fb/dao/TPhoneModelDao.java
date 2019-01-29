package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TPhoneModel;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月24日 下午7:06:42 
* 类说明:手机型号类操作接口
*/
public interface TPhoneModelDao {
	/**
	 * 新增：手机型号
	 * @param phoneModel
	 * @return 受影响行数
	 */
	public int add(TPhoneModel phoneModel);
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
	public int del(String uid);
	/**
	 * 修改：手机型号
	 * @param phoneModel
	 * @return 受影响行数
	 */
	public int mod(TPhoneModel phoneModel);
	/**
	 * 获取：手机型号
	 * @param uid
	 * @return 手机型号
	 */
	public TPhoneModel get(String uid);
	/**
	 * 获取：手机型号集合
	 * @param phoneModel
	 * @return 手机型号集合
	 */
	public List<TPhoneModel> getList(TPhoneModel phoneModel);
}
