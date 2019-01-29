package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TSupplierOrder;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月27日 下午3:50:48 
* 类说明:供应商单据类操作接口
*/
public interface TSupplierOrderDao {
	/**
	 * 新增：供应商单据
	 * @param supplierOrder
	 * @return 受影响行数
	 */
	public int add(TSupplierOrder supplierOrder);
	/**
	 * 删除：供应商单据
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	/**
	 * 修改：供应商单据
	 * @param supplierOrder
	 * @return 受影响行数
	 */
	public int mod(TSupplierOrder supplierOrder);
	/**
	 * 获取：供应商单据
	 * @param uid
	 * @return 单据信息
	 */
	public TSupplierOrder get(String uid);
	/**
	 * 获取：供应商单据集合
	 * @param supplierOrder
	 * @return 单据信息集合
	 */
	public List<TSupplierOrder> getList(TSupplierOrder supplierOrder);
	/**
	 * 获取：已审核实收或实付量
	 * @param uid
	 * @return 数量
	 */
	public int getAuditReceiptsNumber(String uid);
}
