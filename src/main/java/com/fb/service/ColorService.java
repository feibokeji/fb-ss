package com.fb.service;

import java.util.List;

import com.fb.core.utils.Page;
import com.fb.domain.po.TColor;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午3:11:59 
* 类说明:
* 颜色操作接口
*/
public interface ColorService {
	
	/**
	 * 新增 颜色信息
	 * @param color
	 * @return 受影响行数
	 */
	public int add(TColor color);
	
	/**
	 * 删除 颜色信息
	 * @param uid
	 * @return 受影响行数
	 */
	public int delete(String uid);
	
	/**
	 * 修改 颜色信息
	 * @param color
	 * @return 受影响行数
	 */
	public int update(TColor color);
	
	/**
	 * 获取 颜色信息
	 * @param uid
	 * @return 颜色信息
	 */
	public TColor get(String uid);
	
	/**
	 * 获取 颜色信息集合
	 * @return 颜色信息集合
	 */
	public List<TColor> getColorList();
	
	/**
	 * 获取 颜色信息分页
	 * @param color
	 * @param currentPage
	 * @return 颜色信息分页
	 */
	public Page<TColor> getColorPage(TColor color,int currentPage);
}
