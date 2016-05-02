package com.fb.web.handler;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.fb.core.utils.ConstantUtils;
import com.fb.web.Application;
import com.fb.web.base.BaseHandler;

/**
 * 身份验证拦截器
 * @since 2015-6-14 下午2:54:53
 * @author Liu bo
 */
@Service
public class AuthorizationHandler extends BaseHandler {
    
    public AuthorizationHandler() {
        super("/{:(?!ajax|toReceiveXML).+}/**,/*", 0);
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (Application.getSession().getAttribute(ConstantUtils.getConstant("session_container_key")) == null) {
            StringBuffer url = request.getRequestURL();
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (parameterMap.size() > 0) url.append("?");
            for (String param : parameterMap.keySet()) {
                for (String value : parameterMap.get(param)) {
                    url.append(param);
                    url.append("=");
                    url.append(URLEncoder.encode(value, "UTF-8"));
                    url.append("&");
                }
            }
            request.getRequestDispatcher("/login.jsp?url=" + url).forward(request, response);
            logger.info("登录失效：" + request.getRequestURI());
            return false;
        }
        
        return super.preHandle(request, response, handler);
    }
}
