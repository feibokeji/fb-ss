package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.core.utils.DataUtils;
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
    
    @Transactional
    public synchronized int deleteProductMaterialByUProductId(String uproductid) {
        return productMaterialDao.deleteProductMaterialByUProductId(uproductid);
    }
    
    @Transactional
    public synchronized boolean saveProductMaterial(String uproductid, String umaterialids) {
        if (DataUtils.isUid(uproductid) && !DataUtils.isNullOrEmpty(umaterialids)) {
            if (umaterialids.contains(",")) {// 物料外键集合
                String[] ids = umaterialids.split(",");
                for (String id : ids) {
                    if (!DataUtils.isUid(id)) {
                        return false;
                    }
                }
                productMaterialDao.deleteProductMaterialByUProductId(uproductid);
                for (String id : ids) {
                    TProductMaterial productMaterial = new TProductMaterial();
                    productMaterial.setUid(DataUtils.newUUID());
                    productMaterial.setUproductid(uproductid);
                    productMaterial.setUmaterialid(id);
                    productMaterial.setNqty(1.0);
                    productMaterial.setIenablesign(0);
                    productMaterialDao.addProductMaterial(productMaterial);
                }
                return true;
            } else if (DataUtils.isUid(umaterialids)) {// 一个物料外键
                productMaterialDao.deleteProductMaterialByUProductId(uproductid);
                TProductMaterial productMaterial = new TProductMaterial();
                productMaterial.setUid(DataUtils.newUUID());
                productMaterial.setUproductid(uproductid);
                productMaterial.setUmaterialid(umaterialids);
                productMaterial.setNqty(1.0);
                productMaterial.setIenablesign(0);
                productMaterialDao.addProductMaterial(productMaterial);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    
}
