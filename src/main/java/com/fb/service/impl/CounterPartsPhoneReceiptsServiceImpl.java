package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TCounterPartsPhoneReceiptsDao;
import com.fb.domain.po.TCounterPartsPhoneReceipts;
import com.fb.service.CounterPartsPhoneReceiptsService;
import com.fb.service.SimpServiceAbstract;


/**
 * @author 作者：Liu Bo
 * @version 创建时间：2019年2月24日 下午2:55:57
 * 同行手机单据实收实付服务接口实现类
 */
@Service
public class CounterPartsPhoneReceiptsServiceImpl extends SimpServiceAbstract implements CounterPartsPhoneReceiptsService {
    
    @Autowired
    private TCounterPartsPhoneReceiptsDao receiptsDao;
    
    public int add(TCounterPartsPhoneReceipts receipts) {
        return receiptsDao.add(receipts);
    }
    
    public int del(String uid) {
        return receiptsDao.del(uid);
    }
    
    public int delByUreceivableid(String ureceivableid) {
        return receiptsDao.delByUreceivableid(ureceivableid);
    }
    
    public int mod(TCounterPartsPhoneReceipts receipts) {
        return receiptsDao.mod(receipts);
    }
    
    public int modStatus(String uid, int istatus) {
        return receiptsDao.modStatus(uid, istatus);
    }
    
    public TCounterPartsPhoneReceipts get(String uid) {
        return receiptsDao.get(uid);
    }
    
    public List<TCounterPartsPhoneReceipts> getByUreceivableid(String ureceivableid) {
        return receiptsDao.getByUreceivableid(ureceivableid);
    }
    
    public List<TCounterPartsPhoneReceipts> get(TCounterPartsPhoneReceipts receipts) {
        return receiptsDao.get(receipts);
    }

    public int getOrderReceiptsNum(String uorderid) {
        return receiptsDao.getOrderReceiptsNum(uorderid);
    }
    
}
