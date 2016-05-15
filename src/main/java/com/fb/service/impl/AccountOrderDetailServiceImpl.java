package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TAccountOrderDetailDao;
import com.fb.domain.po.TAccountOrderDetail;
import com.fb.service.AccountOrderDetailService;
import com.fb.service.SimpServiceAbstract;

@Service
public class AccountOrderDetailServiceImpl extends SimpServiceAbstract implements AccountOrderDetailService {
    
    @Autowired
    private TAccountOrderDetailDao accountOrderDetailDao;
    
    @Transactional
    public synchronized int addAccountOrderDetail(TAccountOrderDetail accountOrderDetail) {
        return accountOrderDetailDao.addAccountOrderDetail(accountOrderDetail);
    }
    
    @Transactional
    public synchronized int updateAccountOrderDetail(TAccountOrderDetail accountOrderDetail) {
        return accountOrderDetailDao.updateAccountOrderDetail(accountOrderDetail);
    }
    
    @Transactional
    public List<TAccountOrderDetail> getAccountOrderDetailByUAccountOrderId(String uaccountorderid) {
        return accountOrderDetailDao.getAccountOrderDetailByUAccountOrderId(uaccountorderid);
    }
    
    @Transactional
    public synchronized int deleteAccountOrderDetailByUAccountOrderId(String uaccountorderid) {
        return accountOrderDetailDao.deleteAccountOrderDetailByUAccountOrderId(uaccountorderid);
    }
    
}
