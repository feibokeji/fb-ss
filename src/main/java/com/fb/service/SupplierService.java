package com.fb.service;

import java.util.List;

import com.fb.domain.po.TSupplier;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午7:17:44 
* 类说明:
* 供应商信息操作
*/
public interface SupplierService {
	/**
	 * 获取：供应商信息列表
	 * @return 供应商信息列表
	 */
	public List<TSupplier> getSupplierList(TSupplier supplier);
	/**
	 * 新增：供应商信息
	 * @param supplier
	 * @return 受影响行数
	 */
	public int addSupplier(TSupplier supplier);
	/**
	 * 修改：供应商信息
	 * @param supplier
	 * @return 受影响行数
	 */
	public int modifySupplier(TSupplier supplier);
	/**
	 * 获取：供应商信息
	 * @param uid
	 * @return 供应商信息
	 */
	public TSupplier getSupplier(String uid);
	/**
	 * 获取：供应商业务数量
	 * @param uid
	 * @return 产生的业务数量
	 */
	public int getSupplierBusinessNumber(String uid);
	/**
	 * 删除：供应商信息
	 * @param uid
	 * @return 受影响行数
	 */
	public int deleteSupplier(String uid);
}
