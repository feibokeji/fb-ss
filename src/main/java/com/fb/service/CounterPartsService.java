package com.fb.service;

import java.util.List;

import com.fb.domain.po.TCounterParts;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月22日 上午10:17:20 
* 类说明:同行类操作接口
*/
public interface CounterPartsService {
	/**
	 * 新增：同行信息
	 * @param counterParts
	 * @return 受影响行数
	 */
	public int addCounterParts(TCounterParts counterParts);
	/**
	 * 获取：同行手机业务量
	 * @param ucounterpartsid
	 * @return 手机业务量
	 */
	public int getPhoneBusinessNumber(String ucounterpartsid);
	/**
	 * 删除：同行信息
	 * @param uid
	 * @return 受影响行数
	 */
	public int deleteCounterParts(String uid);
	/**
	 * 修改：同行信息
	 * @param counterParts
	 * @return 受影响行数
	 */
	public int modifyCounterParts(TCounterParts counterParts);
	/**
	 * 获取：同行信息
	 * @param uid
	 * @return 同行信息
	 */
	public TCounterParts getCounterParts(String uid);
	/**
	 * 获取：同行信息列表
	 * @param counterParts
	 * @return 同行信息列表
	 */
	public List<TCounterParts> getCounterPartsList(TCounterParts counterParts);
}
