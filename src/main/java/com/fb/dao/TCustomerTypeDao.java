package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCustomerType;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午5:22:36 
* 类说明:
* 客户类型类操作接口
*/
public interface TCustomerTypeDao {
	/**
	 * 新增：客户类型
	 * @param customerType
	 * @return 受影响行数
	 */
	public int add(TCustomerType customerType);
	/**
	 * 删除：客户类型
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	/**
	 * 修改：客户类型
	 * @param customerType
	 * @return 受影响行数
	 */
	public int mod(TCustomerType customerType);
	/**
	 * 获取：客户类型
	 * @param uid
	 * @return 客户类型
	 */
	public TCustomerType get(String uid);
	/**
	 * 获取：客户类型列表
	 * @return 客户类型列表
	 */
	public List<TCustomerType> getList();
	/**
	 * 获取：客户类型下客户量
	 * @param uid
	 * @return 客户量
	 */
	public int getCustomerNumber(String uid);
}
