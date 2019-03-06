package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TCustomerPhoneOrderReceiptsDao;
import com.fb.domain.po.TCustomerPhoneOrderReceipts;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月4日 下午7:36:24
 * 客户手机单据实收实付接口实现类
 */
@Service
public class TCustomerPhoneOrderReceiptsDaoImpl extends SimpMapper<TCustomerPhoneOrderReceipts> implements TCustomerPhoneOrderReceiptsDao {
    
    public int add(TCustomerPhoneOrderReceipts receipts) {
        return super.save(receipts);
    }
    
    public int del(String uid) {
        return super.delete(uid);
    }
    
    public int delByReceivable(String ureceivableid) {
        String sql = "delete from t_customer_phone_order_receipts where ureceivableid = :ureceivableid";
        return super.execute(sql, new QMap("ureceivableid",ureceivableid));
    }
    
    public int mod(TCustomerPhoneOrderReceipts receipts) {
        return super.update(receipts);
    }
    
    public int modStatus(String uid, int istatus) {
        String sql = "update t_customer_phone_order_receipts set istatus = :istatus where uid = :uid";
        QMap map = new QMap();
        map.put("uid", uid);
        map.put("istatus", istatus);
        return super.execute(sql, map);
    }
    
    public TCustomerPhoneOrderReceipts get(String uid) {
        StringBuilder sql = new StringBuilder("select cporp.uid,cporp.ureceivableid,cpo.imei,cporp.upaymentmethodid,pm.ccode as cpaymentmethodcode");
        sql.append(",pm.cname as cpaymentmethodname,cporp.uuserid,u.cname as cusername,cporp.udeptid,cporp.ctype");
        sql.append(",cporp.namount,cporp.istatus,cporp.drecorddate,cporp.dupdatedate");
        sql.append(" from t_customer_phone_order_receipts as cporp");
        sql.append(" left join t_customer_phone_order_receivable as cporb on cporb.uid = cporp.ureceivableid");
        sql.append(" left join t_customer_phone_order as cpo on cpo.uid = cporb.ucustomerphoneorderid");
        sql.append(" left join t_payment_method as pm on pm.uid = cporp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = cporp.uuserid");
        sql.append(" where cporp.uid = :uid");
        return super.get(sql, new QMap("uid",uid), TCustomerPhoneOrderReceipts.class);
    }
    
    public List<TCustomerPhoneOrderReceipts> getByReceivable(String ureceivableid) {
        StringBuilder sql = new StringBuilder("select cporp.uid,cporp.ureceivableid,cpo.imei,cporp.upaymentmethodid,pm.ccode as cpaymentmethodcode");
        sql.append(",pm.cname as cpaymentmethodname,cporp.uuserid,u.cname as cusername,cporp.udeptid,cporp.ctype");
        sql.append(",cporp.namount,cporp.istatus,cporp.drecorddate,cporp.dupdatedate");
        sql.append(" from t_customer_phone_order_receipts as cporp");
        sql.append(" left join t_customer_phone_order_receivable as cporb on cporb.uid = cporp.ureceivableid");
        sql.append(" left join t_customer_phone_order as cpo on cpo.uid = cporb.ucustomerphoneorderid");
        sql.append(" left join t_payment_method as pm on pm.uid = cporp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = cporp.uuserid");
        sql.append(" where cporp.ureceivableid = :ureceivableid");
        return super.findList(sql, new QMap("ureceivableid",ureceivableid));
    }
    
    public int getStatusNumByReceivable(String ureceivableid, int istatus) {
        String sql = "select count(*) from t_customer_phone_order_receipts where ureceivableid = :ureceivableid and istatus = :istatus";
        QMap map = new QMap();
        map.put("ureceivableid", ureceivableid);
        map.put("istatus", istatus);
        return super.getInt(sql, map);
    }
    
    public List<TCustomerPhoneOrderReceipts> get(TCustomerPhoneOrderReceipts receipts) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select cporp.uid,cporp.ureceivableid,cpo.imei,cporp.upaymentmethodid,pm.ccode as cpaymentmethodcode");
        sql.append(",pm.cname as cpaymentmethodname,cporp.uuserid,u.cname as cusername,cporp.udeptid,cporp.ctype");
        sql.append(",cporp.namount,cporp.istatus,cporp.drecorddate,cporp.dupdatedate");
        sql.append(" from t_customer_phone_order_receipts as cporp");
        sql.append(" left join t_customer_phone_order_receivable as cporb on cporb.uid = cporp.ureceivableid");
        sql.append(" left join t_customer_phone_order as cpo on cpo.uid = cporb.ucustomerphoneorderid");
        sql.append(" left join t_payment_method as pm on pm.uid = cporp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = cporp.uuserid");
        sql.append(" where 1 = 1");
        if(DataUtils.isUid(receipts.getUreceivableid())){
            sql.append(" and cporp.ureceivableid = :ureceivableid");
            map.put("ureceivableid", receipts.getUreceivableid());
        }
        if(!DataUtils.isNullOrEmpty(receipts.getImei())){
            sql.append(" and cpo.imei like :imei");
            map.put("imei", "%" + receipts.getImei() + "%");
        }
        if(DataUtils.isUid(receipts.getUpaymentmethodid())){
            sql.append(" and cporp.upaymentmethodid = :upaymentmethodid");
            map.put("upaymentmethodid", receipts.getUpaymentmethodid());
        }
        if(DataUtils.isUid(receipts.getUdeptid())){
            sql.append(" and cporp.udeptid = :udeptid");
            map.put("udeptid", receipts.getUdeptid());
        }
        if(!DataUtils.isNullOrEmpty(receipts.getCtype())){
            sql.append(" and cporp.ctype = :ctype");
            map.put("ctype", receipts.getCtype());
        }
        if(receipts.getIstatus() != null && receipts.getIstatus() != -1){
            sql.append(" and cporp.istatus = :istatus");
            map.put("istatus", receipts.getIstatus());
        }
        if(!DataUtils.isNullOrEmpty(receipts.getDrecorddateStrMin())){
            sql.append(" and cporp.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", receipts.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(receipts.getDrecorddateStrMax())){
            sql.append(" and cporp.drecorddate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", receipts.getDrecorddateStrMax() + " 23:59:59");
        }
        return super.findList(sql, map);
    }

    public List<TCustomerPhoneOrderReceipts> getByOrder(String uorderid) {
        StringBuilder sql = new StringBuilder("select cporp.uid,cporp.ureceivableid,cpo.imei,cporp.upaymentmethodid,pm.ccode as cpaymentmethodcode");
        sql.append(",pm.cname as cpaymentmethodname,cporp.uuserid,u.cname as cusername,cporp.udeptid,cporp.ctype");
        sql.append(",cporp.namount,cporp.istatus,cporp.drecorddate,cporp.dupdatedate");
        sql.append(" from t_customer_phone_order_receipts as cporp");
        sql.append(" left join t_customer_phone_order_receivable as cporb on cporb.uid = cporp.ureceivableid");
        sql.append(" left join t_customer_phone_order as cpo on cpo.uid = cporb.ucustomerphoneorderid");
        sql.append(" left join t_payment_method as pm on pm.uid = cporp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = cporp.uuserid");
        sql.append(" where cpo.uid = :uorderid");
        return super.findList(sql, new QMap("uorderid",uorderid));
    }
    
}
