package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TAccountTypeDao;
import com.fb.domain.po.TAccountType;
import com.fb.domain.vo.Combobox;
import com.fb.service.AccountTypeService;
import com.fb.service.SimpServiceAbstract;

/**
 * 账务类型
 * @since 2016年4月12日 下午4:42:37
 * @author Liu bo
 */
@Service
public class AccountTypeServiceImpl extends SimpServiceAbstract implements AccountTypeService {
    
    @Autowired
    private TAccountTypeDao accountTypeDao;
    
    @Transactional
    public synchronized int addAccountType(TAccountType accountType) {
        return accountTypeDao.addAccountType(accountType);
    }
    
    @Transactional
    public synchronized int updateAccountType(TAccountType accountType) {
        return accountTypeDao.updateAccountType(accountType);
    }
    
    public TAccountType getAccountType(String uid) {
        return accountTypeDao.getAccountType(uid);
    }
    
    public List<TAccountType> getAccountTypeList() {
        return accountTypeDao.getAccountTypeList();
    }

    @Transactional
    public synchronized int deleteAccountType(String uid) {
        return accountTypeDao.deleteAccountType(uid);
    }

    public List<Combobox> getCombobox(String ctype) {
        return accountTypeDao.getCombobox(ctype);
    }
    
}
