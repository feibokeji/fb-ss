package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fb.dao.TAccountTypeDao;
import com.fb.domain.po.TAccountType;
import com.fb.service.AccountTypeService;
import com.fb.service.SimpServiceAbstract;

/**
 * 账务类型
 * @since 2016年4月12日 下午4:42:37
 * @author Liu bo
 */
public class AccountTypeServiceImpl extends SimpServiceAbstract implements AccountTypeService {
    
    @Autowired
    private TAccountTypeDao accountTypeDao;
    
    public int addAccountType(TAccountType accountType) {
        return 0;
    }
    
    public int updateAccountType(TAccountType accountType) {
        return 0;
    }
    
    public TAccountType getAccountType(String uid) {
        return accountTypeDao.getAccountType(uid);
    }
    
    public List<TAccountType> getAccountTypeList() {
        return accountTypeDao.getAccountTypeList();
    }
    
}
