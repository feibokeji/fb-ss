package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TRoleDao;
import com.fb.domain.po.TRole;

@Service
public class TRoleDaoImpl extends SimpMapper<TRole>implements TRoleDao {

	public int addRole(TRole role) {
		return save(role);
	}

	public List<TRole> getRoleByUserId(String uuserid) {
		String sql = "select * from t_role where uuserid = :uuserid";
		return findList(sql, new QMap("uuserid",uuserid));
	}

    public int delete(String uid) {
        return super.delete(uid);
    }

    public int modify(TRole role) {
        return super.update(role);
    }

    public List<TRole> getRoleList() {
        String sql = "select * from t_role";
        return super.findList(sql, null);
    }

}
