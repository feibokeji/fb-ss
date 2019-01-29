package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TPhoneModelColor;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月24日 下午7:12:39 
* 类说明:手机型号颜色类操作接口
*/
public interface TPhoneModelColorDao {
	/**
	 * 新增：手机型号颜色
	 * @param phoneModelColor
	 * @return 受影响行数
	 */
	public int add(TPhoneModelColor phoneModelColor);
	/**
	 * 删除：手机型号颜色
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	/**
	 * 删除：手机型号的所有颜色
	 * @param uphonemodelid
	 * @return 受影响行数
	 */
	public int delByUPhoneModelId(String uphonemodelid);
	/**
	 * 获取：手机型号的所有颜色
	 * @param uphonemodelid
	 * @return 手机型号颜色集合
	 */
	public List<TPhoneModelColor> getListByUPhoneModelId(String uphonemodelid);
	/**
	 * 获取：手机型号颜色的使用量
	 * @param uphonemodelid
	 * @param ucolorid
	 * @return 使用量
	 */
	public int getUseNumber(String uphonemodelid,String ucolorid);
	/**
	 * 获取：手机型号颜色信息
	 * @param uid
	 * @return 颜色信息
	 */
	public TPhoneModelColor get(String uid);
}
