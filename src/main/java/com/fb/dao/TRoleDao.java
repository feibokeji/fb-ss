package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TRole;

/**
 * 角色操作
 * 
 * @author Liu bo
 *
 */
public interface TRoleDao {
	/**
	 * 新增角色
	 * 
	 * @param role
	 * @return
	 */
	public int addRole(TRole role);

	/////////////// 此功能预留后期多角色管理时使用
	/**
	 * 获取账户角色
	 * 
	 * @param uuserid
	 * @return
	 */
	public List<TRole> getRoleByUserId(String uuserid);
}
