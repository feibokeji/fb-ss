package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TProductMaterialDao;
import com.fb.domain.po.TProductMaterial;

/**
 * 产品物料关联表控制
 * @since 2016年5月3日 下午7:33:56
 * @author Liu bo
 */
@Service
public class TProductMaterialDaoImpl extends SimpMapper<TProductMaterial> implements TProductMaterialDao {
    
    
    /**
     * 新增产品物料关系数据
     */
    public int addProductMaterial(TProductMaterial productMaterial) {
        return super.save(productMaterial);
    }
    
    /**
     * 删除产品物料关系数据
     */
    public int deleteProductMaterial(String uid) {
        return super.delete(uid);
    }
    
    /**
     * 更新产品物料关系数据
     */
    public int updateProductMaterial(TProductMaterial productMaterial) {
        return super.update(productMaterial);
    }
    
    /**
     * 获取包含此物料的关联数据量
     * @param umaterialid
     * @return
     * @author Liu bo
     */
    public int getProductMaterialByUMaterialId(String umaterialid) {
        String sql = "select count(*) from t_product_material t where t.umaterialid = :umaterialid";
        return super.getInt(sql, new QMap("umaterialid", umaterialid));
    }
    
    public List<TProductMaterial> getProductMaterialByUProductId(String uproductid) {
        String sql = "select * from t_product_material t where t.uproductid = :uproductid";
        return findList(sql, new QMap("uproductid", uproductid));
    }

    public int deleteProductMaterialByUProductId(String uproductid) {
        String sql = "delete from t_product_material  where uproductid = :uproductid";
        return execute(sql, new QMap("uproductid",uproductid));
    }
    
}
