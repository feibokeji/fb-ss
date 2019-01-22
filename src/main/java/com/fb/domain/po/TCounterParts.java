package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午4:11:03 
* 类说明:
* 同行类
*/
@TableMapper("t_conterparts")
public class TCounterParts extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -292214270607387738L;
	/**
	 * 主键
	 */
	@PrimaryKeyMapper
	private String uid;
	/**
	 * 用户表外键
	 */
	private String uuserid;
	/**
	 * 部门表外键
	 */
	private String udeptid;
	/**
	 * 商铺名称
	 */
	private String cshopname;
	/**
	 * 经营者
	 */
	private String coperator;
	/**
	 * 联系电话
	 */
	private String ctelephone;
	/**
	 * 微信
	 */
	private String cwechat;
	/**
	 * 地址
	 */
	private String caddress;
	/**
	 * 经营范围
	 */
	private String cbusinessscope;
	/**
	 * 经营状态
	 */
	private Integer ibusinessstatus;
	/**
	 * 账期天数
	 */
	private Integer ipaymentdays;
	/**
	 * 记录日期
	 */
	private Date drecorddate;
	/**
	 * 更新日期
	 */
	private Date dupdatedate;
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
	 * 获取:商铺名称
	 * @return cshopname
	 */
	public String getCshopname() {
		return cshopname;
	}
	/**
	 * 设置：商铺名称
	 * @param cshopname
	 */
	public void setCshopname(String cshopname) {
		this.cshopname = cshopname;
	}
	/**
	 * 获取:经营者
	 * @return coperator
	 */
	public String getCoperator() {
		return coperator;
	}
	/**
	 * 设置：经营者
	 * @param coperator
	 */
	public void setCoperator(String coperator) {
		this.coperator = coperator;
	}
	/**
	 * 获取:电话
	 * @return ctelephone
	 */
	public String getCtelephone() {
		return ctelephone;
	}
	/**
	 * 设置：电话
	 * @param ctelephone
	 */
	public void setCtelephone(String ctelephone) {
		this.ctelephone = ctelephone;
	}
	/**
	 * 获取:微信
	 * @return cwechat
	 */
	public String getCwechat() {
		return cwechat;
	}
	/**
	 * 设置：微信
	 * @param cwechat
	 */
	public void setCwechat(String cwechat) {
		this.cwechat = cwechat;
	}
	/**
	 * 获取:地址
	 * @return caddress
	 */
	public String getCaddress() {
		return caddress;
	}
	/**
	 * 设置：地址
	 * @param caddress
	 */
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	/**
	 * 获取:经营范围
	 * @return cbusinessscope
	 */
	public String getCbusinessscope() {
		return cbusinessscope;
	}
	/**
	 * 设置：经营范围
	 * @param cbuinessscope
	 */
	public void setCbusinessscope(String cbusinessscope) {
		this.cbusinessscope = cbusinessscope;
	}
	/**
	 * 获取:经营状态
	 * @return ibusinessstatus
	 */
	public Integer getIbusinessstatus() {
		return ibusinessstatus;
	}
	/**
	 * 设置：经营状态
	 * @param ibusinessstatus
	 */
	public void setIbuinessstatus(Integer ibusinessstatus) {
		this.ibusinessstatus = ibusinessstatus;
	}
	/**
	 * 获取:账期天数
	 * @return ipaymentdays
	 */
	public Integer getIpaymentdays() {
		return ipaymentdays;
	}
	/**
	 * 设置：账期天数
	 * @param ipaymentdays
	 */
	public void setIpaymentdays(Integer ipaymentdays) {
		this.ipaymentdays = ipaymentdays;
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
	}
	
}
