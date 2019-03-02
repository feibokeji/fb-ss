package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月1日 下午6:54:30
 * 客户单据明细表
 */
@TableMapper("t_customer_order_detail")
public class TCustomerOrderDetail extends BaseDomain {

    /**
     * 
     */
    private static final long serialVersionUID = -181238436029106981L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 单据表外键
     */
    private String uorderid;
    
    /**
     * 商品表外键
     */
    private String uothergoodsid;
    
    /**
     * 类别名称
     */
    @NotFieldMapper
    private String ccategoryname;
    
    /**
     * 品牌名称
     */
    @NotFieldMapper
    private String cbrandname;
    
    /**
     * 商品编号
     */
    @NotFieldMapper
    private String cothergoodsno;
    
    /**
     * 商品条形码
     */
    @NotFieldMapper
    private String cothergoodsbarcode;
    
    /**
     * 商品名称
     */
    @NotFieldMapper
    private String cothergoodsname;
    
    /**
     * 商品规格
     */
    @NotFieldMapper
    private String cspecifications;
    
    /**
     * 用户表外键
     */
    private String uuserid;
    
    /**
     * 部门表外键
     */
    private String udeptid;
    
    /**
     * 单位名称
     */
    @NotFieldMapper
    private String cunitname;
    
    /**
     * 价格
     */
    private Double nprice;
    
    /**
     * 数量
     */
    private Double nquantity;
    
    /**
     * 金额
     */
    private Double namount;
    
    /**
     * 记录日期
     */
    private Date drecorddate;
    
    /**
     * 记录日期
     */
    @NotFieldMapper
    private String drecorddateStr;
    
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
     * 序号
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
     * 获取 单据表外键
     * @return uorderid
     */
    public String getUorderid() {
        return uorderid;
    }
    

    
    /**
     * 设置 单据表外键
     * @param uorderid 单据表外键
     */
    public void setUorderid(String uorderid) {
        this.uorderid = uorderid;
    }
    

    
    /**
     * 获取 商品表外键
     * @return uothergoodsid
     */
    public String getUothergoodsid() {
        return uothergoodsid;
    }
    

    
    /**
     * 设置 商品表外键
     * @param uothergoodsid 商品表外键
     */
    public void setUothergoodsid(String uothergoodsid) {
        this.uothergoodsid = uothergoodsid;
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
     * 获取 品牌名称
     * @return cbrandname
     */
    public String getCbrandname() {
        return cbrandname;
    }
    

    
    /**
     * 设置 品牌名称
     * @param cbrandname 品牌名称
     */
    public void setCbrandname(String cbrandname) {
        this.cbrandname = cbrandname;
    }
    

    
    /**
     * 获取 商品编号
     * @return cothergoodsno
     */
    public String getCothergoodsno() {
        return cothergoodsno;
    }
    

    
    /**
     * 设置 商品编号
     * @param cothergoodsno 商品编号
     */
    public void setCothergoodsno(String cothergoodsno) {
        this.cothergoodsno = cothergoodsno;
    }
    

    
    /**
     * 获取 商品条形码
     * @return cothergoodsbarcode
     */
    public String getCothergoodsbarcode() {
        return cothergoodsbarcode;
    }
    

    
    /**
     * 设置 商品条形码
     * @param cothergoodsbarcode 商品条形码
     */
    public void setCothergoodsbarcode(String cothergoodsbarcode) {
        this.cothergoodsbarcode = cothergoodsbarcode;
    }
    

    
    /**
     * 获取 商品名称
     * @return cothergoodsname
     */
    public String getCothergoodsname() {
        return cothergoodsname;
    }
    

    
    /**
     * 设置 商品名称
     * @param cothergoodsname 商品名称
     */
    public void setCothergoodsname(String cothergoodsname) {
        this.cothergoodsname = cothergoodsname;
    }
    

    
    /**
     * 获取 商品规格
     * @return cspecifications
     */
    public String getCspecifications() {
        return cspecifications;
    }
    

    
    /**
     * 设置 商品规格
     * @param cspecifications 商品规格
     */
    public void setCspecifications(String cspecifications) {
        this.cspecifications = cspecifications;
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
     * 获取 单位名称
     * @return cunitname
     */
    public String getCunitname() {
        return cunitname;
    }
    

    
    /**
     * 设置 单位名称
     * @param cunitname 单位名称
     */
    public void setCunitname(String cunitname) {
        this.cunitname = cunitname;
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
     * @return nquantity
     */
    public Double getNquantity() {
        return nquantity;
    }
    

    
    /**
     * 设置 数量
     * @param nquantity 数量
     */
    public void setNquantity(Double nquantity) {
        this.nquantity = nquantity;
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
     * 获取 记录日期
     * @return drecorddate
     */
    public Date getDrecorddate() {
        return drecorddate;
    }
    

    
    /**
     * 设置 记录日期
     * @param drecorddate 记录日期
     */
    public void setDrecorddate(Date drecorddate) {
        this.drecorddate = drecorddate;
        this.drecorddateStr = FormatUtils.formatDate(drecorddate, "yyyy-MM-dd HH:mm:ss");
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
    
    
}
