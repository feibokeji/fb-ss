package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TSupplierPhoneOrderReceiptsDao;
import com.fb.domain.po.TSupplierPhoneOrderReceipts;
import com.fb.service.SimpServiceAbstract;
import com.fb.service.SupplierPhoneOrderReceiptsService;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月19日 上午10:10:12
 * 供应商手机单据实收实付服务接口实现类
 */
@Service
public class SupplierPhoneOrderReceiptsServiceImpl extends SimpServiceAbstract implements SupplierPhoneOrderReceiptsService {
    
    @Autowired
    private TSupplierPhoneOrderReceiptsDao receiptsDao;
    
    public int addSupplierPhoneOrderReceipts(TSupplierPhoneOrderReceipts receipts) {
        return receiptsDao.add(receipts);
    }
    
    public int delSupplierPhoneOrderReceipts(String uid) {
        return receiptsDao.del(uid);
    }
    
    public int modSupplierPhoneOrderReceipts(TSupplierPhoneOrderReceipts receipts) {
        return receiptsDao.mod(receipts);
    }
    
    public int modSupplierPhoneOrderReceiptsStatus(String uid, int istatus) {
        return receiptsDao.modStatus(uid, istatus);
    }
    
    public TSupplierPhoneOrderReceipts getSupplierPhoneOrderReceipts(String uid) {
        return receiptsDao.get(uid);
    }
    
    public List<TSupplierPhoneOrderReceipts> getSupplierPhoneOrderReceipts(TSupplierPhoneOrderReceipts receipts) {
        return receiptsDao.get(receipts);
    }
    
    public int getSupplierPhoneOrderReceiptsNum(String imei) {
        return receiptsDao.getReceiptsNum(imei);
    }
}
