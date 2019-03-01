package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TCounterPartsPhoneReceivableDao;
import com.fb.domain.po.TCounterPartsPhoneReceivable;
import com.fb.service.CounterPartsPhoneReceivableService;
import com.fb.service.SimpServiceAbstract;


/**
 * @author 作者：Liu Bo
 * @version 创建时间：2019年2月24日 下午2:51:45
 * 同行手机单据应收应付服务接口实现类
 */
@Service
public class CounterPartsPhoneReceivableServiceImpl extends SimpServiceAbstract implements CounterPartsPhoneReceivableService {
    
    @Autowired
    private TCounterPartsPhoneReceivableDao receivableDao;
    
    public int add(TCounterPartsPhoneReceivable receivable) {
        return receivableDao.add(receivable);
    }
    
    public int del(String uorderid) {
        return receivableDao.del(uorderid);
    }
    
    public int mod(TCounterPartsPhoneReceivable receivable) {
        return receivableDao.mod(receivable);
    }
    
    public int modStatus(String uid, int istatus) {
        return receivableDao.modStatus(uid, istatus);
    }
    
    public TCounterPartsPhoneReceivable get(String uid) {
        return receivableDao.get(uid);
    }
    
    public List<TCounterPartsPhoneReceivable> getByUorderid(String uorderid) {
        return receivableDao.getByUorderid(uorderid);
    }
    
    public List<TCounterPartsPhoneReceivable> get(TCounterPartsPhoneReceivable receivable) {
        return receivableDao.get(receivable);
    }
    
}
