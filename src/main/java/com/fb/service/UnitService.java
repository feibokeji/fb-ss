package com.fb.service;

import java.util.List;

import com.fb.core.utils.Page;
import com.fb.domain.po.TUnit;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午3:12:24 
* 类说明:
* 单位操作接口
*/
public interface UnitService {
	
	/**
	 * 新增 单位信息
	 * @param unit
	 * @return 受影响行数
	 */
	public int add(TUnit unit);
	
	/**
	 * 删除 单位信息
	 * @param uid
	 * @return 受影响行数
	 */
	public int delete(String uid);
	
	/**
	 * 修改 单位信息
	 * @param unit
	 * @return 受影响行数
	 */
	public int update(TUnit unit);
	
	/**
	 * 获取 单位信息
	 * @param uid
	 * @return 单位信息
	 */
	public TUnit get(String uid);
	
	/**
	 * 获取 单位信息集合
	 * @return 单位信息集合
	 */
	public List<TUnit> getUnitList();
	
	/**
	 * 获取 单位信息分页
	 * @return 单位信息分页
	 */
	public Page<TUnit> getUnitPage();
}
