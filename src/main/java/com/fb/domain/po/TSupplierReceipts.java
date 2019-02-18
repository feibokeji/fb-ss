package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月1日 下午6:18:16
 * 供应商实收实付表类
 */
@TableMapper("t_supplier_receipts")
public class TSupplierReceipts extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = -6082960998450661936L;
    
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
     * 供应商表外键
     */
    @NotFieldMapper
    private String usupplierid;
    
    /**
     * 供应商名称
     */
    @NotFieldMapper
    private String csuppliername;
    
    /**
     * 供应商单据编号
     */
    @NotFieldMapper
    private String corderno;
    
    /**
     * 收付款方式表外键
     */
    private String upaymentmethodid;
    
    /**
     * 收付款方式名称
     */
    @NotFieldMapper
    private String cpaymentmethodname;
    
    /**
     * 收付款方式代码
     */
    @NotFieldMapper
    private String cpaymentmethodcode;
    
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
     * 部门名称
     */
    private String cdeptname;
    
    /**
     * 类型
     * {@value AR=实收}
     * {@value AP=实付}
     */
    private String ctype;
    
    /**
     * 类型字符串
     * {@value 实收}
     * {@value 实付}
     */
    @NotFieldMapper
    private String ctypeStr;
    
    /**
     * 金额
     */
    private Double namount;
    
    /**
     * 状态
     * {@value 0=未结算}
     * {@value 1=已结算}
     */
    private Integer istatus;
    
    /**
     * 状态字符串
     * {@value 未结算}
     * {@value 已结算}
     */
    @NotFieldMapper
    private String istatusStr;
    
    /**
     * 记录日期
     */
    private Date drecorddate;
    
    /**
     * 记录日期字符串
     */
    @NotFieldMapper
    private String drecorddateStr;
    
    /**
     * 记录日期字符串最小值
     */
    @NotFieldMapper
    private String drecorddateStrMin;
    
    /**
     * 记录日期字符串最大值
     */
    @NotFieldMapper
    private String drecorddateStrMax;
    
    /**
     * 更新日期
     */
    private Date dupdatedate;
    
    /**
     * 更新日期字符串
     */
    private String dupdatedateStr;

    /**
     * 获取：主键
     * @return 主键
     * @author Liu bo
     */
    public String getUid() {
        return uid;
    }
    
    /**
     * 设置：主键
     * @param uid 主键
     * @author Liu bo
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
    
    /**
     * 获取：应付应收表外键
     * @return 应付应收表外键
     * @author Liu bo
     */
    public String getUreceivableid() {
        return ureceivableid;
    }
    
    /**
     * 设置：应付应收表外键
     * @param ureceivableid 应付应收表外键
     * @author Liu bo
     */
    public void setUreceivableid(String ureceivableid) {
        this.ureceivableid = ureceivableid;
    }
    
    /**
     * 获取：供应商名称
     * @return 供应商名称
     * @author Liu bo
     */
    public String getCsuppliername() {
        return csuppliername;
    }
    
    /**
     * 设置：供应商名称
     * @param csuppliername 供应商名称
     * @author Liu bo
     */
    public void setCsuppliername(String csuppliername) {
        this.csuppliername = csuppliername;
    }
    
    /**
     * 获取：供应商单据编号
     * @return 供应商单据编号
     * @author Liu bo
     */
    public String getCorderno() {
        return corderno;
    }
    
    /**
     * 设置：供应商单据编号
     * @param corderno 供应商单据编号
     * @author Liu bo
     */
    public void setCorderno(String corderno) {
        this.corderno = corderno;
    }
    
    /**
     * 获取：收付款方式表外键
     * @return 收付款方式表外键
     * @author Liu bo
     */
    public String getUpaymentmethodid() {
        return upaymentmethodid;
    }
    
    /**
     * 设置：收付款方式表外键
     * @param upaymentmethodid 收付款方式表外键
     * @author Liu bo
     */
    public void setUpaymentmethodid(String upaymentmethodid) {
        this.upaymentmethodid = upaymentmethodid;
    }
    
    /**
     * 获取：收付款方式名称
     * @return 收付款方式名称
     * @author Liu bo
     */
    public String getCpaymentmethodname() {
        return cpaymentmethodname;
    }
    
    /**
     * 设置：收付款方式名称
     * @param cpaymentmethodname
     * @author Liu bo
     */
    public void setCpaymentmethodname(String cpaymentmethodname) {
        this.cpaymentmethodname = cpaymentmethodname;
    }
    
    /**
     * 获取：收付款方式代码
     * @return 收付款方式代码
     * @author Liu bo
     */
    public String getCpaymentmethodcode() {
        return cpaymentmethodcode;
    }
    
    /**
     * 设置：收付款方式代码
     * @param cpaymentmethodcode 收付款方式代码
     * @author Liu bo
     */
    public void setCpaymentmethodcode(String cpaymentmethodcode) {
        this.cpaymentmethodcode = cpaymentmethodcode;
    }
    
    /**
     * 获取：用户表外键
     * @return 用户表外键
     * @author Liu bo
     */
    public String getUuserid() {
        return uuserid;
    }
    
    /**
     * 设置：用户表外键
     * @param uuserid
     * @author Liu bo
     */
    public void setUuserid(String uuserid) {
        this.uuserid = uuserid;
    }
    
    /**
     * 获取：用户名称
     * @return 用户名称
     * @author Liu bo
     */
    public String getCusername() {
        return cusername;
    }
    
    /**
     * 设置：用户名称
     * @param cusername
     * @author Liu bo
     */
    public void setCusername(String cusername) {
        this.cusername = cusername;
    }
    
    /**
     * 获取：部门表外键
     * @return
     * @author Liu bo
     */
    public String getUdeptid() {
        return udeptid;
    }
    
    /**
     * 设置：部门表外键
     * @param udeptid
     * @author Liu bo
     */
    public void setUdeptid(String udeptid) {
        this.udeptid = udeptid;
    }
    
    /**
     * 获取：部门名称
     * @return
     * @author Liu bo
     */
    public String getCdeptname() {
        return cdeptname;
    }
    
    /**
     * 设置：部门名称
     * @param cdeptname
     * @author Liu bo
     */
    public void setCdeptname(String cdeptname) {
        this.cdeptname = cdeptname;
    }
    
    /**
     * 获取：类型
     * @return {@value AR=实收}{@value AP=实付}
     * @author Liu bo
     */
    public String getCtype() {
        return ctype;
    }
    
    /**
     * 设置：类型
     * @param ctype {@value AR=实收}{@value AP=实付}
     * @author Liu bo
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
        if(ctype.equals("AR"))
            this.ctypeStr = "实收";
        else if(ctype.equals("AP"))
            this.ctypeStr = "实付";
    }
    
    /**
     * 获取：类型字符串
     * @return {@value 实收}{@value 实付}
     * @author Liu bo
     */
    public String getCtypeStr() {
        return ctypeStr;
    }
    
    /**
     * 设置：类型字符串
     * @param ctypeStr {@value 实收}{@value 实付}
     * @author Liu bo
     */
    public void setCtypeStr(String ctypeStr) {
        this.ctypeStr = ctypeStr;
    }
    
    /**
     * 获取：金额
     * @return
     * @author Liu bo
     */
    public Double getNamount() {
        return namount;
    }
    
    /**
     * 设置：金额
     * @param namount
     * @author Liu bo
     */
    public void setNamount(Double namount) {
        this.namount = namount;
    }
    
    /**
     * 获取：状态
     * @return {@value 0=未结算}{@value 1=已结算}
     * @author Liu bo
     */
    public Integer getIstatus() {
        return istatus;
    }
    
    /**
     * 设置：状态
     * @param istatus {@value 0=未结算}{@value 1=已结算}
     * @author Liu bo
     */
    public void setIstatus(Integer istatus) {
        this.istatus = istatus;
        switch(istatus){
            case 0:
                this.istatusStr = "未结算";
                break;
            case 1:
                this.istatusStr = "已结算";
                break;
            default:
                this.istatusStr = "未结算";
                break;
        }
    }
    
    /**
     * 获取：状态字符串
     * @return {@value 未结算} {@value 已结算}
     * @author Liu bo
     */
    public String getIstatusStr() {
        return istatusStr;
    }
    
    /**
     * 设置：状态字符串
     * @param istatusStr {@value 未结算} {@value 已结算}
     * @author Liu bo
     */
    public void setIstatusStr(String istatusStr) {
        this.istatusStr = istatusStr;
    }
    
    /**
     * 获取：记录日期
     * @return
     * @author Liu bo
     */
    public Date getDrecorddate() {
        return drecorddate;
    }
    
    /**
     * 设置：记录日期
     * @param drecorddate
     * @author Liu bo
     */
    public void setDrecorddate(Date drecorddate) {
        this.drecorddate = drecorddate;
        this.drecorddateStr = FormatUtils.formatDate(drecorddate, "yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 获取：记录日期字符串
     * @return
     * @author Liu bo
     */
    public String getDrecorddateStr() {
        return drecorddateStr;
    }
    
    /**
     * 设置：记录日期字符串
     * @param drecorddateStr
     * @author Liu bo
     */
    public void setDrecorddateStr(String drecorddateStr) {
        this.drecorddateStr = drecorddateStr;
    }
    
    /**
     * 获取：记录日期字符串最小值
     * @return
     * @author Liu bo
     */
    public String getDrecorddateStrMin() {
        return drecorddateStrMin;
    }
    
    /**
     * 设置：记录日期字符串最小值
     * @param drecorddateStrMin
     * @author Liu bo
     */
    public void setDrecorddateStrMin(String drecorddateStrMin) {
        this.drecorddateStrMin = drecorddateStrMin;
    }
    
    /**
     * 获取：记录日期字符串最大值
     * @return
     * @author Liu bo
     */
    public String getDrecorddateStrMax() {
        return drecorddateStrMax;
    }
    
    /**
     * 设置：记录日期字符串最大值
     * @param drecorddateStrMax
     * @author Liu bo
     */
    public void setDrecorddateStrMax(String drecorddateStrMax) {
        this.drecorddateStrMax = drecorddateStrMax;
    }
    
    /**
     * 获取：更新日期
     * @return
     * @author Liu bo
     */
    public Date getDupdatedate() {
        return dupdatedate;
    }
    
    /**
     * 设置：更新日期
     * @param dupdatedate
     * @author Liu bo
     */
    public void setDupdatedate(Date dupdatedate) {
        this.dupdatedate = dupdatedate;
        this.dupdatedateStr = FormatUtils.formatDate(dupdatedate, "yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 获取：更新日期字符串
     * @return
     * @author Liu bo
     */
    public String getDupdatedateStr() {
        return dupdatedateStr;
    }
    
    /**
     * 设置：更新日期字符串
     * @param dupdatedateStr
     * @author Liu bo
     */
    public void setDupdatedateStr(String dupdatedateStr) {
        this.dupdatedateStr = dupdatedateStr;
    }
    
    /**
     * 获取：供应商表外键
     * @return
     * @author Liu bo
     */
    public String getUsupplierid() {
        return usupplierid;
    }
    
    /**
     * 设置：供应商表外键
     * @param usupplierid
     * @author Liu bo
     */
    public void setUsupplierid(String usupplierid) {
        this.usupplierid = usupplierid;
    }
    
    
}
