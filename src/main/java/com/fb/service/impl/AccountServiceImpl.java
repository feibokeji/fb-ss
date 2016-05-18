package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TAccountDao;
import com.fb.domain.po.TAccount;
import com.fb.domain.vo.Combobox;
import com.fb.service.AccountService;
import com.fb.service.SimpServiceAbstract;

@Service
public class AccountServiceImpl extends SimpServiceAbstract implements AccountService {
    
    @Autowired
    private TAccountDao accountDao;
    
    @Transactional
    public synchronized int add(TAccount account) {
        return accountDao.add(account);
    }
    
    @Transactional
    public synchronized int del(String uid) {
        return accountDao.del(uid);
    }
    
    @Transactional
    public synchronized int mod(TAccount account) {
        return accountDao.mod(account);
    }
    
    public List<TAccount> getList() {
        return accountDao.getList();
    }
    
    public int mod(String uid, String cno, String cname) {
        return accountDao.mod(uid, cno, cname);
    }
    
    public TAccount get(String uid) {
        return accountDao.get(uid);
    }

    public List<Combobox> getCombobox() {
        return accountDao.getCombobox();
    }
    
}
