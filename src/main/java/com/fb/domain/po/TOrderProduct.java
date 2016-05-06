package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 产品订单明细实体类
 * @since 2016年5月6日 上午10:18:20
 * @author Liu bo
 */
@TableMapper("t_order_product")
public class TOrderProduct extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8212210604928247047L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 订单外键
     */
    private String uorderid;
    
    /**
     * 产品外键
     */
    private String uproductid;
    
    /**
     * 产品名称
     */
    private String cproductname;
    
    /**
     * 价格
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
     * 获取 订单外键
     * @return uorderid
     */
    public String getUorderid() {
        return uorderid;
    }
    
    /**
     * 设置 订单外键
     * @param uorderid 订单外键
     */
    public void setUorderid(String uorderid) {
        this.uorderid = uorderid;
    }
    
    /**
     * 获取 产品外键
     * @return uproductid
     */
    public String getUproductid() {
        return uproductid;
    }
    
    /**
     * 设置 产品外键
     * @param uproductid 产品外键
     */
    public void setUproductid(String uproductid) {
        this.uproductid = uproductid;
    }
    
    /**
     * 获取 产品名称
     * @return cproductname
     */
    public String getCproductname() {
        return cproductname;
    }
    
    /**
     * 设置 产品名称
     * @param cproductname 产品名称
     */
    public void setCproductname(String cproductname) {
        this.cproductname = cproductname;
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
