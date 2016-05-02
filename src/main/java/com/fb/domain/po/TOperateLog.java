package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 操作日志表
 * @since 2015-6-18 下午5:37:03
 * @author Liu bo
 */
@TableMapper("t_operate_log")
public class TOperateLog extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5614640005069830992L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 操作类型
     */
    private String ctype;
    
    /**
     * 操作时间
     */
    private Date doperatetime;
    
    /**
     * 操作人ID
     */
    private String uuserid;
    
    /**
     * 操作IP地址
     */
    private String coperateip;
    
    /**
     * 操作地址URL
     */
    private String coperateurl;
    
    /**
     * 关联表名
     */
    private String clinktable;
    
    /**
     * 关联表主键
     */
    private String ulinktableid;
    
    /**
     * 当前状态
     */
    private String cstatus;
    
    /**
     * 操作选项
     */
    private String cchoice;
    
    /**
     * 取消标志
     */
    private String ccancel;
    
    /**
     * 操作说明
     */
    private String cmemo;
    
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
     * 获取 操作类型
     * @return ctype
     */
    public String getCtype() {
        return ctype;
    }
    
    /**
     * 设置 操作类型
     * @param ctype 操作类型
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
    
    /**
     * 获取 操作时间
     * @return doperatetime
     */
    public Date getDoperatetime() {
        return doperatetime;
    }
    
    /**
     * 设置 操作时间
     * @param doperatetime 操作时间
     */
    public void setDoperatetime(Date doperatetime) {
        this.doperatetime = doperatetime;
    }
    
    /**
     * 获取 操作人ID
     * @return uuserid
     */
    public String getUuserid() {
        return uuserid;
    }
    
    /**
     * 设置 操作人ID
     * @param uuserid 操作人ID
     */
    public void setUuserid(String uuserid) {
        this.uuserid = uuserid;
    }
    
    /**
     * 获取 操作地址URL
     * @return coperateurl
     */
    public String getCoperateurl() {
        return coperateurl;
    }
    
    /**
     * 设置 操作地址URL
     * @param coperateurl 操作地址URL
     */
    public void setCoperateurl(String coperateurl) {
        this.coperateurl = coperateurl;
    }
    
    /**
     * 获取 关联表名
     * @return clinktable
     */
    public String getClinktable() {
        return clinktable;
    }
    
    /**
     * 设置 关联表名
     * @param clinktable 关联表名
     */
    public void setClinktable(String clinktable) {
        this.clinktable = clinktable;
    }
    
    /**
     * 获取 关联表主键
     * @return ulinktableid
     */
    public String getUlinktableid() {
        return ulinktableid;
    }
    
    /**
     * 设置 关联表主键
     * @param ulinktableid 关联表主键
     */
    public void setUlinktableid(String ulinktableid) {
        this.ulinktableid = ulinktableid;
    }
    
    /**
     * 获取 当前状态
     * @return cstatus
     */
    public String getCstatus() {
        return cstatus;
    }
    
    /**
     * 设置 当前状态
     * @param cstatus 当前状态
     */
    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }
    
    /**
     * 获取 操作选项
     * @return cchoice
     */
    public String getCchoice() {
        return cchoice;
    }
    
    /**
     * 设置 操作选项
     * @param cchoice 操作选项
     */
    public void setCchoice(String cchoice) {
        this.cchoice = cchoice;
    }
    
    /**
     * 获取 取消标志
     * @return ccancel
     */
    public String getCcancel() {
        return ccancel;
    }
    
    /**
     * 设置 取消标志
     * @param ccancel 取消标志
     */
    public void setCcancel(String ccancel) {
        this.ccancel = ccancel;
    }
    
    /**
     * 获取 操作说明
     * @return cmemo
     */
    public String getCmemo() {
        return cmemo;
    }
    
    /**
     * 设置 操作说明
     * @param cmemo 操作说明
     */
    public void setCmemo(String cmemo) {
        this.cmemo = cmemo;
    }
    
    /**
     * 获取 操作IP地址
     * @return coperateip
     */
    public String getCoperateip() {
        return coperateip;
    }
    
    /**
     * 设置 操作IP地址
     * @param coperateip 操作IP地址
     */
    public void setCoperateip(String coperateip) {
        this.coperateip = coperateip;
    }
    
}
