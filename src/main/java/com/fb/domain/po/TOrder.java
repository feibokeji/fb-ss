package com.fb.domain.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 订单实体类
 * @since 2016年5月6日 上午9:47:49
 * @author Liu bo
 */
@TableMapper("t_order")
public class TOrder extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4447231107006610392L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 编号
     */
    private String cno;
    
    /**
     * 订单类型
     */
    private String ctype;
    
    /**
     * 订单状态
     */
    private String cstatus;
    
    /**
     * 订单日期
     */
    private Date dordertime;
    
    /**
     * 开始日期
     */
    @NotFieldMapper
    private String begantime;
    
    /**
     * 截止日期
     */
    @NotFieldMapper
    private String endtime;
    
    /**
     * 创建时间
     */
    private Date dcreatetime;
    
    /**
     * 更新时间
     */
    private Date dupdatetime;
    
    /**
     * 物料订单明细
     */
    @NotFieldMapper
    private List<TOrderMaterial> orderMaterialDetailList = new ArrayList<TOrderMaterial>();
    
    /**
     * 产品订单明细
     */
    @NotFieldMapper
    private List<TOrderProduct> orderProductDetailList = new ArrayList<TOrderProduct>();
    
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
     * 获取 订单类型
     * @return ctype
     */
    public String getCtype() {
        return ctype;
    }
    
    /**
     * 设置 订单类型
     * @param ctype 订单类型
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
    
    /**
     * 获取 订单状态
     * @return cstatus
     */
    public String getCstatus() {
        return cstatus;
    }
    
    /**
     * 设置 订单状态
     * @param cstatus 订单状态
     */
    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
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
     * 获取 物料订单明细
     * @return orderMaterialDetailList
     */
    public List<TOrderMaterial> getOrderMaterialDetailList() {
        return orderMaterialDetailList;
    }
    
    /**
     * 设置 物料订单明细
     * @param orderMaterialDetailList 物料订单明细
     */
    public void setOrderMaterialDetailList(List<TOrderMaterial> orderMaterialDetailList) {
        this.orderMaterialDetailList = orderMaterialDetailList;
    }
    
    /**
     * 获取 产品订单明细
     * @return orderProductDetailList
     */
    public List<TOrderProduct> getOrderProductDetailList() {
        return orderProductDetailList;
    }
    
    /**
     * 设置 产品订单明细
     * @param orderProductDetailList 产品订单明细
     */
    public void setOrderProductDetailList(List<TOrderProduct> orderProductDetailList) {
        this.orderProductDetailList = orderProductDetailList;
    }
    
    /**
     * 获取 订单日期
     * @return dordertime
     */
    public Date getDordertime() {
        return dordertime;
    }
    
    /**
     * 设置 订单日期
     * @param dordertime 订单日期
     */
    public void setDordertime(Date dordertime) {
        this.dordertime = dordertime;
    }
    
    /**
     * 获取 开始日期
     * @return begantime
     */
    public String getBegantime() {
        return begantime;
    }
    
    /**
     * 设置 开始日期
     * @param begantime 开始日期
     */
    public void setBegantime(String begantime) {
        this.begantime = begantime;
    }
    
    /**
     * 获取 截止日期
     * @return endtime
     */
    public String getEndtime() {
        return endtime;
    }
    
    /**
     * 设置 截止日期
     * @param endtime 截止日期
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
    
}
