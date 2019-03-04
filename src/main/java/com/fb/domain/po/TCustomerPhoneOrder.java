package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月15日 下午6:36:48
 * 客户手机单据表
 */
@TableMapper("t_customer_phone_order")
public class TCustomerPhoneOrder extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = -8453674090862040492L;
    
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
     * 类型
     * {@value 0 = 销售}
     * {@value 1 = 退货}
     */
    private Integer itype;
    
    /**
     * 类型字符串
     * {@value 销售}
     * {@value 退货}
     */
    @NotFieldMapper
    private String itypeStr;
    
    /**
     * 金额
     */
    private Double namount;
    
    /**
     * 状态
     * {@value 0 = 未审核}
     * {@value 1 = 已审核}
     */
    private Integer istatus;
    
    /**
     * 状态字符串
     * {@value 未审核}
     * {@value 已审核}
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
     * 获取 类型      
     * {@value 0 = 销售}      
     * {@value 1 = 退货}
     * @return itype
     */
    public Integer getItype() {
        return itype;
    }
    

    
    /**
     * 设置 类型      
     * {@value 0 = 销售}      
     * {@value 1 = 退货}
     * @param itype 类型      {@value 0 = 销售}      {@value 1 = 退货}
     */
    public void setItype(Integer itype) {
        this.itype = itype;
        switch(itype){
            case 0:
                this.itypeStr = "销售";
                break;
            case 1:
                this.itypeStr = "退货";
                break;
        }
    }
    

    
    /**
     * 获取 类型字符串      
     * {@value 销售}      
     * {@value 退货}
     * @return itypeStr
     */
    public String getItypeStr() {
        return itypeStr;
    }
    

    
    /**
     * 设置 类型字符串      
     * {@value 销售}      
     * {@value 退货}
     * @param itypeStr 类型字符串      {@value 销售}      {@value 退货}
     */
    public void setItypeStr(String itypeStr) {
        this.itypeStr = itypeStr;
    }
    

    
    /**
     * 获取 状态      
     * {@value 0 = 未审核}      
     * {@value 1 = 已审核}
     * @return istatus
     */
    public Integer getIstatus() {
        return istatus;
    }
    

    
    /**
     * 设置 状态      
     * {@value 0 = 未审核}      
     * {@value 1 = 已审核}
     * @param istatus 状态      {@value 0 = 未审核}      {@value 1 = 已审核}
     */
    public void setIstatus(Integer istatus) {
        this.istatus = istatus;
        switch(istatus){
            case 0:
                this.istatusStr = "未审核";
                break;
            case 1:
                this.istatusStr = "已审核";
                break;
        }
    }
    

    
    /**
     * 获取 状态字符串      
     * {@value 未审核}      
     * {@value 已审核}
     * @return istatusStr
     */
    public String getIstatusStr() {
        return istatusStr;
    }
    

    
    /**
     * 设置 状态字符串      
     * {@value 未审核}      
     * {@value 已审核}
     * @param istatusStr 状态字符串      {@value 未审核}      {@value 已审核}
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
     * 获取 记录日期字符串
     * @return drecorddateStr
     */
    public String getDrecorddateStr() {
        return drecorddateStr;
    }
    

    
    /**
     * 设置 记录日期字符串
     * @param drecorddateStr 记录日期字符串
     */
    public void setDrecorddateStr(String drecorddateStr) {
        this.drecorddateStr = drecorddateStr;
    }
    

    
    /**
     * 获取 记录日期字符串最小值
     * @return drecorddateStrMin
     */
    public String getDrecorddateStrMin() {
        return drecorddateStrMin;
    }
    

    
    /**
     * 设置 记录日期字符串最小值
     * @param drecorddateStrMin 记录日期字符串最小值
     */
    public void setDrecorddateStrMin(String drecorddateStrMin) {
        this.drecorddateStrMin = drecorddateStrMin;
    }
    

    
    /**
     * 获取 记录日期字符串最大值
     * @return drecorddateStrMax
     */
    public String getDrecorddateStrMax() {
        return drecorddateStrMax;
    }
    

    
    /**
     * 设置 记录日期字符串最大值
     * @param drecorddateStrMax 记录日期字符串最大值
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
     * 获取 更新日期字符串
     * @return dupdatedateStr
     */
    public String getDupdatedateStr() {
        return dupdatedateStr;
    }
    

    
    /**
     * 设置 更新日期字符串
     * @param dupdatedateStr 更新日期字符串
     */
    public void setDupdatedateStr(String dupdatedateStr) {
        this.dupdatedateStr = dupdatedateStr;
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
    
    
    
    
}
