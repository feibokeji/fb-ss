package com.fb.service;

import java.util.List;

import com.fb.core.utils.Page;
import com.fb.domain.po.TBrand;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午3:11:45 
* 类说明:
* 品牌操作接口
*/
public interface BrandService {
	
	/**
	 * 新增 品牌信息
	 * @param brand
	 * @return 受影响行数
	 */
	public int add(TBrand brand);
	
	/**
	 * 删除 品牌信息
	 * @param uid
	 * @return 受影响行数
	 */
	public int delete(String uid);
	
	/**
	 * 修改 品牌信息
	 * @param brand
	 * @return 受影响行数
	 */
	public int update(TBrand brand);
	
	/**
	 * 获取 品牌信息
	 * @param uid
	 * @return 品牌信息
	 */
	public TBrand get(String uid);
	
	/**
	 * 获取 品牌信息集合
	 * @return 品牌信息集合
	 */
	public List<TBrand> getBrandList();
	
	/**
	 * 获取 品牌信息分页信息
	 * @param brand
	 * @param currentPage
	 * @return 品牌信息分页信息
	 */
	public Page<TBrand> getBrandPage(TBrand brand,int currentPage);
}
