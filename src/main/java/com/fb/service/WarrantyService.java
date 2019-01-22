package com.fb.service;

import java.util.List;

import com.fb.core.utils.Page;
import com.fb.domain.po.TWarranty;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午3:12:13 
* 类说明:
* 保修政策类操作接口
*/
public interface WarrantyService {
	
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
	public int delete(String uid);
	
	/**
	 * 修改 保修政策信息
	 * @param warranty
	 * @return 受影响行数
	 */
	public int update(TWarranty warranty);
	
	/**
	 * 获取 保修政策信息
	 * @param uid
	 * @return 保修政策信息
	 */
	public TWarranty get(String uid);
	
	/**
	 * 获取 保修政策集合
	 * @return 保修政策集合
	 */
	public List<TWarranty> getWarrantyList();
	
	/**
	 * 获取 保修政策分页
	 * @param warranty
	 * @param currentPage
	 * @return 保修政策分页
	 */
	public Page<TWarranty> getWarrantyPage(TWarranty warranty,int currentPage);
}
