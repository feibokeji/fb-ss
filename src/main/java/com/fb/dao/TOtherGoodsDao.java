package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TOtherGoods;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 下午3:05:24 
* 类说明:其它商品操作接口
*/
public interface TOtherGoodsDao {
	/**
	 * 新增：其它商品
	 * @param otherGoods
	 * @return 受影响行数
	 */
	public int add(TOtherGoods otherGoods);
	/**
	 * 获取：客户业务量
	 * @param uothergoodsid
	 * @return 业务量
	 */
	public int getCustomerBusinessNumber(String uothergoodsid);
	/**
	 * 获取：供应商业务量
	 * @param uothergoodsid
	 * @return 业务量
	 */
	public int getSupplierBusinessNumber(String uothergoodsid);
	/**
	 * 删除：其它商品
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	/**
	 * 修改：其它商品
	 * @param otherGoods
	 * @return 受影响行数
	 */
	public int mod(TOtherGoods otherGoods);
	/**
	 * 获取：其它商品
	 * @param uid
	 * @return 其它商品
	 */
	public TOtherGoods get(String uid);
	/**
	 * 获取：其它商品集合
	 * @param otherGoods
	 * @return 其它商品集合
	 */
	public List<TOtherGoods> getList(TOtherGoods otherGoods);
	
	/**
	 * 获取 商品库存信息集合
	 * @param otherGoods
	 * @return
	 * @author Liu bo
	 */
	public List<TOtherGoods> getInventory(TOtherGoods otherGoods);
}
