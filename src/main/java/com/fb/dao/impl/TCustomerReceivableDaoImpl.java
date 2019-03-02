package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TCustomerReceivableDao;
import com.fb.domain.po.TCustomerReceivable;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月2日 上午9:55:44
 * 客户商品单据应收应付款接口实现类
 */
@Service
public class TCustomerReceivableDaoImpl extends SimpMapper<TCustomerReceivable> implements TCustomerReceivableDao {
    
    
    public int add(TCustomerReceivable receivable) {
        return super.save(receivable);
    }
    
    public int delOrderReceivable(String uorderid) {
        String sql = "delete from t_customer_receivable where uorderid = :uorderid";
        return super.execute(sql, new QMap("uorderid",uorderid));
    }
    
    public int mod(TCustomerReceivable receivable) {
        return super.update(receivable);
    }
    
    public int modStatus(String uid, int istatus) {
        QMap map = new QMap();
        String sql = "update t_customer_receivable set istatus = :istatus where uid = :uid";
        map.put("uid", uid);
        map.put("istatus", istatus);
        return super.execute(sql, map);
    }
    
    public List<TCustomerReceivable> getOrderReceivable(String uorderid) {
        StringBuilder sql = new StringBuilder("select cr.uid,cr.ucustomerid,c.cname as ccustomername,cr.uorderid");
        sql.append(",co.cno as corderno,cr.uuserid,u.cname as cusername,cr.udeptid");
        sql.append(",cr.ctype,cr.nactualamount,cr.ndiscount,cr.namount,cr.istatus");
        sql.append(",cr.drecorddate,cr.dupdatedate");
        sql.append(" from t_customer_receivable as cr");
        sql.append(" left join t_customer as c on c.uid = cr.ucustomerid");
        sql.append(" left join t_customer_order as co on co.uid = cr.uorderid");
        sql.append(" left join t_user as u on u.uid = cr.uuserid");
        sql.append(" where cr.uorderid = :uorderid");
        return super.findList(sql, new QMap("uorderid",uorderid));
    }
    
    public List<TCustomerReceivable> getReceivable(TCustomerReceivable receivable) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select cr.uid,cr.ucustomerid,c.cname as ccustomername,cr.uorderid");
        sql.append(",co.cno as corderno,cr.uuserid,u.cname as cusername,cr.udeptid");
        sql.append(",cr.ctype,cr.nactualamount,cr.ndiscount,cr.namount,cr.istatus");
        sql.append(",cr.drecorddate,cr.dupdatedate");
        sql.append(" from t_customer_receivable as cr");
        sql.append(" left join t_customer as c on c.uid = cr.ucustomerid");
        sql.append(" left join t_customer_order as co on co.uid = cr.uorderid");
        sql.append(" left join t_user as u on u.uid = cr.uuserid");
        sql.append(" where 1 = 1");
        if(DataUtils.isUid(receivable.getUcustomerid())){
            sql.append(" and cr.ucustomerid = :ucustomerid");
            map.put("ucustomerid", receivable.getUcustomerid());
        }
        if(!DataUtils.isNullOrEmpty(receivable.getCcustomername())){
            sql.append(" and c.cname like :ccustomername");
            map.put("ccustomername", "%" + receivable.getCcustomername() + "%");
        }
        if(!DataUtils.isNullOrEmpty(receivable.getCorderno())){
            sql.append(" and co.cno like :corderno");
            map.put("corderno", "%" + receivable.getCorderno() + "%");
        }
        if(DataUtils.isUid(receivable.getUdeptid())){
            sql.append(" and cr.udeptid = :udeptid");
            map.put("udeptid", receivable.getUdeptid());
        }
        if(!DataUtils.isNullOrEmpty(receivable.getCtype())){
            sql.append(" and cr.ctype = :ctype");
            map.put("ctype", receivable.getCtype());
        }
        if(receivable.getIstatus() != null && receivable.getIstatus() != -1){
            sql.append(" and cr.istatus = :istatus");
            map.put("istatus", receivable.getIstatus());
        }
        if(!DataUtils.isNullOrEmpty(receivable.getDrecorddateStrMin())){
            sql.append(" and cr.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", receivable.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(receivable.getDrecorddateStrMax())){
            sql.append(" and cr.drecorddate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", receivable.getDrecorddateStrMax() + " 23:59:59");
        }
        sql.append(" order by cr.drecorddate desc");
        return super.findList(sql, map);
    }
    
}
