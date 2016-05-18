package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TRoleModuleGroupDao;
import com.fb.domain.po.TRoleModuleGroup;

@Service
public class TRoleModuleGroupDaoImpl extends SimpMapper<TRoleModuleGroup>implements TRoleModuleGroupDao {

	public int addRoleModuleGroup(TRoleModuleGroup roleModuleGroup) {
		return save(roleModuleGroup);
	}

	public List<TRoleModuleGroup> getRoleModuleGroupByRoleId(String uroleid) {
		String sql = "select * from t_role_module_group where uroleid = :uroleid";
		return findList(sql, new QMap("uroleid", uroleid));
	}

    public int getRoleModuleGroupCountByURoleId(String uroleid) {
        String sql = "select count(*) from t_role_module_group where uroleid = :uroleid";
        return super.getInt(sql, null);
    }

}
