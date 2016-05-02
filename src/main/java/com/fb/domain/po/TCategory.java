package com.fb.domain.po;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.base.persistence.PrimaryKeyMapper;

/**
 * 产品类别
 * @since 2016年4月29日 下午4:38:14
 * @author Liu bo
 */
public class TCategory extends BaseDomain {
    
    
    /**
     * 
     */
    private static final long serialVersionUID = 2879673398034207263L;
    
    /**
     * 主键
     */
    @PrimaryKeyMapper
    private String uid;
    
    /**
     * 编码
     */
    private String cno;
    
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
     * @param uid 主键
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
    
    /**
     * 获取 编码
     * @return cno
     */
    public String getCno() {
        return cno;
    }
    
    /**
     * 设置 编码
     * @param cno 编码
     */
    public void setCno(String cno) {
        this.cno = cno;
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
     * @param cname 名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    
}
