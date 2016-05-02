package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 角色间访问控制信息表,初始化时要求每个角色都对自己开放删除
 * @since 2015-6-10 下午7:54:42
 * @author Liu bo
 */
@TableMapper("t_role_access")
public class TRoleAccess extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = -9192173579165518015L;
    
    /**
     * 唯一ID
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 共享角色ID
     */
    private String uroleid;
    
    /**
     * 访问角色ID
     */
    private String uaccessroleid;
    
    /**
     * 访问级别 <li>1 - 只读 <li>2 - 修改 <li>3 - 删除 <li>4 - 所有
     */
    private Integer iaccess;
    
    /**
     * 审核标识 <li>0 - 不能审核 <li>1 - 可以审核
     */
    private Integer iaudit;
    
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
     * 获取 共享角色ID
     * @return uroleid
     */
    public String getUroleid() {
        return uroleid;
    }
    
    /**
     * 设置 共享角色ID
     * @param uroleid 共享角色ID
     */
    public void setUroleid(String uroleid) {
        this.uroleid = uroleid;
    }
    
    /**
     * 获取 访问角色ID
     * @return uaccessroleid
     */
    public String getUaccessroleid() {
        return uaccessroleid;
    }
    
    /**
     * 设置 访问角色ID
     * @param uaccessroleid 访问角色ID
     */
    public void setUaccessroleid(String uaccessroleid) {
        this.uaccessroleid = uaccessroleid;
    }
    
    /**
     * 获取 访问级别 <li>1 - 只读 <li>2 - 修改 <li>3 - 删除 <li>4 - 所有
     * @return iaccess
     */
    public Integer getIaccess() {
        return iaccess;
    }
    
    /**
     * 设置 访问级别 <li>1 - 只读 <li>2 - 修改 <li>3 - 删除 <li>4 - 所有
     * @param iaccess 访问级别 <li>1 - 只读 <li>2 - 修改 <li>3 - 删除 <li>4 - 所有
     */
    public void setIaccess(Integer iaccess) {
        this.iaccess = iaccess;
    }
    
    /**
     * 获取 审核标识 <li>0 - 不能审核 <li>1 - 可以审核
     * @return iaudit
     */
    public Integer getIaudit() {
        return iaudit;
    }
    
    /**
     * 设置 审核标识 <li>0 - 不能审核 <li>1 - 可以审核
     * @param iaudit 审核标识 <li>0 - 不能审核 <li>1 - 可以审核
     */
    public void setIaudit(Integer iaudit) {
        this.iaudit = iaudit;
    }
    
}
