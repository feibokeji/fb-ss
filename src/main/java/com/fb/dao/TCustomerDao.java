package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCustomer;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午5:25:16 
* 类说明:
* 客户类操作接口
*/
public interface TCustomerDao {
	/**
	 * 新增：客户
	 * @param customer
	 * @return 受影响行数
	 */
	public int add(TCustomer customer);
	/**
	 * 删除：客户
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	/**
	 * 修改：客户
	 * @param customer
	 * @return 受影响行数
	 */
	public int mod(TCustomer customer);
	/**
	 * 获取：客户
	 * @param uid
	 * @return 客户
	 */
	public TCustomer get(String uid);
	/**
	 * 获取:客户列表
	 * @return 客户列表
	 */
	public List<TCustomer> getList(TCustomer customer);
	/**
	 * 获取：手机业务量
	 * @param ucustomerid
	 * @return 手机业务量
	 */
	public int getPhoneBusinessNumber(String ucustomerid);
	/**
	 * 获取：其它业务量
	 * @param ucustomerid
	 * @return 其它业务量
	 */
	public int getOtherBusinessNumber(String ucustomerid);
}
