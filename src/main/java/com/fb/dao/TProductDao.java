package com.fb.dao;

/**
 * 产品控制
 * @since 2016年5月2日 下午9:55:18
 * @author Liu bo
 */
public interface TProductDao {
    
    
    /**
     * 获取类别下的产品数量
     * @param ucategoryid
     * @return
     * @author Liu bo
     */
    public int getProductByUCategoryId(String ucategoryid);
}
