package com.fb.domain.vo;

import com.fb.core.base.domain.BaseDomain;

public class Combobox extends BaseDomain {
    
    /**
     * 
     */
    private static final long serialVersionUID = -3286807663945805726L;
    
    private String text;
    
    private String id;
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
}
