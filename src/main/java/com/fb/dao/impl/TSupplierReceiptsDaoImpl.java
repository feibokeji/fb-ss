package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TSupplierReceiptsDao;
import com.fb.domain.po.TSupplierReceipts;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月2日 上午9:48:36
 * 供应商实收实付表操作接口实现类
 */
@Service
public class TSupplierReceiptsDaoImpl extends SimpMapper<TSupplierReceipts> implements TSupplierReceiptsDao {
    
    
    public int add(TSupplierReceipts supplierReceipts) {
        return super.save(supplierReceipts);
    }
    
    public int del(String uid) {
        return super.delete(uid);
    }
    
    public int delAll(String ureceivableid) {
        String sql = "delete from t_supplier_receipts where ureceivableid = :ureceivableid";
        return super.execute(sql, new QMap("ureceivableid",ureceivableid));
    }
    
    public int mod(TSupplierReceipts supplierReceipts) {
        return super.update(supplierReceipts);
    }
    
    public int modStatus(String uid, int istatus) {
        String sql = "update t_supplier_receipts set istatus = :istatus where uid = :uid";
        QMap map = new QMap();
        map.put("istatus", istatus);
        map.put("uid", uid);
        return super.execute(sql, map);
    }
    
    public TSupplierReceipts get(String uid) {
        return super.get(uid);
    }
    
    public List<TSupplierReceipts> getAll(String ureceivableid) {
        StringBuilder sql = new StringBuilder("select srp.uid,srp.ureceivableid,s.uid as usupplierid,s.cname as csuppliername");
        sql.append(",so.cno as corderno,srp.upaymentmethodid,pm.cname as cpaymentmethodname");
        sql.append(",pm.ccode as cpaymentmethodcode,srp.uuserid,u.cname as cusername");
        sql.append(",srp.udeptid,d.cname as cdeptname,srp.ctype,srp.namount");
        sql.append(",srp.istatus,srp.drecorddate,srp.dupdatedate from t_supplier_receipts as srp");
        sql.append(" left join t_supplier_receivable as srb on srb.uid = srp.ureceivableid");
        sql.append(" left join t_supplier as s on s.uid = srb.usupplierid");
        sql.append(" left join t_supplier_order as so on so.uid = srb.uorderid");
        sql.append(" left join t_payment_method as pm on pm.uid = srp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = srp.uuserid");
        sql.append(" left join t_dept as d on d.uid = srp.udeptid");
        sql.append(" where srp.ureceivableid = :ureceivableid");
        sql.append(" order by srp.drecorddate desc");
        return super.findList(sql, new QMap("ureceivableid",ureceivableid));
    }

    public List<TSupplierReceipts> getList(TSupplierReceipts supplierReceipts) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select srp.uid,srp.ureceivableid,s.uid as usupplierid,s.cname as csuppliername");
        sql.append(",so.cno as corderno,srp.upaymentmethodid,pm.cname as cpaymentmethodname");
        sql.append(",pm.ccode as cpaymentmethodcode,srp.uuserid,u.cname as cusername");
        sql.append(",srp.udeptid,d.cname as cdeptname,srp.ctype,srp.namount");
        sql.append(",srp.istatus,srp.drecorddate,srp.dupdatedate from t_supplier_receipts as srp");
        sql.append(" left join t_supplier_receivable as srb on srb.uid = srp.ureceivableid");
        sql.append(" left join t_supplier as s on s.uid = srb.usupplierid");
        sql.append(" left join t_supplier_order as so on so.uid = srb.uorderid");
        sql.append(" left join t_payment_method as pm on pm.uid = srp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = srp.uuserid");
        sql.append(" left join t_dept as d on d.uid = srp.udeptid");
        sql.append(" where 1 = 1");
        if(DataUtils.isUid(supplierReceipts.getUsupplierid())){
            sql.append(" and s.uid = :usupplierid");
            map.put("usupplierid", supplierReceipts.getUsupplierid());
        }
        if(!DataUtils.isNullOrEmpty(supplierReceipts.getCorderno())){
            sql.append(" and so.cno like :corderno");
            map.put("corderno", "%" + supplierReceipts.getCorderno() + "%");
        }
        if(DataUtils.isUid(supplierReceipts.getUpaymentmethodid())){
            sql.append(" and srp.upaymentmethodid = :upaymentmethodid");
            map.put("upaymentmethodid", supplierReceipts.getUpaymentmethodid());
        }
        if(DataUtils.isUid(supplierReceipts.getUuserid())){
            sql.append(" and srp.uuserid = :uuserid");
            map.put("uuserid", supplierReceipts.getUuserid());
        }
        if(!DataUtils.isNullOrEmpty(supplierReceipts.getCtype())){
            sql.append(" and srp.ctype = :ctype");
            map.put("ctype", supplierReceipts.getCtype());
        }
        if(supplierReceipts.getIstatus() != null){
            sql.append(" and srp.istatus = :istatus");
            map.put("istatus", supplierReceipts.getIstatus());
        }
        if(!DataUtils.isNullOrEmpty(supplierReceipts.getDrecorddateStrMin())){
            sql.append(" and srp.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", supplierReceipts.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(supplierReceipts.getDrecorddateStrMax())){
            sql.append(" and srp.drecorddate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", supplierReceipts.getDrecorddateStrMax() + " 23:59:59");
        }
        sql.append(" order by srp.drecorddate desc");
        return null;
    }

    public int getOrderReceiptsNumber(String uorderid, int istatus) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select count(*) from t_supplier_receipts as srp");
        sql.append(" left join t_supplier_receivable as srb on srb.uid = srp.ureceivableid");
        sql.append(" left join t_supplier as s on s.uid = srb.usupplierid");
        sql.append(" left join t_supplier_order as so on so.uid = srb.uorderid");
        sql.append(" where 1 = 1");
        if(DataUtils.isUid(uorderid)){
            sql.append(" and so.uid = :uorderid");
            map.put("uorderid", uorderid);
        }
        if(istatus > 0){
            sql.append(" and srp.istatus = :istatus");
            map.put("istatus", istatus);
        }
        return getInt(sql, map);
    }
    
}
