package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TCustomerOrderDao;
import com.fb.domain.po.TCustomerOrder;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月1日 下午7:58:11
 * 客户商品单据接口实现类
 */
@Service
public class TCustomerOrderDaoImpl extends SimpMapper<TCustomerOrder> implements TCustomerOrderDao {
    
    
    public int add(TCustomerOrder order) {
        return super.save(order);
    }
    
    public int del(String uid) {
        return super.delete(uid);
    }
    
    public int mod(TCustomerOrder order) {
        return super.update(order);
    }
    
    public int modStatus(String uid, int istatus) {
        String sql = "update t_customer_order set istatus = :istatus where uid = :uid";
        QMap map = new QMap();
        map.put("uid", uid);
        map.put("istatus", istatus);
        return super.execute(sql, map);
    }
    
    public TCustomerOrder get(String uid) {
        StringBuilder sql = new StringBuilder("select co.uid,co.ucustomerid,c.cname as ccustomername,co.uuserid,u.cname as cusername");
        sql.append(",co.udeptid,co.cno,co.itype,co.istatus,co.drecorddate,co.dupdatedate");
        sql.append(" from t_customer_order as co");
        sql.append(" left join t_customer as c on c.uid = co.ucustomerid");
        sql.append(" left join t_user as u on u.uid = co.uuserid");
        sql.append(" where co.uid = :uid");
        return super.get(sql, new QMap("uid",uid), TCustomerOrder.class);
    }
    
    public List<TCustomerOrder> get(TCustomerOrder order) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select co.uid,co.ucustomerid,c.cname as ccustomername,co.uuserid,u.cname as cusername");
        sql.append(",co.udeptid,co.cno,co.itype,co.istatus,co.drecorddate,co.dupdatedate");
        sql.append(" from t_customer_order as co");
        sql.append(" left join t_customer as c on c.uid = co.ucustomerid");
        sql.append(" left join t_user as u on u.uid = co.uuserid");
        sql.append(" where 1 = 1");
        if(!DataUtils.isNullOrEmpty(order.getCcustomername())){
            sql.append(" and c.cname like :ccustomername");
            map.put("ccustomername", "%" + order.getCcustomername() + "%");
        }
        if(DataUtils.isUid(order.getUdeptid())){
            sql.append(" and co.udeptid = :udeptid");
            map.put("udeptid", order.getUdeptid());
        }
        if(!DataUtils.isNullOrEmpty(order.getCno())){
            sql.append(" and co.cno like :cno");
            map.put("cno", "%" + order.getCno() + "%");
        }
        if(order.getItype() != null && order.getItype() != -1){
            sql.append(" and co.itype = :itype");
            map.put("itype", order.getItype());
        }
        if(order.getIstatus() != null && order.getIstatus() != -1){
            sql.append(" and co.istatus = :istatus");
            map.put("istatus", order.getIstatus());
        }
        if(!DataUtils.isNullOrEmpty(order.getDrecorddateStrMin())){
            sql.append(" and co.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", order.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(order.getDrecorddateStrMax())){
            sql.append(" and co.drecorddate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", order.getDrecorddateStrMax() + " 23:59:59");
        }
        sql.append(" order by co.drecorddate desc");
        return super.findList(sql, map);
    }
    
}
