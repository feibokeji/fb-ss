package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TSupplierOrderDetail;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月27日 下午5:01:42 
* 类说明:供应商单据明细类操作接口
*/
public interface TSupplierOrderDetailDao {
	/**
	 * 新增：供应商单据明细
	 * @param supplierOrderDetail
	 * @return 受影响行数
	 */
	public int add(TSupplierOrderDetail supplierOrderDetail);
	/**
	 * 删除：供应商单据明细
	 * @param uorderid 单据表外键
	 * @return 受影响行数
	 */
	public int del(String uorderid);
	/**
	 * 获取：供应商单据明细集合
	 * @param uorderid 单据表外键
	 * @return 受影响行数
	 */
	public List<TSupplierOrderDetail> getList(String uorderid);
}
