package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TOrderDao;
import com.fb.domain.po.TOrder;
import com.fb.util.Util;

@Service
public class TOrderDaoImpl extends SimpMapper<TOrder>implements TOrderDao {
    
    public int addOrder(TOrder order) {
        return super.save(order);
    }
    
    public int deleteOrder(String uid) {
        return super.delete(uid);
    }
    
    public int updateOrder(TOrder order) {
        return super.update(order);
    }
    
    public TOrder getOrder(String uid) {
        return super.get(uid);
    }
    
    public List<TOrder> getOrderList(TOrder order) {
        StringBuilder sql = new StringBuilder("select * from t_order t where 1 = 1");
        QMap map = new QMap();
        if (order != null) {
            if (!DataUtils.isNullOrEmpty(order.getCtype())) {
                sql.append(" and t.ctype = :ctype");
                map.put("ctype", order.getCtype());
            }
            if (Util.isValidDate(order.getBegantime())) {
                sql.append(" and t.dordertime > = :begantime");
                map.put("begantime", order.getBegantime());
            }
            if (Util.isValidDate(order.getEndtime())) {
                sql.append(" and t.dordertime <= :endtime");
                map.put("endtime", order.getEndtime());
            }
        }
        sql.append(" order by t.dordertime desc");
        return findList(sql.toString(), map);
    }
    
    public int auditOrder(String uid, String cstatus) {
        String sql = "update t_order set cstatus = :cstatus where uid = :uid";
        QMap map = new QMap();
        map.put("cstatus", cstatus);
        map.put("uid", uid);
        return execute(sql, map);
    }
    
}
