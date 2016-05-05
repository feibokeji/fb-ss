package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 物料类
 * @since 2016年5月3日 下午4:09:29
 * @author Liu bo
 */
@TableMapper("t_material")
public class TMaterial extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6922707781833980523L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 关联的产品外键
     */
    @NotFieldMapper
    private String uproductid;
    
    /**
     * 物料是否已关联产品
     */
    @NotFieldMapper
    private Integer haveProduct;
    
    /**
     * 编码
     */
    private String cno;
    
    /**
     * 名称
     */
    private String cname;
    
    /**
     * 规格
     */
    private String cspecifications;
    
    /**
     * 价格
     */
    private Double nprice;
    
    /**
     * 数量
     */
    @NotFieldMapper
    private Double nqty = 1.0;
    
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
     * 获取 编码
     * @return cno
     */
    public String getCno() {
        return cno;
    }
    
    /**
     * 设置 编码
     * @param cno 编码
     */
    public void setCno(String cno) {
        this.cno = cno;
    }
    
    /**
     * 获取 名称
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 名称
     * @param cname 名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    /**
     * 获取 规格
     * @return cspecifications
     */
    public String getCspecifications() {
        return cspecifications;
    }
    
    /**
     * 设置 规格
     * @param cspecifications 规格
     */
    public void setCspecifications(String cspecifications) {
        this.cspecifications = cspecifications;
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
     * 获取 物料是否已关联产品
     * @return haveProduct
     */
    public Integer getHaveProduct() {
        return haveProduct;
    }
    
    /**
     * 设置 物料是否已关联产品
     * @param haveProduct 物料是否已关联产品
     */
    public void setHaveProduct(Integer haveProduct) {
        this.haveProduct = haveProduct;
    }
    
    /**
     * 获取 关联的产品外键
     * @return uproductid
     */
    public String getUproductid() {
        return uproductid;
    }
    
    /**
     * 设置 关联的产品外键
     * @param uproductid 关联的产品外键
     */
    public void setUproductid(String uproductid) {
        this.uproductid = uproductid;
    }
    
}
