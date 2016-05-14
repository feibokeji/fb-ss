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
     * 序号
     */
    private Integer isort;
    
    /**
     * 订单外键
     */
    private String uorderid;
    
    /**
     * 产品外键
     */
    private String uproductid;
    
    /**
     * 产品编码
     */
    private String cproductno;
    
    /**
     * 产品名称
     */
    private String cproductname;
    
    /**
     * 类别名称
     */
    private String ccategoryname;
    
    /**
     * 销售数量
     */
    private Double nsqty;
    
    /**
     * 销售金额
     */
    private Double nsamount;
    
    /**
     * 退货数量
     */
    private Double nbqty;
    
    /**
     * 退货金额
     */
    private Double nbamount;
    
    /**
     * 赠送数量
     */
    private Double ngqty;
    
    /**
     * 赠送金额
     */
    private Double ngamount;
    
    /**
     * 数量小计
     */
    private Double nqtysubtotal;
    
    /**
     * 金额小计
     */
    private Double namountsubtotal;
    
    /**
     * 参考进价
     */
    private Double nreferenceprice;
    
    /**
     * 进价金额
     */
    
    private Double npurchaseprice;
    
    /**
     * 参考利润
     */
    private Double nreferenceprofits;
    
    /**
     * 主供应商
     */
    private String cmainsupplier;
    
    /**
     * 品牌
     */
    private String cbrand;
    
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
     * 获取 产品编码
     * @return cproductno
     */
    public String getCproductno() {
        return cproductno;
    }
    
    /**
     * 设置 产品编码
     * @param cproductno 产品编码
     */
    public void setCproductno(String cproductno) {
        this.cproductno = cproductno;
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
     * 获取 类别名称
     * @return ccategoryname
     */
    public String getCcategoryname() {
        return ccategoryname;
    }
    
    /**
     * 设置 类别名称
     * @param ccategoryname 类别名称
     */
    public void setCcategoryname(String ccategoryname) {
        this.ccategoryname = ccategoryname;
    }
    
    /**
     * 获取 销售数量
     * @return nsqty
     */
    public Double getNsqty() {
        return nsqty;
    }
    
    /**
     * 设置 销售数量
     * @param nsqty 销售数量
     */
    public void setNsqty(Double nsqty) {
        this.nsqty = nsqty;
    }
    
    /**
     * 获取 销售金额
     * @return nsamount
     */
    public Double getNsamount() {
        return nsamount;
    }
    
    /**
     * 设置 销售金额
     * @param nsamount 销售金额
     */
    public void setNsamount(Double nsamount) {
        this.nsamount = nsamount;
    }
    
    /**
     * 获取 退货数量
     * @return nbqty
     */
    public Double getNbqty() {
        return nbqty;
    }
    
    /**
     * 设置 退货数量
     * @param nbqty 退货数量
     */
    public void setNbqty(Double nbqty) {
        this.nbqty = nbqty;
    }
    
    /**
     * 获取 退货金额
     * @return nbamount
     */
    public Double getNbamount() {
        return nbamount;
    }
    
    /**
     * 设置 退货金额
     * @param nbamount 退货金额
     */
    public void setNbamount(Double nbamount) {
        this.nbamount = nbamount;
    }
    
    /**
     * 获取 赠送数量
     * @return ngqty
     */
    public Double getNgqty() {
        return ngqty;
    }
    
    /**
     * 设置 赠送数量
     * @param ngqty 赠送数量
     */
    public void setNgqty(Double ngqty) {
        this.ngqty = ngqty;
    }
    
    /**
     * 获取 赠送金额
     * @return ngamount
     */
    public Double getNgamount() {
        return ngamount;
    }
    
    /**
     * 设置 赠送金额
     * @param ngamount 赠送金额
     */
    public void setNgamount(Double ngamount) {
        this.ngamount = ngamount;
    }
    
    /**
     * 获取 数量小计
     * @return nqtysubtotal
     */
    public Double getNqtysubtotal() {
        return nqtysubtotal;
    }
    
    /**
     * 设置 数量小计
     * @param nqtysubtotal 数量小计
     */
    public void setNqtysubtotal(Double nqtysubtotal) {
        this.nqtysubtotal = nqtysubtotal;
    }
    
    /**
     * 获取 金额小计
     * @return namountsubtotal
     */
    public Double getNamountsubtotal() {
        return namountsubtotal;
    }
    
    /**
     * 设置 金额小计
     * @param namountsubtotal 金额小计
     */
    public void setNamountsubtotal(Double namountsubtotal) {
        this.namountsubtotal = namountsubtotal;
    }
    
    /**
     * 获取 参考进价
     * @return nreferenceprice
     */
    public Double getNreferenceprice() {
        return nreferenceprice;
    }
    
    /**
     * 设置 参考进价
     * @param nreferenceprice 参考进价
     */
    public void setNreferenceprice(Double nreferenceprice) {
        this.nreferenceprice = nreferenceprice;
    }
    
    /**
     * 获取 进价金额
     * @return npurchaseprice
     */
    public Double getNpurchaseprice() {
        return npurchaseprice;
    }
    
    /**
     * 设置 进价金额
     * @param npurchaseprice 进价金额
     */
    public void setNpurchaseprice(Double npurchaseprice) {
        this.npurchaseprice = npurchaseprice;
    }
    
    /**
     * 获取 参考利润
     * @return nreferenceprofits
     */
    public Double getNreferenceprofits() {
        return nreferenceprofits;
    }
    
    /**
     * 设置 参考利润
     * @param nreferenceprofits 参考利润
     */
    public void setNreferenceprofits(Double nreferenceprofits) {
        this.nreferenceprofits = nreferenceprofits;
    }
    
    /**
     * 获取 主供应商
     * @return cmainsupplier
     */
    public String getCmainsupplier() {
        return cmainsupplier;
    }
    
    /**
     * 设置 主供应商
     * @param cmainsupplier 主供应商
     */
    public void setCmainsupplier(String cmainsupplier) {
        this.cmainsupplier = cmainsupplier;
    }
    
    /**
     * 获取 品牌
     * @return cbrand
     */
    public String getCbrand() {
        return cbrand;
    }
    
    /**
     * 设置 品牌
     * @param cbrand 品牌
     */
    public void setCbrand(String cbrand) {
        this.cbrand = cbrand;
    }
    
}
