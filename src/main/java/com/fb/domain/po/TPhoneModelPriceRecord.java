package com.fb.domain.po;

import java.util.Date;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
import com.fb.core.utils.FormatUtils;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月24日 下午5:53:02 
* 类说明:手机型号价格记录表
*/
@TableMapper("t_phone_model_price_record")
public class TPhoneModelPriceRecord extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5529643655692986883L;
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
	 * 用户名称
	 */
	@NotFieldMapper
	private String cusername;
	/**
	 * 手机型号表外键
	 */
	private String uphonemodelid;
	/**
	 * 进货价
	 */
	private Double ncostprice;
	/**
	 * 销售价
	 */
	private Double nretailprice;
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
	 * 状态：0-正常 1-停用
	 */
	private Integer istatus;
	/**
	 * 状态字符串格式
	 */
	@NotFieldMapper
	private String istatusStr;
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
	 * 获取:手机型号表外键
	 * @return uphonemodelid
	 */
	public String getUphonemodelid() {
		return uphonemodelid;
	}
	/**
	 * 设置：手机型号表外键
	 * @param uphonemodelid
	 */
	public void setUphonemodelid(String uphonemodelid) {
		this.uphonemodelid = uphonemodelid;
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
		this.istatusStr = this.istatus == 0 ? "正常" : "停用";
	}
	/**
	 * 获取:状态字符串格式
	 * @return istatusStr
	 */
	public String getIstatusStr() {
		return istatusStr;
	}
	/**
	 * 设置：状态字符串格式
	 * @param istatusStr
	 */
	public void setIstatusStr(String istatusStr) {
		this.istatusStr = istatusStr;
	}
	
}
