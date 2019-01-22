package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午3:51:55 
* 类说明:
* 客户类型类
*/
@TableMapper("t_customer_type")
public class TCustomerType extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5100817373416086584L;
	/**
	 * 主键
	 */
	@PrimaryKeyMapper
	private String uid;
	/**
	 * 编号
	 */
	private String cno;
	/**
	 * 名称
	 */
	private String cname;
	/**
	 * 账期天数
	 */
	private Integer ipaymentdays;
	/**
	 * 获取：主键
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
	 * 获取:编号
	 * @return cno
	 */
	public String getCno() {
		return cno;
	}
	/**
	 * 设置：编号
	 * @param cno
	 */
	public void setCno(String cno) {
		this.cno = cno;
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
	
}
