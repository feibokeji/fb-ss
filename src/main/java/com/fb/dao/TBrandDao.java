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
	 * 修改 品牌
	 * @param uid
	 * @param cname
	 * @param clogo
	 * @param curl
	 * @param cdesc
	 * @param isort
	 * @return 受影响行数
	 */
	public int mod(String uid,String cname,String clogo,String curl,String cdesc,int isort);
	
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
	public List<TBrand> getList();
}
