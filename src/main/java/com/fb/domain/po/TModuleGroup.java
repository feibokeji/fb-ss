package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 功能模块组信息表
 * @since 2015-6-9 下午7:29:17
 * @author Liu bo
 */
@TableMapper("t_module_group")
public class TModuleGroup extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5134706027166573810L;
    
    /**
     * 唯一ID
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 模块组代码
     */
    private String ccode;
    
    /**
     * 模块组名称
     */
    private String cname;
    
    /**
     * 关联的角色主键
     */
    @NotFieldMapper
    private String uroleid;
    
    /**
     * 角色关联的功能模块组数量
     */
    @NotFieldMapper
    private Integer haveModuleGroup;
    
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
     * 获取 模块组代码
     * @return ccode
     */
    public String getCcode() {
        return ccode;
    }
    
    /**
     * 设置 模块组代码
     * @param ccode 模块组代码
     */
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    
    /**
     * 获取 模块组名称
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 模块组名称
     * @param cname 模块组名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    /**
     * 获取 角色关联的功能模块组数量
     * @return haveModuleGroup
     */
    public Integer getHaveModuleGroup() {
        return haveModuleGroup;
    }
    
    /**
     * 设置 角色关联的功能模块组数量
     * @param haveModuleGroup 角色关联的功能模块组数量
     */
    public void setHaveModuleGroup(Integer haveModuleGroup) {
        this.haveModuleGroup = haveModuleGroup;
    }
    
    /**
     * 获取 关联的角色主键
     * @return uroleid
     */
    public String getUroleid() {
        return uroleid;
    }
    
    /**
     * 设置 关联的角色主键
     * @param uroleid 关联的角色主键
     */
    public void setUroleid(String uroleid) {
        this.uroleid = uroleid;
    }
    
}
