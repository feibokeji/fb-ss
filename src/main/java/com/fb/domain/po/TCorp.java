package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 企业基本信息表
 * 
 * @since 2015-6-10 下午6:38:39
 * @author Liu bo
 */
@TableMapper("t_corp")
public class TCorp extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1899502498115407620L;

	/**
	 * 唯一ID
	 */
	@PrimaryKeyMapper
	private String uid;

	/**
	 * 企业代码
	 */
	private String ccode;

	/**
	 * 企业名称
	 */
	private String cname;

	/**
	 * 企业英文名称
	 */
	private String cnameen;

	/**
	 * 企业简称
	 */
	private String cnameab;

	/**
	 * 企业负责人
	 */
	private String cprincipal;

	/**
	 * 税务登记号
	 */
	private String ctaxno;

	/**
	 * 企业地址
	 */
	private String caddr;

	/**
	 * 邮编
	 */
	private String czip;

	/**
	 * 传真号
	 */
	private String cfax;

	/**
	 * 总机电话
	 */
	private String ctelgeneral;

	/**
	 * 值班电话
	 */
	private String ctelguard;

	/**
	 * 电子邮件地址
	 */
	private String cemail;

	/**
	 * 网站地址
	 */
	private String cwebsite;

	/**
	 * 备注
	 */
	private String cmemo;

	/**
	 * 所在省份
	 */
	private String cprovinces;

	/**
	 * 所在城市
	 */
	private String ccity;

	/**
	 * 信息创建时间
	 */
	private Date dcreatetime;

	/**
	 * 信息更新时间
	 */
	private Date dupdatetime;

	/**
	 * 获取 唯一ID
	 * 
	 * @return uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * 设置 唯一ID
	 * 
	 * @param uid
	 *            唯一ID
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * 获取 企业代码
	 * 
	 * @return ccode
	 */
	public String getCcode() {
		return ccode;
	}

	/**
	 * 设置 企业代码
	 * 
	 * @param ccode
	 *            企业代码
	 */
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	/**
	 * 获取 企业名称
	 * 
	 * @return cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * 设置 企业名称
	 * 
	 * @param cname
	 *            企业名称
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * 获取 企业英文名称
	 * 
	 * @return cnameen
	 */
	public String getCnameen() {
		return cnameen;
	}

	/**
	 * 设置 企业英文名称
	 * 
	 * @param cnameen
	 *            企业英文名称
	 */
	public void setCnameen(String cnameen) {
		this.cnameen = cnameen;
	}

	/**
	 * 获取 企业简称
	 * 
	 * @return cnameab
	 */
	public String getCnameab() {
		return cnameab;
	}

	/**
	 * 设置 企业简称
	 * 
	 * @param cnameab
	 *            企业简称
	 */
	public void setCnameab(String cnameab) {
		this.cnameab = cnameab;
	}

	/**
	 * 获取 企业负责人
	 * 
	 * @return cprincipal
	 */
	public String getCprincipal() {
		return cprincipal;
	}

	/**
	 * 设置 企业负责人
	 * 
	 * @param cprincipal
	 *            企业负责人
	 */
	public void setCprincipal(String cprincipal) {
		this.cprincipal = cprincipal;
	}

	/**
	 * 获取 税务登记号
	 * 
	 * @return ctaxno
	 */
	public String getCtaxno() {
		return ctaxno;
	}

	/**
	 * 设置 税务登记号
	 * 
	 * @param ctaxno
	 *            税务登记号
	 */
	public void setCtaxno(String ctaxno) {
		this.ctaxno = ctaxno;
	}

	/**
	 * 获取 企业地址
	 * 
	 * @return caddr
	 */
	public String getCaddr() {
		return caddr;
	}

	/**
	 * 设置 企业地址
	 * 
	 * @param caddr
	 *            企业地址
	 */
	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}

	/**
	 * 获取 邮编
	 * 
	 * @return czip
	 */
	public String getCzip() {
		return czip;
	}

	/**
	 * 设置 邮编
	 * 
	 * @param czip
	 *            邮编
	 */
	public void setCzip(String czip) {
		this.czip = czip;
	}

	/**
	 * 获取 传真号
	 * 
	 * @return cfax
	 */
	public String getCfax() {
		return cfax;
	}

	/**
	 * 设置 传真号
	 * 
	 * @param cfax
	 *            传真号
	 */
	public void setCfax(String cfax) {
		this.cfax = cfax;
	}

	/**
	 * 获取 总机电话
	 * 
	 * @return ctelgeneral
	 */
	public String getCtelgeneral() {
		return ctelgeneral;
	}

	/**
	 * 设置 总机电话
	 * 
	 * @param ctelgeneral
	 *            总机电话
	 */
	public void setCtelgeneral(String ctelgeneral) {
		this.ctelgeneral = ctelgeneral;
	}

	/**
	 * 获取 值班电话
	 * 
	 * @return ctelguard
	 */
	public String getCtelguard() {
		return ctelguard;
	}

	/**
	 * 设置 值班电话
	 * 
	 * @param ctelguard
	 *            值班电话
	 */
	public void setCtelguard(String ctelguard) {
		this.ctelguard = ctelguard;
	}

	/**
	 * 获取 电子邮件地址
	 * 
	 * @return cemail
	 */
	public String getCemail() {
		return cemail;
	}

	/**
	 * 设置 电子邮件地址
	 * 
	 * @param cemail
	 *            电子邮件地址
	 */
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	/**
	 * 获取 网站地址
	 * 
	 * @return cwebsite
	 */
	public String getCwebsite() {
		return cwebsite;
	}

	/**
	 * 设置 网站地址
	 * 
	 * @param cwebsite
	 *            网站地址
	 */
	public void setCwebsite(String cwebsite) {
		this.cwebsite = cwebsite;
	}

	/**
	 * 获取 备注
	 * 
	 * @return cmemo
	 */
	public String getCmemo() {
		return cmemo;
	}

	/**
	 * 设置 备注
	 * 
	 * @param cmemo
	 *            备注
	 */
	public void setCmemo(String cmemo) {
		this.cmemo = cmemo;
	}

	/**
	 * 获取 所在城市
	 * 
	 * @return ccity
	 */
	public String getCcity() {
		return ccity;
	}

	/**
	 * 设置 所在城市
	 * 
	 * @param ccity
	 *            所在城市
	 */
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}

	/**
	 * 获取 信息创建时间
	 * 
	 * @return dcreatetime
	 */
	public Date getDcreatetime() {
		return dcreatetime;
	}

	/**
	 * 设置 信息创建时间
	 * 
	 * @param dcreatetime
	 *            信息创建时间
	 */
	public void setDcreatetime(Date dcreatetime) {
		this.dcreatetime = dcreatetime;
	}

	/**
	 * 获取 信息更新时间
	 * 
	 * @return dupdatetime
	 */
	public Date getDupdatetime() {
		return dupdatetime;
	}

	/**
	 * 设置 信息更新时间
	 * 
	 * @param dupdatetime
	 *            信息更新时间
	 */
	public void setDupdatetime(Date dupdatetime) {
		this.dupdatetime = dupdatetime;
	}

	/**
	 * 设置 所在省份
	 * @return the cprovinces
	 */
	public String getCprovinces() {
		return cprovinces;
	}

	/**
	 * 获取 所在省份
	 * @param cprovinces
	 */
	public void setCprovinces(String cprovinces) {
		this.cprovinces = cprovinces;
	}

}
