package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TCounterPartsPhoneReceiptsDao;
import com.fb.domain.po.TCounterPartsPhoneReceipts;


/**
 * @author 作者：Liu Bo
 * @version 创建时间：2019年2月24日 上午11:29:53
 * 同行手机单据实收实付表接口实现类
 */
@Service
public class TCounterPartsPhoneReceiptsDaoImpl extends SimpMapper<TCounterPartsPhoneReceipts> implements TCounterPartsPhoneReceiptsDao {
    
    public int add(TCounterPartsPhoneReceipts receipts) {
        return super.save(receipts);
    }
    
    public int del(String uid) {
        return super.delete(uid);
    }
    
    public int delByUreceivableid(String ureceivableid) {
        String sql = "delete from t_counterparts_phone_receipts where ureceivableid = :ureceivableid";
        return super.execute(sql, new QMap("ureceivableid",ureceivableid));
    }
    
    public int mod(TCounterPartsPhoneReceipts receipts) {
        return super.update(receipts);
    }
    
    public int modStatus(String uid, int istatus) {
        String sql = "update t_counterparts_phone_receipts set istatus = :istatus where uid = :uid";
        QMap map = new QMap();
        map.put("uid", uid);
        map.put("istatus", istatus);
        return super.execute(sql, map);
    }
    
    public TCounterPartsPhoneReceipts get(String uid) {
        StringBuilder sql = new StringBuilder("select cpr.uid,cpr.ureceivableid,cprb.ucounterpartsid,c.cshopname as ccounterpartsname");
        sql.append(",cpo.imei,cpr.upaymentmethodid,pm.ccode as cpaymentmethodcode,pm.cname as cpaymentmethodname");
        sql.append(",cpr.uuserid,u.cname as cusername,cpr.udeptid,cpr.ctype,cpr.istatus,cpr.namount");
        sql.append(",cpr.drecorddate,cpr.dupdatedate");
        sql.append(" from t_counterparts_phone_receipts as cpr");
        sql.append(" left join t_counterparts_phone_receivable as cprb on cprb.uid = cpr.ureceivableid");
        sql.append(" left join t_counterparts as c on c.uid = cprb.ucounterpartsid");
        sql.append(" left join t_counterparts_phone_order as cpo on cpo.uid = cprb.ucounterpartsorderid");
        sql.append(" left join t_payment_method as pm on pm.uid = cpr.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = cpr.uuserid");
        sql.append(" where cpr.uid = :uid");
        return super.get(sql, new QMap("uid",uid), TCounterPartsPhoneReceipts.class);
    }
    
    public List<TCounterPartsPhoneReceipts> getByUreceivableid(String ureceivableid) {
        StringBuilder sql = new StringBuilder("select cpr.uid,cpr.ureceivableid,cprb.ucounterpartsid,c.cshopname as ccounterpartsname");
        sql.append(",cpo.imei,cpr.upaymentmethodid,pm.ccode as cpaymentmethodcode,pm.cname as cpaymentmethodname");
        sql.append(",cpr.uuserid,u.cname as cusername,cpr.udeptid,cpr.ctype,cpr.istatus,cpr.namount");
        sql.append(",cpr.drecorddate,cpr.dupdatedate");
        sql.append(" from t_counterparts_phone_receipts as cpr");
        sql.append(" left join t_counterparts_phone_receivable as cprb on cprb.uid = cpr.ureceivableid");
        sql.append(" left join t_counterparts as c on c.uid = cprb.ucounterpartsid");
        sql.append(" left join t_counterparts_phone_order as cpo on cpo.uid = cprb.ucounterpartsorderid");
        sql.append(" left join t_payment_method as pm on pm.uid = cpr.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = cpr.uuserid");
        sql.append(" where cpr.ureceivableid = :ureceivableid");
        return super.findList(sql, new QMap("ureceivableid",ureceivableid));
    }
    
    public List<TCounterPartsPhoneReceipts> get(TCounterPartsPhoneReceipts receipts) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select cpr.uid,cpr.ureceivableid,cprb.ucounterpartsid,c.cshopname as ccounterpartsname");
        sql.append(",cpo.imei,cpr.upaymentmethodid,pm.ccode as cpaymentmethodcode,pm.cname as cpaymentmethodname");
        sql.append(",cpr.uuserid,u.cname as cusername,cpr.udeptid,cpr.ctype,cpr.istatus,cpr.namount");
        sql.append(",cpr.drecorddate,cpr.dupdatedate");
        sql.append(" from t_counterparts_phone_receipts as cpr");
        sql.append(" left join t_counterparts_phone_receivable as cprb on cprb.uid = cpr.ureceivableid");
        sql.append(" left join t_counterparts as c on c.uid = cprb.ucounterpartsid");
        sql.append(" left join t_counterparts_phone_order as cpo on cpo.uid = cprb.ucounterpartsorderid");
        sql.append(" left join t_payment_method as pm on pm.uid = cpr.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = cpr.uuserid");
        sql.append(" where 1 = 1");
        if(DataUtils.isUid(receipts.getUcounterpartsid())){
            sql.append(" and cprb.ucounterpartsid = :ucounterpartsid");
            map.put("ucounterpartsid", receipts.getUcounterpartsid());
        }
        if(!DataUtils.isNullOrEmpty(receipts.getImei())){
            sql.append(" and cpo.imei like :imei");
            map.put("imei", "%" + receipts.getImei() + "%");
        }
        if(!DataUtils.isNullOrEmpty(receipts.getCtype())){
            sql.append(" and cpr.ctype = :ctype");
            map.put("ctype", receipts.getCtype());
        }
        if(receipts.getIstatus() != null && receipts.getIstatus() != -1){
            sql.append(" and cpr.istatus = :istatus");
            map.put("istatus", receipts.getIstatus());
        }
        if(!DataUtils.isNullOrEmpty(receipts.getDrecorddateStrMin())){
            sql.append(" and cpr.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", receipts.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(receipts.getDrecorddateStrMax())){
            sql.append(" and cpr.drecorddate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", receipts.getDrecorddateStrMax() + " 23:59:59");
        }
        sql.append(" order by cpr.drecorddate desc");
        return super.findList(sql, map);
    }

    public int getOrderReceiptsNum(String uorderid) {
        StringBuilder sql = new StringBuilder("select count(*)");
        sql.append(" from t_counterparts_phone_receipts as cpr");
        sql.append(" left join t_counterparts_phone_receivable as cprb on cprb.uid = cpr.ureceivableid");
        sql.append(" left join t_counterparts_phone_order as cpo on cpo.uid = cprb.ucounterpartsorderid");
        sql.append(" where cpo.uid = :uorderid");
        return super.getInt(sql, new QMap("uorderid",uorderid));
    }
    
}
