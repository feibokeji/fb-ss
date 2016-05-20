package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.TableMapper;

/**
 * 盘点差异表
 * @since 2016年5月20日 下午12:38:41
 * @author Liu bo
 */
@TableMapper("t_material_check_diff")
public class TMaterialCheckDiff extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7337775756954576393L;
    
    /**
     * 主键
     */
    private String uid;
    
    /**
     * 盘点单外键
     */
    private String uorderid;
    
    /**
     * 物料外键
     */
    private String umaterialid;
    
    /**
     * 物料名称
     */
    private String cmaterialname;
    
    /**
     * 差异数
     */
    private Double nqty;
    
    /**
     * 系统库存
     */
    private Double nqty1;
    
    /**
     * 实盘库存
     */
    private Double nqty2;
    
    /**
     * 生成差异日期
     */
    private Date dcreatetime;
    
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
     * 获取 盘点单外键
     * @return uorderid
     */
    public String getUorderid() {
        return uorderid;
    }
    
    /**
     * 设置 盘点单外键
     * @param uorderid 盘点单外键
     */
    public void setUorderid(String uorderid) {
        this.uorderid = uorderid;
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
     * 获取 物料名称
     * @return cmaterialname
     */
    public String getCmaterialname() {
        return cmaterialname;
    }
    
    /**
     * 设置 物料名称
     * @param cmaterialname 物料名称
     */
    public void setCmaterialname(String cmaterialname) {
        this.cmaterialname = cmaterialname;
    }
    
    /**
     * 获取 系统库存
     * @return nqty1
     */
    public Double getNqty1() {
        return nqty1;
    }
    
    /**
     * 设置 系统库存
     * @param nqty1 系统库存
     */
    public void setNqty1(Double nqty1) {
        this.nqty1 = nqty1;
    }
    
    /**
     * 获取 实盘库存
     * @return nqty2
     */
    public Double getNqty2() {
        return nqty2;
    }
    
    /**
     * 设置 实盘库存
     * @param nqty2 实盘库存
     */
    public void setNqty2(Double nqty2) {
        this.nqty2 = nqty2;
    }
    
    /**
     * 获取 生成差异日期
     * @return dcreatetime
     */
    public Date getDcreatetime() {
        return dcreatetime;
    }
    
    /**
     * 设置 生成差异日期
     * @param dcreatetime 生成差异日期
     */
    public void setDcreatetime(Date dcreatetime) {
        this.dcreatetime = dcreatetime;
    }
    
    /**
     * 获取 差异数
     * @return nqty
     */
    public Double getNqty() {
        return nqty;
    }
    
    /**
     * 设置 差异数
     * @param nqty 差异数
     */
    public void setNqty(Double nqty) {
        this.nqty = nqty;
    }
    
}
