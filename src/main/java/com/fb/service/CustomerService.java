package com.fb.service;

import java.util.List;

import com.fb.domain.po.TCustomer;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月20日 下午6:39:17 
* 类说明:
* 客户信息操作接口
*/
public interface CustomerService {
	/**
	 * 新增：客户信息
	 * @param customer
	 * @return 受影响行数
	 */
	public int addCustomer(TCustomer customer);
	/**
	 * 获取：客户业务量
	 * @param ucustomerid
	 * @return 客户业务量
	 */
	public int getCustomerBusinessNumber(String ucustomerid);
	/**
	 * 删除：客户信息
	 * @param uid
	 * @return
	 */
	public int deleteCustomer(String uid);
	/**
	 * 修改：客户信息
	 * @param customer
	 * @return
	 */
	public int modifyCustomer(TCustomer customer);
	/**
	 * 获取：客户信息列表
	 * @param customer
	 * @return
	 */
	public List<TCustomer> getCustomerList(TCustomer customer);
	/**
	 * 获取：客户信息
	 * @param uid
	 * @return 客户信息
	 */
	public TCustomer getCustomer(String uid);
}
