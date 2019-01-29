package com.fb.domain.po;

import java.util.Date;
import java.util.List;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月27日 上午10:18:39 
* 类说明:供应商单据类
*/
@TableMapper("t_supplier_order")
public class TSupplierOrder extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4499002493134161915L;
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
	 * 单据编号
	 */
	private String cno;
	/**
	 * 单据类型
	 * 0-入库单
	 * 1-退库单
	 * 2-报损单
	 */
	private Integer itype;
	/**
	 * 单据类型字符串
	 */
	@NotFieldMapper
	private String itypeStr;
	/**
	 * 单据状态
	 * 0-已审核
	 * 1-未审核
	 */
	private Integer istatus;
	/**
	 * 单据状态字符串
	 */
	@NotFieldMapper
	private String istatusStr;
	/**
	 * 单据记录日期
	 */
	private Date drecorddate;
	/**
	 * 单据记录日期字符串格式
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
	 * 单据更新日期
	 */
	private Date dupdatedate;
	/**
	 * 单据更新日期字符串格式
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
	 * 单据明细集合
	 */
	@NotFieldMapper
	private List<TSupplierOrderDetail> orderDetailList;
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
	 * 获取:单据编号
	 * @return cno
	 */
	public String getCno() {
		return cno;
	}
	/**
	 * 设置：单据编号
	 * @param cno
	 */
	public void setCno(String cno) {
		this.cno = cno;
	}
	/**
	 * 获取:单据类型
	 * @return itype
	 */
	public Integer getItype() {
		return itype;
	}
	/**
	 * 设置：单据类型
	 * @param itype
	 */
	public void setItype(Integer itype) {
		this.itype = itype;
		switch (this.itype) {
		case 0:
			this.itypeStr = "入库单";
			break;
		case 1:
			this.itypeStr = "退货单";
			break;
		case 2:
			this.itypeStr = "报损单";
			break;
		default:
			break;
		}
	}
	/**
	 * 获取:单据状态
	 * @return istatus
	 */
	public Integer getIstatus() {
		return istatus;
	}
	/**
	 * 设置：单据状态
	 * @param istatus
	 */
	public void setIstatus(Integer istatus) {
		this.istatus = istatus;
		switch (this.istatus) {
		case 0:
			this.istatusStr = "已审核";
			break;
		case 1:
			this.istatusStr = "未审核";
			break;
		default:
			break;
		}
	}
	/**
	 * 获取:单据记录日期
	 * @return drecorddate
	 */
	public Date getDrecorddate() {
		return drecorddate;
	}
	/**
	 * 设置：单据记录日期
	 * @param drecorddate
	 */
	public void setDrecorddate(Date drecorddate) {
		this.drecorddate = drecorddate;
		this.drecorddateStr = FormatUtils.formatDate(this.drecorddate, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 获取:单据记录日期字符串格式
	 * @return drecorddateStr
	 */
	public String getDrecorddateStr() {
		return drecorddateStr;
	}
	/**
	 * 设置：单据记录日期字符串格式
	 * @param drecorddateStr
	 */
	public void setDrecorddateStr(String drecorddateStr) {
		this.drecorddateStr = drecorddateStr;
	}
	/**
	 * 获取:单据更新日期
	 * @return dupdatedate
	 */
	public Date getDupdatedate() {
		return dupdatedate;
	}
	/**
	 * 设置：单据更新日期
	 * @param dupdatedate
	 */
	public void setDupdatedate(Date dupdatedate) {
		this.dupdatedate = dupdatedate;
		this.dupdatedateStr = FormatUtils.formatDate(this.dupdatedate, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 获取:单据更新日期字符串格式
	 * @return dupdatedateStr
	 */
	public String getDupdatedateStr() {
		return dupdatedateStr;
	}
	/**
	 * 设置：单据更新日期字符串格式
	 * @param dupdatedateStr
	 */
	public void setDupdatedateStr(String dupdatedateStr) {
		this.dupdatedateStr = dupdatedateStr;
	}
	/**
	 * 获取:单据明细集合
	 * @return orderDetailList
	 */
	public List<TSupplierOrderDetail> getOrderDetailList() {
		return orderDetailList;
	}
	/**
	 * 设置：单据明细集合
	 * @param orderDetailList
	 */
	public void setOrderDetailList(List<TSupplierOrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	/**
	 * 获取:单据类型字符串
	 * @return itypeStr
	 */
	public String getItypeStr() {
		return itypeStr;
	}
	/**
	 * 设置：单据类型字符串
	 * @param itypeStr
	 */
	public void setItypeStr(String itypeStr) {
		this.itypeStr = itypeStr;
	}
	/**
	 * 获取:单据状态字符串
	 * @return istatusStr
	 */
	public String getIstatusStr() {
		return istatusStr;
	}
	/**
	 * 设置：单据状态字符串
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
}
