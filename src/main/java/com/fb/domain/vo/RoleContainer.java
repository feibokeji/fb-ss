package com.fb.domain.vo;

import java.util.Map;

import com.fb.domain.po.TCorp;
import com.fb.domain.po.TDept;
import com.fb.domain.po.TRole;
import com.fb.domain.po.TRoleAccess;

public class RoleContainer extends SessionContainer {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4897136722482244020L;
    
    private TRole role;
    
    private TDept dept;
    
    private TCorp corp;
    
    private Map<String, TRoleAccess> roleAccessMap;
    
    /**
     * <u>权限级别 - 共享角色ID组</u> 的映射集 eg: 1 - "roleid1,roleid2"
     */
    private Map<String, String> levelAccessMap;
    
    /**
     * 功能模块代码组合字符串 以"|"打头、结尾以及分隔 eg: |code1|code2|code3|
     */
    private String moduleCodes;
    
    /**
     * 所有可访问功能模块的url组成的正册则达式 用于filter中url过滤 防止盗链
     */
    private String urlRegex;
    
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
    
    public Map<String, TRoleAccess> getRoleAccessMap() {
        return roleAccessMap;
    }
    
    public void setRoleAccessMap(Map<String, TRoleAccess> roleAccessMap) {
        this.roleAccessMap = roleAccessMap;
    }
    
    public Map<String, String> getLevelAccessMap() {
        return levelAccessMap;
    }
    
    public void setLevelAccessMap(Map<String, String> levelAccessMap) {
        this.levelAccessMap = levelAccessMap;
    }
    
    public String getModuleCodes() {
        return moduleCodes;
    }
    
    public void setModuleCodes(String moduleCodes) {
        this.moduleCodes = moduleCodes;
    }
    
    public String getUrlRegex() {
        return urlRegex;
    }
    
    public void setUrlRegex(String urlRegex) {
        this.urlRegex = urlRegex;
    }
    
}
