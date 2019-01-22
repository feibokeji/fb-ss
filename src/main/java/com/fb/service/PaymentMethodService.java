package com.fb.service;

import java.util.List;

import com.fb.core.utils.Page;
import com.fb.domain.po.TPaymentMethod;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午3:12:38 
* 类说明:
* 付款方式操作接口
*/
public interface PaymentMethodService {
	
	/**
	 * 新增 付款方式
	 * @param paymentMethod
	 * @return 受影响行数
	 */
	public int add(TPaymentMethod paymentMethod);
	
	/**
	 * 删除 付款方式
	 * @param uid
	 * @return 受影响行数
	 */
	public int delete(String uid);
	
	/**
	 * 修改 付款方式
	 * @param paymentMethod
	 * @return 受影响行数
	 */
	public int update(TPaymentMethod paymentMethod);
	
	/**
	 * 获取 付款方式
	 * @param uid
	 * @return 付款方式
	 */
	public TPaymentMethod get(String uid);
	
	/**
	 * 获取 付款方式集合
	 * @return 付款方式集合
	 */
	public List<TPaymentMethod> getPaymentMethodList();
	
	/**
	 * 获取 付款方式分页
	 * @return 付款方式分页
	 */
	public Page<TPaymentMethod> getPaymentMethodPage();
}
