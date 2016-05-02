package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TRoleModuleGroup;

/**
 * 角色模块组管理
 * 
 * @author Liu bo
 *
 */
public interface TRoleModuleGroupDao {

	/**
	 * 新增角色模块组
	 * 
	 * @param roleModuleGroup
	 * @return
	 */
	public int addRoleModuleGroup(TRoleModuleGroup roleModuleGroup);

	/**
	 * 获取角色下模块组集合
	 * 
	 * @param uroleid
	 * @return
	 */
	public List<TRoleModuleGroup> getRoleModuleGroupByRoleId(String uroleid);
}
