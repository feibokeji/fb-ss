package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TOrderProductDao;
import com.fb.domain.po.TOrderProduct;

@Service
public class TOrderProductDaoImpl extends SimpMapper<TOrderProduct>implements TOrderProductDao {
    
    public int addOrderProduct(TOrderProduct orderProduct) {
        return super.save(orderProduct);
    }
    
    public int deleteOrderProductByUid(String uid) {
        return super.delete(uid);
    }
    
    public int deleteOrderProductByUOrderId(String uorderid) {
        return super.delete("uorderid", uorderid);
    }
    
    public int updateOrderProduct(TOrderProduct orderProduct) {
        return super.update(orderProduct);
    }
    
    public TOrderProduct getOrderProduct(String uid) {
        return super.get(uid);
    }
    
    public List<TOrderProduct> getOrderProductList(String uorderid) {
        String sql = "select * from t_order_product t where t.uorderid = :uorderid order by t.isort asc";
        return findList(sql, new QMap("uorderid", uorderid));
    }
    
}
