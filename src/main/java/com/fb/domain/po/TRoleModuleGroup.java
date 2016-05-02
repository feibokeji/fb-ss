package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 角色关联功能权限组信息表
 * @since 2015-6-10 下午8:02:18
 * @author Liu bo
 */
@TableMapper("t_role_module_group")
public class TRoleModuleGroup extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4441186651075692504L;
    
    /**
     * 唯一ID
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 功能权限组ID
     */
    private String umodulegroupid;
    
    /**
     * 角色ID
     */
    private String uroleid;
    
    /**
     * 获取 唯一ID
     * @return uid
     */
    public String getUid() {
        return uid;
    }
    
    /**
     * 设置 唯一ID
     * @param uid 唯一ID
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
    
    /**
     * 获取 功能权限组ID
     * @return umodulegroupid
     */
    public String getUmodulegroupid() {
        return umodulegroupid;
    }
    
    /**
     * 设置 功能权限组ID
     * @param umodulegroupid 功能权限组ID
     */
    public void setUmodulegroupid(String umodulegroupid) {
        this.umodulegroupid = umodulegroupid;
    }
    
    /**
     * 获取 角色ID
     * @return uroleid
     */
    public String getUroleid() {
        return uroleid;
    }
    
    /**
     * 设置 角色ID
     * @param uroleid 角色ID
     */
    public void setUroleid(String uroleid) {
        this.uroleid = uroleid;
    }
    
}
