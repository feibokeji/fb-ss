package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TAccountDao;
import com.fb.domain.po.TAccount;
import com.fb.domain.vo.Combobox;

@Service
public class AccountDaoImpl extends SimpMapper<TAccount>implements TAccountDao {
    
    public int add(TAccount account) {
        return super.save(account);
    }
    
    public int del(String uid) {
        return super.delete(uid);
    }
    
    public int mod(TAccount account) {
        return super.update(account);
    }
    
    public List<TAccount> getList() {
        StringBuilder sql = new StringBuilder();
        sql.append("select t.uid,t.uuserid,t.cusername,t.udeptid,t.cdeptname,t.ucorpid,t.ccorpname,t.cno,t.cname,");
        sql.append("(select sum(taod.namount) from t_account_order_detail taod where taod.uaccountorderid in (select tao.uid from t_account_order tao where tao.uid = taod.uaccountorderid and tao.uaccountid = t.uid and tao.ctype = '收入' and tao.iaudit = 1)) as ntotalamount,");
        sql.append("(select sum(taod.namount) from t_account_order_detail taod where taod.uaccountorderid in (select tao.uid from t_account_order tao where tao.uid = taod.uaccountorderid and tao.uaccountid = t.uid and tao.ctype = '支出' and tao.iaudit = 1)) as ntotalspendamount");
        sql.append(" from t_account t order by t.cno");
        return super.findList(sql, null);
    }
    
    public int mod(String uid, String cno, String cname) {
        String sql = "update t_account set cno = :cno,cname = :cname where uid = :uid";
        QMap map = new QMap();
        map.put("uid", uid);
        map.put("cno", cno);
        map.put("cname", cname);
        return super.execute(sql, map);
    }
    
    public TAccount get(String uid) {
        return super.get(uid);
    }

    public List<Combobox> getCombobox() {
        String sql = "select uid as id,cname as text from t_account order by cno";
        return super.findList(sql, null, Combobox.class);
    }
    
}
