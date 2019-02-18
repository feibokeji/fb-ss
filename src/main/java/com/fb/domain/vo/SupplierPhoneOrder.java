package com.fb.domain.vo;

import java.util.List;

import com.fb.core.base.domain.BaseDomain;
import com.fb.domain.po.TSupplierPhoneOrder;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月17日 上午11:13:17
 * 供应商手机单据封装类
 */
public class SupplierPhoneOrder extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = 6486685400548391700L;
    
    /**
     * 单据类型
     */
    private Integer itype;
    
    /**
     * 单据状态
     */
    private Integer istatus;
    
    /**
     * 供应商主键
     */
    private String usupplierid;
    
    /**
     * 记录日期
     */
    private String drecorddateStr;
    
    /**
     * 单据明细
     */
    private List<TSupplierPhoneOrder> orderDetailList;

    /**
     * 获取 单据类型
     * @return itype
     */
    public Integer getItype() {
        return itype;
    }
    
    /**
     * 设置 单据类型
     * @param itype 单据类型
     */
    public void setItype(Integer itype) {
        this.itype = itype;
    }
    
    /**
     * 获取 单据状态
     * @return istatus
     */
    public Integer getIstatus() {
        return istatus;
    }
    
    /**
     * 设置 单据状态
     * @param istatus 单据状态
     */
    public void setIstatus(Integer istatus) {
        this.istatus = istatus;
    }
    
    /**
     * 获取 供应商主键
     * @return usupplierid
     */
    public String getUsupplierid() {
        return usupplierid;
    }
    
    /**
     * 设置 供应商主键
     * @param usupplierid 供应商主键
     */
    public void setUsupplierid(String usupplierid) {
        this.usupplierid = usupplierid;
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
     * 获取 单据明细
     * @return orderDetailList
     */
    public List<TSupplierPhoneOrder> getOrderDetailList() {
        return orderDetailList;
    }
    
    /**
     * 设置 单据明细
     * @param orderDetailList 单据明细
     */
    public void setOrderDetailList(List<TSupplierPhoneOrder> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
    
}
