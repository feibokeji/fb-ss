package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 用户信息表
 * @since 2015-6-9 下午7:40:14
 * @author Liu bo
 */
@TableMapper("t_user")
public class TUser extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3399184985615880782L;
    
    /**
     * 唯一ID
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 所属部门ID
     */
    private String udeptid;
    
    /**
     * 用户代码
     */
    private String ccode;
    
    /**
     * 用户名称
     */
    private String cname;
    
    /**
     * 用户英文名称
     */
    private String cnameen;
    
    /**
     * 用户密码
     */
    private String cpassword;
    
    /**
     * 用户职务
     */
    private String cduty;
    
    /**
     * 用户级别
     */
    private String crank;
    
    /**
     * 入职日期
     */
    private Date djoindate;
    
    /**
     * 身份证号
     */
    private String cidcard;
    
    /**
     * 性别
     */
    private String csex;
    
    /**
     * 出生日期
     */
    private Date dbirthday;
    
    /**
     * 文化程度
     */
    private String ceducate;
    
    /**
     * 工作电话
     */
    private String cofficetel;
    
    /**
     * 工作传真
     */
    private String cofficefax;
    
    /**
     * 工作地址
     */
    private String cofficeaddr;
    
    /**
     * 移动电话
     */
    private String cmobiletel;
    
    /**
     * 住宅电话
     */
    private String chometel;
    
    /**
     * 住宅地址
     */
    private String chomeaddr;
    
    /**
     * 电子邮件地址
     */
    private String cemail;
    
    /**
     * MSN地址
     */
    private String cmsn;
    
    /**
     * QQ号码
     */
    private String cqq;
    
    /**
     * 备注
     */
    private String cmemo;
    
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
     * 获取 所属部门ID
     * @return udeptid
     */
    public String getUdeptid() {
        return udeptid;
    }
    
    /**
     * 设置 所属部门ID
     * @param udeptid 所属部门ID
     */
    public void setUdeptid(String udeptid) {
        this.udeptid = udeptid;
    }
    
    /**
     * 获取 用户代码
     * @return ccode
     */
    public String getCcode() {
        return ccode;
    }
    
    /**
     * 设置 用户代码
     * @param ccode 用户代码
     */
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    
    /**
     * 获取 用户名称
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 用户名称
     * @param cname 用户名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    /**
     * 获取 用户英文名称
     * @return cnameen
     */
    public String getCnameen() {
        return cnameen;
    }
    
    /**
     * 设置 用户英文名称
     * @param cnameen 用户英文名称
     */
    public void setCnameen(String cnameen) {
        this.cnameen = cnameen;
    }
    
    /**
     * 获取 用户密码
     * @return cpassword
     */
    public String getCpassword() {
        return cpassword;
    }
    
    /**
     * 设置 用户密码
     * @param cpassword 用户密码
     */
    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
    
    /**
     * 获取 用户职务
     * @return cduty
     */
    public String getCduty() {
        return cduty;
    }
    
    /**
     * 设置 用户职务
     * @param cduty 用户职务
     */
    public void setCduty(String cduty) {
        this.cduty = cduty;
    }
    
    /**
     * 获取 用户级别
     * @return crank
     */
    public String getCrank() {
        return crank;
    }
    
    /**
     * 设置 用户级别
     * @param crank 用户级别
     */
    public void setCrank(String crank) {
        this.crank = crank;
    }
    
    /**
     * 获取 入职日期
     * @return djoindate
     */
    public Date getDjoindate() {
        return djoindate;
    }
    
    /**
     * 设置 入职日期
     * @param djoindate 入职日期
     */
    public void setDjoindate(Date djoindate) {
        this.djoindate = djoindate;
    }
    
    /**
     * 获取 身份证号
     * @return cidcard
     */
    public String getCidcard() {
        return cidcard;
    }
    
    /**
     * 设置 身份证号
     * @param cidcard 身份证号
     */
    public void setCidcard(String cidcard) {
        this.cidcard = cidcard;
    }
    
    /**
     * 获取 性别
     * @return csex
     */
    public String getCsex() {
        return csex;
    }
    
    /**
     * 设置 性别
     * @param csex 性别
     */
    public void setCsex(String csex) {
        this.csex = csex;
    }
    
    /**
     * 获取 出生日期
     * @return dbirthday
     */
    public Date getDbirthday() {
        return dbirthday;
    }
    
    /**
     * 设置 出生日期
     * @param dbirthday 出生日期
     */
    public void setDbirthday(Date dbirthday) {
        this.dbirthday = dbirthday;
    }
    
    /**
     * 获取 文化程度
     * @return ceducate
     */
    public String getCeducate() {
        return ceducate;
    }
    
    /**
     * 设置 文化程度
     * @param ceducate 文化程度
     */
    public void setCeducate(String ceducate) {
        this.ceducate = ceducate;
    }
    
    /**
     * 获取 工作电话
     * @return cofficetel
     */
    public String getCofficetel() {
        return cofficetel;
    }
    
    /**
     * 设置 工作电话
     * @param cofficetel 工作电话
     */
    public void setCofficetel(String cofficetel) {
        this.cofficetel = cofficetel;
    }
    
    /**
     * 获取 工作传真
     * @return cofficefax
     */
    public String getCofficefax() {
        return cofficefax;
    }
    
    /**
     * 设置 工作传真
     * @param cofficefax 工作传真
     */
    public void setCofficefax(String cofficefax) {
        this.cofficefax = cofficefax;
    }
    
    /**
     * 获取 工作地址
     * @return cofficeaddr
     */
    public String getCofficeaddr() {
        return cofficeaddr;
    }
    
    /**
     * 设置 工作地址
     * @param cofficeaddr 工作地址
     */
    public void setCofficeaddr(String cofficeaddr) {
        this.cofficeaddr = cofficeaddr;
    }
    
    /**
     * 获取 移动电话
     * @return cmobiletel
     */
    public String getCmobiletel() {
        return cmobiletel;
    }
    
    /**
     * 设置 移动电话
     * @param cmobiletel 移动电话
     */
    public void setCmobiletel(String cmobiletel) {
        this.cmobiletel = cmobiletel;
    }
    
    /**
     * 获取 住宅电话
     * @return chometel
     */
    public String getChometel() {
        return chometel;
    }
    
    /**
     * 设置 住宅电话
     * @param chometel 住宅电话
     */
    public void setChometel(String chometel) {
        this.chometel = chometel;
    }
    
    /**
     * 获取 住宅地址
     * @return chomeaddr
     */
    public String getChomeaddr() {
        return chomeaddr;
    }
    
    /**
     * 设置 住宅地址
     * @param chomeaddr 住宅地址
     */
    public void setChomeaddr(String chomeaddr) {
        this.chomeaddr = chomeaddr;
    }
    
    /**
     * 获取 电子邮件地址
     * @return cemail
     */
    public String getCemail() {
        return cemail;
    }
    
    /**
     * 设置 电子邮件地址
     * @param cemail 电子邮件地址
     */
    public void setCemail(String cemail) {
        this.cemail = cemail;
    }
    
    /**
     * 获取 MSN地址
     * @return cmsn
     */
    public String getCmsn() {
        return cmsn;
    }
    
    /**
     * 设置 MSN地址
     * @param cmsn MSN地址
     */
    public void setCmsn(String cmsn) {
        this.cmsn = cmsn;
    }
    
    /**
     * 获取 QQ号码
     * @return cqq
     */
    public String getCqq() {
        return cqq;
    }
    
    /**
     * 设置 QQ号码
     * @param cqq QQ号码
     */
    public void setCqq(String cqq) {
        this.cqq = cqq;
    }
    
    /**
     * 获取 备注
     * @return cmemo
     */
    public String getCmemo() {
        return cmemo;
    }
    
    /**
     * 设置 备注
     * @param cmemo 备注
     */
    public void setCmemo(String cmemo) {
        this.cmemo = cmemo;
    }
    
}
