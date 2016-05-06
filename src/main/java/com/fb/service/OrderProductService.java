package com.fb.service;

import java.util.List;

import com.fb.domain.po.TOrderProduct;

/**
 * 产品订单操作
 * @since 2016年5月6日 下午5:25:58
 * @author Liu bo
 */
public interface OrderProductService {
    
    /**
     * 新增产品订单明细数据
     * @param orderProduct
     * @return
     * @author Liu bo
     */
    public int addOrderProduct(TOrderProduct orderProduct);
    
    /**
     * 删除产品订单明细数据
     * @param uid
     * @return
     * @author Liu bo
     */
    public int deleteOrderProductByUid(String uid);
    
    /**
     * 删除产品订单明细数据
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public int deleteOrderProductByUOrderId(String uorderid);
    
    /**
     * 更新产品订单明细数据
     * @param orderProduct
     * @return
     * @author Liu bo
     */
    public int updateOrderProduct(TOrderProduct orderProduct);
    
    /**
     * 获取产品订单明细数据
     * @param uid
     * @return
     * @author Liu bo
     */
    public TOrderProduct getOrderProduct(String uid);
    
    /**
     * 获取产品订单明细数据
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public List<TOrderProduct> getOrderProductList(String uorderid);
}
