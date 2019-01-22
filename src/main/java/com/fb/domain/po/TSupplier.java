package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午3:28:17 
* 类说明:
* 供应商类
*/
@TableMapper("t_supplier")
public class TSupplier extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8288257940291062725L;
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
	 * 编号
	 */
	private String cno;
	/**
	 * 名称
	 */
	private String cname;
	/**
	 * 经营范围
	 */
	private String cbusinessscope;
	/**
	 * 地址
	 */
	private String caddress;
	/**
	 * 固定电话
	 */
	private String cfixedtelephone;
	/**
	 * 联系人
	 */
	private String clinkman;
	/**
	 * 联系电话
	 */
	private String ccontactnumber;
	/**
	 * email
	 */
	private String cemail;
	/**
	 * qq
	 */
	private String cqq;
	/**
	 * 微信
	 */
	private String cwechat;
	/**
	 * 开户行
	 */
	private String copenbank;
	/**
	 * 银行卡号
	 */
	private String cbankcardnumber;
	/**
	 * 账期天数
	 */
	private Integer ipaymentdays;
	/**
	 * 账期天数最小值
	 */
	@NotFieldMapper
	private Integer ipaymentdaysMin;
	/**
	 * 账期天数最大值
	 */
	@NotFieldMapper
	private Integer ipaymentdaysMax;
	/**
	 * 记录日期
	 */
	private Date drecorddate;
	/**
	 * 记录日期的字符串格式
	 */
	@NotFieldMapper
	private String drecorddateStr;
	/**
	 * 记录日期最小值
	 */
	@NotFieldMapper
	private String drecorddateMin;
	/**
	 * 记录日期最大值
	 */
	@NotFieldMapper
	private String drecorddateMax;
	/**
	 * 更新日期
	 */
	private Date dupdatedate;
	/**
	 * 更新日期的字符串格式
	 */
	@NotFieldMapper
	private String dupdatedateStr;
	/**
	 * 获取 主键
	 * @return uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * 设置 主键
	 * @param uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
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
	 * @param uuserid
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
	 * @param udeptid
	 */
	public void setUdeptid(String udeptid) {
		this.udeptid = udeptid;
	}
	/**
	 * 获取 编号
	 * @return cno
	 */
	public String getCno() {
		return cno;
	}
	/**
	 * 设置 编号
	 * @param cno
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
	 * @param cname
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * 获取 经营范围
	 * @return the cbusinessscope
	 */
	public String getCbusinessscope() {
		return cbusinessscope;
	}
	/**
	 * 设置 经营范围
	 * @param cbusinessscope
	 */
	public void setCbusinessscope(String cbusinessscope) {
		this.cbusinessscope = cbusinessscope;
	}
	/**
	 * 获取 地址
	 * @return caddress
	 */
	public String getCaddress() {
		return caddress;
	}
	/**
	 * 设置 地址
	 * @param caddress
	 */
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	/**
	 * 获取 固定电话
	 * @return cfixedtelephone
	 */
	public String getCfixedtelephone() {
		return cfixedtelephone;
	}
	/**
	 * 设置 固定电话
	 * @param cfixedtelephone
	 */
	public void setCfixedtelephone(String cfixedtelephone) {
		this.cfixedtelephone = cfixedtelephone;
	}
	/**
	 * 获取 联系人
	 * @return clinkman
	 */
	public String getClinkman() {
		return clinkman;
	}
	/**
	 * 设置 联系人
	 * @param clinkman
	 */
	public void setClinkman(String clinkman) {
		this.clinkman = clinkman;
	}
	/**
	 * 获取 联系电话
	 * @return the ccontactnumber
	 */
	public String getCcontactnumber() {
		return ccontactnumber;
	}
	/**
	 * 设置 联系电话
	 * @param ccontactnumber
	 */
	public void setCcontactnumber(String ccontactnumber) {
		this.ccontactnumber = ccontactnumber;
	}
	/**
	 * 获取 email
	 * @return cemail
	 */
	public String getCemail() {
		return cemail;
	}
	/**
	 * 设置 email
	 * @param cemail
	 */
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	/**
	 * 获取 qq
	 * @return cqq
	 */
	public String getCqq() {
		return cqq;
	}
	/**
	 * 设置 qq
	 * @param cqq
	 */
	public void setCqq(String cqq) {
		this.cqq = cqq;
	}
	/**
	 * 获取 微信
	 * @return cwechat
	 */
	public String getCwechat() {
		return cwechat;
	}
	/**
	 * 设置 微信
	 * @param cwechat
	 */
	public void setCwechat(String cwechat) {
		this.cwechat = cwechat;
	}
	/**
	 * 获取 开户行
	 * @return copenbank
	 */
	public String getCopenbank() {
		return copenbank;
	}
	/**
	 * 设置 开户行
	 * @param copenbank
	 */
	public void setCopenbank(String copenbank) {
		this.copenbank = copenbank;
	}
	/**
	 * 获取 银行卡号
	 * @return cbankcardnumber
	 */
	public String getCbankcardnumber() {
		return cbankcardnumber;
	}
	/**
	 * 设置 银行卡号
	 * @param cbankcardnumber
	 */
	public void setCbankcardnumber(String cbankcardnumber) {
		this.cbankcardnumber = cbankcardnumber;
	}
	/**
	 * 获取 账期天数
	 * @return ipaymentdays
	 */
	public Integer getIpaymentdays() {
		return ipaymentdays;
	}
	/**
	 * 设置 账期天数
	 * @param ipaymentdays
	 */
	public void setIpaymentdays(Integer ipaymentdays) {
		this.ipaymentdays = ipaymentdays;
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
	 * @param drecorddate
	 */
	public void setDrecorddate(Date drecorddate) {
		this.drecorddate = drecorddate;
		this.drecorddateStr = FormatUtils.formatDate(this.drecorddate, "yyyy-MM-dd HH-mm-ss");
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
	 * @param dupdatedate
	 */
	public void setDupdatedate(Date dupdatedate) {
		this.dupdatedate = dupdatedate;
		this.dupdatedateStr = FormatUtils.formatDate(this.dupdatedate, "yyyy-MM-dd HH-mm-ss");
	}
	/**
	 * 获取:记录日期的字符串格式
	 * @return drecorddateStr
	 */
	public String getDrecorddateStr() {
		return drecorddateStr;
	}
	/**
	 * 设置：记录日期的字符串格式
	 * @param drecorddateStr
	 */
	public void setDrecorddateStr(String drecorddateStr) {
		this.drecorddateStr = drecorddateStr;
	}
	/**
	 * 获取:更新日期的字符串格式
	 * @return dupdatedateStr
	 */
	public String getDupdatedateStr() {
		return dupdatedateStr;
	}
	/**
	 * 设置：更新日期的字符串格式
	 * @param dupdatedateStr
	 */
	public void setDupdatedateStr(String dupdatedateStr) {
		this.dupdatedateStr = dupdatedateStr;
	}
	/**
	 * 获取:账期天数最小值
	 * @return ipaymentdaysMin
	 */
	public Integer getIpaymentdaysMin() {
		return ipaymentdaysMin;
	}
	/**
	 * 设置：账期天数最小值
	 * @param ipaymentdaysMin
	 */
	public void setIpaymentdaysMin(Integer ipaymentdaysMin) {
		this.ipaymentdaysMin = ipaymentdaysMin;
	}
	/**
	 * 获取:账期天数最大值
	 * @return ipaymentdaysMax
	 */
	public Integer getIpaymentdaysMax() {
		return ipaymentdaysMax;
	}
	/**
	 * 设置：账期天数最大值
	 * @param ipaymentdaysMax
	 */
	public void setIpaymentdaysMax(Integer ipaymentdaysMax) {
		this.ipaymentdaysMax = ipaymentdaysMax;
	}
	/**
	 * 获取:记录日期最小值
	 * @return drecorddateMin
	 */
	public String getDrecorddateMin() {
		return drecorddateMin;
	}
	/**
	 * 设置：记录日期最小值
	 * @param drecorddateMin
	 */
	public void setDrecorddateMin(String drecorddateMin) {
		this.drecorddateMin = drecorddateMin;
	}
	/**
	 * 获取:记录日期最大值
	 * @return drecorddateMax
	 */
	public String getDrecorddateMax() {
		return drecorddateMax;
	}
	/**
	 * 设置：记录日期最大值
	 * @param drecorddateMax
	 */
	public void setDrecorddateMax(String drecorddateMax) {
		this.drecorddateMax = drecorddateMax;
	}
	
}
