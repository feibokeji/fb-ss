package com.fb.service;

import java.util.List;

import com.fb.domain.po.TSupplierOrder;
import com.fb.domain.po.TSupplierOrderDetail;
import com.fb.domain.po.TSupplierReceivable;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月28日 上午10:17:38 
* 类说明:供应商单据类操作服务接口
*/
public interface SupplierOrderService {
	/**
	 * 新增：供应商单据信息
	 * @param supplierOrder
	 * @return 受影响行数
	 */
	public int addSupplierOrder(TSupplierOrder supplierOrder);
	/**
	 * 获取：供应商单据集合
	 * @param supplierOrder
	 * @return 单据集合
	 */
	public List<TSupplierOrder> getSupplierOrder(TSupplierOrder supplierOrder);
	/**
	 * 获取：供应商单据明细集合
	 * @param uorderid 单据主键
	 * @return 明细集合
	 */
	public List<TSupplierOrderDetail> getSupplierOrderDetail(String uorderid);
	/**
	 * 获取：供应商单据的应付
	 * @param uorderid 单据主键
	 * @return 应付集合
	 */
	public List<TSupplierReceivable> getSupplierReceivable(String uorderid);
	/**
	 * 获取：供应商单据信息
	 * @param uid 单据表主键
	 * @return
	 * @author Liu bo
	 */
	public TSupplierOrder getSupplierOrder(String uid);
	/**
	 * 修改：供应商单据信息
	 * @param supplierOrder
	 * @return 受影响行数
	 * @author Liu bo
	 */
	public int modifySupplierOrder(TSupplierOrder supplierOrder);
	/**
	 * 获取：供应商实付款数量
	 * @param uorderid
	 * @return
	 * @author Liu bo
	 */
	public int getSupplierReceiptsNumber(String uorderid);
	/**
	 * 删除：供应商单据
	 * @param uid
	 * @return
	 * @author Liu bo
	 */
	public int deleteSupplierOrder(String uid);
	/**
	 * 审核：供应商单据
	 * @param uid
	 * @param uuserid
	 * @param udeptid
	 * @return
	 * @author Liu bo
	 */
	public int auditSupplierOrder(String uid,String uuserid,String udeptid);
	/**
	 * 反审核：供应商单据
	 * @param uid
	 * @param uuserid
	 * @param udeptid
	 * @return
	 * @author Liu bo
	 */
	public int unAuditSupplierOrder(String uid,String uuserid,String udeptid);
}
