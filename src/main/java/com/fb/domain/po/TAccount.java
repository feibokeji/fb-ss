package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 账户表
 * @since 2016年5月17日 下午1:21:44
 * @author Liu bo
 */
@TableMapper("t_account")
public class TAccount extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7360569120807358829L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 用户外键
     */
    private String uuserid;
    
    /**
     * 用户名
     */
    private String cusername;
    
    /**
     * 部门外键
     */
    private String udeptid;
    
    /**
     * 部门名
     */
    private String cdeptname;
    
    /**
     * 公司外键
     */
    private String ucorpid;
    
    /**
     * 公司名
     */
    private String ccorpname;
    
    /**
     * 编号
     */
    private String cno;
    
    /**
     * 名称
     */
    private String cname;
    
    /**
     * 备用金
     */
    private String namount;
    
    /**
     * 总收入金额
     */
    @NotFieldMapper
    private Double ntotalamount;
    
    /**
     * 总支出金额
     */
    @NotFieldMapper
    private Double ntotalspendamount;
    
    /**
     * 剩余金额
     */
    @NotFieldMapper
    private Double nresidueamount;
    
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
     * 获取 用户外键
     * @return uuserid
     */
    public String getUuserid() {
        return uuserid;
    }
    
    /**
     * 设置 用户外键
     * @param uuserid 用户外键
     */
    public void setUuserid(String uuserid) {
        this.uuserid = uuserid;
    }
    
    /**
     * 获取 用户名
     * @return cusername
     */
    public String getCusername() {
        return cusername;
    }
    
    /**
     * 设置 用户名
     * @param cusername 用户名
     */
    public void setCusername(String cusername) {
        this.cusername = cusername;
    }
    
    /**
     * 获取 部门外键
     * @return udeptid
     */
    public String getUdeptid() {
        return udeptid;
    }
    
    /**
     * 设置 部门外键
     * @param udeptid 部门外键
     */
    public void setUdeptid(String udeptid) {
        this.udeptid = udeptid;
    }
    
    /**
     * 获取 部门名
     * @return cdeptname
     */
    public String getCdeptname() {
        return cdeptname;
    }
    
    /**
     * 设置 部门名
     * @param cdeptname 部门名
     */
    public void setCdeptname(String cdeptname) {
        this.cdeptname = cdeptname;
    }
    
    /**
     * 获取 公司外键
     * @return ucorpid
     */
    public String getUcorpid() {
        return ucorpid;
    }
    
    /**
     * 设置 公司外键
     * @param ucorpid 公司外键
     */
    public void setUcorpid(String ucorpid) {
        this.ucorpid = ucorpid;
    }
    
    /**
     * 获取 公司名
     * @return ccorpname
     */
    public String getCcorpname() {
        return ccorpname;
    }
    
    /**
     * 设置 公司名
     * @param ccorpname 公司名
     */
    public void setCcorpname(String ccorpname) {
        this.ccorpname = ccorpname;
    }
    
    /**
     * 获取 编号
     * @return cno
     */
    public String getCno() {
        return cno;
    }
    
    /**
     * 设置 编号
     * @param cno 编号
     */
    public void setCno(String cno) {
        this.cno = cno;
    }
    
    /**
     * 获取 名称
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 名称
     * @param cname 名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    /**
     * 获取 总收入金额
     * @return ntotalamount
     */
    public Double getNtotalamount() {
        return ntotalamount;
    }
    
    /**
     * 设置 总收入金额
     * @param ntotalamount 总收入金额
     */
    public void setNtotalamount(Double ntotalamount) {
        this.ntotalamount = ntotalamount;
    }
    
    /**
     * 获取 总支出金额
     * @return ntotalspendamount
     */
    public Double getNtotalspendamount() {
        return ntotalspendamount;
    }
    
    /**
     * 设置 总支出金额
     * @param ntotalspendamount 总支出金额
     */
    public void setNtotalspendamount(Double ntotalspendamount) {
        this.ntotalspendamount = ntotalspendamount;
    }
    
    /**
     * 获取 剩余金额
     * @return nresidueamount
     */
    public Double getNresidueamount() {
        double total1 = this.ntotalamount == null ? 0.0 : this.ntotalamount;
        double total2 = this.ntotalspendamount == null ? 0.0 : this.ntotalspendamount;
        return total1 - total2;
    }
    
    /**
     * 设置 剩余金额
     * @param nresidueamount 剩余金额
     */
    public void setNresidueamount(Double nresidueamount) {
        this.nresidueamount = nresidueamount;
    }
    
    /**
     * 获取 备用金
     * @return namount
     */
    public String getNamount() {
        return namount;
    }
    
    /**
     * 设置 备用金
     * @param namount 备用金
     */
    public void setNamount(String namount) {
        this.namount = namount;
    }
    
}
