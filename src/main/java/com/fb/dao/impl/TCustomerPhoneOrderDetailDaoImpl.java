package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.dao.TCustomerPhoneOrderDetailDao;
import com.fb.domain.po.TCustomerPhoneOrderDetail;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月8日 下午3:16:39
 * 客户手机单据明细接口实现类
 */
@Service
public class TCustomerPhoneOrderDetailDaoImpl extends SimpMapper<TCustomerPhoneOrderDetail> implements TCustomerPhoneOrderDetailDao {
    
    
    public int add(TCustomerPhoneOrderDetail detail) {
        return 0;
    }
    
    public int delByOrder(String uorderid) {
        return 0;
    }
    
    public TCustomerPhoneOrderDetail get(String uid) {
        return null;
    }
    
    public List<TCustomerPhoneOrderDetail> getByOrder(String uorderid) {
        return null;
    }
    
    public List<TCustomerPhoneOrderDetail> get(TCustomerPhoneOrderDetail detail) {
        return null;
    }
    
}
