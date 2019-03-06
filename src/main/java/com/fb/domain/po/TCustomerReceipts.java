package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月1日 下午7:31:37
 * 客户商品实收实付表
 */
@TableMapper("t_customer_receipts")
public class TCustomerReceipts extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = 8260626853762798376L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 应收应付表外键
     */
    private String ureceivableid;
    
    /**
     * 单据编号
     */
    @NotFieldMapper
    private String corderno;
    
    /**
     * 收付款方式表外键
     */
    private String upaymentmethodid;
    
    /**
     * 收付款代码
     */
    @NotFieldMapper
    private String cpaymentmethodcode;
    
    /**
     * 收付款名称
     */
    @NotFieldMapper
    private String cpaymentmethodname;
    
    /**
     * 用户表外键
     */
    private String uuserid;
    
    /**
     * 用户名称
     */
    @NotFieldMapper
    private String cusername;
    
    /**
     * 部门表外键
     */
    private String udeptid;
    
    /**
     * 类型
     * {@value AR=实收/AP=实付}
     */
    private String ctype;
    
    /**
     * 类型
     * {@value 实收/实付}
     */
    @NotFieldMapper
    private String ctypeStr;
    
    /**
     * 金额
     */
    private Double namount;
    
    /**
     * 状态
     * {@value 0=未结算/1=已结算}
     */
    private Integer istatus;
    
    /**
     * 状态
     * {@value 未结算/已结算}
     */
    @NotFieldMapper
    private String istatusStr;
    
    /**
     * 记录日期
     */
    private Date drecorddate;
    
    /**
     * 记录日期
     */
    @NotFieldMapper
    private String drecorddateStr;
    
    /**
     * 记录日期最小值
     */
    @NotFieldMapper
    private String drecorddateStrMin;
    
    /**
     * 记录日期最大值
     */
    @NotFieldMapper
    private String drecorddateStrMax;
    
    /**
     * 更新日期
     */
    private Date dupdatedate;
    
    /**
     * 更新日期
     */
    @NotFieldMapper
    private String dupdatedateStr;

    
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
     * 获取 应收应付表外键
     * @return ureceivableid
     */
    public String getUreceivableid() {
        return ureceivableid;
    }
    

    
    /**
     * 设置 应收应付表外键
     * @param ureceivableid 应收应付表外键
     */
    public void setUreceivableid(String ureceivableid) {
        this.ureceivableid = ureceivableid;
    }
    

    
    /**
     * 获取 单据编号
     * @return corderno
     */
    public String getCorderno() {
        return corderno;
    }
    

    
    /**
     * 设置 单据编号
     * @param corderno 单据编号
     */
    public void setCorderno(String corderno) {
        this.corderno = corderno;
    }
    

    
    /**
     * 获取 收付款方式表外键
     * @return upaymentmethodid
     */
    public String getUpaymentmethodid() {
        return upaymentmethodid;
    }
    

    
    /**
     * 设置 收付款方式表外键
     * @param upaymentmethodid 收付款方式表外键
     */
    public void setUpaymentmethodid(String upaymentmethodid) {
        this.upaymentmethodid = upaymentmethodid;
    }
    

    
    /**
     * 获取 收付款代码
     * @return cpaymentmethodcode
     */
    public String getCpaymentmethodcode() {
        return cpaymentmethodcode;
    }
    

    
    /**
     * 设置 收付款代码
     * @param cpaymentmethodcode 收付款代码
     */
    public void setCpaymentmethodcode(String cpaymentmethodcode) {
        this.cpaymentmethodcode = cpaymentmethodcode;
    }
    

    
    /**
     * 获取 收付款名称
     * @return cpaymentmethodname
     */
    public String getCpaymentmethodname() {
        return cpaymentmethodname;
    }
    

    
    /**
     * 设置 收付款名称
     * @param cpaymentmethodname 收付款名称
     */
    public void setCpaymentmethodname(String cpaymentmethodname) {
        this.cpaymentmethodname = cpaymentmethodname;
    }
    

    
    /**
     * 获取 用户表外键
     * @return uuserid
     */
    public String getUuserid() {
        return uuserid;
    }
    

    
    /**
     * 设置 用户表外键
     * @param uuserid 用户表外键
     */
    public void setUuserid(String uuserid) {
        this.uuserid = uuserid;
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
     * 获取 部门表外键
     * @return udeptid
     */
    public String getUdeptid() {
        return udeptid;
    }
    

    
    /**
     * 设置 部门表外键
     * @param udeptid 部门表外键
     */
    public void setUdeptid(String udeptid) {
        this.udeptid = udeptid;
    }
    

    
    /**
     * 获取 类型      {@value AR=实收AP=实付}
     * @return ctype
     */
    public String getCtype() {
        return ctype;
    }
    

    
    /**
     * 设置 类型      {@value AR=实收AP=实付}
     * @param ctype 类型      {@value AR=实收AP=实付}
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
    

    
    /**
     * 获取 类型      {@value 实收实付}
     * @return ctypeStr
     */
    public String getCtypeStr() {
        return ctypeStr;
    }
    

    
    /**
     * 设置 类型      {@value 实收实付}
     * @param ctypeStr 类型      {@value 实收实付}
     */
    public void setCtypeStr(String ctypeStr) {
        this.ctypeStr = ctypeStr;
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
     * 获取 状态      {@value 0=未结算1=已结算}
     * @return istatus
     */
    public Integer getIstatus() {
        return istatus;
    }
    

    
    /**
     * 设置 状态      {@value 0=未结算1=已结算}
     * @param istatus 状态      {@value 0=未结算1=已结算}
     */
    public void setIstatus(Integer istatus) {
        this.istatus = istatus;
    }
    

    
    /**
     * 获取 状态      {@value 未结算已结算}
     * @return istatusStr
     */
    public String getIstatusStr() {
        return istatusStr;
    }
    

    
    /**
     * 设置 状态      {@value 未结算已结算}
     * @param istatusStr 状态      {@value 未结算已结算}
     */
    public void setIstatusStr(String istatusStr) {
        this.istatusStr = istatusStr;
    }
    

    
    /**
     * 获取 记录日期
     * @return drecorddate
     */
    public Date getDrecorddate() {
        return drecorddate;
    }
    

    
    /**
     * 设置 记录日期
     * @param drecorddate 记录日期
     */
    public void setDrecorddate(Date drecorddate) {
        this.drecorddate = drecorddate;
    }
    

    
    /**
     * 获取 记录日期
     * @return drecorddateStr
     */
    public String getDrecorddateStr() {
        return drecorddateStr;
    }
    

    
    /**
     * 设置 记录日期
     * @param drecorddateStr 记录日期
     */
    public void setDrecorddateStr(String drecorddateStr) {
        this.drecorddateStr = drecorddateStr;
    }
    

    
    /**
     * 获取 记录日期最小值
     * @return drecorddateStrMin
     */
    public String getDrecorddateStrMin() {
        return drecorddateStrMin;
    }
    

    
    /**
     * 设置 记录日期最小值
     * @param drecorddateStrMin 记录日期最小值
     */
    public void setDrecorddateStrMin(String drecorddateStrMin) {
        this.drecorddateStrMin = drecorddateStrMin;
    }
    

    
    /**
     * 获取 记录日期最大值
     * @return drecorddateStrMax
     */
    public String getDrecorddateStrMax() {
        return drecorddateStrMax;
    }
    

    
    /**
     * 设置 记录日期最大值
     * @param drecorddateStrMax 记录日期最大值
     */
    public void setDrecorddateStrMax(String drecorddateStrMax) {
        this.drecorddateStrMax = drecorddateStrMax;
    }
    

    
    /**
     * 获取 更新日期
     * @return dupdatedate
     */
    public Date getDupdatedate() {
        return dupdatedate;
    }
    

    
    /**
     * 设置 更新日期
     * @param dupdatedate 更新日期
     */
    public void setDupdatedate(Date dupdatedate) {
        this.dupdatedate = dupdatedate;
    }
    

    
    /**
     * 获取 更新日期
     * @return dupdatedateStr
     */
    public String getDupdatedateStr() {
        return dupdatedateStr;
    }
    

    
    /**
     * 设置 更新日期
     * @param dupdatedateStr 更新日期
     */
    public void setDupdatedateStr(String dupdatedateStr) {
        this.dupdatedateStr = dupdatedateStr;
    }
    
}