package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月14日 下午1:42:48 
* 类说明 
*/
@TableMapper("t_payment_method")
public class TPaymentMethod extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7663781827105654956L;
	
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
	 * 代码
	 */
	private String ccode;
	
	/**
	 * 描述
	 */
	private String cdesc;

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

	/**
	 * 获取 代码
	 * @return ccode
	 */
	public String getCcode() {
		return ccode;
	}

	/**
	 * 设置 代码
	 * @param ccode
	 */
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	/**
	 * 获取 描述
	 * @return cdesc
	 */
	public String getCdesc() {
		return cdesc;
	}

	/**
	 * 设置 描述
	 * @param cdesc
	 */
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	
}
