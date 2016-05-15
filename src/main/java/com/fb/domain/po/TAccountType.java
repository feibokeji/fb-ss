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
     * 类型代码
     */
    private String cno;
    
    /**
     * 类型名称
     */
    private String cname;
    
    /**
     * 类型所属类别
     */
    private String ctype;
    
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
     * 获取 类型代码
     * @return cno
     */
    public String getCno() {
        return cno;
    }
    
    /**
     * 设置 类型代码
     * @param cno 类型代码
     */
    public void setCno(String cno) {
        this.cno = cno;
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
