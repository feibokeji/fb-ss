package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TOrderMaterialDao;
import com.fb.domain.po.TOrderMaterial;

@Service
public class TOrderMaterialDaoImpl extends SimpMapper<TOrderMaterial>implements TOrderMaterialDao {
    
    public int addOrderMaterial(TOrderMaterial orderMaterial) {
        return super.save(orderMaterial);
    }
    
    public int deleteOrderMaterialByUid(String uid) {
        return super.delete(uid);
    }
    
    public int deleteOrderMaterialByUOrderId(String uorderid) {
        return super.delete("uorderid", uorderid);
    }
    
    public int updateOrderMaterial(TOrderMaterial orderMaterial) {
        return super.update(orderMaterial);
    }
    
    public TOrderMaterial getOrderMaterial(String uid) {
        return super.get(uid);
    }
    
    public List<TOrderMaterial> getOrderMaterialList(String uorderid) {
        String sql = "select * from t_order_material t where t.uorderid = :uorderid order by t.isort asc";
        return findList(sql, new QMap("uorderid", uorderid));
    }
    
}
