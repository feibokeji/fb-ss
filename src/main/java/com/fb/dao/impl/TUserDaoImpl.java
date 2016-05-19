package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TUserDao;
import com.fb.domain.po.TUser;
import com.fb.domain.vo.Combobox;

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

    public int modify(TUser user) {
        return super.update(user);
    }

    public List<TUser> getUserList() {
        String sql = "select * from t_user";
        return super.findList(sql, null);
    }

    public TUser getUser(String uid) {
        return super.get(uid);
    }

    public int add(TUser user) {
        return super.save(user);
    }

    public List<Combobox> getUserComboboxList() {
        String sql = "select t.uid as id,t.cname as text from t_user t order by t.cname";
        return super.findList(sql, null, Combobox.class);
    }
    
}
