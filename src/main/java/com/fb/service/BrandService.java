package com.fb.service;

import java.util.List;
import com.fb.domain.po.TBrand;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午3:11:45 
* 类说明:
* 品牌操作接口
*/
public interface BrandService {
	/**
	 * 新增：品牌信息
	 * @param brand
	 * @return 受影响行数
	 */
	public int addBrand(TBrand brand);
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
	/**
	 * 删除：品牌信息
	 * @param uid
	 * @return 受影响行数
	 */
	public int deleteBrand(String uid);
	/**
	 * 修改：品牌信息
	 * @param brand
	 * @return 受影响行数
	 */
	public int modifyBrand(TBrand brand);
	/**
	 * 获取：品牌信息
	 * @param uid
	 * @return 品牌信息
	 */
	public TBrand getBrand(String uid);
	/**
	 * 获取：品牌信息列表
	 * @param brand
	 * @return 品牌信息列表
	 */
	public List<TBrand> getBrandList(TBrand brand);
}
