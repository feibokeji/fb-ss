package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TPaymentMethod;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午2:53:23 
* 类说明:
* 付款方式类操作接口
*/
public interface TPaymentMethodDao {
	
	/**
	 * 新增 付款方式信息
	 * @param paymentMethod
	 * @return 受影响行数
	 */
	public int add(TPaymentMethod paymentMethod);
	
	/**
	 * 删除 付款方式信息
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	
	/**
	 * 修改 付款方式信息
	 * @param paymentMethod
	 * @return 受影响行数
	 */
	public int mod(TPaymentMethod paymentMethod);
	
	/**
	 * 修改 付款方式信息
	 * @param uid
	 * @param cname
	 * @param ccode
	 * @param cdesc
	 * @return 受影响行数
	 */
	public int mod(String uid,String cname,String ccode,String cdesc);
	
	/**
	 * 获取 付款方式信息
	 * @param uid
	 * @return 付款方式信息
	 */
	public TPaymentMethod get(String uid);
	
	/**
	 * 获取 付款方式信息集合
	 * @return 付款方式信息集合
	 */
	public List<TPaymentMethod> getList();
}
