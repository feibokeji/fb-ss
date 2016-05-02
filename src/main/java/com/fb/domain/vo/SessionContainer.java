package com.fb.domain.vo;

import java.util.Date;
import java.util.List;

import com.fb.core.base.domain.BaseDomain;
import com.fb.domain.po.TCorp;
import com.fb.domain.po.TDept;
import com.fb.domain.po.TRole;
import com.fb.domain.po.TUser;

/**
 * session容器对象
 * @since 2015-6-13 下午7:25:35
 * @author Liu bo
 */
public class SessionContainer extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7161076185977361370L;
    
    private TUser user;
    
    private List<TRole> roles;
    
    private Date loginTime = new Date();
    
    private TRole role;
    
    private TDept dept;
    
    private TCorp corp;
    
    public TUser getUser() {
        return user;
    }
    
    public void setUser(TUser user) {
        this.user = user;
    }
    
    public List<TRole> getRoles() {
        return roles;
    }
    
    public void setRoles(List<TRole> roles) {
        this.roles = roles;
    }
    
    public Date getLoginTime() {
        return loginTime;
    }
    
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
    
    public TRole getRole() {
        return role;
    }
    
    public void setRole(TRole role) {
        this.role = role;
    }
    
    public TDept getDept() {
        return dept;
    }
    
    public void setDept(TDept dept) {
        this.dept = dept;
    }
    
    public TCorp getCorp() {
        return corp;
    }
    
    public void setCorp(TCorp corp) {
        this.corp = corp;
    }
    
}
