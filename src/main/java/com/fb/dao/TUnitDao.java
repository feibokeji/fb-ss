package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TUnit;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午2:48:28 
* 类说明:
* 单位类操作接口
*/
public interface TUnitDao {
	
	/**
	 * 新增 单位信息
	 * @param unit
	 * @return 受影响行数
	 */
	public int add(TUnit unit);
	
	/**
	 * 删除 单位信息
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	
	/**
	 * 修改 单位信息
	 * @param unit
	 * @return 受影响行数
	 */
	public int mod(TUnit unit);
	
	/**
	 * 修改 单位信息
	 * @param uid
	 * @param cname
	 * @return 受影响行数
	 */
	public int mod(String uid,String cname);
	
	/**
	 * 获取 单位信息
	 * @param uid
	 * @return 单位信息
	 */
	public TUnit get(String uid);
	
	/**
	 * 获取 单位信息集合
	 * @return 单位信息集合
	 */
	public List<TUnit> getList();
	/**
	 * 获取：单位使用量
	 * @return
	 */
	public int getUseNumber(String uunitid);
}
