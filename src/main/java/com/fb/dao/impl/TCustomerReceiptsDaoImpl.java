package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TCustomerReceiptsDao;
import com.fb.domain.po.TCustomerReceipts;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月2日 上午10:34:24
 * 商品单据实收实付接口实现类
 */
@Service
public class TCustomerReceiptsDaoImpl extends SimpMapper<TCustomerReceipts> implements TCustomerReceiptsDao {
    
    
    public int add(TCustomerReceipts receipts) {
        return super.save(receipts);
    }
    
    public int del(String uid) {
        return super.delete(uid);
    }
    
    public int delByReceivable(String ureceivableid) {
        String sql = "delete from t_customer_receipts where ureceivableid = :ureceivableid";
        return super.execute(sql, new QMap("ureceivableid",ureceivableid));
    }
    
    public int mod(TCustomerReceipts receipts) {
        return super.update(receipts);
    }
    
    public int modStatus(String uid, int istatus) {
        QMap map = new QMap();
        String sql = "update t_customer_receipts set istatus = :istatus where uid = :uid";
        map.put("uid", uid);
        map.put("istatus", istatus);
        return super.execute(sql, map);
    }
    
    public List<TCustomerReceipts> getByReceivable(String ureceivableid) {
        StringBuilder sql = new StringBuilder("select crp.uid,crp.ureceivableid,co.cno as corderno,crp.upaymentmethodid");
        sql.append(",pm.ccode as cpaymentmethodcode,pm.cname as cpaymentmethodname,crp.uuserid");
        sql.append(",u.cname as cusername,crp.udeptid,crp.ctype,crp.namount,crp.istatus");
        sql.append(",crp.drecorddate,crp.dupdatedate");
        sql.append(" from t_customer_receipts as crp");
        sql.append(" left join t_customer_receivable as crb on crb.uid = crp.ureceivableid");
        sql.append(" left join t_customer_order as co on co.uid = crb.uorderid");
        sql.append(" left join t_payment_method as pm on pm.uid = crp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = crp.uuserid");
        sql.append(" where crp.ureceivableid = :ureceivableid");
        return super.findList(sql, new QMap("ureceivableid",ureceivableid));
    }
    
    public List<TCustomerReceipts> getReceipts(TCustomerReceipts receipts) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select crp.uid,crp.ureceivableid,co.cno as corderno,crp.upaymentmethodid");
        sql.append(",pm.ccode as cpaymentmethodcode,pm.cname as cpaymentmethodname,crp.uuserid");
        sql.append(",u.cname as cusername,crp.udeptid,crp.ctype,crp.namount,crp.istatus");
        sql.append(",crp.drecorddate,crp.dupdatedate");
        sql.append(" from t_customer_receipts as crp");
        sql.append(" left join t_customer_receivable as crb on crb.uid = crp.ureceivableid");
        sql.append(" left join t_customer_order as co on co.uid = crb.uorderid");
        sql.append(" left join t_payment_method as pm on pm.uid = crp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = crp.uuserid");
        sql.append(" where 1 = 1");
        if(!DataUtils.isNullOrEmpty(receipts.getCorderno())){
            sql.append(" and co.cno like :corderno");
            map.put("corderno", "%" + receipts.getCorderno() + "%");
        }
        if(DataUtils.isUid(receipts.getUpaymentmethodid())){
            sql.append(" and crp.upaymentmethodid = :upaymentmethodid");
            map.put("upaymentmethodid", receipts.getUpaymentmethodid());
        }
        if(DataUtils.isUid(receipts.getUdeptid())){
            sql.append(" and crp.udeptid = :udeptid");
            map.put("udeptid", receipts.getUdeptid());
        }
        if(!DataUtils.isNullOrEmpty(receipts.getCtype())){
            sql.append(" and crp.ctype = :ctype");
            map.put("ctype", receipts.getCtype());
        }
        if(receipts.getIstatus() != null && receipts.getIstatus() != -1){
            sql.append(" and crp.istatus = :istatus");
            map.put("istatus", receipts.getIstatus());
        }
        if(!DataUtils.isNullOrEmpty(receipts.getDrecorddateStrMin())){
            sql.append(" and crp.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", receipts.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(receipts.getDrecorddateStrMax())){
            sql.append(" and crp.dupdatedate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", receipts.getDrecorddateStrMax() + " 23:59:59");
        }
        return super.findList(sql, map);
    }

    public List<TCustomerReceipts> getReceiptsByOrder(String uorderid) {
        StringBuilder sql = new StringBuilder("select crp.uid,crp.ureceivableid,co.cno as corderno,crp.upaymentmethodid");
        sql.append(",pm.ccode as cpaymentmethodcode,pm.cname as cpaymentmethodname,crp.uuserid");
        sql.append(",u.cname as cusername,crp.udeptid,crp.ctype,crp.namount,crp.istatus");
        sql.append(",crp.drecorddate,crp.dupdatedate");
        sql.append(" from t_customer_receipts as crp");
        sql.append(" left join t_customer_receivable as crb on crb.uid = crp.ureceivableid");
        sql.append(" left join t_customer_order as co on co.uid = crb.uorderid");
        sql.append(" left join t_payment_method as pm on pm.uid = crp.upaymentmethodid");
        sql.append(" left join t_user as u on u.uid = crp.uuserid");
        sql.append(" where co.uid = :uorderid");
        return super.findList(sql, new QMap("uorderid",uorderid));
    }
    
}
