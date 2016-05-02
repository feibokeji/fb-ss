package com.fb.web.jsp.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.fb.core.utils.ConstantUtils;
import com.fb.domain.vo.RoleContainer;

public class ModuleTag extends BodyTagSupport{

    /**
     * 
     */
    private static final long serialVersionUID = 2754614026907063359L;
    
    /**
     * 功能模块代码
     */
    private String code;
    
    
    public int doEndTag() throws JspException {
        
        RoleContainer roleContainer = (RoleContainer) pageContext.getSession().getAttribute(ConstantUtils.getConstant("role_container_key"));
        
        if(roleContainer != null){
            if(roleContainer.getModuleCodes().contains(this.code)){
                try {
                    pageContext.getOut().print(bodyContent.getString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return EVAL_PAGE;
            }
        }
        return SKIP_BODY;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
