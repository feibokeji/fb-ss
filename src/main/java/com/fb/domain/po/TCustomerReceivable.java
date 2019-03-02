package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月1日 下午7:08:47
 * 客户商品应收应付表
 */
@TableMapper("t_customer_receivable")
public class TCustomerReceivable extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = 3008612919776716814L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 客户表外键
     */
    private String ucustomerid;
    
    /**
     * 客户名称
     */
    @NotFieldMapper
    private String ccustomername;
    
    /**
     * 单据表外键
     */
    private String uorderid;
    
    /**
     * 单据编号
     */
    @NotFieldMapper
    private String corderno;
    
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
     * {@value AR=应收/AP=应付}
     */
    private String ctype;
    
    /**
     * 类型
     * {@value 应收/应付}
     */
    @NotFieldMapper
    private String ctypeStr;
    
    /**
     * 原始金额
     */
    private Double nactualamount;
    
    /**
     * 折扣
     */
    private Double ndiscount;
    
    /**
     * 折后金额
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
     * 获取 客户表外键
     * @return ucustomerid
     */
    public String getUcustomerid() {
        return ucustomerid;
    }
    

    
    /**
     * 设置 客户表外键
     * @param ucustomerid 客户表外键
     */
    public void setUcustomerid(String ucustomerid) {
        this.ucustomerid = ucustomerid;
    }
    

    
    /**
     * 获取 客户名称
     * @return ccustomername
     */
    public String getCcustomername() {
        return ccustomername;
    }
    

    
    /**
     * 设置 客户名称
     * @param ccustomername 客户名称
     */
    public void setCcustomername(String ccustomername) {
        this.ccustomername = ccustomername;
    }
    

    
    /**
     * 获取 单据表外键
     * @return uorderid
     */
    public String getUorderid() {
        return uorderid;
    }
    

    
    /**
     * 设置 单据表外键
     * @param uorderid 单据表外键
     */
    public void setUorderid(String uorderid) {
        this.uorderid = uorderid;
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
     * 获取 类型      {@value AR=应收AP=应付}
     * @return ctype
     */
    public String getCtype() {
        return ctype;
    }
    

    
    /**
     * 设置 类型      {@value AR=应收AP=应付}
     * @param ctype 类型      {@value AR=应收AP=应付}
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
        if(ctype.equals("AR"))
            this.ctypeStr = "应收";
        else if(ctype.equals("AP"))
            this.ctypeStr = "应付";
    }
    

    
    /**
     * 获取 类型      {@value 应收应付}
     * @return ctypeStr
     */
    public String getCtypeStr() {
        return ctypeStr;
    }
    

    
    /**
     * 设置 类型      {@value 应收应付}
     * @param ctypeStr 类型      {@value 应收应付}
     */
    public void setCtypeStr(String ctypeStr) {
        this.ctypeStr = ctypeStr;
    }
    

    
    /**
     * 获取 原始金额
     * @return nactualamount
     */
    public Double getNactualamount() {
        return nactualamount;
    }
    

    
    /**
     * 设置 原始金额
     * @param nactualamount 原始金额
     */
    public void setNactualamount(Double nactualamount) {
        this.nactualamount = nactualamount;
    }
    

    
    /**
     * 获取 折扣
     * @return ndiscount
     */
    public Double getNdiscount() {
        return ndiscount;
    }
    

    
    /**
     * 设置 折扣
     * @param ndiscount 折扣
     */
    public void setNdiscount(Double ndiscount) {
        this.ndiscount = ndiscount;
    }
    

    
    /**
     * 获取 折后金额
     * @return namount
     */
    public Double getNamount() {
        return namount;
    }
    

    
    /**
     * 设置 折后金额
     * @param namount 折后金额
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
        switch(istatus){
            case 0:
                this.istatusStr = "未结算";
                break;
            case 1:
                this.istatusStr = "已结算";
                break;
        }
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
        this.drecorddateStr = FormatUtils.formatDate(drecorddate, "yyyy-MM-dd HH:mm:ss");
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
        this.dupdatedateStr = FormatUtils.formatDate(dupdatedate, "yyyy-MM-dd HH:mm:ss");
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
