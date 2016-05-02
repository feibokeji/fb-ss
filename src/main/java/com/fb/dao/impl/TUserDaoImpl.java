package com.fb.dao.impl;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TUserDao;
import com.fb.domain.po.TUser;

@Service
public class TUserDaoImpl extends SimpMapper<TUser> implements TUserDao {
    
    public TUser getUserByCode(String code) {
        String sql = "select * from t_user t where t.ccode = :ccode";
        return get(sql, new QMap("ccode", code), TUser.class);
    }
    
    public int setUserPassword(String uid, String password) {
        String sql = "update t_user set cpassword = :cpassword where uid = :uid";
        QMap map = new QMap("cpassword", password, "uid", uid);
        return execute(sql, map);
    }
    
}
