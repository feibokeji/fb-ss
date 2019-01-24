package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TWarranty;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午2:33:44 
* 类说明:
* 保修政策类操作接口
*/
public interface TWarrantyDao {
	
	/**
	 * 新增 保修政策信息
	 * @param warranty
	 * @return 受影响行数
	 */
	public int add(TWarranty warranty);
	
	/**
	 * 删除 保修政策信息
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	
	/**
	 * 修改 保修政策信息
	 * @param warranty
	 * @return 受影响行数
	 */
	public int mod(TWarranty warranty);
	
	/**
	 * 修改 保修政策信息
	 * @param uid
	 * @param iday
	 * @param ccontent
	 * @return 受影响行数
	 */
	public int mod(String uid,int iday,String ccontent);
	
	/**
	 * 获取 保修政策信息
	 * @param uid
	 * @return 保修政策信息
	 */
	public TWarranty get(String uid);
	
	/**
	 * 获取 保修政策信息集合
	 * @return 保修政策信息集合
	 */
	public List<TWarranty> getList();
	
	/**
	 * 获取：其它商品使用量
	 * @param uwarrantyid
	 * @return 使用量
	 */
	public int getOtherUseNumber(String uwarrantyid);
	
	/**
	 * 获取：手机使用量
	 * @param uwarrantyid
	 * @return 使用量
	 */
	public int getPhoneUseNumber(String uwarrantyid);
}
