package com.fb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TUserDao;
import com.fb.domain.po.TUser;
import com.fb.service.SimpServiceAbstract;
import com.fb.service.UserService;

@Service
public class UserServiceImpl extends SimpServiceAbstract implements UserService {
    
    @Autowired
    private TUserDao userDao;
    
    public TUser getUserByCode(String code) {
        return userDao.getUserByCode(code);
    }
    
    public int setUserPassword(String uid, String password) {
        return userDao.setUserPassword(uid, password);
    }
    
}
