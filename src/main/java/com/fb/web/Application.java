package com.fb.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ServletContextAware;

import com.fb.core.utils.ConstantUtils;
import com.fb.domain.vo.RoleContainer;

public class Application implements ApplicationContextAware, ServletContextAware, DisposableBean {
    
    private static final String ENSURE_INJECT_MESSAGE = "确保%s已注入Application, 检查web.xml是否配置WebApplicationFilter";
    
    private static Logger logger = Logger.getLogger(Application.class);
    
    private static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
    
    private static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<HttpServletResponse>();
    
    private static ApplicationContext applicationContext;
    
    private static ServletContext servletContext;
    
    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException(ENSURE_INJECT_MESSAGE);
        }
    }
    
    private static void checkServletContext() {
        if (servletContext == null) {
            throw new IllegalStateException("servletContext,请确定在web环境下获取");
        }
    }
    
    public static void setRequestAndResponse(HttpServletRequest req, HttpServletResponse resp) {
        requestHolder.set(req);
        responseHolder.set(resp);
    }
    
    public static ApplicationContext getApplicationContext() {
        checkApplicationContext();
        return applicationContext;
    }
    
    /**
     * 获取当前HttpServletRequest.
     * <p/>
     * 方便工具类访问request. Controller内推荐使用方法参数声明方式获取.
     * @author Biller Zou
     */
    public static HttpServletRequest getRequest() {
        return requestHolder.get();
    }
    
    /**
     * 得到session
     * @return HttpSession
     * @author Biller Zou
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }
    
    public static RoleContainer getRoleContainer() {
        RoleContainer temp = (RoleContainer) getSession().getAttribute(ConstantUtils.getConstant("roll_container_key"));
        return temp;
    }
    
    /**
     * 取得存储在静态变量中的servletContext.
     * @author Biller Zou
     */
    public static ServletContext getServletContext() {
        checkServletContext();
        return servletContext;
    }
    
    /**
     * 获取应用上下文名称.
     * @author Biller Zou
     */
    public static String getContextPath() {
        return getServletContext().getContextPath();
    }
    
    public static String getRealPath(String path) {
        return getServletContext().getRealPath(path);
    }
    
    /**
     * 清除applicationContext,servletContext静态变量.
     * @author Biller Zou
     */
    public static void cleanContexts() {
        applicationContext = null;
        servletContext = null;
        logger.info("清理applicationContext,servletContext完毕..........");
    }
    
    public void destroy() throws Exception {
        applicationContext = null;
        servletContext = null;
        logger.info("清理applicationContext,servletContext完毕..........");
    }
    
    public void setServletContext(ServletContext servletContext) {
        Application.servletContext = servletContext;
    }
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Application.applicationContext = applicationContext;
    }
    
}
