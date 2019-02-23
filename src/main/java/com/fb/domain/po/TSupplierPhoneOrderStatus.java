package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月15日 下午4:57:00
 * 供应商手机单据状态表
 */
@TableMapper("t_supplier_phone_order_status")
public class TSupplierPhoneOrderStatus extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = 884578297257357868L;
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    /**
     * 手机串号
     */
    private String imei;
    /**
     * 类型
     * {@value 0 = 入库}
     * {@value 1 = 退库}
     * {@value 2 = 销售}
     * {@value 3 = 退货}
     * {@value 4 = 调出}
     * {@value 5 = 调入}
     */
    private Integer itype;
    /**
     * 类型字符串
     * {@value 入库}
     * {@value 退库}
     * {@value 销售}
     * {@value 退货}
     * {@value 调出}
     * {@value 调入}
     */
    @NotFieldMapper
    private String itypeStr;
    /**
     * 状态
     * {@value 0 = 禁用}
     * {@value 1 = 启用}
     */
    private Integer istatus;
    /**
     * 状态字符串
     * {@value 禁用}
     * {@value 启用}
     */
    @NotFieldMapper
    private String istatusStr;
    
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
     * 记录日期
     */
    private Date drecorddate;
    /**
     * 记录日期字符串
     */
    @NotFieldMapper
    private String drecorddateStr;
    
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
     * 获取 类型     
     * {@value 0 = 入库}      
     * {@value 1 = 退库}      
     * {@value 2 = 销售}      
     * {@value 3 = 退货}      
     * {@value 4 = 调出}
     * {@value 5 = 调入}
     * @return itype
     */
    public Integer getItype() {
        return itype;
    }
    
    
    /**
     * 设置 类型      
     * {@value 0 = 入库}      
     * {@value 1 = 退库}      
     * {@value 2 = 销售}      
     * {@value 3 = 退货}      
     * {@value 4 = 调出}
     * {@value 5 = 调入}
     * @param itype 类型      {@value 0 = 入库}      {@value 1 = 退库}      {@value 2 = 销售}      {@value 3 = 退货}      {@value 4 = 调出} {@value 5 = 调入}
     */
    public void setItype(Integer itype) {
        this.itype = itype;
        switch (itype) {
            case 0:
                this.itypeStr = "入库";
                break;
            case 1:
                this.itypeStr = "退库";
                break;
            case 2:
                this.itypeStr = "销售";
                break;
            case 3:
                this.itypeStr = "退货";
                break;
            case 4:
                this.itypeStr = "调出";
                break;
            case 5:
                this.itypeStr = "调入";
                break;
            default:
                break;
        }
    }
    
    
    /**
     * 获取 类型字符串      
     * {@value 入库}      
     * {@value 退库}      
     * {@value 销售}      
     * {@value 退货}      
     * {@value 调出}
     * {@value 调入}
     * @return itypeStr
     */
    public String getItypeStr() {
        return itypeStr;
    }
    
    
    /**
     * 设置 类型字符串      
     * {@value 入库}      
     * {@value 退库}      
     * {@value 销售}      
     * {@value 退货}      
     * {@value 调出}
     * {@value 调入}
     * @param itypeStr 类型字符串      {@value 入库}      {@value 退库}      {@value 销售}      {@value 退货}      {@value 调出}      {@value 调入}
     */
    public void setItypeStr(String itypeStr) {
        this.itypeStr = itypeStr;
    }
    
    
    /**
     * 获取 状态      
     * {@value 0 = 禁用}      
     * {@value 1 = 启用}
     * @return istatus
     */
    public Integer getIstatus() {
        return istatus;
    }
    
    
    /**
     * 设置 状态     
     * {@value 0 = 禁用}      
     * {@value 1 = 启用}
     * @param istatus 状态      {@value 0 = 禁用}      {@value 1 = 启用}
     */
    public void setIstatus(Integer istatus) {
        this.istatus = istatus;
        switch (istatus) {
            case 0:
                this.istatusStr = "禁用";
                break;
            case 1:
                this.istatusStr = "启用";
                break;
            default:
                break;
        }
    }
    
    
    /**
     * 获取 状态字符串      
     * {@value 禁用}      
     * {@value 启用}
     * @return istatusStr
     */
    public String getIstatusStr() {
        return istatusStr;
    }
    
    
    /**
     * 设置 状态字符串     
     * {@value 禁用}      
     * {@value 启用}
     * @param istatusStr 状态字符串      {@value 禁用}      {@value 启用}
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
    
    
    
}
