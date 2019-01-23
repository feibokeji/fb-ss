package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TBrand;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午2:05:13 
* 类说明 ：
* 品牌类操作接口
*/
public interface TBrandDao {
	
	/**
	 * 新增 品牌
	 * @param brand
	 * @return 受影响行数
	 */
	public int add(TBrand brand);
	
	/**
	 * 删除 品牌
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	
	/**
	 * 修改 品牌
	 * @param brand
	 * @return 受影响行数
	 */
	public int mod(TBrand brand);
	
	/**
	 * 获取 品牌信息
	 * @param uid
	 * @return 品牌信息
	 */
	public TBrand get(String uid);
	
	/**
	 * 获取 品牌信息集合
	 * @return 集合
	 */
	public List<TBrand> getList(TBrand brand);
	/**
	 * 获取：手机业务量
	 * @param ubrandid
	 * @return 业务量
	 */
	public int getPhoneBusinessNumber(String ubrandid);
	/**
	 * 获取：其它业务量
	 * @param ubrandid
	 * @return 业务量
	 */
	public int getOtherBusinessNumber(String ubrandid);
}
