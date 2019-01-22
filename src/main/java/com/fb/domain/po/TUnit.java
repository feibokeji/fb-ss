package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/** 
* @author 作者 刘博 
* @version 创建时间：2019年1月14日 下午1:37:50 
* 类说明 
* 单位类
*/
@TableMapper("t_unit")
public class TUnit extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8234904454297490555L;
	
	/**
	 * 主键
	 */
	@PrimaryKeyMapper
	private String uid;
	
	/**
	 * 名称
	 */
	private String cname;

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
	
	
}
