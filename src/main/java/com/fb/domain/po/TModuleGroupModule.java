package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 功能模块组模块信息表
 * @since 2015-6-9 下午7:32:06
 * @author Liu bo
 */
@TableMapper("t_module_group_module")
public class TModuleGroupModule extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7257528355242242132L;
    
    /**
     * 唯一ID
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 模块ID
     */
    private String umoduleid;
    
    /**
     * 模块组ID
     */
    private String umodulegroupid;
    
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
     * 获取 模块ID
     * @return umoduleid
     */
    public String getUmoduleid() {
        return umoduleid;
    }
    
    /**
     * 设置 模块ID
     * @param umoduleid 模块ID
     */
    public void setUmoduleid(String umoduleid) {
        this.umoduleid = umoduleid;
    }
    
    /**
     * 获取 模块组ID
     * @return umodulegroupid
     */
    public String getUmodulegroupid() {
        return umodulegroupid;
    }
    
    /**
     * 设置 模块组ID
     * @param umodulegroupid 模块组ID
     */
    public void setUmodulegroupid(String umodulegroupid) {
        this.umodulegroupid = umodulegroupid;
    }
    
}
