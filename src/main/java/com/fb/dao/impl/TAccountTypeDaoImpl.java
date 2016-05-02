package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.dao.TAccountTypeDao;
import com.fb.domain.po.TAccountType;

/**
 * 账务类型操作
 * @since 2016年4月11日 下午6:01:54
 * @author Liu bo
 */
@Service
public class TAccountTypeDaoImpl extends SimpMapper<TAccountType> implements TAccountTypeDao {
    
    
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
        String sql = "select * from t_account_type order by isort asc,ctype";
        return findList(sql, null);
    }
    
}
