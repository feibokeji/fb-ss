package com.fb.service;

import java.util.List;

import com.fb.domain.po.TPaymentMethod;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午3:12:38 
* 类说明:
* 付款方式操作接口
*/
public interface PaymentMethodService {
	/**
	 * 新增：付款方式
	 * @param paymentMethod
	 * @return 受影响行数
	 */
	public int addPaymentMethod(TPaymentMethod paymentMethod);
	/**
	 * 获取：付款方式使用量
	 * @param upaymentmethodid
	 * @return 使用量
	 */
	public int getPaymentMethodUseNumber(String upaymentmethodid);
	/**
	 * 删除：付款方式
	 * @param uid
	 * @return 受影响行数
	 */
	public int deletePaymentMethod(String uid);
	/**
	 * 修改：付款方式
	 * @param paymentMethod
	 * @return 受影响行数
	 */
	public int modifyPaymentMethod(TPaymentMethod paymentMethod);
	/**
	 * 获取：付款方式
	 * @param uid
	 * @return 付款方式
	 */
	public TPaymentMethod getPaymentMethod(String uid);
	/**
	 * 获取：付款方式列表
	 * @return 付款方式列表
	 */ 
	public List<TPaymentMethod> getPaymentMethodList();
}
