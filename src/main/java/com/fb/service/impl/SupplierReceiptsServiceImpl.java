package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TSupplierReceiptsDao;
import com.fb.domain.po.TSupplierReceipts;
import com.fb.service.SimpServiceAbstract;
import com.fb.service.SupplierReceiptsService;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月16日 下午4:46:35
 */
@Service
public class SupplierReceiptsServiceImpl extends SimpServiceAbstract implements SupplierReceiptsService {
    
    @Autowired
    private TSupplierReceiptsDao receiptsDao;
    
    public List<TSupplierReceipts> getReceiptsListByReceivable(String ureceivableid) {
        return receiptsDao.getAll(ureceivableid);
    }

    public double getReceiptsNamountByReceivable(String ureceivableid, int istatus) {
        return receiptsDao.getNamountByReceivable(ureceivableid, istatus);
    }

    public int addReceipts(TSupplierReceipts receipts) {
        return receiptsDao.add(receipts);
    }
    
}
