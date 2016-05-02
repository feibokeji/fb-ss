package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TModuleGroupModule;

/**
 * 模块组-模块关系表操作
 * 
 * @author Liu bo
 *
 */
public interface TModuleGroupModuleDao {

	/**
	 * 新增关系
	 * 
	 * @param moduleGroupModule
	 * @return
	 */
	public int addModuleGroupModule(TModuleGroupModule moduleGroupModule);

	/**
	 * 获取模块组关系集合
	 * 
	 * @param umodulegroupid
	 * @return
	 */
	public List<TModuleGroupModule> getModuleGroupModuleByModuleGroupId(String umodulegroupid);
	
	/**
	 * 根据功能模块ID获取与功能模块组的关系记录数
	 * @param umoduleid
	 * @return
	 */
	public int getModuleGroupModuleCountByUModuleId(String umoduleid);
}
