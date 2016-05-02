package com.fb.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.ConstantUtils;
import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TCorp;
import com.fb.domain.po.TDept;
import com.fb.domain.po.TLoginLog;
import com.fb.domain.po.TUser;
import com.fb.domain.vo.RoleContainer;
import com.fb.domain.vo.SessionContainer;
import com.fb.util.Util;

@Controller
@RequestMapping("/ajax")
public class AjaxController extends SimpController {
    
    /**
     * 用户登录
     * @param code 登录代码
     * @param password 登录密码
     * @param verifyCode 验证码
     * @param remember 是否记录登录信息
     * @param errorcount 登录错误次数
     * @param request
     * @param response
     * @param session
     * @return
     * @author Liu bo
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> loginTo(String code, String password, String verifyCode,String moduleCode, boolean remember, Integer errorcount, HttpServletRequest request, HttpServletResponse response,
                                       HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        RoleContainer roleContainer = new RoleContainer();
        String mac = Util.getMACAddress(request.getRemoteAddr());
        // 记录登录日志表
        TLoginLog loginLog = new TLoginLog();
        loginLog.setUid(DataUtils.newUUID());
        loginLog.setDlogintime(new Date());
        loginLog.setCtype("登录");
        loginLog.setCmac(mac);
        String ip = "";
        String[] temp = {request.getHeader("x-forwarded-for"), request.getHeader("Proxy-Client-IP"), request.getHeader("WL-Proxy-Client-IP"), request.getRemoteAddr()};
        for (int i = 0; i < temp.length; i++) {
            if (!"".equals(DataUtils.defaultString(temp[i])) && !"unknown".equalsIgnoreCase(temp[i])) {
                ip += temp[i] + "|";
            }
        }
        loginLog.setCloginip(ip);
        loginLog.setCloginurl(request.getRequestURL().toString());
        this.getService().getLoginService().login(code, password, (String) Application.getSession().getAttribute("verifyCode"), verifyCode, roleContainer, map, loginLog, errorcount);
        if (Boolean.valueOf(map.get("isSuccess").toString())) {
            TUser user = getService().getUserService().getUserByCode(code);
            loginLog.setUuserid(user.getUid());
            TDept dept = getService().getDeptService().getDeptByUid(user.getUdeptid());
            TCorp corp = getService().getCorpService().getCorpByUid(dept.getUcorpid());
            SessionContainer sessionContainer = new SessionContainer();
            sessionContainer.setUser(user);
            sessionContainer.setDept(dept);
            sessionContainer.setCorp(corp);
            session.setAttribute(ConstantUtils.getConstant("session_container_key"), sessionContainer);
            session.setAttribute(ConstantUtils.getConstant("role_container_key"), roleContainer);
            session.setAttribute("loginTime", new Date());
            session.setMaxInactiveInterval(60 * 60 * 4);
            getService().getLoginService().addLoginLog(loginLog);
            rememberUserInfo(code, remember, response);
        }
        return map;
    }
    
    /**
     * 获取cookies
     * @param request
     * @return
     * @author Liu bo
     */
    @RequestMapping("/getCookies")
    @ResponseBody
    public Map<String, String> getCookies(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            try {
                map.put(c.getName(), URLDecoder.decode(c.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                logger.error("Cookie获取错误", e);
            }
        }
        return map;
    }
    
    /**
     * 存储登录账号
     * @param code
     * @param remember
     * @param response
     * @author Liu bo
     */
    private void rememberUserInfo(String code, boolean remember, HttpServletResponse response) {
        if (remember) {
            try {
                Cookie codeCookie = new Cookie("code", URLEncoder.encode(code, "UTF-8"));
                Cookie rememberCookie = new Cookie("remember", "true");
                int age = 60 * 60 * 24 * 30;
                codeCookie.setMaxAge(age);
                rememberCookie.setMaxAge(age);
                response.addCookie(codeCookie);
                response.addCookie(rememberCookie);
            } catch (UnsupportedEncodingException e) {
                logger.warn("Cookie保存错误", e);
            }
        } else {
            Cookie codeCookie = new Cookie("code", null);
            Cookie rememberCookie = new Cookie("remember", null);
            int age = 0;
            codeCookie.setMaxAge(age);
            rememberCookie.setMaxAge(age);
            response.addCookie(codeCookie);
            response.addCookie(rememberCookie);
        }
    }
}
