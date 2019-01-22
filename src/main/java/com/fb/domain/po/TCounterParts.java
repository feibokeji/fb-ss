package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午4:11:03 
* 类说明:
* 同行类
*/
@TableMapper("t_counterparts")
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
	 * 经营状态字符串格式
	 * 0-正常
	 * 1-停业
	 */
	@NotFieldMapper
	private String ibusinessstatusStr;
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
	 * 记录日期字符串格式
	 */
	@NotFieldMapper
	private String drecorddateStr;
	/**
	 * 记录日期字符串格式最小值
	 */
	@NotFieldMapper
	private String drecorddateStrMin;
	/**
	 * 记录日期字符串格式最大值
	 */
	@NotFieldMapper
	private String drecorddateStrMax;
	/**
	 * 更新日期
	 */
	private Date dupdatedate;
	/**
	 * 更新日期字符串格式
	 */
	@NotFieldMapper
	private String dupdatedateStr;
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
		this.drecorddateStr = FormatUtils.formatDate(this.drecorddate, "yyyy-MM-dd HH:mm:ss");
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
	 * 获取:记录日期字符串格式
	 * @return drecorddateStr
	 */
	public String getDrecorddateStr() {
		return drecorddateStr;
	}
	/**
	 * 设置：记录日期字符串格式
	 * @param drecorddateStr
	 */
	public void setDrecorddateStr(String drecorddateStr) {
		this.drecorddateStr = drecorddateStr;
	}
	/**
	 * 获取:记录日期字符串格式最小值
	 * @return drecorddateStrMin
	 */
	public String getDrecorddateStrMin() {
		return drecorddateStrMin;
	}
	/**
	 * 设置：记录日期字符串格式最小值
	 * @param drecorddateStrMin
	 */
	public void setDrecorddateStrMin(String drecorddateStrMin) {
		this.drecorddateStrMin = drecorddateStrMin;
	}
	/**
	 * 获取:记录日期字符串格式最大值
	 * @return drecorddateStrMax
	 */
	public String getDrecorddateStrMax() {
		return drecorddateStrMax;
	}
	/**
	 * 设置：记录日期字符串格式最大值
	 * @param drecorddateStrMax
	 */
	public void setDrecorddateStrMax(String drecorddateStrMax) {
		this.drecorddateStrMax = drecorddateStrMax;
	}
	/**
	 * 获取:更新日期字符串格式
	 * @return dupdatedateStr
	 */
	public String getDupdatedateStr() {
		return dupdatedateStr;
	}
	/**
	 * 设置：更新日期字符串格式
	 * @param dupdatedateStr
	 */
	public void setDupdatedateStr(String dupdatedateStr) {
		this.dupdatedateStr = dupdatedateStr;
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
	public void setIbusinessstatus(Integer ibusinessstatus) {
		this.ibusinessstatus = ibusinessstatus;
		switch (this.ibusinessstatus) {
		case 0:
			this.ibusinessstatusStr = "正常";
			break;
		case 1:
			this.ibusinessstatusStr = "停业";
		default:
			this.ibusinessstatusStr = "停业";
			break;
		}
	}
	/**
	 * 获取:经营状态字符串格式
	 * @return ibusinessstatusStr
	 */
	public String getIbusinessstatusStr() {
		return ibusinessstatusStr;
	}
	/**
	 * 设置：经营状态字符串格式
	 * @param ibusinessstatusStr
	 */
	public void setIbusinessstatusStr(String ibusinessstatusStr) {
		this.ibusinessstatusStr = ibusinessstatusStr;
	}
	
}
