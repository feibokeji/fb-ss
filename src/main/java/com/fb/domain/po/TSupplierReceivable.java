package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月27日 下午3:11:04 
* 类说明:供应商应收应付类
*/
@TableMapper("t_supplier_receivable")
public class TSupplierReceivable extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8180979729055360116L;
	/**
	 * 主键
	 */
	@PrimaryKeyMapper
	private String uid;
	/**
	 * 供应商表外键
	 */
	private String usupplierid;
	/**
	 * 供应商名称
	 */
	@NotFieldMapper
	private String csuppliername;
	/**
	 * 单据表外键
	 */
	private String uorderid;
	/**
	 * 单据编号
	 */
	@NotFieldMapper
	private String corderno;
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
	 * 应收或应付
	 * AR-应收
	 * AP-应付
	 */
	private String ctype;
	/**
	 * 应收或应付字符串
	 */
	@NotFieldMapper
	private String ctypeStr;
	/**
	 * 实际金额
	 */
	private Double nactualamount;
	/**
	 * 折扣
	 */
	private Double ndiscount;
	/**
	 * 金额
	 */
	private Double namount;
	/**
	 * 状态
	 * 0-未结算
	 * 1-已结算
	 */
	private Integer istatus;
	/**
	 * 状态字符串
	 */
	@NotFieldMapper
	private String istatusStr;
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
	 * 记录日期字符串最小值
	 */
	@NotFieldMapper
	private String drecorddateStrMin;
	/**
	 * 记录日期字符串最大值
	 */
	@NotFieldMapper
	private String drecorddateStrMax;
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
	 * 更新日期字符串最小值
	 */
	@NotFieldMapper
	private String dupdatedateStrMin;
	/**
	 * 更新日期字符串最大值
	 */
	@NotFieldMapper
	private String dupdatedateStrMax;
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
	 * 获取:供应商表外键
	 * @return usupplierid
	 */
	public String getUsupplierid() {
		return usupplierid;
	}
	/**
	 * 设置：供应商表外键
	 * @param usupplierid
	 */
	public void setUsupplierid(String usupplierid) {
		this.usupplierid = usupplierid;
	}
	/**
	 * 获取:供应商名称
	 * @return csuppliername
	 */
	public String getCsuppliername() {
		return csuppliername;
	}
	/**
	 * 设置：供应商名称
	 * @param csuppliername
	 */
	public void setCsuppliername(String csuppliername) {
		this.csuppliername = csuppliername;
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
	 * 获取:单据编号
	 * @return corderno
	 */
	public String getCorderno() {
		return corderno;
	}
	/**
	 * 设置：单据编号
	 * @param corderno
	 */
	public void setCorderno(String corderno) {
		this.corderno = corderno;
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
	/**
	 * 获取:应收或应付
	 * AR-应收
	 * AP-应付
	 * @return ctype
	 */
	public String getCtype() {
		return ctype;
	}
	/**
	 * 设置：应收或应付
	 * AR-应收
	 * AP-应付
	 * @param ctype
	 */
	public void setCtype(String ctype) {
		this.ctype = ctype;
		if(this.ctype.equals("AR"))
			this.ctypeStr = "应收";
		else if(this.ctype.equals("AP"))
			this.ctypeStr = "应付";
	}
	/**
	 * 获取:实际金额
	 * @return nactualamount
	 */
	public Double getNactualamount() {
		return nactualamount;
	}
	/**
	 * 设置：实际金额
	 * @param nactualamount
	 */
	public void setNactualamount(Double nactualamount) {
		this.nactualamount = nactualamount;
	}
	/**
	 * 获取:折扣
	 * @return ndiscount
	 */
	public Double getNdiscount() {
		return ndiscount;
	}
	/**
	 * 设置：折扣
	 * @param ndiscount
	 */
	public void setNdiscount(Double ndiscount) {
		this.ndiscount = ndiscount;
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
	 * 获取:状态
	 * @return istatus
	 */
	public Integer getIstatus() {
		return istatus;
	}
	/**
	 * 设置：状态
	 * @param istatus
	 */
	public void setIstatus(Integer istatus) {
		this.istatus = istatus;
		switch(this.istatus){
		    case 0:
		        this.istatusStr = "未结算";
		        break;
		    case 1:
		        this.istatusStr = "已结算";
		        break;
		}
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
	 * 获取:状态字符串
	 * @return istatusStr
	 */
	public String getIstatusStr() {
		return istatusStr;
	}
	/**
	 * 设置：状态字符串
	 * @param istatusStr
	 */
	public void setIstatusStr(String istatusStr) {
		this.istatusStr = istatusStr;
	}
	/**
	 * 获取:记录日期字符串最小值
	 * @return drecorddateStrMin
	 */
	public String getDrecorddateStrMin() {
		return drecorddateStrMin;
	}
	/**
	 * 设置：记录日期字符串最小值
	 * @param drecorddateStrMin
	 */
	public void setDrecorddateStrMin(String drecorddateStrMin) {
		this.drecorddateStrMin = drecorddateStrMin;
	}
	/**
	 * 获取:记录日期字符串最大值
	 * @return drecorddateStrMax
	 */
	public String getDrecorddateStrMax() {
		return drecorddateStrMax;
	}
	/**
	 * 设置：记录日期字符串最大值
	 * @param drecorddateStrMax
	 */
	public void setDrecorddateStrMax(String drecorddateStrMax) {
		this.drecorddateStrMax = drecorddateStrMax;
	}
	/**
	 * 获取:更新日期字符串最小值
	 * @return dupdatedateStrMin
	 */
	public String getDupdatedateStrMin() {
		return dupdatedateStrMin;
	}
	/**
	 * 设置：更新日期字符串最小值
	 * @param dupdatedateStrMin
	 */
	public void setDupdatedateStrMin(String dupdatedateStrMin) {
		this.dupdatedateStrMin = dupdatedateStrMin;
	}
	/**
	 * 获取:更新日期字符串最大值
	 * @return dupdatedateStrMax
	 */
	public String getDupdatedateStrMax() {
		return dupdatedateStrMax;
	}
	/**
	 * 设置：更新日期字符串最大值
	 * @param dupdatedateStrMax
	 */
	public void setDupdatedateStrMax(String dupdatedateStrMax) {
		this.dupdatedateStrMax = dupdatedateStrMax;
	}
	/**
	 * 获取:应收应付字符串
	 * @return ctypeStr
	 */
	public String getCtypeStr() {
		return ctypeStr;
	}
	/**
	 * 设置：应收应付字符串
	 * @param ctypeStr
	 */
	public void setCtypeStr(String ctypeStr) {
		this.ctypeStr = ctypeStr;
	}
}
