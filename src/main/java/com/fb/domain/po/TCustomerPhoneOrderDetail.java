package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月8日 下午2:39:22
 * 客户手机单据明细表
 */
@TableMapper("t_customer_phone_order_detail")
public class TCustomerPhoneOrderDetail extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = -2150292741785079687L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 单据表外键
     */
    private String uorderid;
    
    /**
     * 手机串号
     */
    private String imei;
    
    /**
     * 品牌表外键
     */
    @NotFieldMapper
    private String ubrandid;
    
    /**
     * 品牌名称
     */
    @NotFieldMapper
    private String cbrandname;
    
    /**
     * 手机型号名称
     */
    @NotFieldMapper
    private String cphonemodelname;
    
    /**
     * 运行内存
     */
    @NotFieldMapper
    private String cram;
    
    /**
     * 存储空间
     */
    @NotFieldMapper
    private String crom;
    
    /**
     * 处理器
     */
    @NotFieldMapper
    private String ccpu;
    
    /**
     * 摄像头
     */
    @NotFieldMapper
    private String ccamera;
    
    /**
     * 屏幕
     */
    @NotFieldMapper
    private String cscreen;
    
    /**
     * 电池
     */
    @NotFieldMapper
    private String cbattery;
    
    /**
     * 颜色名称
     */
    @NotFieldMapper
    private String ccolorname;
    
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
     * 价格
     */
    private Double nprice;
    
    /**
     * 折扣
     */
    private Double ndiscount;
    
    /**
     * 金额
     */
    private Double namount;
    
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
     * 更新日期
     */
    private Date dupdatedate;
    
    /**
     * 更新日期
     */
    @NotFieldMapper
    private String dupdatedateStr;
    
    /**
     * 序号
     */
    private Integer isort;

    
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
     * 获取 手机串号
     * @return imei
     */
    public String getImei() {
        return imei;
    }
    

    
    /**
     * 设置 手机串号
     * @param imei 手机串号
     */
    public void setImei(String imei) {
        this.imei = imei;
    }
    

    
    /**
     * 获取 品牌表外键
     * @return ubrandid
     */
    public String getUbrandid() {
        return ubrandid;
    }
    

    
    /**
     * 设置 品牌表外键
     * @param ubrandid 品牌表外键
     */
    public void setUbrandid(String ubrandid) {
        this.ubrandid = ubrandid;
    }
    

    
    /**
     * 获取 品牌名称
     * @return cbrandname
     */
    public String getCbrandname() {
        return cbrandname;
    }
    

    
    /**
     * 设置 品牌名称
     * @param cbrandname 品牌名称
     */
    public void setCbrandname(String cbrandname) {
        this.cbrandname = cbrandname;
    }
    

    
    /**
     * 获取 手机型号名称
     * @return cphonemodelname
     */
    public String getCphonemodelname() {
        return cphonemodelname;
    }
    

    
    /**
     * 设置 手机型号名称
     * @param cphonemodelname 手机型号名称
     */
    public void setCphonemodelname(String cphonemodelname) {
        this.cphonemodelname = cphonemodelname;
    }
    

    
    /**
     * 获取 运行内存
     * @return cram
     */
    public String getCram() {
        return cram;
    }
    

    
    /**
     * 设置 运行内存
     * @param cram 运行内存
     */
    public void setCram(String cram) {
        this.cram = cram;
    }
    

    
    /**
     * 获取 存储空间
     * @return crom
     */
    public String getCrom() {
        return crom;
    }
    

    
    /**
     * 设置 存储空间
     * @param crom 存储空间
     */
    public void setCrom(String crom) {
        this.crom = crom;
    }
    

    
    /**
     * 获取 处理器
     * @return ccpu
     */
    public String getCcpu() {
        return ccpu;
    }
    

    
    /**
     * 设置 处理器
     * @param ccpu 处理器
     */
    public void setCcpu(String ccpu) {
        this.ccpu = ccpu;
    }
    

    
    /**
     * 获取 摄像头
     * @return ccamera
     */
    public String getCcamera() {
        return ccamera;
    }
    

    
    /**
     * 设置 摄像头
     * @param ccamera 摄像头
     */
    public void setCcamera(String ccamera) {
        this.ccamera = ccamera;
    }
    

    
    /**
     * 获取 屏幕
     * @return cscreen
     */
    public String getCscreen() {
        return cscreen;
    }
    

    
    /**
     * 设置 屏幕
     * @param cscreen 屏幕
     */
    public void setCscreen(String cscreen) {
        this.cscreen = cscreen;
    }
    

    
    /**
     * 获取 电池
     * @return cbattery
     */
    public String getCbattery() {
        return cbattery;
    }
    

    
    /**
     * 设置 电池
     * @param cbattery 电池
     */
    public void setCbattery(String cbattery) {
        this.cbattery = cbattery;
    }
    

    
    /**
     * 获取 颜色名称
     * @return ccolorname
     */
    public String getCcolorname() {
        return ccolorname;
    }
    

    
    /**
     * 设置 颜色名称
     * @param ccolorname 颜色名称
     */
    public void setCcolorname(String ccolorname) {
        this.ccolorname = ccolorname;
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
     * 获取 价格
     * @return nprice
     */
    public Double getNprice() {
        return nprice;
    }
    

    
    /**
     * 设置 价格
     * @param nprice 价格
     */
    public void setNprice(Double nprice) {
        this.nprice = nprice;
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
    

    
    /**
     * 获取 序号
     * @return isort
     */
    public Integer getIsort() {
        return isort;
    }
    

    
    /**
     * 设置 序号
     * @param isort 序号
     */
    public void setIsort(Integer isort) {
        this.isort = isort;
    }
    
}
