package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TProductDao;
import com.fb.domain.po.TProduct;
import com.fb.service.ProductService;
import com.fb.service.SimpServiceAbstract;

/**
 * 产品控制
 * 
 * @since 2016年5月2日 下午10:01:24
 * @author Liu bo
 */
@Service
public class ProductServiceImpl extends SimpServiceAbstract implements ProductService {
    
    @Autowired
    private TProductDao productDao;
    
    public int getProductByUCategoryId(String ucategoryid) {
        return productDao.getProductByUCategoryId(ucategoryid);
    }
    
    @Transactional
    public synchronized int addProduct(TProduct product) {
        return productDao.addProduct(product);
    }
    
    @Transactional
    public synchronized int deleteProduct(String uid) {
        return productDao.deleteProduct(uid);
    }
    
    @Transactional
    public synchronized int updateProduct(TProduct product) {
        return productDao.updateProduct(product);
    }

    public List<TProduct> getProductList() {
        return productDao.getProductList();
    }
    
}
