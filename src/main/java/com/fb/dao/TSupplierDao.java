package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TSupplier;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午5:18:57 
* 类说明:
* 供应商类操作接口
*/
public interface TSupplierDao {
	/**
	 * 新增：供应商
	 * @param supplier
	 * @return 受影响行数
	 */
	public int add(TSupplier supplier);
	/**
	 * 删除：供应商
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	/**
	 * 修改：供应商
	 * @param supplier
	 * @return 受影响行数
	 */
	public int mod(TSupplier supplier);
	/**
	 * 获取：供应商
	 * @param uid
	 * @return 供应商
	 */
	public TSupplier get(String uid);
	/**
	 * 获取：供应商列表
	 * @return 供应商列表
	 */
	public List<TSupplier> getList(TSupplier supplier);
	/**
	 * 获取：供应商手机业务量
	 * @param usupplierid
	 * @return 业务量
	 */
	public int getPhoneBusinessNumber(String usupplierid);
	/**
	 * 获取：供应商其它业务量
	 * @param usupplierid
	 * @return 业务量
	 */
	public int getOtherBusinessNumber(String usupplierid);
}
