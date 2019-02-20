package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TSupplierPhoneOrderReceiptsDao;
import com.fb.domain.po.TSupplierPhoneOrderReceipts;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月19日 上午9:24:56
 * 供应商手机单据实收实付操作接口实现类
 */
@Service
public class TSupplierPhoneOrderReceiptsDaoImpl extends SimpMapper<TSupplierPhoneOrderReceipts> implements TSupplierPhoneOrderReceiptsDao {
    
    public int add(TSupplierPhoneOrderReceipts receipts) {
        return super.save(receipts);
    }
    
    public int del(String uid) {
        return super.delete(uid);
    }
    
    public int mod(TSupplierPhoneOrderReceipts receipts) {
        return super.update(receipts);
    }
    
    public int modStatus(String uid, int istatus) {
        String sql = "update t_supplier_phone_order_receipts set istatus = :istatus where uid = :uid";
        QMap map = new QMap();
        map.put("istatus", istatus);
        map.put("uid", uid);
        return super.execute(sql, map);
    }
    
    public TSupplierPhoneOrderReceipts get(String uid) {
        StringBuilder sql = new StringBuilder("select sporp.uid,sporp.ureceivableid,sporb.usupplierid,sporb.imei");
        sql.append(",sporp.upaymentmethodid,pm.ccode as cpaymentmethodcode,pm.cname as cpaymentmethodname");
        sql.append(",sporp.uuserid,u.cname as cusername,sporp.udeptid,sporp.ctype");
        sql.append(",sporp.namount,sporp.istatus,sporp.drecorddate,sporp.dupdatedate");
        sql.append(" from t_supplier_phone_order_receipts as sporp");
        sql.append(" left join t_supplier_phone_order_receivable as sporb on sporb.uid = sporp.ureceivableid");
        sql.append(" left join t_payment_method as pm on pm.uid = sporp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = sporp.uuserid");
        sql.append(" where sporp.uid = :uid");
        return super.get(sql, new QMap("uid",uid), TSupplierPhoneOrderReceipts.class);
    }
    
    public List<TSupplierPhoneOrderReceipts> get(TSupplierPhoneOrderReceipts receipts) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select sporp.uid,sporp.ureceivableid,sporb.usupplierid,sporb.imei");
        sql.append(",sporp.upaymentmethodid,pm.ccode as cpaymentmethodcode,pm.cname as cpaymentmethodname");
        sql.append(",sporp.uuserid,u.cname as cusername,sporp.udeptid,sporp.ctype");
        sql.append(",sporp.namount,sporp.istatus,sporp.drecorddate,sporp.dupdatedate");
        sql.append(" from t_supplier_phone_order_receipts as sporp");
        sql.append(" left join t_supplier_phone_order_receivable as sporb on sporb.uid = sporp.ureceivableid");
        sql.append(" left join t_payment_method as pm on pm.uid = sporp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = sporp.uuserid");
        sql.append(" where 1 = 1");
        if(DataUtils.isUid(receipts.getUreceivableid())){
            sql.append(" and sporp.ureceivableid = :ureceivableid");
            map.put("ureceivableid", receipts.getUreceivableid());
        }
        if(DataUtils.isUid(receipts.getUsupplierid())){
            sql.append(" and sporb.usupplierid = :usupplierid");
            map.put("usupplierid", receipts.getUsupplierid());
        }
        if(!DataUtils.isNullOrEmpty(receipts.getImei())){
            sql.append(" and sporb.imei like :imei");
            map.put("imei", "%" + receipts.getImei() + "%");
        }
        if(DataUtils.isUid(receipts.getUpaymentmethodid())){
            sql.append(" and sporp.upaymentmethodid = :upaymentmethodid");
            map.put("upaymentmethodid", receipts.getUpaymentmethodid());
        }
        if(!DataUtils.isNullOrEmpty(receipts.getCtype())){
            sql.append(" and sporp.ctype = :ctype");
            map.put("ctype", receipts.getCtype());
        }
        if(receipts.getIstatus() != null && receipts.getIstatus() != -1){
            sql.append(" and sporp.istatus = :istatus");
            map.put("istatus", receipts.getIstatus());
        }
        if(!DataUtils.isNullOrEmpty(receipts.getDrecorddateStrMin())){
            sql.append(" and sporp.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", receipts.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(receipts.getDrecorddateStrMax())){
            sql.append(" and sporp.drecorddate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", receipts.getDrecorddateStrMax() + " 23:59:59");
        }
        return super.findList(sql, map);
    }
    
    public int getReceiptsNum(String imei) {
        StringBuilder sql = new StringBuilder("select count(*)");
        sql.append(" from t_supplier_phone_order_receipts as sporp");
        sql.append(" left join t_supplier_phone_order_receivable as sporb on sporb.uid = sporp.ureceivableid");
        sql.append(" left join t_payment_method as pm on pm.uid = sporp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = sporp.uuserid");
        sql.append(" where sporb.imei = :imei");
        return super.getInt(sql, new QMap("imei",imei));
    }

    public List<TSupplierPhoneOrderReceipts> getByUreceivableid(String ureceivableid) {
        StringBuilder sql = new StringBuilder("select sporp.uid,sporp.ureceivableid,sporb.usupplierid,sporb.imei");
        sql.append(",sporp.upaymentmethodid,pm.ccode as cpaymentmethodcode,pm.cname as cpaymentmethodname");
        sql.append(",sporp.uuserid,u.cname as cusername,sporp.udeptid,sporp.ctype");
        sql.append(",sporp.namount,sporp.istatus,sporp.drecorddate,sporp.dupdatedate");
        sql.append(" from t_supplier_phone_order_receipts as sporp");
        sql.append(" left join t_supplier_phone_order_receivable as sporb on sporb.uid = sporp.ureceivableid");
        sql.append(" left join t_payment_method as pm on pm.uid = sporp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = sporp.uuserid");
        sql.append(" where sporp.ureceivableid = :ureceivableid");
        return super.findList(sql, new QMap("ureceivableid",ureceivableid));
    }
}
