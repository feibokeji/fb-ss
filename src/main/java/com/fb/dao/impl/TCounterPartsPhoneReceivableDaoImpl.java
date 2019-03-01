package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TCounterPartsPhoneReceivableDao;
import com.fb.domain.po.TCounterPartsPhoneReceivable;


/**
 * @author 作者：Liu Bo
 * @version 创建时间：2019年2月24日 上午11:28:04
 * 同行手机单据应收应付表接口实现类
 */
@Service
public class TCounterPartsPhoneReceivableDaoImpl extends SimpMapper<TCounterPartsPhoneReceivable> implements TCounterPartsPhoneReceivableDao {
    
    public int add(TCounterPartsPhoneReceivable receivable) {
        return super.save(receivable);
    }
    
    public int del(String uorderid) {
        String sql = "delete from t_counterparts_phone_receivable where ucounterpartsorderid = :uorderid";
        return super.execute(sql, new QMap("uorderid",uorderid));
    }
    
    public int mod(TCounterPartsPhoneReceivable receivable) {
        return super.update(receivable);
    }
    
    public int modStatus(String uid, int istatus) {
        String sql = "update t_counterparts_phone_receivable set istatus = :istatus where uid = :uid";
        QMap map = new QMap();
        map.put("uid", uid);
        map.put("istatus", istatus);
        return super.execute(sql, map);
    }
    
    public TCounterPartsPhoneReceivable get(String uid) {
        StringBuilder sql = new StringBuilder("select cpr.uid,cpr.ucounterpartsid,c.cshopname as ccounterpartsname");
        sql.append(",cpr.ucounterpartsorderid,cpo.imei,cpr.uuserid,u.cname as cusername");
        sql.append(",cpr.udeptid,cpr.ctype,cpr.nactualamount,cpr.ndiscount,cpr.namount");
        sql.append(",cpr.istatus,cpr.drecorddate,cpr.dupdatedate");
        sql.append(" from t_counterparts_phone_receivable as cpr");
        sql.append(" left join t_counterparts as c on c.uid = cpr.ucounterpartsid");
        sql.append(" left join t_counterparts_phone_order as cpo on cpo.uid = cpr.ucounterpartsorderid");
        sql.append(" left join t_user as u on u.uid = cpr.uuserid");
        sql.append(" where cpr.uid = :uid");
        return super.get(sql, new QMap("uid",uid), TCounterPartsPhoneReceivable.class);
    }
    
    public List<TCounterPartsPhoneReceivable> get(TCounterPartsPhoneReceivable receivable) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select cpr.uid,cpr.ucounterpartsid,c.cshopname as ccounterpartsname");
        sql.append(",cpr.ucounterpartsorderid,cpo.imei,cpr.uuserid,u.cname as cusername");
        sql.append(",cpr.udeptid,cpr.ctype,cpr.nactualamount,cpr.ndiscount,cpr.namount");
        sql.append(",cpr.istatus,cpr.drecorddate,cpr.dupdatedate");
        sql.append(" from t_counterparts_phone_receivable as cpr");
        sql.append(" left join t_counterparts as c on c.uid = cpr.ucounterpartsid");
        sql.append(" left join t_counterparts_phone_order as cpo on cpo.uid = cpr.ucounterpartsorderid");
        sql.append(" left join t_user as u on u.uid = cpr.uuserid");
        sql.append(" where 1 = 1");
        if(DataUtils.isUid(receivable.getUcounterpartsid())){
            sql.append(" and cpr.ucounterpartsid = :ucounterpartsid");
            map.put("ucounterpartsid", receivable.getUcounterpartsid());
        }
        if(!DataUtils.isNullOrEmpty(receivable.getImei())){
            sql.append(" and cpo.imei like :imei");
            map.put("imei", "%" + receivable.getImei() + "%");
        }
        if(DataUtils.isUid(receivable.getUdeptid())){
            sql.append(" and cpr.udeptid = :udeptid");
            map.put("udeptid", receivable.getUdeptid());
        }
        if(!DataUtils.isNullOrEmpty(receivable.getCtype())){
            sql.append(" and cpr.ctype = :ctype");
            map.put("ctype", receivable.getCtype());
        }
        if(receivable.getIstatus() != null && receivable.getIstatus() != -1){
            sql.append(" and cpr.istatus = :istatus");
            map.put("istatus", receivable.getIstatus());
        }
        if(!DataUtils.isNullOrEmpty(receivable.getDrecorddateStrMin())){
            sql.append(" and cpr.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", receivable.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(receivable.getDrecorddateStrMax())){
            sql.append(" and cpr.drecorddate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", receivable.getDrecorddateStrMax() + " 23:59:59");
        }
        sql.append(" order by cpr.drecorddate desc");
        return super.findList(sql, map);
    }

    public List<TCounterPartsPhoneReceivable> getByUorderid(String uorderid) {
        StringBuilder sql = new StringBuilder("select cpr.uid,cpr.ucounterpartsid,c.cshopname as ccounterpartsname");
        sql.append(",cpr.ucounterpartsorderid,cpo.imei,cpr.uuserid,u.cname as cusername");
        sql.append(",cpr.udeptid,cpr.ctype,cpr.nactualamount,cpr.ndiscount,cpr.namount");
        sql.append(",cpr.istatus,cpr.drecorddate,cpr.dupdatedate");
        sql.append(" from t_counterparts_phone_receivable as cpr");
        sql.append(" left join t_counterparts as c on c.uid = cpr.ucounterpartsid");
        sql.append(" left join t_counterparts_phone_order as cpo on cpo.uid = cpr.ucounterpartsorderid");
        sql.append(" left join t_user as u on u.uid = cpr.uuserid");
        sql.append(" where cpr.ucounterpartsorderid = :uorderid");
        return super.findList(sql, new QMap("uorderid",uorderid));
    }
    
}
