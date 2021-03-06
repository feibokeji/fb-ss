package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TRoleModuleGroup;

/**
 * 角色模块组管理
 * @author Liu bo
 */
public interface TRoleModuleGroupDao {
    
    /**
     * 新增角色模块组
     * @param roleModuleGroup
     * @return
     */
    public int addRoleModuleGroup(TRoleModuleGroup roleModuleGroup);
    
    /**
     * 获取角色下模块组集合
     * @param uroleid
     * @return
     */
    public List<TRoleModuleGroup> getRoleModuleGroupByRoleId(String uroleid);
    
    /**
     * 获取角色关系记录数
     * @param uroleid
     * @return
     * @author Liu bo
     */
    public int getRoleModuleGroupCountByURoleId(String uroleid);
    
    /**
     * 清除角色与功能模块组之间的关系
     * @param uroleid
     * @return
     * @author Liu bo
     */
    public int deleteRoleModuleGroupByURoleId(String uroleid);
}
