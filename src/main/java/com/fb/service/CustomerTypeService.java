package com.fb.service;

import java.util.List;

import com.fb.domain.po.TCustomerType;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月20日 下午7:18:37 
* 类说明:客户类型操作接口
*/
public interface CustomerTypeService {
	/**
	 * 新增：客户类型信息
	 * @param customerType
	 * @return 受影响行数
	 */
	public int addCustomerType(TCustomerType customerType);
	/**
	 * 获取：客户类型下客户量
	 * @param uid
	 * @return 客户类型天客户量
	 */
	public int getCustomerNumber(String uid);
	/**
	 * 删除：客户类型信息
	 * @param uid
	 * @return 受影响行数
	 */
	public int deleteCustomerType(String uid);
	/**
	 * 修改：客户类型信息
	 * @param customerType
	 * @return 受影响行数
	 */
	public int modifyCustomerType(TCustomerType customerType);
	/**
	 * 获取：客户类型信息
	 * @param uid
	 * @return 客户类型信息
	 */
	public TCustomerType getCustomerType(String uid);
	/**
	 * 获取：客户类型信息列表
	 * @return 客户类型信息列表
	 */
	public List<TCustomerType> getCustomerTypeList();
}
