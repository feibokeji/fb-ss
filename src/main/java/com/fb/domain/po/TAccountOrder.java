package com.fb.domain.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 账务类单据
 * @since 2016年4月11日 下午4:01:12
 * @author Liu bo
 */
@TableMapper("t_account_order")
public class TAccountOrder extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6265638089412312517L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 单据代码
     */
    private String ccode;
    
    /**
     * 名称
     */
    private String cname;
    
    /**
     * 单据类别
     */
    private String ctype;
    
    /**
     * 单据类别的类型
     */
    private String uaccounttypeid;
    
    /**
     * 单据类别的类型名称
     */
    @NotFieldMapper
    private String caccounttypename;
    
    /**
     * 账户外键
     */
    private String uaccountid;
    
    /**
     * 账户名
     */
    @NotFieldMapper
    private String caccountname;
    
    /**
     * 公司主键
     */
    private String ucorpid;
    
    /**
     * 部门主键
     */
    private String udeptid;
    
    /**
     * 用户主键
     */
    private String uuserid;
    
    /**
     * 用户名称
     */
    @NotFieldMapper
    private String cusername;
    
    /**
     * 备注
     */
    private String cmemo;
    
    /**
     * 创建时间
     */
    private Date dcreatetime;
    
    /**
     * 创建时间的字符串
     */
    @NotFieldMapper
    private String ccreatetime;
    
    /**
     * 更新时间
     */
    private Date dupdatetime;
    
    /**
     * 审核标志 0-未审核 1-已审核
     */
    private Integer iaudit;
    
    /**
     * 审核时间
     */
    private Date daudittime;
    
    /**
     * 开始时间
     */
    @NotFieldMapper
    private String beganTime;
    
    /**
     * 结束时间
     */
    @NotFieldMapper
    private String endTime;
    
    /**
     * 金额
     */
    @NotFieldMapper
    private Double namount;
    
    /**
     * 单据明细列表
     */
    @NotFieldMapper
    private List<TAccountOrderDetail> accountOrderDetailList = new ArrayList<TAccountOrderDetail>();
    
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
     * 获取 单据代码
     * @return ccode
     */
    public String getCcode() {
        return ccode;
    }
    
    /**
     * 设置 单据代码
     * @param ccode 单据代码
     */
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    
    /**
     * 获取 单据类别
     * @return ctype
     */
    public String getCtype() {
        return ctype;
    }
    
    /**
     * 设置 单据类别
     * @param ctype 单据类别
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
    
    /**
     * 获取 单据类别的类型
     * @return uaccounttypeid
     */
    public String getUaccounttypeid() {
        return uaccounttypeid;
    }
    
    /**
     * 设置 单据类别的类型
     * @param uaccounttypeid 单据类别的类型
     */
    public void setUaccounttypeid(String uaccounttypeid) {
        this.uaccounttypeid = uaccounttypeid;
    }
    
    /**
     * 获取 公司主键
     * @return ucorpid
     */
    public String getUcorpid() {
        return ucorpid;
    }
    
    /**
     * 设置 公司主键
     * @param ucorpid 公司主键
     */
    public void setUcorpid(String ucorpid) {
        this.ucorpid = ucorpid;
    }
    
    /**
     * 获取 部门主键
     * @return udeptid
     */
    public String getUdeptid() {
        return udeptid;
    }
    
    /**
     * 设置 部门主键
     * @param udeptid 部门主键
     */
    public void setUdeptid(String udeptid) {
        this.udeptid = udeptid;
    }
    
    /**
     * 获取 用户主键
     * @return uuserid
     */
    public String getUuserid() {
        return uuserid;
    }
    
    /**
     * 设置 用户主键
     * @param uuserid 用户主键
     */
    public void setUuserid(String uuserid) {
        this.uuserid = uuserid;
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
    
    /**
     * 获取 创建时间
     * @return dcreatetime
     */
    public Date getDcreatetime() {
        return dcreatetime;
    }
    
    /**
     * 设置 创建时间
     * @param dcreatetime 创建时间
     */
    public void setDcreatetime(Date dcreatetime) {
        this.dcreatetime = dcreatetime;
    }
    
    /**
     * 获取 更新时间
     * @return dupdatetime
     */
    public Date getDupdatetime() {
        return dupdatetime;
    }
    
    /**
     * 设置 更新时间
     * @param dupdatetime 更新时间
     */
    public void setDupdatetime(Date dupdatetime) {
        this.dupdatetime = dupdatetime;
    }
    
    /**
     * 获取 审核标志 0-未审核 1-已审核
     * @return iaudit
     */
    public Integer getIaudit() {
        return iaudit;
    }
    
    /**
     * 设置 审核标志 0-未审核 1-已审核
     * @param iaudit 审核标志 0-未审核 1-已审核
     */
    public void setIaudit(Integer iaudit) {
        this.iaudit = iaudit;
    }
    
    /**
     * 获取 审核时间
     * @return daudittime
     */
    public Date getDaudittime() {
        return daudittime;
    }
    
    /**
     * 设置 审核时间
     * @param daudittime 审核时间
     */
    public void setDaudittime(Date daudittime) {
        this.daudittime = daudittime;
    }
    
    /**
     * 获取 开始时间
     * @return beganTime
     */
    public String getBeganTime() {
        return beganTime;
    }
    
    /**
     * 设置 开始时间
     * @param beganTime 开始时间
     */
    public void setBeganTime(String beganTime) {
        this.beganTime = beganTime;
    }
    
    /**
     * 获取 结束时间
     * @return endTime
     */
    public String getEndTime() {
        return endTime;
    }
    
    /**
     * 设置 结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    /**
     * 获取 单据明细列表
     * @return accountOrderDetailList
     */
    public List<TAccountOrderDetail> getAccountOrderDetailList() {
        return accountOrderDetailList;
    }
    
    /**
     * 设置 单据明细列表
     * @param accountOrderDetailList 单据明细列表
     */
    public void setAccountOrderDetailList(List<TAccountOrderDetail> accountOrderDetailList) {
        this.accountOrderDetailList = accountOrderDetailList;
    }
    
    /**
     * 获取 单据类别的类型名称
     * @return caccounttypename
     */
    public String getCaccounttypename() {
        return caccounttypename;
    }
    
    /**
     * 设置 单据类别的类型名称
     * @param caccounttypename 单据类别的类型名称
     */
    public void setCaccounttypename(String caccounttypename) {
        this.caccounttypename = caccounttypename;
    }
    
    /**
     * 获取 用户名称
     * @return cusername
     */
    public String getCusername() {
        return cusername;
    }
    
    /**
     * 设置 用户名称
     * @param cusername 用户名称
     */
    public void setCusername(String cusername) {
        this.cusername = cusername;
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
    
    public String getCcreatetime() {
        return ccreatetime;
    }
    
    public void setCcreatetime(String ccreatetime) {
        this.ccreatetime = ccreatetime;
    }
    
    /**
     * 获取 金额
     * @return namount
     */
    public Double getNamount() {
        return namount;
    }
    
    /**
     * 设置 金额
     * @param namount 金额
     */
    public void setNamount(Double namount) {
        this.namount = namount;
    }
    
    /**
     * 获取 账户外键
     * @return uaccountid
     */
    public String getUaccountid() {
        return uaccountid;
    }
    
    /**
     * 设置 账户外键
     * @param uaccountid 账户外键
     */
    public void setUaccountid(String uaccountid) {
        this.uaccountid = uaccountid;
    }
    
    /**
     * 获取 账户名
     * @return caccountname
     */
    public String getCaccountname() {
        return caccountname;
    }
    
    /**
     * 设置 账户名
     * @param caccountname 账户名
     */
    public void setCaccountname(String caccountname) {
        this.caccountname = caccountname;
    }
    
}
