package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 功能模块信息表
 * @since 2015-6-9 下午7:19:54
 * @author Liu bo
 */
@TableMapper("t_module")
public class TModule extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = 4343202022538891105L;
    
    @PrimaryKeyMapper
    private String uid;
    
    private String ctype;
    
    private String ccode;
    
    private String cname;
    
    private String cparent;
    
    private Integer ilevel;
    
    private Integer isort;
    
    private String ccodepath;
    
    private String caddr;
    
    @NotFieldMapper
    private String umodulegroupid;
    
    @NotFieldMapper
    private Integer haveGroup;
    
    public String getUid() {
        return uid;
    }
    
    public void setUid(String uid) {
        this.uid = uid;
    }
    
    public String getCtype() {
        return ctype;
    }
    
    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
    
    public String getCcode() {
        return ccode;
    }
    
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    
    public String getCname() {
        return cname;
    }
    
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    public String getCparent() {
        return cparent;
    }
    
    public void setCparent(String cparent) {
        this.cparent = cparent;
    }
    
    public Integer getIlevel() {
        return ilevel;
    }
    
    public void setIlevel(Integer ilevel) {
        this.ilevel = ilevel;
    }
    
    public Integer getIsort() {
        return isort;
    }
    
    public void setIsort(Integer isort) {
        this.isort = isort;
    }
    
    public String getCcodepath() {
        return ccodepath;
    }
    
    public void setCcodepath(String ccodepath) {
        this.ccodepath = ccodepath;
    }
    
    public String getCaddr() {
        return caddr;
    }
    
    public void setCaddr(String caddr) {
        this.caddr = caddr;
    }
    
    public String getUmodulegroupid() {
        return umodulegroupid;
    }
    
    public void setUmodulegroupid(String umodulegroupid) {
        this.umodulegroupid = umodulegroupid;
    }
    
    public Integer getHaveGroup() {
        return haveGroup;
    }
    
    public void setHaveGroup(Integer haveGroup) {
        this.haveGroup = haveGroup;
    }
    
}
