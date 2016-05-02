package com.fb.dao;

import com.fb.domain.po.TUser;

public interface TUserDao {
    
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
}
