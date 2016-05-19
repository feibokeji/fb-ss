package com.fb.service;

import java.util.List;

import com.fb.domain.po.TModule;

/**
 * 功能模块操作
 * @author Liu bo
 */
public interface ModuleService {
    
    /**
     * 新增功能模块
     * @param module
     * @return
     */
    public int addModule(TModule module);
    
    /**
     * 获取功能模块
     * @param uid
     * @return
     */
    public TModule getModuleByUid(String uid);
    
    /**
     * 获取功能模块集合
     * @return
     */
    public List<TModule> getModuleList();
    
    /**
     * 删除功能模块
     * @param uid
     * @return
     */
    public int deleteModule(String uid);
    
    /**
     * 获取功能模块集合用于转换为JSON数据
     * @return
     * @author Liu bo
     */
    public List<TModule> getModuleListJSON(String umodulegroupid);
}
