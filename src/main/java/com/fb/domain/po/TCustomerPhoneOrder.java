package com.fb.domain.po;

import java.util.Date;
import java.util.List;

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
     * 单据编号
     */
    private String cno;
    
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
     * 手机单据明细集合
     */
    @NotFieldMapper
    private List<TCustomerPhoneOrderDetail> orderDetailList;
    
    /**
     * 手机单据应收应付
     */
    @NotFieldMapper
    private TCustomerPhoneOrderReceivable orderReceivable;
    
    /**
     * 手机单据实收实付
     */
    @NotFieldMapper
    private TCustomerPhoneOrderReceipts orderReceipts;

    
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
     * 获取 单据编号
     * @return cno
     */
    public String getCno() {
        return cno;
    }
    



    
    /**
     * 设置 单据编号
     * @param cno 单据编号
     */
    public void setCno(String cno) {
        this.cno = cno;
    }



    
    /**
     * 获取 手机单据明细集合
     * @return orderDetailList
     */
    public List<TCustomerPhoneOrderDetail> getOrderDetailList() {
        return orderDetailList;
    }
    



    
    /**
     * 设置 手机单据明细集合
     * @param orderDetailList 手机单据明细集合
     */
    public void setOrderDetailList(List<TCustomerPhoneOrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
    



    
    /**
     * 获取 手机单据应收应付
     * @return orderReceivable
     */
    public TCustomerPhoneOrderReceivable getOrderReceivable() {
        return orderReceivable;
    }
    



    
    /**
     * 设置 手机单据应收应付
     * @param orderReceivable 手机单据应收应付
     */
    public void setOrderReceivable(TCustomerPhoneOrderReceivable orderReceivable) {
        this.orderReceivable = orderReceivable;
    }
    



    
    /**
     * 获取 手机单据实收实付
     * @return orderReceipts
     */
    public TCustomerPhoneOrderReceipts getOrderReceipts() {
        return orderReceipts;
    }
    



    
    /**
     * 设置 手机单据实收实付
     * @param orderReceipts 手机单据实收实付
     */
    public void setOrderReceipts(TCustomerPhoneOrderReceipts orderReceipts) {
        this.orderReceipts = orderReceipts;
    }
    
    
    
    
    
    
}
