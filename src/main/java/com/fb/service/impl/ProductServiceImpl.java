package com.fb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TProductDao;
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
    
}
