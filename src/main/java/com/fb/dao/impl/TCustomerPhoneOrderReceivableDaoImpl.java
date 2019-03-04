package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TCustomerPhoneOrderReceivableDao;
import com.fb.domain.po.TCustomerPhoneOrderReceivable;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月2日 下午6:19:14
 * 客户手机单据[应收/应付]接口实现类
 */
@Service
public class TCustomerPhoneOrderReceivableDaoImpl extends SimpMapper<TCustomerPhoneOrderReceivable> implements TCustomerPhoneOrderReceivableDao {
    
    public int add(TCustomerPhoneOrderReceivable receivable) {
        return super.save(receivable);
    }
    
    public int delByOrder(String uorderid) {
        String sql = "delete from t_customer_phone_order_receivable where ucustomerphoneorderid = :uorderid";
        return super.execute(sql, new QMap("uorderid",uorderid));
    }
    
    public int mod(TCustomerPhoneOrderReceivable receivable) {
        return super.update(receivable);
    }
    
    public int modStatus(String uid, int istatus) {
        String sql = "update t_customer_phone_order_receivable set istatus = :istatus where uid = :uid";
        QMap map = new QMap();
        map.put("istatus", istatus);
        map.put("uid", uid);
        return super.execute(sql, map);
    }
    
    public List<TCustomerPhoneOrderReceivable> getByOrder(String uorderid) {
        StringBuilder sql = new StringBuilder("select cpor.uid,cpor.ucustomerid,c.cname as ccustomername,cpor.ucustomerphoneorderid");
        sql.append(",cpo.imei,cpor.uuserid,u.cname as cusername,cpor.udeptid,cpor.ctype,cpor.nactualamount");
        sql.append(",cpor.ndiscount,cpor.namount,cpor.istatus,cpor.drecorddate,cpor.dupdatedate");
        sql.append(" from t_customer_phone_order_receivable as cpor");
        sql.append(" left join t_customer as c on c.uid = cpor.ucustomerid");
        sql.append(" left join t_customer_phone_order as cpo on cpo.uid = cpor.ucustomerphoneorderid");
        sql.append(" left join t_user as u on u.uid = cpor.uuserid");
        sql.append(" where cpor.ucustomerphoneorderid = :ucustomerphoneorderid");
        return super.findList(sql, new QMap("ucustomerphoneorderid",uorderid));
    }
    
    public List<TCustomerPhoneOrderReceivable> get(TCustomerPhoneOrderReceivable receivable) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select cpor.uid,cpor.ucustomerid,c.cname as ccustomername,cpor.ucustomerphoneorderid");
        sql.append(",cpo.imei,cpor.uuserid,u.cname as cusername,cpor.udeptid,cpor.ctype,cpor.nactualamount");
        sql.append(",cpor.ndiscount,cpor.namount,cpor.istatus,cpor.drecorddate,cpor.dupdatedate");
        sql.append(" from t_customer_phone_order_receivable as cpor");
        sql.append(" left join t_customer as c on c.uid = cpor.ucustomerid");
        sql.append(" left join t_customer_phone_order as cpo on cpo.uid = cpor.ucustomerphoneorderid");
        sql.append(" left join t_user as u on u.uid = cpor.uuserid");
        sql.append(" where 1 = 1");
        if(DataUtils.isUid(receivable.getUcustomerid())){
            sql.append(" and cpor.ucustomerid = :ucustomerid");
            map.put("ucustomerid", receivable.getUcustomerid());
        }
        if(!DataUtils.isNullOrEmpty(receivable.getCcustomername())){
            sql.append(" and c.cname like :ccustomername");
            map.put("ccustomername", "%" + receivable.getCcustomername() + "%");
        }
        if(DataUtils.isUid(receivable.getUcustomerphoneorderid())){
            sql.append(" and cpor.ucustomerphoneorderid = :ucustomerphoneorderid");
            map.put("ucustomerphoneorderid", receivable.getUcustomerphoneorderid());
        }
        if(!DataUtils.isNullOrEmpty(receivable.getImei())){
            sql.append(" and cpo.imei like :imei");
            map.put("imei", "%" + receivable.getImei() + "%");
        }
        if(DataUtils.isUid(receivable.getUdeptid())){
            sql.append(" and cpor.udeptid = :udeptid");
            map.put("udeptid", receivable.getUdeptid());
        }
        if(!DataUtils.isNullOrEmpty(receivable.getCtype())){
            sql.append(" and cpor.ctype = :ctype");
            map.put("ctype", receivable.getCtype());
        }
        if(receivable.getIstatus() != null && receivable.getIstatus() != -1){
            sql.append(" and cpor.istatus = :istatus");
            map.put("istatus", receivable.getIstatus());
        }
        if(!DataUtils.isNullOrEmpty(receivable.getDrecorddateStrMin())){
            sql.append(" and cpor.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", receivable.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(receivable.getDrecorddateStrMax())){
            sql.append(" and cpor.drecorddate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", receivable.getDrecorddateStrMax() + " 23:59:59");
        }
        sql.append(" order by cpor.drecorddate desc");
        return super.findList(sql, map);
    }
    
}
