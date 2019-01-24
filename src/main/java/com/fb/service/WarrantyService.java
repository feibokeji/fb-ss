package com.fb.service;

import java.util.List;
import com.fb.domain.po.TWarranty;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午3:12:13 
* 类说明:
* 保修政策类操作接口
*/
public interface WarrantyService {
	/**
	 * 新增：保修政策
	 * @param warranty
	 * @return 受影响行数
	 */
	public int addWarranty(TWarranty warranty);
	/**
	 * 获取：保修政策使用量
	 * @param uwarrantyid
	 * @return 使用量
	 */
	public int getWarrantyUseNumber(String uwarrantyid);
	/**
	 * 删除：保修政策
	 * @param uid
	 * @return 受影响行数
	 */
	public int deleteWarranty(String uid);
	/**
	 * 修改：保修政策
	 * @param warranty
	 * @return 受影响行数
	 */
	public int modifyWarranty(TWarranty warranty);
	/**
	 * 获取：保修政策
	 * @param uid
	 * @return 保修政策
	 */
	public TWarranty getWarranty(String uid);
	/**
	 * 获取：保修政策集合
	 * @return 保修政策集合
	 */
	public List<TWarranty> getWarrantyList();
}
