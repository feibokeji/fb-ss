package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TRole;

/**
 * 角色操作
 * @author Liu bo
 */
public interface TRoleDao {
    
    /**
     * 新增角色
     * @param role
     * @return
     */
    public int addRole(TRole role);
    
    /**
     * 获取 角色
     * @param uid
     * @return
     * @author Liu bo
     */
    public TRole get(String uid);
    
    /////////////// 此功能预留后期多角色管理时使用
    /**
     * 获取账户角色
     * @param uuserid
     * @return
     */
    public List<TRole> getRoleByUserId(String uuserid);
    
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
}
