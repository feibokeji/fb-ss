package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月27日 下午2:47:50 
* 类说明:供应商单据明细类
*/
@TableMapper("t_supplier_order_detail")
public class TSupplierOrderDetail extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4170862451306042101L;
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
	 * 用户表外键
	 */
	private String uuserid;
	/**
	 * 用户名称
	 */
	@NotFieldMapper
	private String cusername;
	/**
	 * 部门表外键
	 */
	private String udeptid;
	/**
	 * 商品编号
	 */
	@NotFieldMapper
	private String cno;
	/**
	 * 商品条形码
	 */
	@NotFieldMapper
	private String cbarcode;
	/**
	 * 商品品牌名称
	 */
	@NotFieldMapper
	private String cbrandname;
	/**
	 * 商品类别名称
	 */
	@NotFieldMapper
	private String ccategoryname;
	/**
	 * 商品名称
	 */
	@NotFieldMapper
	private String cname;
	/**
	 * 商品单位名称
	 */
	@NotFieldMapper
	private String cunitname;
	/**
	 * 数量
	 */
	private Double nquantity;
	/**
	 * 价格
	 */
	private Double nprice;
	/**
	 * 金额
	 */
	private Double namount;
	/**
	 * 记录日期
	 */
	private Date drecorddate;
	/**
	 * 记录日期字符串
	 */
	@NotFieldMapper
	private String drecorddateStr;
	/**
	 * 更新日期
	 */
	private Date dupdatedate;
	/**
	 * 更新日期字符串
	 */
	@NotFieldMapper
	private String dupdatedateStr;
	/**
	 * 排序
	 */
	private Integer isort;
	/**
	 * 获取:主键
	 * @return uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * 设置：主键
	 * @param uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * 获取:单据表外键
	 * @return uorderid
	 */
	public String getUorderid() {
		return uorderid;
	}
	/**
	 * 设置：单据表外键
	 * @param uorderid
	 */
	public void setUorderid(String uorderid) {
		this.uorderid = uorderid;
	}
	/**
	 * 获取:其它商品表外键
	 * @return uothergoodsid
	 */
	public String getUothergoodsid() {
		return uothergoodsid;
	}
	/**
	 * 设置：其它商品表外键
	 * @param uothergoodsid
	 */
	public void setUothergoodsid(String uothergoodsid) {
		this.uothergoodsid = uothergoodsid;
	}
	/**
	 * 获取:商品编号
	 * @return cno
	 */
	public String getCno() {
		return cno;
	}
	/**
	 * 设置：商品编号
	 * @param cno
	 */
	public void setCno(String cno) {
		this.cno = cno;
	}
	/**
	 * 获取:商品条形码
	 * @return cbarcode
	 */
	public String getCbarcode() {
		return cbarcode;
	}
	/**
	 * 设置：商品条形码
	 * @param cbarcode
	 */
	public void setCbarcode(String cbarcode) {
		this.cbarcode = cbarcode;
	}
	/**
	 * 获取:商品品牌名称
	 * @return cbrandname
	 */
	public String getCbrandname() {
		return cbrandname;
	}
	/**
	 * 设置：商品品牌名称
	 * @param cbrandname
	 */
	public void setCbrandname(String cbrandname) {
		this.cbrandname = cbrandname;
	}
	/**
	 * 获取:商品类别名称
	 * @return ccategoryname
	 */
	public String getCcategoryname() {
		return ccategoryname;
	}
	/**
	 * 设置：商品类别名称
	 * @param ccategoryname
	 */
	public void setCcategoryname(String ccategoryname) {
		this.ccategoryname = ccategoryname;
	}
	/**
	 * 获取:商品名称
	 * @return cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * 设置：商品名称
	 * @param cname
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * 获取:商品单位名称
	 * @return cunitname
	 */
	public String getCunitname() {
		return cunitname;
	}
	/**
	 * 设置：商品单位名称
	 * @param cunitname
	 */
	public void setCunitname(String cunitname) {
		this.cunitname = cunitname;
	}
	/**
	 * 获取:数量
	 * @return nquantity
	 */
	public Double getNquantity() {
		return nquantity;
	}
	/**
	 * 设置：数量
	 * @param nquantity
	 */
	public void setNquantity(Double nquantity) {
		this.nquantity = nquantity;
	}
	/**
	 * 获取:价格
	 * @return nprice
	 */
	public Double getNprice() {
		return nprice;
	}
	/**
	 * 设置：价格
	 * @param nprice
	 */
	public void setNprice(Double nprice) {
		this.nprice = nprice;
	}
	/**
	 * 获取:金额
	 * @return namount
	 */
	public Double getNamount() {
		return namount;
	}
	/**
	 * 设置：金额
	 * @param namount
	 */
	public void setNamount(Double namount) {
		this.namount = namount;
	}
	/**
	 * 获取:记录日期
	 * @return drecorddate
	 */
	public Date getDrecorddate() {
		return drecorddate;
	}
	/**
	 * 设置：记录日期
	 * @param drecorddate
	 */
	public void setDrecorddate(Date drecorddate) {
		this.drecorddate = drecorddate;
		this.drecorddateStr = FormatUtils.formatDate(this.drecorddate, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 获取:记录日期字符串
	 * @return drecorddateStr
	 */
	public String getDrecorddateStr() {
		return drecorddateStr;
	}
	/**
	 * 设置：记录日期字符串
	 * @param drecorddateStr
	 */
	public void setDrecorddateStr(String drecorddateStr) {
		this.drecorddateStr = drecorddateStr;
	}
	/**
	 * 获取:更新日期
	 * @return dupdatedate
	 */
	public Date getDupdatedate() {
		return dupdatedate;
	}
	/**
	 * 设置：更新日期
	 * @param dupdatedate
	 */
	public void setDupdatedate(Date dupdatedate) {
		this.dupdatedate = dupdatedate;
		this.dupdatedateStr = FormatUtils.formatDate(this.dupdatedate, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 获取:更新日期字符串
	 * @return dupdatedateStr
	 */
	public String getDupdatedateStr() {
		return dupdatedateStr;
	}
	/**
	 * 设置：更新日期字符串
	 * @param dupdatedateStr
	 */
	public void setDupdatedateStr(String dupdatedateStr) {
		this.dupdatedateStr = dupdatedateStr;
	}
	/**
	 * 获取:排序
	 * @return isort
	 */
	public Integer getIsort() {
		return isort;
	}
	/**
	 * 设置：排序
	 * @param isort
	 */
	public void setIsort(Integer isort) {
		this.isort = isort;
	}
	/**
	 * 获取:用户表外键
	 * @return uuserid
	 */
	public String getUuserid() {
		return uuserid;
	}
	/**
	 * 设置：用户表外键
	 * @param uuserid
	 */
	public void setUuserid(String uuserid) {
		this.uuserid = uuserid;
	}
	/**
	 * 获取:用户名称
	 * @return cusername
	 */
	public String getCusername() {
		return cusername;
	}
	/**
	 * 设置：用户名称
	 * @param cusername
	 */
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	/**
	 * 获取:部门表外键
	 * @return udeptid
	 */
	public String getUdeptid() {
		return udeptid;
	}
	/**
	 * 设置：部门表外键
	 * @param udeptid
	 */
	public void setUdeptid(String udeptid) {
		this.udeptid = udeptid;
	}
}
