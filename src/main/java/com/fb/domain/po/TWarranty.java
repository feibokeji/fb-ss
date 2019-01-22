package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2019年1月14日 下午1:33:17 
* 类说明 
* 保修政策类
*/
@TableMapper("t_warranty")
public class TWarranty extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6043969429036219643L;
	
	/**
	 * 主键
	 */
	@PrimaryKeyMapper
	private String uid;
	
	/**
	 * 天数
	 */
	private Integer iday;
	
	/**
	 * 内容
	 */
	private String ccontent;

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
	 * 获取 天数
	 * @return iday
	 */
	public Integer getIday() {
		return iday;
	}

	/**
	 * 设置 天数
	 * @param iday
	 */
	public void setIday(Integer iday) {
		this.iday = iday;
	}

	/**
	 * 获取 内容
	 * @return ccontent
	 */
	public String getCcontent() {
		return ccontent;
	}

	/**
	 * 设置 内容
	 * @param ccontent
	 */
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	
	
}
