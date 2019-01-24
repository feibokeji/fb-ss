package com.fb.service;

import java.util.List;

import com.fb.domain.po.TColor;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午3:11:59 
* 类说明:
* 颜色操作接口
*/
public interface ColorService {
	/**
	 * 新增：颜色信息
	 * @param color
	 * @return 受影响行数
	 */
	public int addColor(TColor color);
	/**
	 * 获取：颜色使用量
	 * @param ucolorid
	 * @return 使用量
	 */
	public int getColorUseNumber(String ucolorid);
	/**
	 * 删除：颜色信息
	 * @param uid
	 * @return 受影响行数
	 */
	public int deleteColor(String uid);
	/**
	 * 修改：颜色信息
	 * @param color
	 * @return 受影响行数
	 */
	public int modifyColor(TColor color);
	/**
	 * 获取：颜色信息
	 * @param uid
	 * @return 颜色信息
	 */
	public TColor getColor(String uid);
	/**
	 * 获取：颜色信息列表
	 * @return 颜色信息列表
	 */
	public List<TColor> getColorList();
}
