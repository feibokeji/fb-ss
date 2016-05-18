package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 登陆日志
 * @since 2015-6-18 下午3:59:37
 * @author Liu bo
 */
@TableMapper("t_login_log")
public class TLoginLog extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2019467146971494743L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 登录/注销/异常
     */
    private String ctype;
    
    /**
     * 登录/注销/异常时间
     */
    private Date dlogintime;
    
    /**
     * 登录/注销/异常ID
     */
    private String uuserid;
    
    /**
     * 登录/注销/异常名称
     */
    @NotFieldMapper
    private String cusername;
    
    /**
     * 登录/注销/异常IP地址
     */
    private String cloginip;
    
    /**
     * 登录/注销/异常地址URL
     */
    private String cloginurl;
    
    /**
     * 登录/注销/异常说明
     */
    private String cmemo;
    
    /**
     * MAC地址
     */
    private String cmac;
    
    /**
     * 获取 主键
     * @return uid
     */
    public String getUid() {
        return uid;
    }
    
    /**
     * 设置 主键
     * @param uid 主键
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
    
    /**
     * 获取 登录注销异常
     * @return ctype
     */
    public String getCtype() {
        return ctype;
    }
    
    /**
     * 设置 登录注销异常
     * @param ctype 登录注销异常
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
    
    /**
     * 获取 登录时间
     * @return dlogintime
     */
    public Date getDlogintime() {
        return dlogintime;
    }
    
    /**
     * 设置 登录时间
     * @param dlogintime 登录时间
     */
    public void setDlogintime(Date dlogintime) {
        this.dlogintime = dlogintime;
    }
    
    /**
     * 获取 登录ID
     * @return uuserid
     */
    public String getUuserid() {
        return uuserid;
    }
    
    /**
     * 设置 登录ID
     * @param uuserid 登录ID
     */
    public void setUuserid(String uuserid) {
        this.uuserid = uuserid;
    }
    
    /**
     * 获取 登录IP地址
     * @return cloginip
     */
    public String getCloginip() {
        return cloginip;
    }
    
    /**
     * 设置 登录IP地址
     * @param cloginip 登录IP地址
     */
    public void setCloginip(String cloginip) {
        this.cloginip = cloginip;
    }
    
    /**
     * 获取 登录地址URL
     * @return cloginurl
     */
    public String getCloginurl() {
        return cloginurl;
    }
    
    /**
     * 设置 登录地址URL
     * @param cloginurl 登录地址URL
     */
    public void setCloginurl(String cloginurl) {
        this.cloginurl = cloginurl;
    }
    
    /**
     * 获取 登录说明
     * @return cmemo
     */
    public String getCmemo() {
        return cmemo;
    }
    
    /**
     * 设置 登录说明
     * @param cmemo 登录说明
     */
    public void setCmemo(String cmemo) {
        this.cmemo = cmemo;
    }
    
    /**
     * 获取 MAC地址
     * @return cmac
     */
    public String getCmac() {
        return cmac;
    }
    
    /**
     * 设置 MAC地址
     * @param cmac MAC地址
     */
    public void setCmac(String cmac) {
        this.cmac = cmac;
    }
    
    /**
     * 获取 登录注销异常名称
     * @return cusername
     */
    public String getCusername() {
        return cusername;
    }
    
    /**
     * 设置 登录注销异常名称
     * @param cusername 登录注销异常名称
     */
    public void setCusername(String cusername) {
        this.cusername = cusername;
    }
    
}
