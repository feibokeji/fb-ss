package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;
/** 
* @author 作者 E-mail: 刘博
* @version 创建时间：2019年1月14日 下午1:17:55 
* 类说明 
* 品牌类
*/
@TableMapper("t_brand")
public class TBrand extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9170699905310075106L;
	
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
	 * LOGO
	 */
	private String clogo;
	
	/**
	 * 网址
	 */
	private String curl;
	
	/**
	 * 描述
	 */
	private String cdesc;
	
	/**
	 * 排序
	 */
	private Integer isort;

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
	 * 获取 LOGO
	 * @return clogo
	 */
	public String getClogo() {
		return clogo;
	}

	/**
	 * 设置 LOGO
	 * @param clogo
	 */
	public void setClogo(String clogo) {
		this.clogo = clogo;
	}

	/**
	 * 获取 网址
	 * @return curl
	 */
	public String getCurl() {
		return curl;
	}

	/**
	 * 设置 网址
	 * @param curl
	 */
	public void setCurl(String curl) {
		this.curl = curl;
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

	/**
	 * 获取 排序
	 * @return isort
	 */
	public Integer getIsort() {
		return isort;
	}

	/**
	 * 设置 排序
	 * @param isort
	 */
	public void setIsort(Integer isort) {
		this.isort = isort;
	}
	
	
}
