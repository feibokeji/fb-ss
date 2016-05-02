package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TAccountOrderDao;
import com.fb.domain.po.TAccountOrder;

/**
 * 账务单据操作
 * @since 2016年4月11日 下午6:03:55
 * @author Liu bo
 */
@Service
public class TAccountOrderDaoImpl extends SimpMapper<TAccountOrder> implements TAccountOrderDao {
    
    
    public int addAccountOrder(TAccountOrder accountOrder) {
        return this.save(accountOrder);
    }
    
    public int updateAccountOrder(TAccountOrder accountOrder) {
        return this.update(accountOrder);
    }

    public TAccountOrder getAccountOrder(String uid) {
        return super.get(uid);
    }

    public int getAccountOrderCount(TAccountOrder accountOrder) {
        StringBuilder sql = new StringBuilder("select count(*) from t_account_order t where 1 = 1");
        QMap map = new QMap();
        if (accountOrder != null) {
            if (!DataUtils.isNullOrEmpty(accountOrder.getCcode())) {
                sql.append(" and t.ccode like '%" + accountOrder.getCcode() + "%'");
            }
            if (!DataUtils.isNullOrEmpty(accountOrder.getCtype())) {
                map.put("ctype", accountOrder.getCtype());
                sql.append(" and t.ctype = :ctype");
            }
            if(!DataUtils.isNullOrEmpty(accountOrder.getUaccounttypeid())){
                map.put("uaccounttypeid", accountOrder.getUaccounttypeid());
                sql.append(" and t.uaccounttypeid = :uaccounttypeid");
            }
            if(!DataUtils.isNullOrEmpty(accountOrder.getUcorpid())){
                map.put("ucorpid", accountOrder.getUcorpid());
                sql.append(" and t.ucorpid = :ucorpid");
            }
            if(!DataUtils.isNullOrEmpty(accountOrder.getUdeptid())){
                map.put("udeptid", accountOrder.getUdeptid());
                sql.append(" and t.udeptid = :udeptid");
            }
            if(accountOrder.getIaudit() != null){
                map.put("iaudit", accountOrder.getIaudit());
                sql.append(" and t.iaudit = :iaudit");
            }
            if(!DataUtils.isNullOrEmpty(accountOrder.getBeganTime())){
                sql.append(" and t.dcreatetime >= '" + accountOrder.getBeganTime() + "'");
            }
            if(!DataUtils.isNullOrEmpty(accountOrder.getEndTime())){
                sql.append(" and t.dcreatetime <= '" + accountOrder.getEndTime() + "'");
            }
        }
        return getInt(sql, map);
    }

    public List<TAccountOrder> getAccountOrderListPage(TAccountOrder accountOrder, int startRow, int pageSize) {
        StringBuilder sql = new StringBuilder("select * from t_account_order t where 1 = 1");
        QMap map = new QMap();
        if (accountOrder != null) {
            if (!DataUtils.isNullOrEmpty(accountOrder.getCcode())) {
                sql.append(" and t.ccode like '%" + accountOrder.getCcode() + "%'");
            }
            if (!DataUtils.isNullOrEmpty(accountOrder.getCtype())) {
                map.put("ctype", accountOrder.getCtype());
                sql.append(" and t.ctype = :ctype");
            }
            if(!DataUtils.isNullOrEmpty(accountOrder.getUaccounttypeid())){
                map.put("uaccounttypeid", accountOrder.getUaccounttypeid());
                sql.append(" and t.uaccounttypeid = :uaccounttypeid");
            }
            if(!DataUtils.isNullOrEmpty(accountOrder.getUcorpid())){
                map.put("ucorpid", accountOrder.getUcorpid());
                sql.append(" and t.ucorpid = :ucorpid");
            }
            if(!DataUtils.isNullOrEmpty(accountOrder.getUdeptid())){
                map.put("udeptid", accountOrder.getUdeptid());
                sql.append(" and t.udeptid = :udeptid");
            }
            if(accountOrder.getIaudit() != null){
                map.put("iaudit", accountOrder.getIaudit());
                sql.append(" and t.iaudit = :iaudit");
            }
            if(!DataUtils.isNullOrEmpty(accountOrder.getBeganTime())){
                sql.append(" and t.dcreatetime >= '" + accountOrder.getBeganTime() + "'");
            }
            if(!DataUtils.isNullOrEmpty(accountOrder.getEndTime())){
                sql.append(" and t.dcreatetime <= '" + accountOrder.getEndTime() + "'");
            }
        }
        sql.append(" order by t.dcreatetime asc");
        return getPage(sql, map, startRow, pageSize);
    }
    
}
