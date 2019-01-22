package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCounterParts;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午5:30:48 
* 类说明:
* 同行类操作接口
*/
public interface TCounterPartsDao {
	/**
	 * 新增：同行
	 * @param counterParts
	 * @return 受影响行数
	 */
	public int add(TCounterParts counterParts);
	/**
	 * 删除：同行
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	/**
	 * 修改：同行
	 * @param counterParts
	 * @return 受影响行数
	 */
	public int mod(TCounterParts counterParts);
	/**
	 * 获取：同行
	 * @param uid
	 * @return 同行
	 */
	public TCounterParts get(String uid);
	/**
	 * 获取：同行列表
	 * @return 同行列表
	 */
	public List<TCounterParts> getList(TCounterParts counterParts);
	/**
	 * 获取：同行手机业务量
	 * @param ucounterpartsid
	 * @return 同行手机业务量
	 */
	public int getPhoneBusinessNumber(String ucounterpartsid);
}
