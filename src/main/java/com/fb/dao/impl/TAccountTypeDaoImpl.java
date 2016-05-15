package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TAccountTypeDao;
import com.fb.domain.po.TAccountType;
import com.fb.domain.vo.Combobox;

/**
 * 账务类型操作
 * @since 2016年4月11日 下午6:01:54
 * @author Liu bo
 */
@Service
public class TAccountTypeDaoImpl extends SimpMapper<TAccountType>implements TAccountTypeDao {
    
    public int addAccountType(TAccountType accountType) {
        return super.save(accountType);
    }
    
    public int updateAccountType(TAccountType accountType) {
        return super.update(accountType);
    }
    
    public TAccountType getAccountType(String uid) {
        return super.get(uid);
    }
    
    public List<TAccountType> getAccountTypeList() {
        String sql = "select * from t_account_type order by ctype";
        return findList(sql, null);
    }
    
    public int deleteAccountType(String uid) {
        return super.delete(uid);
    }
    
    public List<Combobox> getCombobox(String ctype) {
        String sql = "select t.uid as id,t.cname as text from t_account_type t where t.ctype = :ctype order by t.cno";
        return super.findList(sql, new QMap("ctype", ctype), Combobox.class);
    }
    
}
