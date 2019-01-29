package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TSupplierReceivable;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月27日 下午5:18:15 
* 类说明:供应商应收应付类操作接口
*/
public interface TSupplierReceivableDao {
	/**
	 * 新增：供应商应收或应付
	 * @param supplierReceivable
	 * @return 受影响行数
	 */
	public int add(TSupplierReceivable supplierReceivable);
	/**
	 * 删除：供应商应收或应付
	 * @param uorderid 供应商单据表外键
	 * @return 受影响行数
	 */
	public int del(String uorderid);
	/**
	 * 修改：供应商应收或应付状态
	 * @param uid
	 * @param istatus
	 * @return 受影响行数
	 */
	public int modStatus(String uid,int istatus);
	/**
	 * 修改：供应商应收或应付
	 * @param supplierReceivable
	 * @return 受影响行数
	 */
	public int mod(TSupplierReceivable supplierReceivable);
	/**
	 * 获取：供应商应收或应付
	 * @param uid
	 * @return 受影响行数
	 */
	public TSupplierReceivable get(String uid);
	/**
	 * 获取：供应商应收或应付集合
	 * @param supplierReceivable
	 * @return 集合
	 */
	public List<TSupplierReceivable> getList(TSupplierReceivable supplierReceivable);
	/**
	 * 获取：供应商应付
	 * @param uorderid
	 * @return 应付集合
	 */
	public List<TSupplierReceivable> getList(String uorderid);
}
