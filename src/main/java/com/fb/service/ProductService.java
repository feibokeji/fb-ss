package com.fb.service;

/**
 * 产品控制
 * @since 2016年5月2日 下午9:59:57
 * @author Liu bo
 */
public interface ProductService {
    
    
    /**
     * 获取类别下产品数量
     * @param ucategoryid
     * @return
     * @author Liu bo
     */
    public int getProductByUCategoryId(String ucategoryid);
}
