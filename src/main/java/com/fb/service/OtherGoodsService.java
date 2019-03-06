package com.fb.service;

import java.util.List;

import com.fb.domain.po.TOtherGoods;
import com.fb.domain.po.TOtherGoodsPriceRecord;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 下午4:11:35 
* 类说明:其它商品服务接口实现类
*/
public interface OtherGoodsService {
	/**
	 * 新增：其它商品信息
	 * @param otherGoods
	 * @return 受影响行数
	 */
	public int addOtherGoods(TOtherGoods otherGoods);
	/**
	 * 获取：其它商品业务量
	 * @param uid
	 * @return 业务量
	 */
	public int getBusinessNumber(String uid);
	/**
	 * 删除：其它商品
	 * @param uid
	 * @return 受影响行数
	 */
	public int deleteOtherGoods(String uid);
	/**
	 * 修改：其它商品
	 * @param otherGoods
	 * @return 受影响行数
	 */
	public int modifyOtherGoods(TOtherGoods otherGoods);
	/**
	 * 获取：其它商品
	 * @param uid
	 * @return 其它商品
	 */
	public TOtherGoods getOtherGoods(String uid);
	/**
	 * 获取：其它商品集合
	 * @param otherGoods
	 * @return 其它商品集合
	 */
	public List<TOtherGoods> getOtherGoodsList(TOtherGoods otherGoods);
	/**
	 * 获取：其它商品价格记录集合
	 * @param uothergoodsid
	 * @return 其它商品价格记录集合
	 */
	public List<TOtherGoodsPriceRecord> getListByUOtherGoodsId(String uothergoodsid);
	/**
     * 获取 商品库存信息集合
     * @param otherGoods
     * @return
     * @author Liu bo
     */
    public List<TOtherGoods> getInventory(TOtherGoods otherGoods);
}
