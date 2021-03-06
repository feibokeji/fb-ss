package com.fb.service;

import java.util.List;

import com.fb.domain.po.TProduct;

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
    
    /**
     * 新增产品信息
     * @param product
     * @return
     * @author Liu bo
     */
    public int addProduct(TProduct product);
    
    /**
     * 删除产品信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public int deleteProduct(String uid);
    
    /**
     * 更新产品信息
     * @param product
     * @return
     * @author Liu bo
     */
    public int updateProduct(TProduct product);
    
    /**
     * 产品信息列表
     * @return
     * @author Liu bo
     */
    public List<TProduct> getProductList();
    
    /**
     * 根据名称获取产品数据
     * @param cname
     * @return
     * @author Liu bo
     */
    public List<TProduct> getProductByName(String cname);
}
