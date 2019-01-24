package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 下午2:36:55 
* 类说明:其它商品类
*/
@TableMapper("t_other_goods")
public class TOtherGoods extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5392242009399656297L;
	/**
	 * 主键
	 */
	@PrimaryKeyMapper
	private String uid;
	/**
	 * 类别表外键
	 */
	private String ucategoryid;
	/**
	 * 类别名称
	 */
	@NotFieldMapper
	private String ccategoryname;
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
	 * 单位表外键
	 */
	private String uunitid;
	/**
	 * 单位名称
	 */
	@NotFieldMapper
	private String cunitname;
	/**
	 * 保修政策表外键
	 */
	private String uwarrantyid;
	/**
	 * 保修政策天数
	 */
	@NotFieldMapper
	private Integer iwarrantyday;
	/**
	 * 保修内容
	 */
	@NotFieldMapper
	private String cwarrantycontent;
	/**
	 * 用户表外键
	 */
	private String uuserid;
	/**
	 * 部门表外键
	 */
	private String udeptid;
	/**
	 * 商品编号
	 */
	private String cno;
	/**
	 * 商品条码
	 */
	private String cbarcode;
	/**
	 * 商品名称
	 */
	private String cname;
	/**
	 * 商品全称
	 */
	private String cfullname;
	/**
	 * 商品助记码
	 */
	private String cmnemoniccode;
	/**
	 * 商品规格
	 */
	private String cspecifications;
	/**
	 * 商品积分
	 */
	private Integer iintegral;
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
	 * 价格日期
	 */
	@NotFieldMapper
	private Date priceRecordDate;
	/**
	 * 价格日期字符串格式
	 */
	@NotFieldMapper
	private String priceRecordDateStr;
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
	 * 获取:类别表外键
	 * @return ucategoryid
	 */
	public String getUcategoryid() {
		return ucategoryid;
	}
	/**
	 * 设置：类别表外键
	 * @param ucategoryid
	 */
	public void setUcategoryid(String ucategoryid) {
		this.ucategoryid = ucategoryid;
	}
	/**
	 * 获取:类别名称
	 * @return ccategoryname
	 */
	public String getCcategoryname() {
		return ccategoryname;
	}
	/**
	 * 设置：类别名称
	 * @param ccategoryname
	 */
	public void setCcategoryname(String ccategoryname) {
		this.ccategoryname = ccategoryname;
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
	 * 获取:单位表外键
	 * @return uunitid
	 */
	public String getUunitid() {
		return uunitid;
	}
	/**
	 * 设置：单位表外键
	 * @param uunitid
	 */
	public void setUunitid(String uunitid) {
		this.uunitid = uunitid;
	}
	/**
	 * 获取:单位名称
	 * @return cunitname
	 */
	public String getCunitname() {
		return cunitname;
	}
	/**
	 * 设置：单位名称
	 * @param cunitname
	 */
	public void setCunitname(String cunitname) {
		this.cunitname = cunitname;
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
	 * 获取:保修天数
	 * @return iwarrantyday
	 */
	public Integer getIwarrantyday() {
		return iwarrantyday;
	}
	/**
	 * 设置：保修天数
	 * @param iwarrantyday
	 */
	public void setIwarrantyday(Integer iwarrantyday) {
		this.iwarrantyday = iwarrantyday;
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
	 * 获取:商品条码
	 * @return cbarcode
	 */
	public String getCbarcode() {
		return cbarcode;
	}
	/**
	 * 设置：商品条码
	 * @param cbarcode
	 */
	public void setCbarcode(String cbarcode) {
		this.cbarcode = cbarcode;
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
	 * 获取:商品全称
	 * @return cfullname
	 */
	public String getCfullname() {
		return cfullname;
	}
	/**
	 * 设置：商品全称
	 * @param cfullname
	 */
	public void setCfullname(String cfullname) {
		this.cfullname = cfullname;
	}
	/**
	 * 获取:商品助记码
	 * @return cmnemoniccode
	 */
	public String getCmnemoniccode() {
		return cmnemoniccode;
	}
	/**
	 * 设置：商品助记码
	 * @param cmnemoniccode
	 */
	public void setCmnemoniccode(String cmnemoniccode) {
		this.cmnemoniccode = cmnemoniccode;
	}
	/**
	 * 获取:商品规格
	 * @return cspecifications
	 */
	public String getCspecifications() {
		return cspecifications;
	}
	/**
	 * 设置：商品规格
	 * @param cspecifications
	 */
	public void setCspecifications(String cspecifications) {
		this.cspecifications = cspecifications;
	}
	/**
	 * 获取:商品积分
	 * @return iintegral
	 */
	public Integer getIintegral() {
		return iintegral;
	}
	/**
	 * 设置：商品积分
	 * @param iintegral
	 */
	public void setIintegral(Integer iintegral) {
		this.iintegral = iintegral;
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
	 * 获取:进货价格
	 * @return ncostprice
	 */
	public Double getNcostprice() {
		return ncostprice;
	}
	/**
	 * 设置：进货价格
	 * @param ncostprice
	 */
	public void setNcostprice(Double ncostprice) {
		this.ncostprice = ncostprice;
	}
	/**
	 * 获取:销售价格
	 * @return nretailprice
	 */
	public Double getNretailprice() {
		return nretailprice;
	}
	/**
	 * 设置：销售价格
	 * @param nretailprice
	 */
	public void setNretailprice(Double nretailprice) {
		this.nretailprice = nretailprice;
	}
	/**
	 * 获取:价格日期
	 * @return priceRecordDate
	 */
	public Date getPriceRecordDate() {
		return priceRecordDate;
	}
	/**
	 * 设置：价格日期
	 * @param priceRecordDate
	 */
	public void setPriceRecordDate(Date priceRecordDate) {
		this.priceRecordDate = priceRecordDate;
		this.priceRecordDateStr = FormatUtils.formatDate(this.priceRecordDate, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 获取:价格日期字符串格式
	 * @return priceRecordDateStr
	 */
	public String getPriceRecordDateStr() {
		return priceRecordDateStr;
	}
	/**
	 * 设置：价格日期字符串格式
	 * @param priceRecordDateStr
	 */
	public void setPriceRecordDateStr(String priceRecordDateStr) {
		this.priceRecordDateStr = priceRecordDateStr;
	}
}
