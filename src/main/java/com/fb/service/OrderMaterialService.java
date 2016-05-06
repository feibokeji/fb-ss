package com.fb.service;

import java.util.List;

import com.fb.domain.po.TOrderMaterial;

/**
 * 物料订单操作
 * @since 2016年5月6日 下午5:26:12
 * @author Liu bo
 */
public interface OrderMaterialService {
    
    /**
     * 新增物料订单明细数据
     * @param orderMaterial
     * @return
     * @author Liu bo
     */
    public int addOrderMaterial(TOrderMaterial orderMaterial);
    
    /**
     * 删除物料订单明细数据
     * @param uid
     * @return
     * @author Liu bo
     */
    public int deleteOrderMaterialByUid(String uid);
    
    /**
     * 删除物料订单明细数据
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public int deleteOrderMaterialByUOrderId(String uorderid);
    
    /**
     * 更新物料订单明细数据
     * @param orderMaterial
     * @return
     * @author Liu bo
     */
    public int updateOrderMaterial(TOrderMaterial orderMaterial);
    
    /**
     * 获取物料订单数据
     * @param uid
     * @return
     * @author Liu bo
     */
    public TOrderMaterial getOrderMaterial(String uid);
    
    /**
     * 获取物料订单数据列表
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public List<TOrderMaterial> getOrderMaterialList(String uorderid);
}
