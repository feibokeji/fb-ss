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
 * @version 创建时间：2019年3月1日 下午6:44:16
 * 客户商品单据表
 */
@TableMapper("t_customer_order")
public class TCustomerOrder extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = -5902263076055001210L;
    
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
     * 单据类型
     * {@value 0=销售/1=退货}
     */
    private Integer itype;
    
    /**
     * 单据类型
     * {@value 销售/退货}
     */
    @NotFieldMapper
    private String itypeStr;
    
    /**
     * 单据状态
     * {@value 0=未审核/1=已审核}
     */
    private Integer istatus;
    
    /**
     * 单据状态
     * {@value 未审核/已审核}
     */
    @NotFieldMapper
    private String istatusStr;
    
    /**
     * 记录日期
     */
    private Date drecroddate;
    
    /**
     * 记录日期
     */
    @NotFieldMapper
    private String drecroddateStr;
    
    /**
     * 记录日期最小值
     */
    @NotFieldMapper
    private String drecroddateStrMin;
    
    /**
     * 记录日期最大值
     */
    @NotFieldMapper
    private String drecroddateStrMax;
    
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
     * 单据明细集合
     */
    @NotFieldMapper
    private List<TCustomerOrderDetail> orderDetailList;

    
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
     * 获取 单据类型      {@value 0=销售1=退货}
     * @return itype
     */
    public Integer getItype() {
        return itype;
    }
    

    
    /**
     * 设置 单据类型      {@value 0=销售1=退货}
     * @param itype 单据类型      {@value 0=销售1=退货}
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
     * 获取 单据类型      {@value 销售退货}
     * @return itypeStr
     */
    public String getItypeStr() {
        return itypeStr;
    }
    

    
    /**
     * 设置 单据类型      {@value 销售退货}
     * @param itypeStr 单据类型      {@value 销售退货}
     */
    public void setItypeStr(String itypeStr) {
        this.itypeStr = itypeStr;
    }
    

    
    /**
     * 获取 单据状态      {@value 0=未审核1=已审核}
     * @return istatus
     */
    public Integer getIstatus() {
        return istatus;
    }
    

    
    /**
     * 设置 单据状态      {@value 0=未审核1=已审核}
     * @param istatus 单据状态      {@value 0=未审核1=已审核}
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
     * 获取 单据状态      {@value 未审核已审核}
     * @return istatusStr
     */
    public String getIstatusStr() {
        return istatusStr;
    }
    

    
    /**
     * 设置 单据状态      {@value 未审核已审核}
     * @param istatusStr 单据状态      {@value 未审核已审核}
     */
    public void setIstatusStr(String istatusStr) {
        this.istatusStr = istatusStr;
    }
    

    
    /**
     * 获取 记录日期
     * @return drecroddate
     */
    public Date getDrecroddate() {
        return drecroddate;
    }
    

    
    /**
     * 设置 记录日期
     * @param drecroddate 记录日期
     */
    public void setDrecroddate(Date drecroddate) {
        this.drecroddate = drecroddate;
        this.drecroddateStr = FormatUtils.formatDate(drecroddate, "yyyy-MM-dd HH:mm:ss");
    }
    

    
    /**
     * 获取 记录日期
     * @return drecroddateStr
     */
    public String getDrecroddateStr() {
        return drecroddateStr;
    }
    

    
    /**
     * 设置 记录日期
     * @param drecroddateStr 记录日期
     */
    public void setDrecroddateStr(String drecroddateStr) {
        this.drecroddateStr = drecroddateStr;
    }
    

    
    /**
     * 获取 记录日期最小值
     * @return drecroddateStrMin
     */
    public String getDrecroddateStrMin() {
        return drecroddateStrMin;
    }
    

    
    /**
     * 设置 记录日期最小值
     * @param drecroddateStrMin 记录日期最小值
     */
    public void setDrecroddateStrMin(String drecroddateStrMin) {
        this.drecroddateStrMin = drecroddateStrMin;
    }
    

    
    /**
     * 获取 记录日期最大值
     * @return drecroddateStrMax
     */
    public String getDrecroddateStrMax() {
        return drecroddateStrMax;
    }
    

    
    /**
     * 设置 记录日期最大值
     * @param drecroddateStrMax 记录日期最大值
     */
    public void setDrecroddateStrMax(String drecroddateStrMax) {
        this.drecroddateStrMax = drecroddateStrMax;
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



    
    /**
     * 获取 单据明细集合
     * @return orderDetailList
     */
    public List<TCustomerOrderDetail> getOrderDetailList() {
        return orderDetailList;
    }
    



    
    /**
     * 设置 单据明细集合
     * @param orderDetailList 单据明细集合
     */
    public void setOrderDetailList(List<TCustomerOrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
    
    
}
