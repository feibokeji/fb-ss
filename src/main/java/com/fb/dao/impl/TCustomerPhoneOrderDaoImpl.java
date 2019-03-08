package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TCustomerPhoneOrderDao;
import com.fb.domain.po.TCustomerPhoneOrder;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月2日 下午4:37:12
 * 客户手机单据接口实现类
 */
@Service
public class TCustomerPhoneOrderDaoImpl extends SimpMapper<TCustomerPhoneOrder> implements TCustomerPhoneOrderDao {
    
    public int add(TCustomerPhoneOrder order) {
        return super.save(order);
    }
    
    public int del(String uid) {
        return super.delete(uid);
    }
    
    public int mod(TCustomerPhoneOrder order) {
        return super.update(order);
    }
    
    public int modStatus(String uid, int istatus) {
        QMap map = new QMap();
        String sql = "update t_customer_phone_order set istatus = :istatus where uid = :uid";
        map.put("uid", uid);
        map.put("istatus", istatus);
        return super.execute(sql, map);
    }
    
    public TCustomerPhoneOrder get(String uid) {
        StringBuilder sql = new StringBuilder("select cpo.uid,cpo.ucustomerid,c.cname as ccustomername,cpo.uuserid");
        sql.append(",u.cname as cusername,cpo.udeptid,cpo.cno,cpo.itype,cpo.istatus");
        sql.append(",cpo.drecorddate,cpo.dupdatedate");
        sql.append(" from t_customer_phone_order as cpo");
        sql.append(" left join t_customer as c on c.uid = cpo.ucustomerid");
        sql.append(" left join t_user as u on u.uid = cpo.uuserid");
        sql.append(" where cpo.uid = :uid");
        return super.get(sql, new QMap("uid",uid), TCustomerPhoneOrder.class);
    }
    
    public List<TCustomerPhoneOrder> get(TCustomerPhoneOrder order) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select cpo.uid,cpo.ucustomerid,c.cname as ccustomername,cpo.uuserid");
        sql.append(",u.cname as cusername,cpo.udeptid,cpo.cno,cpo.itype,cpo.istatus");
        sql.append(",cpo.drecorddate,cpo.dupdatedate");
        sql.append(" from t_customer_phone_order as cpo");
        sql.append(" left join t_customer as c on c.uid = cpo.ucustomerid");
        sql.append(" left join t_user as u on u.uid = cpo.uuserid");
        sql.append(" where 1 = 1");
        if(DataUtils.isUid(order.getUcustomerid())){
            sql.append(" and cpo.ucustomerid = :ucustomerid");
            map.put("ucustomerid", order.getUcustomerid());
        }
        if(!DataUtils.isNullOrEmpty(order.getCcustomername())){
            sql.append(" and cpo.ccustomername like :ccustomername");
            map.put("ccustomername", "%" + order.getCcustomername() + "%");
        }
        if(DataUtils.isUid(order.getUdeptid())){
            sql.append(" and cpo.udeptid = :udeptid");
            map.put("udeptid", order.getUdeptid());
        }
        if(!DataUtils.isNullOrEmpty(order.getCno())){
            sql.append(" and cpo.cno like :cno");
            map.put("cno", "%" + order.getCno() + "%");
        }
        if(order.getItype() != null && order.getItype() != -1){
            sql.append(" and cpo.itype = :itype");
            map.put("itype", order.getItype());
        }
        if(order.getIstatus() != null && order.getIstatus() != -1){
            sql.append(" and cpo.istatus = :istatus");
            map.put("istatus", order.getIstatus());
        }
        if(!DataUtils.isNullOrEmpty(order.getDrecorddateStrMin())){
            sql.append(" and cpo.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", order.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(order.getDrecorddateStrMax())){
            sql.append(" and cpo.drecorddate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", order.getDrecorddateStrMax() + " 23:59:59");
        }
        sql.append(" order by cpo.drecorddate desc");
        return super.findList(sql, map);
    }
    
}
