package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCategory;

/**
 * 产品类别
 * @since 2016年4月29日 下午4:40:40
 * @author Liu bo
 */
public interface TCategoryDao {
    
    
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
    
    /**
     * 根据名称获取类别数据
     * @param cname
     * @return
     * @author Liu bo
     */
    public TCategory getCategoryByName(String cname);
}
