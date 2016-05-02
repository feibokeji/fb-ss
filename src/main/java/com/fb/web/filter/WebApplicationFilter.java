package com.fb.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fb.web.Application;


public class WebApplicationFilter implements Filter{

    public void destroy() {
        Application.cleanContexts();
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) resp;
        Application.setRequestAndResponse(request, response);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig arg0) throws ServletException {
        
    }
    
}
