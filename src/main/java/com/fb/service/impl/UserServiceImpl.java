package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    @Transactional
    public synchronized int setUserPassword(String uid, String password) {
        return userDao.setUserPassword(uid, password);
    }
    
    @Transactional
    public synchronized int modify(TUser user) {
        return userDao.modify(user);
    }

    public List<TUser> getUserList() {
        return userDao.getUserList();
    }

    public TUser getUser(String uid) {
        return userDao.getUser(uid);
    }
    
    public int save(TUser user) {
        return userDao.add(user);
    }
    
}
