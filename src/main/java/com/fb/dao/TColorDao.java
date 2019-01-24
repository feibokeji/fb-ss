package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TColor;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午2:21:14 
* 类说明:
* 颜色类操作接口
*/
public interface TColorDao {
	
	/**
	 * 新增 颜色
	 * @param color
	 * @return 受影响行数
	 */
	public int add(TColor color);
	
	/**
	 * 删除 颜色
	 * @param uid
	 * @return 受影响行数
	 */
	public int del(String uid);
	
	/**
	 * 修改 颜色
	 * @param color
	 * @return 受影响行数
	 */
	public int mod(TColor color);
	
	/**
	 * 修改 颜色
	 * @param uid
	 * @param cname
	 * @return 受影响行数
	 */
	public int mod(String uid,String cname);
	
	/**
	 * 获取 颜色
	 * @param uid
	 * @return 颜色信息
	 */
	public TColor get(String uid);
	
	/**
	 * 获取 颜色集合
	 * @return 颜色集合
	 */
	public List<TColor> getList();
	
	/**
	 * 获取：颜色使用量
	 * @param ucolorid
	 * @return 使用量
	 */
	public int getUseNumber(String ucolorid);
}
