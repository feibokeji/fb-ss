package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.dao.TModuleGroupModuleDao;
import com.fb.dao.TRoleDao;
import com.fb.dao.TRoleModuleGroupDao;
import com.fb.domain.po.TModuleGroupModule;
import com.fb.domain.po.TRole;
import com.fb.domain.po.TRoleModuleGroup;
import com.fb.service.RoleService;
import com.fb.service.SimpServiceAbstract;

@Service
public class RoleServiceImpl extends SimpServiceAbstract implements RoleService {

	@Autowired
	private TRoleDao roleDao;

	@Autowired
	private TRoleModuleGroupDao roleModuleGroupDao;

	@Autowired
	private TModuleGroupModuleDao moduleGroupModuleDao;

	public List<TRole> getRoleByUserId(String uuserid) {
		return roleDao.getRoleByUserId(uuserid);
	}

	public List<TRoleModuleGroup> getRoleModuleGroupByRoleId(String uroleid) {
		return roleModuleGroupDao.getRoleModuleGroupByRoleId(uroleid);
	}

	public List<TModuleGroupModule> getModuleGroupModuleByModuleGroupId(String umodulegroupid) {
		return moduleGroupModuleDao.getModuleGroupModuleByModuleGroupId(umodulegroupid);
	}

}
