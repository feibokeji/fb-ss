package com.fb.domain.vo;

import com.fb.core.base.domain.BaseDomain;

/**
 * tree类
 * @since 2016年5月8日 下午2:49:01
 * @author Liu bo
 */
public class Tree extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8727458500898521595L;
    
    /**
     * id
     */
    private String id;
    
    /**
     * 父id
     */
    private String pid;
    
    /**
     * 文本
     */
    private String text;
    
    /**
     * 获取 id
     * @return id
     */
    public String getId() {
        return id;
    }
    
    /**
     * 设置 id
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * 获取 父id
     * @return pid
     */
    public String getPid() {
        return pid;
    }
    
    /**
     * 设置 父id
     * @param pid 父id
     */
    public void setPid(String pid) {
        this.pid = pid;
    }
    
    /**
     * 获取 文本
     * @return text
     */
    public String getText() {
        return text;
    }
    
    /**
     * 设置 文本
     * @param text 文本
     */
    public void setText(String text) {
        this.text = text;
    }
    
}
