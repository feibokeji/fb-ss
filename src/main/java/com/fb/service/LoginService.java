package com.fb.service;

import java.util.List;
import java.util.Map;

import com.fb.domain.po.TLoginLog;
import com.fb.domain.po.TModule;
import com.fb.domain.vo.RoleContainer;

/**
 * 用户登录
 * @since 2015-6-18 下午5:00:08
 * @author Liu bo
 */
public interface LoginService {
    
    public static String SUCCESS = "success";
    
    public static String FAILURE = "failure";
    
    /**
     * 带验证码登陆
     * @param code 用户名
     * @param password 用户密码
     * @param verifyCode 验证码
     * @param container 用户信息存贮对象
     * @param loginResulteMsg 登陆结果信息
     * @return boolean true|成功，false|失败
     * @author Liu bo
     */
    public Map<String, Object> login(String code, String password, String verifycodeInSession, String verifyCode, RoleContainer container, Map<String, Object> loginResulteMsg, TLoginLog log,
                                     Integer errorcount);
                                     
    /**
     * 加载角色功能模块
     * @param roleContainer
     * @return
     */
    public List<TModule> loadingModule(RoleContainer roleContainer);
    
    /**
     * 新增登录日志
     * @param loginLog
     * @return
     * @author Liu bo
     */
    public int addLoginLog(TLoginLog loginLog);
    
    /**
     * 登录日志列表
     * @return
     * @author Liu bo
     */
    public List<TLoginLog> getLoginLogList();
}
