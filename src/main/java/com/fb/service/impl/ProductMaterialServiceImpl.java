package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TProductMaterialDao;
import com.fb.domain.po.TProductMaterial;
import com.fb.service.ProductMaterialService;
import com.fb.service.SimpServiceAbstract;

/**
 * 产品物料关联表控制
 * @since 2016年5月3日 下午7:39:39
 * @author Liu bo
 */
@Service
public class ProductMaterialServiceImpl extends SimpServiceAbstract implements ProductMaterialService {
    
    @Autowired
    private TProductMaterialDao productMaterialDao;
    
    @Transactional
    public synchronized int addProductMaterial(TProductMaterial productMaterial) {
        return productMaterialDao.addProductMaterial(productMaterial);
    }
    
    @Transactional
    public synchronized int deleteProductMaterial(String uid) {
        return productMaterialDao.deleteProductMaterial(uid);
    }
    
    @Transactional
    public synchronized int updateProductMaterial(TProductMaterial productMaterial) {
        return productMaterialDao.updateProductMaterial(productMaterial);
    }
    
    public int getProductMaterialByUMaterialId(String umaterialid) {
        return productMaterialDao.getProductMaterialByUMaterialId(umaterialid);
    }

    public List<TProductMaterial> getProductMaterialByUProductId(String uproductid) {
        return productMaterialDao.getProductMaterialByUProductId(uproductid);
    }
    
}
