package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午3:55:46 
* 类说明:
* 客户类
*/
@TableMapper("t_customer")
public class TCustomer extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5943156263761839247L;
	/**
	 * 主键
	 */
	@PrimaryKeyMapper
	private String uid;
	/**
	 * 客户类型表外键
	 */
	private String ucustomertypeid;
	/**
	 * 客户类型表名称
	 */
	@NotFieldMapper
	private String ccustomertypename;
	/**
	 * 用户表外键
	 */
	private String uuserid;
	/**
	 * 部门表外键
	 */
	private String udeptid;
	/**
	 * 名称
	 */
	private String cname;
	/**
	 * 性别
	 * 0-女
	 * 1-男
	 */
	private Integer isex;
	/**
	 * 性别字符串
	 */
	@NotFieldMapper
	private String isexStr;
	/**
	 * 联系电话
	 */
	private String ccontactnumber;
	/**
	 * 地址
	 */
	private String caddress;
	/**
	 * 微信
	 */
	private String cwechat;
	/**
	 * 生日
	 */
	private Date dbirthday;
	/**
	 * 生日字符串格式
	 */
	@NotFieldMapper
	private String dbirthdayStr;
	/**
	 * 生日最小值
	 */
	@NotFieldMapper
	private String dbirthdayStrMin;
	/**
	 * 生日最大值
	 */
	@NotFieldMapper
	private String dbirthdayStrMax;
	/**
	 * 积分
	 */
	private Integer iintegral;
	/**
	 * 积分最小值
	 */
	@NotFieldMapper
	private Integer iintegralMin;
	/**
	 * 积分最大值
	 */
	@NotFieldMapper
	private Integer iintegralMax;
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
	 * 记录日期字符串
	 */
	@NotFieldMapper
	private String drecorddateStr;
	/**
	 * 记录日期最小值
	 */
	@NotFieldMapper
	private String drecorddateStrMin;
	/**
	 * 记录日期最大值
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
	 * 获取:客户类型表外键
	 * @return ucustomertypeid
	 */
	public String getUcustomertypeid() {
		return ucustomertypeid;
	}
	/**
	 * 设置：客户类型表外键
	 * @param ucustomertypeid
	 */
	public void setUcustomertypeid(String ucustomertypeid) {
		this.ucustomertypeid = ucustomertypeid;
	}
	/**
	 * 获取:客户类型名称
	 * @return ccustomertypename
	 */
	public String getCcustomertypename() {
		return ccustomertypename;
	}
	/**
	 * 设置：客户类型名称
	 * @param ccustomertypename
	 */
	public void setCcustomertypename(String ccustomertypename) {
		this.ccustomertypename = ccustomertypename;
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
	 * 获取:名称
	 * @return cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * 设置：名称
	 * @param cname
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * 获取:性别
	 * @return isex
	 */
	public Integer getIsex() {
		return isex;
	}
	/**
	 * 设置：性别
	 * @param isex
	 */
	public void setIsex(Integer isex) {
		this.isex = isex;
		this.isexStr = this.isex == 0 ? "女" : "男";
	}
	/**
	 * 获取:联系电话
	 * @return ccontactnumber
	 */
	public String getCcontactnumber() {
		return ccontactnumber;
	}
	/**
	 * 设置：联系电话
	 * @param ccontactnumber
	 */
	public void setCcontactnumber(String ccontactnumber) {
		this.ccontactnumber = ccontactnumber;
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
	 * 获取:生日
	 * @return dbirthday
	 */
	public Date getDbirthday() {
		return dbirthday;
	}
	/**
	 * 设置：生日
	 * @param dbirthday
	 */
	public void setDbirthday(Date dbirthday) {
		this.dbirthday = dbirthday;
		this.dbirthdayStr = FormatUtils.formatDate(this.dbirthday, "yyyy-MM-dd");
	}
	/**
	 * 获取:积分
	 * @return iintegral
	 */
	public Integer getIintegral() {
		return iintegral;
	}
	/**
	 * 设置：积分
	 * @param iintegral
	 */
	public void setIintegral(Integer iintegral) {
		this.iintegral = iintegral;
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
	 * 获取:生日最小值字符串
	 * @return dbirthdayStrMin
	 */
	public String getDbirthdayStrMin() {
		return dbirthdayStrMin;
	}
	/**
	 * 设置：生日最大值字符串
	 * @param dbirthdayStrMin
	 */
	public void setDbirthdayStrMin(String dbirthdayStrMin) {
		this.dbirthdayStrMin = dbirthdayStrMin;
	}
	/**
	 * 获取:生日最小值字符串
	 * @return dbirthdayStrMax
	 */
	public String getDbirthdayStrMax() {
		return dbirthdayStrMax;
	}
	/**
	 * 设置：生日最大值字符串
	 * @param dbirthdayStrMax
	 */
	public void setDbirthdayStrMax(String dbirthdayStrMax) {
		this.dbirthdayStrMax = dbirthdayStrMax;
	}
	/**
	 * 获取:积分最小值
	 * @return iintegralMin
	 */
	public Integer getIintegralMin() {
		return iintegralMin;
	}
	/**
	 * 设置：积分最小值
	 * @param iintegralMin
	 */
	public void setIintegralMin(Integer iintegralMin) {
		this.iintegralMin = iintegralMin;
	}
	/**
	 * 获取:积分最大值
	 * @return iintegralMax
	 */
	public Integer getIintegralMax() {
		return iintegralMax;
	}
	/**
	 * 设置：积分最大值
	 * @param iintegralMax
	 */
	public void setIintegralMax(Integer iintegralMax) {
		this.iintegralMax = iintegralMax;
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
	 * 获取:记录日期字符串
	 * @return drecorddateStr
	 */
	public String getDrecorddateStr() {
		return this.drecorddateStr;
	}
	/**
	 * 设置：记录日期字符串
	 * @param drecorddateStr
	 */
	public void setDrecorddateStr(String drecorddateStr) {
		this.drecorddateStr = drecorddateStr;
	}
	/**
	 * 获取:更新日期字符串
	 * @return dupdatedateStr
	 */
	public String getDupdatedateStr() {
		return this.dupdatedateStr;
	}
	/**
	 * 设置：更新日期字符串
	 * @param dupdatedateStr
	 */
	public void setDupdatedateStr(String dupdatedateStr) {
		this.dupdatedateStr = dupdatedateStr;
	}
	/**
	 * 获取:记录日期最小值
	 * @return drecorddateStrMin
	 */
	public String getDrecorddateStrMin() {
		return drecorddateStrMin;
	}
	/**
	 * 设置：记录日期最小值
	 * @param drecorddateStrMin
	 */
	public void setDrecorddateStrMin(String drecorddateStrMin) {
		this.drecorddateStrMin = drecorddateStrMin;
	}
	/**
	 * 获取:记录日期最大值
	 * @return drecorddateStrMax
	 */
	public String getDrecorddateStrMax() {
		return drecorddateStrMax;
	}
	/**
	 * 设置：记录日期最大值
	 * @param drecorddateStrMax
	 */
	public void setDrecorddateStrMax(String drecorddateStrMax) {
		this.drecorddateStrMax = drecorddateStrMax;
	}
	/**
	 * 获取:生日字符串格式
	 * @return dbirthdayStr
	 */
	public String getDbirthdayStr() {
		return this.dbirthdayStr;
	}
	/**
	 * 设置：生日字符串格式
	 * @param dbirthdayStr
	 */
	public void setDbirthdayStr(String dbirthdayStr) {
		this.dbirthdayStr = dbirthdayStr;
	}
	/**
	 * 获取:性别字符串
	 * @return isexStr
	 */
	public String getIsexStr() {
		return this.isexStr;
	}
	/**
	 * 设置：性别字符串
	 * @param isexStr
	 */
	public void setIsexStr(String isexStr) {
		this.isexStr = isexStr;
	}
	
}
