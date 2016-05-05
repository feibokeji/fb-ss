package com.fb.service;

import java.util.List;

import com.fb.domain.po.TProductMaterial;

/**
 * 产品物料关联表控制
 * @since 2016年5月3日 下午7:38:37
 * @author Liu bo
 */
public interface ProductMaterialService {
    
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
     * 删除产品物料关联数据
     * @param uproductid
     * @return
     * @author Liu bo
     */
    public int deleteProductMaterialByUProductId(String uproductid);
    
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
    
    /**
     * 获取指定产品所包含的物料关系
     * @param uproductid
     * @return
     * @author Liu bo
     */
    public List<TProductMaterial> getProductMaterialByUProductId(String uproductid);
    
    /**
     * 保存产品物料关系数据
     * @param uproductid
     * @param umaterialids
     * @return
     * @author Liu bo
     */
    public boolean saveProductMaterial(String uproductid, String umaterialids);
}
