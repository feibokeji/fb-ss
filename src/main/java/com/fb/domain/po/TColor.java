package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/** 
* @author 作者 E-mail: 刘博
* @version 创建时间：2019年1月14日 下午1:26:24 
* 类说明 
* 颜色类
*/
@TableMapper("t_color")
public class TColor extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7580646747510778531L;
	
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
