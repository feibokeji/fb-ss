package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 部门信息表
 * @since 2015-6-10 下午6:42:43
 * @author Liu bo
 */
@TableMapper("t_dept")
public class TDept extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8709396029677278893L;
    
    /**
     * 唯一ID
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 所属企业ID
     */
    private String ucorpid;
    
    /**
     * 部门类型
     */
    private String ctype;
    
    /**
     * 部门代码
     */
    private String ccode;
    
    /**
     * 部门名称
     */
    private String cname;
    
    /**
     * 上级部门代码
     */
    private String cparentcode;
    
    /**
     * 部门级别 <li>第一级为1,逐级递增1
     */
    private Integer ilevel;
    
    /**
     * 部门代码路径 <li>用"|"间隔不同层次
     */
    private String ccodepath;
    
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
     * 获取 所属企业ID
     * @return ucorpid
     */
    public String getUcorpid() {
        return ucorpid;
    }
    
    /**
     * 设置 所属企业ID
     * @param ucorpid 所属企业ID
     */
    public void setUcorpid(String ucorpid) {
        this.ucorpid = ucorpid;
    }
    
    /**
     * 获取 部门类型
     * @return ctype
     */
    public String getCtype() {
        return ctype;
    }
    
    /**
     * 设置 部门类型
     * @param ctype 部门类型
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
    
    /**
     * 获取 部门代码
     * @return ccode
     */
    public String getCcode() {
        return ccode;
    }
    
    /**
     * 设置 部门代码
     * @param ccode 部门代码
     */
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    
    /**
     * 获取 部门名称
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 部门名称
     * @param cname 部门名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    /**
     * 获取 上级部门代码
     * @return cparentcode
     */
    public String getCparentcode() {
        return cparentcode;
    }
    
    /**
     * 设置 上级部门代码
     * @param cparentcode 上级部门代码
     */
    public void setCparentcode(String cparentcode) {
        this.cparentcode = cparentcode;
    }
    
    /**
     * 获取 部门级别 <li>第一级为1逐级递增1
     * @return ilevel
     */
    public Integer getIlevel() {
        return ilevel;
    }
    
    /**
     * 设置 部门级别 <li>第一级为1逐级递增1
     * @param ilevel 部门级别 <li>第一级为1逐级递增1
     */
    public void setIlevel(Integer ilevel) {
        this.ilevel = ilevel;
    }
    
    /**
     * 获取 部门代码路径 <li>用"|"间隔不同层次
     * @return ccodepath
     */
    public String getCcodepath() {
        return ccodepath;
    }
    
    /**
     * 设置 部门代码路径 <li>用"|"间隔不同层次
     * @param ccodepath 部门代码路径 <li>用"|"间隔不同层次
     */
    public void setCcodepath(String ccodepath) {
        this.ccodepath = ccodepath;
    }
    
}
