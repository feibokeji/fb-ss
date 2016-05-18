package com.fb.service;

import java.util.List;

import com.fb.domain.po.TUser;

/**
 * 用户管理
 * @since 2015-6-19 下午6:16:58
 * @author Liu bo
 */
public interface UserService {
    
    /**
     * 根据登录代码获取用户信息
     * @param code
     * @return
     * @author Liu bo
     */
    public TUser getUserByCode(String code);
    
    /**
     * 设置用户密码
     * @param uid
     * @param password
     * @return
     * @author Liu bo
     */
    public int setUserPassword(String uid, String password);
    
    /**
     * 修改
     * @param user
     * @return
     * @author Liu bo
     */
    public int modify(TUser user);
    
    /**
     * 新增
     * @param user
     * @return
     * @author Liu bo
     */
    public int save(TUser user);
    
    /**
     * 账户列表
     * @return
     * @author Liu bo
     */
    public List<TUser> getUserList();
    
    /**
     * 账户信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public TUser getUser(String uid);
}
