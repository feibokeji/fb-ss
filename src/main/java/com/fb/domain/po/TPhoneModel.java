package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月24日 下午5:13:31 
* 类说明:手机型号类
*/
@TableMapper("t_phone_model")
public class TPhoneModel extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8439051784382443676L;
	/**
	 * 主键
	 */
	@PrimaryKeyMapper
	private String uid;
	/**
	 * 品牌表外键
	 */
	private String ubrandid;
	/**
	 * 品牌名称
	 */
	@NotFieldMapper
	private String cbrandname;
	/**
	 * 保修政策表外键
	 */
	private String uwarrantyid;
	/**
	 * 保修天数
	 */
	@NotFieldMapper
	private String iwarrantyday;
	/**
	 * 保修内容
	 */
	@NotFieldMapper
	private String cwarrantycontent;
	/**
	 * 名称
	 */
	private String cname;
	/**
	 * 运行内存
	 */
	private String cram;
	/**
	 * 存储内存
	 */
	private String crom;
	/**
	 * CPU
	 */
	private String ccpu;
	/**
	 * 屏幕
	 */
	private String cscreen;
	/**
	 * 摄像头
	 */
	private String ccamera;
	/**
	 * 电池
	 */
	private String cbattery;
	/**
	 * 网络模式
	 */
	private String cnetwork;
	/**
	 * 亮点描述
	 */
	private String chighlightdesc;
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
	 * 更新日期
	 */
	private Date dupdatedate;
	/**
	 * 更新日期字符串格式
	 */
	@NotFieldMapper
	private String dupdatedateStr;
	/**
	 * 进货价格
	 */
	@NotFieldMapper
	private Double ncostprice;
	/**
	 * 销售价格
	 */
	@NotFieldMapper
	private Double nretailprice;
	/**
	 * 手机型号颜色IDS<id用;隔开>
	 */
	@NotFieldMapper
	private String phoneModelColorIds;
	/**
	 * 用户表外键
	 */
	@NotFieldMapper
	private String uuserid;
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
	 * 获取:品牌表外键
	 * @return ubrandid
	 */
	public String getUbrandid() {
		return ubrandid;
	}
	/**
	 * 设置：品牌表外键
	 * @param ubrandid
	 */
	public void setUbrandid(String ubrandid) {
		this.ubrandid = ubrandid;
	}
	/**
	 * 获取:品牌名称
	 * @return cbrandname
	 */
	public String getCbrandname() {
		return cbrandname;
	}
	/**
	 * 设置：品牌名称
	 * @param cbrandname
	 */
	public void setCbrandname(String cbrandname) {
		this.cbrandname = cbrandname;
	}
	/**
	 * 获取:保修政策表外键
	 * @return uwarrantyid
	 */
	public String getUwarrantyid() {
		return uwarrantyid;
	}
	/**
	 * 设置：保修政策表外键
	 * @param uwarrantyid
	 */
	public void setUwarrantyid(String uwarrantyid) {
		this.uwarrantyid = uwarrantyid;
	}
	/**
	 * 获取:保修政策
	 * @return iwarrantyday
	 */
	public String getIwarrantyday() {
		return iwarrantyday;
	}
	/**
	 * 设置：保修政策
	 * @param iwarrantyday
	 */
	public void setIwarrantyday(String iwarrantyday) {
		this.iwarrantyday = iwarrantyday;
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
	 * 获取:运行内存
	 * @return cram
	 */
	public String getCram() {
		return cram;
	}
	/**
	 * 设置：运行内存
	 * @param cram
	 */
	public void setCram(String cram) {
		this.cram = cram;
	}
	/**
	 * 获取:存储内存
	 * @return crom
	 */
	public String getCrom() {
		return crom;
	}
	/**
	 * 设置：存储内存
	 * @param crom
	 */
	public void setCrom(String crom) {
		this.crom = crom;
	}
	/**
	 * 获取:处理器
	 * @return ccpu
	 */
	public String getCcpu() {
		return ccpu;
	}
	/**
	 * 设置：处理器
	 * @param ccpu
	 */
	public void setCcpu(String ccpu) {
		this.ccpu = ccpu;
	}
	/**
	 * 获取:屏幕
	 * @return cscreen
	 */
	public String getCscreen() {
		return cscreen;
	}
	/**
	 * 设置：屏幕
	 * @param cscreen
	 */
	public void setCscreen(String cscreen) {
		this.cscreen = cscreen;
	}
	/**
	 * 获取:摄像头
	 * @return ccamera
	 */
	public String getCcamera() {
		return ccamera;
	}
	/**
	 * 设置：摄像头
	 * @param ccamera
	 */
	public void setCcamera(String ccamera) {
		this.ccamera = ccamera;
	}
	/**
	 * 获取:电池
	 * @return cbattery
	 */
	public String getCbattery() {
		return cbattery;
	}
	/**
	 * 设置：电池
	 * @param cbattery
	 */
	public void setCbattery(String cbattery) {
		this.cbattery = cbattery;
	}
	/**
	 * 获取:网络模式
	 * @return cnetwork
	 */
	public String getCnetwork() {
		return cnetwork;
	}
	/**
	 * 设置：网络模式
	 * @param cnetwork
	 */
	public void setCnetwork(String cnetwork) {
		this.cnetwork = cnetwork;
	}
	/**
	 * 获取:亮点描述
	 * @return chighlightdesc
	 */
	public String getChighlightdesc() {
		return chighlightdesc;
	}
	/**
	 * 设置：亮点描述
	 * @param chighlightdesc
	 */
	public void setChighlightdesc(String chighlightdesc) {
		this.chighlightdesc = chighlightdesc;
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
	 * 获取:进货价
	 * @return ncostprice
	 */
	public Double getNcostprice() {
		return ncostprice;
	}
	/**
	 * 设置：进货价
	 * @param ncostprice
	 */
	public void setNcostprice(Double ncostprice) {
		this.ncostprice = ncostprice;
	}
	/**
	 * 获取:销售价
	 * @return nretailprice
	 */
	public Double getNretailprice() {
		return nretailprice;
	}
	/**
	 * 设置：销售价
	 * @param nretailprice
	 */
	public void setNretailprice(Double nretailprice) {
		this.nretailprice = nretailprice;
	}
	/**
	 * 获取:手机型号颜色IDS<id用;隔开>
	 * @return phoneModelColorIds
	 */
	public String getPhoneModelColorIds() {
		return phoneModelColorIds;
	}
	/**
	 * 设置：手机型号颜色IDS<id用;隔开>
	 * @param phoneModelColorIds
	 */
	public void setPhoneModelColorIds(String phoneModelColorIds) {
		this.phoneModelColorIds = phoneModelColorIds;
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
	 * 获取:保修内容
	 * @return cwarrantycontent
	 */
	public String getCwarrantycontent() {
		return cwarrantycontent;
	}
	/**
	 * 设置：保修内容
	 * @param cwarrantycontent
	 */
	public void setCwarrantycontent(String cwarrantycontent) {
		this.cwarrantycontent = cwarrantycontent;
	}
	
}
