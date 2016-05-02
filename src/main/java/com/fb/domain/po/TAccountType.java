package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;
import com.fb.core.base.persistence.TableMapper;

/**
 * 账务类型
 * @since 2016年4月11日 下午3:35:06
 * @author Liu bo
 */
@TableMapper("t_account_type")
public class TAccountType extends BaseDomain {
    
    
    /**
     * 
     */
    private static final long serialVersionUID = 4844373524128156000L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 父级类型主键
     */
    private String uparentid;
    
    /**
     * 类型代码
     */
    private String ccode;
    
    /**
     * 类型名称
     */
    private String cname;
    
    /**
     * 类型所属类别
     */
    private String ctype;
    
    /**
     * 父级代码
     */
    private String cparent;
    
    /**
     * 序号
     */
    private Integer isort;
    
    /**
     * 备注
     */
    private String cmemo;
    
    /**
     * 获取 主键
     * @return uid
     */
    public String getUid() {
        return uid;
    }
    
    /**
     * 设置 主键
     * @param uid 主键
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
    
    /**
     * 获取 父级类型主键
     * @return uparentid
     */
    public String getUparentid() {
        return uparentid;
    }
    
    /**
     * 设置 父级类型主键
     * @param uparentid 父级类型主键
     */
    public void setUparentid(String uparentid) {
        this.uparentid = uparentid;
    }
    
    /**
     * 获取 类型代码
     * @return ccode
     */
    public String getCcode() {
        return ccode;
    }
    
    /**
     * 设置 类型代码
     * @param ccode 类型代码
     */
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }
    
    /**
     * 获取 类型名称
     * @return cname
     */
    public String getCname() {
        return cname;
    }
    
    /**
     * 设置 类型名称
     * @param cname 类型名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    /**
     * 获取 类型所属类别
     * @return ctype
     */
    public String getCtype() {
        return ctype;
    }
    
    /**
     * 设置 类型所属类别
     * @param ctype 类型所属类别
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
    
    /**
     * 获取 父级代码
     * @return cparent
     */
    public String getCparent() {
        return cparent;
    }
    
    /**
     * 设置 父级代码
     * @param cparent 父级代码
     */
    public void setCparent(String cparent) {
        this.cparent = cparent;
    }
    
    /**
     * 获取 序号
     * @return isort
     */
    public Integer getIsort() {
        return isort;
    }
    
    /**
     * 设置 序号
     * @param isort 序号
     */
    public void setIsort(Integer isort) {
        this.isort = isort;
    }
    
    /**
     * 获取 备注
     * @return cmemo
     */
    public String getCmemo() {
        return cmemo;
    }
    
    /**
     * 设置 备注
     * @param cmemo 备注
     */
    public void setCmemo(String cmemo) {
        this.cmemo = cmemo;
    }
    
}
