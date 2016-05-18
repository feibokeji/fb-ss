package com.fb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.FormatUtils;
import com.fb.core.utils.Page;
import com.fb.dao.TAccountOrderDao;
import com.fb.dao.TAccountOrderDetailDao;
import com.fb.domain.po.TAccountOrder;
import com.fb.domain.po.TAccountOrderDetail;
import com.fb.service.AccountOrderService;
import com.fb.service.SimpServiceAbstract;

@Service
public class AccountOrderServiceImpl extends SimpServiceAbstract implements AccountOrderService {
    
    @Autowired
    private TAccountOrderDao accountOrderDao;
    
    @Autowired
    private TAccountOrderDetailDao accountOrderDetailDao;
    
    @Transactional
    public synchronized int addAccountOrder(TAccountOrder accountOrder) {
        accountOrder.setCcode(FormatUtils.formatDate(new Date(), "yyyy-MM-dd-HH-mm-ss"));
        List<TAccountOrderDetail> list = accountOrder.getAccountOrderDetailList();
        list.get(0).setUid(DataUtils.newUUID());
        list.get(0).setUaccountorderid(accountOrder.getUid());
        list.get(0).setIsort(1);
        int count = accountOrderDetailDao.addAccountOrderDetail(list.get(0));
        count = count + accountOrderDao.addAccountOrder(accountOrder);
        return count;
    }
    
    @Transactional
    public synchronized int updateAccountOrder(TAccountOrder accountOrder) {
        return accountOrderDao.updateAccountOrder(accountOrder);
    }
    
    public TAccountOrder getAccountOrder(String uid) {
        return accountOrderDao.getAccountOrder(uid);
    }
    
    public Page<TAccountOrder> getAccountOrderPage(TAccountOrder accountOrder, int currentPage) {
        return null;
    }
    
    public int getAccountOrderByType(String uaccounttypeid) {
        return accountOrderDao.getAccountOrderByType(uaccounttypeid);
    }

    public List<TAccountOrder> getAccountOrderList(String ctype) {
        return accountOrderDao.getAccountOrderList(ctype);
    }
    
    @Transactional
    public synchronized int deleteAccountOrder(String uid) {
        return accountOrderDao.deleteAccountOrder(uid);
    }

    @Transactional
    public synchronized int auditAccountOrder(String uid, int iaudit) {
        return accountOrderDao.auditAccountOrder(uid, iaudit);
    }

    public int getAccountOrderByUAccountId(String uaccountid) {
        return accountOrderDao.getAccountOrderByUAccountId(uaccountid);
    }
    
}
