package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 产品物料关联表
 * @since 2016年5月3日 下午7:21:57
 * @author Liu bo
 */
@TableMapper("t_product_material")
public class TProductMaterial extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7365570331776629697L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 产品外键
     */
    private String uproductid;
    
    /**
     * 物料外键
     */
    private String umaterialid;
    
    /**
     * 数量
     */
    private Double nqty;
    
    /**
     * 是否启用
     * <li>0 - 启用[默认]
     * <li>1 - 停用
     */
    private Integer ienablesign;
    
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
     * 获取 物料外键
     * @return umaterialid
     */
    public String getUmaterialid() {
        return umaterialid;
    }
    
    /**
     * 设置 物料外键
     * @param umaterialid 物料外键
     */
    public void setUmaterialid(String umaterialid) {
        this.umaterialid = umaterialid;
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
     * 获取 是否启用
     * <li>0 - 启用[默认]
     * <li>1 - 停用
     * @return ienablesign
     */
    public Integer getIenablesign() {
        return ienablesign;
    }
    
    /**
     * 设置 是否启用
     * <li>0 - 启用[默认]
     * <li>1 - 停用
     * @param ienablesign 是否启用
     *            <li>0 - 启用[默认]
     *            <li>1 - 停用
     */
    public void setIenablesign(Integer ienablesign) {
        this.ienablesign = ienablesign;
    }
    
}
