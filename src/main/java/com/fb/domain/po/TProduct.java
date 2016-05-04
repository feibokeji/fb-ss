package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 产品表
 * @since 2016年5月2日 下午7:26:41
 * @author Liu bo
 */
@TableMapper("t_product")
public class TProduct extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = 196147499997202876L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 类别外键
     */
    private String ucategoryid;
    
    /**
     * 类别名称
     */
    @NotFieldMapper
    private String ccategoryname;
    
    /**
     * 编码
     */
    private String cno;
    
    /**
     * 名称
     */
    private String cname;
    
    /**
     * 价格
     */
    private Double nprice;
    
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
     * 获取 类别外键
     * @return ucategoryid
     */
    public String getUcategoryid() {
        return ucategoryid;
    }
    
    /**
     * 设置 类别外键
     * @param ucategoryid 类别外键
     */
    public void setUcategoryid(String ucategoryid) {
        this.ucategoryid = ucategoryid;
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
    
}
