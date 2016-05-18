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
public class TAccountOrderDaoImpl extends SimpMapper<TAccountOrder>implements TAccountOrderDao {
    
    public int addAccountOrder(TAccountOrder accountOrder) {
        return this.save(accountOrder);
    }
    
    public int updateAccountOrder(TAccountOrder accountOrder) {
        return this.update(accountOrder);
    }
    
    public TAccountOrder getAccountOrder(String uid) {
        StringBuilder sql = new StringBuilder();
        sql.append("select t.uid,t.ccode,t.cname,t.ctype,t.uaccounttypeid,(select at.cname from t_account_type at where at.uid = t.uaccounttypeid) as caccounttypename,");
        sql.append("t.ucorpid,t.udeptid,t.uuserid,(select u.cname from t_user u where u.uid = t.uuserid) as cusername,t.cmemo,t.dcreatetime,t.dupdatetime,t.iaudit,t.daudittime");
        sql.append(",t.dcreatetime as ccreatetime,(select sum(tao.namount) from t_account_order_detail tao where tao.uaccountorderid = t.uid) as namount");
        sql.append(",t.uaccountid,(select ta.cname from t_account ta where ta.uid = t.uaccountid) as caccountname");
        sql.append(" from t_account_order t where t.uid = :uid");
        return super.get(sql, new QMap("uid", uid), TAccountOrder.class);
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
            if (!DataUtils.isNullOrEmpty(accountOrder.getUaccounttypeid())) {
                map.put("uaccounttypeid", accountOrder.getUaccounttypeid());
                sql.append(" and t.uaccounttypeid = :uaccounttypeid");
            }
            if (!DataUtils.isNullOrEmpty(accountOrder.getUcorpid())) {
                map.put("ucorpid", accountOrder.getUcorpid());
                sql.append(" and t.ucorpid = :ucorpid");
            }
            if (!DataUtils.isNullOrEmpty(accountOrder.getUdeptid())) {
                map.put("udeptid", accountOrder.getUdeptid());
                sql.append(" and t.udeptid = :udeptid");
            }
            if (accountOrder.getIaudit() != null) {
                map.put("iaudit", accountOrder.getIaudit());
                sql.append(" and t.iaudit = :iaudit");
            }
            if (!DataUtils.isNullOrEmpty(accountOrder.getBeganTime())) {
                sql.append(" and t.dcreatetime >= '" + accountOrder.getBeganTime() + "'");
            }
            if (!DataUtils.isNullOrEmpty(accountOrder.getEndTime())) {
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
            if (!DataUtils.isNullOrEmpty(accountOrder.getUaccounttypeid())) {
                map.put("uaccounttypeid", accountOrder.getUaccounttypeid());
                sql.append(" and t.uaccounttypeid = :uaccounttypeid");
            }
            if (!DataUtils.isNullOrEmpty(accountOrder.getUcorpid())) {
                map.put("ucorpid", accountOrder.getUcorpid());
                sql.append(" and t.ucorpid = :ucorpid");
            }
            if (!DataUtils.isNullOrEmpty(accountOrder.getUdeptid())) {
                map.put("udeptid", accountOrder.getUdeptid());
                sql.append(" and t.udeptid = :udeptid");
            }
            if (accountOrder.getIaudit() != null) {
                map.put("iaudit", accountOrder.getIaudit());
                sql.append(" and t.iaudit = :iaudit");
            }
            if (!DataUtils.isNullOrEmpty(accountOrder.getBeganTime())) {
                sql.append(" and t.dcreatetime >= '" + accountOrder.getBeganTime() + "'");
            }
            if (!DataUtils.isNullOrEmpty(accountOrder.getEndTime())) {
                sql.append(" and t.dcreatetime <= '" + accountOrder.getEndTime() + "'");
            }
        }
        sql.append(" order by t.dcreatetime asc");
        return getPage(sql, map, startRow, pageSize);
    }
    
    public int getAccountOrderByType(String uaccounttypeid) {
        String sql = "select count(*) from t_account_order where uaccounttypeid = :uaccounttypeid";
        return getInt(sql, new QMap("uaccounttypeid", uaccounttypeid));
    }
    
    public List<TAccountOrder> getAccountOrderList(String ctype) {
        StringBuilder sql = new StringBuilder();
        sql.append("select t.uid,t.ccode,t.cname,t.ctype,t.uaccounttypeid,(select at.cname from t_account_type at where at.uid = t.uaccounttypeid) as caccounttypename,");
        sql.append("t.ucorpid,t.udeptid,t.uuserid,(select u.cname from t_user u where u.uid = t.uuserid) as cusername,t.cmemo,t.dcreatetime,t.dupdatetime,t.iaudit,t.daudittime");
        sql.append(",t.dcreatetime as ccreatetime,(select sum(tao.namount) from t_account_order_detail tao where tao.uaccountorderid = t.uid) as namount");
        sql.append(",t.uaccountid,(select ta.cname from t_account ta where ta.uid = t.uaccountid) as caccountname");
        sql.append(" from t_account_order t where t.ctype = :ctype order by t.dcreatetime desc");
        return super.findList(sql, new QMap("ctype", ctype));
    }
    
    public int deleteAccountOrder(String uid) {
        return super.delete(uid);
    }
    
    public int auditAccountOrder(String uid, int iaudit) {
        String sql = "update t_account_order set iaudit = :iaudit where uid = :uid";
        QMap map = new QMap();
        map.put("iaudit", iaudit);
        map.put("uid", uid);
        return super.execute(sql, map);
    }
    
    public int getAccountOrderByUAccountId(String uaccountid) {
        String sql = "select count(*) from t_account_order where uaccountid = :uaccountid";
        return super.getInt(sql, new QMap("uaccountid", uaccountid));
    }
    
}
