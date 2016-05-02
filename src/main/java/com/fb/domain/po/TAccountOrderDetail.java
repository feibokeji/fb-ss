package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 单据明细
 * @since 2016年4月11日 下午4:08:27
 * @author Liu bo
 */
@TableMapper("t_account_order_detail")
public class TAccountOrderDetail extends BaseDomain {
    
    
    /**
     * 
     */
    private static final long serialVersionUID = 7409500618883561746L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 单据主表主键
     */
    private String uaccountorderid;
    
    /**
     * 单价
     */
    private Double nprice;
    
    /**
     * 数量
     */
    private Double nqty;
    
    /**
     * 金额
     */
    private Double namount;
    
    /**
     * 排序
     */
    private Integer isort;
    
    /**
     * 备注
     */
    private String cmemo;
    
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
     * 获取 单据主表主键
     * @return uaccountorderid
     */
    public String getUaccountorderid() {
        return uaccountorderid;
    }
    
    /**
     * 设置 单据主表主键
     * @param uaccountorderid 单据主表主键
     */
    public void setUaccountorderid(String uaccountorderid) {
        this.uaccountorderid = uaccountorderid;
    }
    
    /**
     * 获取 单价
     * @return nprice
     */
    public Double getNprice() {
        return nprice;
    }
    
    /**
     * 设置 单价
     * @param nprice 单价
     */
    public void setNprice(Double nprice) {
        this.nprice = nprice;
    }
    
    /**
     * 获取 数量
     * @return nqty
     */
    public Double getNqty() {
        return nqty;
    }
    
    /**
     * 设置 数量
     * @param nqty 数量
     */
    public void setNqty(Double nqty) {
        this.nqty = nqty;
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
     * 获取 备注
     * @return cmemo
     */
    public String getCmemo() {
        return cmemo;
    }
    
    /**
     * 设置 备注
     * @param cmemo 备注
     */
    public void setCmemo(String cmemo) {
        this.cmemo = cmemo;
    }
    
    /**
     * 获取 排序
     * @return isort
     */
    public Integer getIsort() {
        return isort;
    }
    
    /**
     * 设置 排序
     * @param isort 排序
     */
    public void setIsort(Integer isort) {
        this.isort = isort;
    }
    
}
