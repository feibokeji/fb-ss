package com.fb.service;

import java.util.List;

import com.fb.domain.po.TCategory;

public interface CategoryService {
    
    /**
     * 新增
     * @param category
     * @return
     * @author Liu bo
     */
    public int add(TCategory category);
    
    /**
     * 删除
     * @param uid
     * @return
     * @author Liu bo
     */
    public int delete(String uid);
    
    /**
     * 更新
     * @param category
     * @return
     * @author Liu bo
     */
    public int update(TCategory category);
    
    /**
     * 产品类别集合
     * @return
     * @author Liu bo
     */
    public List<TCategory> getCategoryList();
}
