package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 角色信息表
 * @since 2015-6-10 下午6:45:16
 * @author Liu bo
 */
@TableMapper("t_role")
public class TRole extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4224177743876726037L;
    
    /**
     * 唯一ID
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 角色所属部门ID
     */
    private String udeptid;
    
    /**
     * 角色代码
     */
    private String ccode;
    
    /**
     * 角色名称
     */
    private String cname;
    
    /**
     * 角色所属用户ID
     */
    private String uuserid;
    
    /**
     * 角色所属用户名称
     */
    @NotFieldMapper
    private String cusername;
    
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
     * 获取 角色所属部门ID
     * @return udeptid
     */
    public String getUdeptid() {
        return udeptid;
    }
    
    /**
     * 设置 角色所属部门ID
     * @param udeptid 角色所属部门ID
     */
    public void setUdeptid(String udeptid) {
        this.udeptid = udeptid;
    }
    
    /**
     * 获取 角色代码
     * @return ccode
     */
    public String getCcode() {
        return ccode;
    }
    
    /**
     * 设置 角色代码
     * @param ccode 角色代码
     */
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    
    /**
     * 获取 角色名称
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 角色名称
     * @param cname 角色名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    /**
     * 获取 角色所属用户ID
     * @return uuserid
     */
    public String getUuserid() {
        return uuserid;
    }
    
    /**
     * 设置 角色所属用户ID
     * @param uuserid 角色所属用户ID
     */
    public void setUuserid(String uuserid) {
        this.uuserid = uuserid;
    }
    
    /**
     * 获取 角色所属用户名称
     * @return cusername
     */
    public String getCusername() {
        return cusername;
    }
    
    /**
     * 设置 角色所属用户名称
     * @param cusername 角色所属用户名称
     */
    public void setCusername(String cusername) {
        this.cusername = cusername;
    }
    
}
