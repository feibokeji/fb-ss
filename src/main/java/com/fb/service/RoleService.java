package com.fb.service;

import java.util.List;

import com.fb.domain.po.TModuleGroupModule;
import com.fb.domain.po.TRole;
import com.fb.domain.po.TRoleModuleGroup;

/**
 * 角色功能操作
 * @author Liu bo
 */
public interface RoleService {
    
    /**
     * 获取账户角色集合
     * @param uuserid
     * @return
     */
    public List<TRole> getRoleByUserId(String uuserid);
    
    /**
     * 获取角色模块组集合
     * @param uroleid
     * @return
     */
    public List<TRoleModuleGroup> getRoleModuleGroupByRoleId(String uroleid);
    
    /**
     * 获取模块组关联集合
     * @param umodulegroupid
     * @return
     */
    public List<TModuleGroupModule> getModuleGroupModuleByModuleGroupId(String umodulegroupid);
    
    /**
     * 获取角色关系记录数
     * @param uroleid
     * @return
     * @author Liu bo
     */
    public int getRoleModuleGroupCountByURoleId(String uroleid);
    
    /**
     * 删除
     * @param uid
     * @return
     * @author Liu bo
     */
    public int delete(String uid);
    
    /**
     * 修改
     * @param role
     * @return
     * @author Liu bo
     */
    public int modify(TRole role);
    
    /**
     * 角色列表
     * @return
     * @author Liu bo
     */
    public List<TRole> getRoleList();
    
    /**
     * 新增角色
     * @param role
     * @return
     */
    public int addRole(TRole role);
}
