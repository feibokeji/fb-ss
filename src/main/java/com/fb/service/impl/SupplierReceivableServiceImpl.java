package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TSupplierReceivableDao;
import com.fb.domain.po.TSupplierReceivable;
import com.fb.service.SimpServiceAbstract;
import com.fb.service.SupplierReceivableService;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月28日 上午10:43:19 
* 类说明:供应商应收应付服务接口实现类
*/
@Service
public class SupplierReceivableServiceImpl extends SimpServiceAbstract implements SupplierReceivableService {

    @Autowired
    private TSupplierReceivableDao receivableDao;
    
    public List<TSupplierReceivable> getReceivableList(TSupplierReceivable receivable) {
        return receivableDao.getList(receivable);
    }

    public TSupplierReceivable getReceivable(String uid) {
        return receivableDao.get(uid);
    }

}
