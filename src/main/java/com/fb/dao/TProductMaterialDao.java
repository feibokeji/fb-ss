package com.fb.dao;

import com.fb.domain.po.TProductMaterial;

/**
 * 产品物料关联表控制
 * @since 2016年5月3日 下午7:29:55
 * @author Liu bo
 */
public interface TProductMaterialDao {
    
    /**
     * 新增产品物料关联数据
     * @param productMaterial
     * @return
     * @author Liu bo
     */
    public int addProductMaterial(TProductMaterial productMaterial);
    
    /**
     * 删除产品物料关联数据
     * @param uid
     * @return
     * @author Liu bo
     */
    public int deleteProductMaterial(String uid);
    
    /**
     * 更新产品物料关联数据
     * @param productMaterial
     * @return
     * @author Liu bo
     */
    public int updateProductMaterial(TProductMaterial productMaterial);
    
    /**
     * 获取包含此物料的关联数据量
     * @param umaterialid
     * @return
     * @author Liu bo
     */
    public int getProductMaterialByUMaterialId(String umaterialid);
}
