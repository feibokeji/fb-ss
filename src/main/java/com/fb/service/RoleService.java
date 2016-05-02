package com.fb.service;

import java.util.List;

import com.fb.domain.po.TModuleGroupModule;
import com.fb.domain.po.TRole;
import com.fb.domain.po.TRoleModuleGroup;

/**
 * 角色功能操作
 * 
 * @author Liu bo
 *
 */
public interface RoleService {

	/**
	 * 获取账户角色集合
	 * 
	 * @param uuserid
	 * @return
	 */
	public List<TRole> getRoleByUserId(String uuserid);

	/**
	 * 获取角色模块组集合
	 * 
	 * @param uroleid
	 * @return
	 */
	public List<TRoleModuleGroup> getRoleModuleGroupByRoleId(String uroleid);

	/**
	 * 获取模块组关联集合
	 * 
	 * @param umodulegroupid
	 * @return
	 */
	public List<TModuleGroupModule> getModuleGroupModuleByModuleGroupId(String umodulegroupid);
}
