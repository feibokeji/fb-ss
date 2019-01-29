package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.NotFieldMapper;
import com.fb.core.base.persistence.TableMapper;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月24日 下午5:48:46 
* 类说明:手机型号颜色类
*/
@TableMapper("t_phone_model_color")
public class TPhoneModelColor extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6219944657310755311L;
	/**
	 * 主键
	 */
	private String uid;
	/**
	 * 手机型号表外键
	 */
	private String uphonemodelid;
	/**
	 * 颜色表外键
	 */
	private String ucolorid;
	/**
	 * 颜色
	 */
	@NotFieldMapper
	private String ccolorname;
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
	 * 获取:颜色表外键
	 * @return ucolorid
	 */
	public String getUcolorid() {
		return ucolorid;
	}
	/**
	 * 设置：颜色表外键
	 * @param ucolorid
	 */
	public void setUcolorid(String ucolorid) {
		this.ucolorid = ucolorid;
	}
	/**
	 * 获取:颜色
	 * @return ccolorname
	 */
	public String getCcolorname() {
		return ccolorname;
	}
	/**
	 * 设置：颜色
	 * @param ccolorname
	 */
	public void setCcolorname(String ccolorname) {
		this.ccolorname = ccolorname;
	}
	
}
