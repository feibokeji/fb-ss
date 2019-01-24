package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TOtherGoodsPriceRecord;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 下午4:28:06 
* 类说明:
*/
public interface TOtherGoodsPriceRecordDao {
	/**
	 * 新增：其它商品价格记录信息
	 * @param otherGoodsPriceRecord
	 * @return 受影响行数
	 */
	public int add(TOtherGoodsPriceRecord otherGoodsPriceRecord);
	/**
	 * 删除：其它商品价格记录
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	/**
	 * 删除：其它商品价格记录
	 * @param uothergoodsid
	 * @return 受影响行数
	 */
	public int delByUOtherGoodsId(String uothergoodsid);
	/**
	 * 修改：其他商品价格记录
	 * @param otherGoodsPriceRecord
	 * @return 受影响行数
	 */
	public int mod(TOtherGoodsPriceRecord otherGoodsPriceRecord);
	/**
	 * 获取：其它商品价格记录
	 * @param uid
	 * @return 其它商品价格记录
	 */
	public TOtherGoodsPriceRecord get(String uid);
	/**
	 * 获取：其它商品价格记录集合
	 * @param uothergoodsid
	 * @return 其它商品价格记录集合
	 */
	public List<TOtherGoodsPriceRecord> getListByUOtherGoodsId(String uothergoodsid);
	/**
	 * 修改：商品价格记录状态
	 * @param uothergoodsid
	 * @param istatus
	 * @return 受影响行数
	 */
	public int modPriceRecordStatusByUOtherGoodsId(String uothergoodsid,int istatus);
}
