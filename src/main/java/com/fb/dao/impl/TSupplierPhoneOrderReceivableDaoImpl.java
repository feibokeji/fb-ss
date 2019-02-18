package com.fb.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TSupplierPhoneOrderReceivableDao;
import com.fb.domain.po.TSupplierPhoneOrderReceivable;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月16日 下午2:27:31
 * 供应商手机单据应收应付操作接口实现类
 */
@Service
public class TSupplierPhoneOrderReceivableDaoImpl extends SimpMapper<TSupplierPhoneOrderReceivable> implements TSupplierPhoneOrderReceivableDao {
    
    public int add(TSupplierPhoneOrderReceivable receivable) {
        return super.save(receivable);
    }
    
    public int del(String uid){
        return super.delete(uid);
    }
    
    public int delByIMEI(String imei) {
        String sql = "delete from t_supplier_phone_order_receivable where imei = :imei";
        return super.execute(sql, new QMap("imei",imei));
    }
    
    public int mod(TSupplierPhoneOrderReceivable receivable) {
        return super.update(receivable);
    }
    
    public int modStatus(String uid, int istatus, Date dupdatedate) {
        String sql = "update t_supplier_phone_order_receivable set istatus = :istatus,dupdatedate = :dupdatedate where uid = :uid";
        QMap map = new QMap();
        map.put("uid", uid);
        map.put("istatus", istatus);
        map.put("dupdatedate", dupdatedate);
        return super.execute(sql, map);
    }
    
    public TSupplierPhoneOrderReceivable get(String uid) {
        StringBuilder sql = new StringBuilder("select spor.uid,spor.usupplierid,s.cname as csuppliername,");
        sql.append("spor.imei,spor.uuserid,u.cname as cusername,spor.udeptid,");
        sql.append("spor.ctype,spor.nactualamount,spor.ndiscount,spor.namount,");
        sql.append("spor.istatus,spor.drecorddate,spor.dupdatedate");
        sql.append(" from t_supplier_phone_order_receivable as spor");
        sql.append(" left join t_supplier as s on s.uid = spor.usupplierid");
        sql.append(" left join t_user as u on u.uid = spor.uuserid");
        sql.append(" where spor.uid = :uid");
        return super.get(sql, new QMap("uid",uid), TSupplierPhoneOrderReceivable.class);
    }
    
    public List<TSupplierPhoneOrderReceivable> getByIMEI(String imei) {
        StringBuilder sql = new StringBuilder("select spor.uid,spor.usupplierid,s.cname as csuppliername,");
        sql.append("spor.imei,spor.uuserid,u.cname as cusername,spor.udeptid,");
        sql.append("spor.ctype,spor.nactualamount,spor.ndiscount,spor.namount,");
        sql.append("spor.istatus,spor.drecorddate,spor.dupdatedate");
        sql.append(" from t_supplier_phone_order_receivable as spor");
        sql.append(" left join t_supplier as s on s.uid = spor.usupplierid");
        sql.append(" left join t_user as u on u.uid = spor.uuserid");
        sql.append(" where spor.imei = :imei");
        return super.findList(sql, new QMap("imei",imei));
    }
    
    public List<TSupplierPhoneOrderReceivable> get(TSupplierPhoneOrderReceivable receivable) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select spor.uid,spor.usupplierid,s.cname as csuppliername,");
        sql.append("spor.IMEI,spor.uuserid,u.cname as cusername,spor.udeptid,");
        sql.append("spor.ctype,spor.nactualamount,spor.ndiscount,spor.namount,");
        sql.append("spor.istatus,spor.drecorddate,spor.dupdatedate");
        sql.append(" from t_supplier_phone_order_receivable as spor");
        sql.append(" left join t_supplier as s on s.uid = spor.usupplierid");
        sql.append(" left join t_user as u on u.uid = spor.uuserid");
        sql.append(" where 1 = 1");
        if(DataUtils.isUid(receivable.getUsupplierid())){
            sql.append(" and spor.usupplierid = :usupplierid");
            map.put("usupplierid", receivable.getUsupplierid());
        }
        if(DataUtils.isUid(receivable.getUdeptid())){
            sql.append(" and spor.udeptid = :udeptid");
            map.put("udeptid", receivable.getUdeptid());
        }
        if(!DataUtils.isNullOrEmpty(receivable.getCtype())){
            sql.append(" and spor.ctype = :ctype");
            map.put("ctype", receivable.getCtype());
        }
        if(receivable.getIstatus() != null && receivable.getIstatus() != -1){
            sql.append(" and spor.istatus = :istatus");
            map.put("istatus", receivable.getIstatus());
        }
        if(!DataUtils.isNullOrEmpty(receivable.getDrecorddateStrMin())){
            sql.append(" and spor.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", receivable.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(receivable.getDrecorddateStrMax())){
            sql.append(" and spor.drecorddate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", receivable.getDrecorddateStrMax() + " 23:59:59");
        }
        sql.append(" order by spor.drecorddate desc");
        return super.findList(sql, map);
    }
    
}
