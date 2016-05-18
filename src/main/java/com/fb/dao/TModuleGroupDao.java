package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TModuleGroup;

/**
 * 功能权限组
 * @since 2016年5月18日 下午5:49:14
 * @author Liu bo
 */
public interface TModuleGroupDao {
    
    /**
     * 新增
     * @param moduleGroup
     * @return
     * @author Liu bo
     */
    public int add(TModuleGroup moduleGroup);
    
    /**
     * 删除
     * @param uid
     * @return
     * @author Liu bo
     */
    public int del(String uid);
    
    /**
     * 修改
     * @param moduleGroup
     * @return
     * @author Liu bo
     */
    public int modify(TModuleGroup moduleGroup);
    
    /**
     * 列表
     * @return
     * @author Liu bo
     */
    public List<TModuleGroup> getModuleGroupJSON();
}
