package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TCounterPartsPhoneOrderDao;
import com.fb.domain.po.TCounterPartsPhoneOrder;


/**
 * @author 作者：Liu Bo
 * @version 创建时间：2019年2月23日 下午12:41:45
 * 同行手机单据接口实现类
 */
@Service
public class TCounterPartsPhoneOrderDaoImpl extends SimpMapper<TCounterPartsPhoneOrder> implements TCounterPartsPhoneOrderDao {
    
    
    public int add(TCounterPartsPhoneOrder order) {
        return super.save(order);
    }
    
    public int del(String uid) {
        return super.delete(uid);
    }
    
    public int mod(TCounterPartsPhoneOrder order) {
        return super.update(order);
    }
    
    public int modStatus(String uid, Integer istatus) {
        QMap map = new QMap();
        String sql = "update t_counterparts_phone_order set istatus = :istatus where uid = :uid";
        map.put("uid", uid);
        map.put("istatus", istatus);
        return super.execute(sql, map);
    }
    
    public TCounterPartsPhoneOrder get(String uid) {
        StringBuilder sql = new StringBuilder("select cpo.uid,cpo.ucounterpartsid,cp.cshopname as ccounterpartsname");
        sql.append(",b.uid as ubrandid,b.cname as cbrandname,pm.uid as uphonemodelid");
        sql.append(",pm.cname as cphonemodelname,cpo.imei,spo.ucolorid,c.cname as ccolorname");
        sql.append(",cpo.namount,cpo.itype,cpo.istatus,pm.cram,pm.crom,pm.ccpu,pm.ccamera");
        sql.append(",pm.cscreen,pm.cbattery,cpo.uuserid,u.cname as cusername,cpo.udeptid");
        sql.append(",cpo.drecorddate,cpo.dupdatedate");
        sql.append(" from t_counterparts_phone_order as cpo");
        sql.append(" left join t_counterparts as cp on cp.uid = cpo.ucounterpartsid");
        sql.append(" left join t_supplier_phone_order as spo on spo.imei = cpo.imei");
        sql.append(" left join t_phone_model as pm on pm.uid = spo.uphonemodelid");
        sql.append(" left join t_brand as b on b.uid = pm.ubrandid");
        sql.append(" left join t_color as c on c.uid = spo.ucolorid");
        sql.append(" left join t_user as u on u.uid = cpo.uuserid");
        sql.append(" where cpo.uid = :uid");
        return super.get(sql, new QMap("uid",uid), TCounterPartsPhoneOrder.class);
    }
    
    public List<TCounterPartsPhoneOrder> get(TCounterPartsPhoneOrder order) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select cpo.uid,cpo.ucounterpartsid,cp.cshopname as ccounterpartsname");
        sql.append(",b.uid as ubrandid,b.cname as cbrandname,pm.uid as uphonemodelid");
        sql.append(",pm.cname as cphonemodelname,cpo.imei,spo.ucolorid,c.cname as ccolorname");
        sql.append(",cpo.namount,cpo.itype,cpo.istatus,pm.cram,pm.crom,pm.ccpu,pm.ccamera");
        sql.append(",pm.cscreen,pm.cbattery,cpo.uuserid,u.cname as cusername,cpo.udeptid");
        sql.append(",cpo.drecorddate,cpo.dupdatedate");
        sql.append(" from t_counterparts_phone_order as cpo");
        sql.append(" left join t_counterparts as cp on cp.uid = cpo.ucounterpartsid");
        sql.append(" left join t_supplier_phone_order as spo on spo.imei = cpo.imei");
        sql.append(" left join t_phone_model as pm on pm.uid = spo.uphonemodelid");
        sql.append(" left join t_brand as b on b.uid = pm.ubrandid");
        sql.append(" left join t_color as c on c.uid = spo.ucolorid");
        sql.append(" left join t_user as u on u.uid = cpo.uuserid");
        sql.append(" where 1 = 1");
        if(DataUtils.isUid(order.getUcounterpartsid())){
            sql.append(" and cpo.ucounterpartsid = :ucounterpartsid");
            map.put("ucounterpartsid", order.getUcounterpartsid());
        }
        if(DataUtils.isUid(order.getUbrandid())){
            sql.append(" and b.uid = :ubrandid");
            map.put("ubrandid", order.getUbrandid());
        }
        if(!DataUtils.isNullOrEmpty(order.getCphonemodelname())){
            sql.append(" and pm.cname like :cphonemodelname");
            map.put("cphonemodelname", "%" + order.getCphonemodelname() + "%");
        }
        if(!DataUtils.isNullOrEmpty(order.getImei())){
            sql.append(" and cpo.imei like :imei");
            map.put("imei", "%" + order.getImei() + "%");
        }
        if(order.getItype() != null && order.getItype() != -1){
            sql.append(" and cpo.itype = :itype");
            map.put("itype", order.getItype());
        }
        if(order.getIstatus() != null && order.getIstatus() != -1){
            sql.append(" and cpo.istatus = :istatus");
            map.put("istatus", order.getIstatus());
        }
        if(DataUtils.isUid(order.getUdeptid())){
            sql.append(" and cpo.udeptid = :udeptid");
            map.put("udeptid", order.getUdeptid());
        }
        if(!DataUtils.isNullOrEmpty(order.getDrecorddateStrMin())){
            sql.append(" and cpo.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", order.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(order.getDrecorddateStrMax())){
            sql.append(" and cpo.drecorddate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", order.getDrecorddateStrMax() + " 23:59:59");
        }
        return super.findList(sql, map);
    }
    
}
