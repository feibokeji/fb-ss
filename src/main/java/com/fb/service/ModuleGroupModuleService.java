package com.fb.service;

/**
 * 功能模块组与功能模块关系操作
 * @author Liu bo
 *
 */
public interface ModuleGroupModuleService {
	/**
	 * 根据功能模块ID获取与功能模块组的关系记录数
	 * @param umoduleid
	 * @return
	 */
	public int getModuleGroupModuleCountByUModuleId(String umoduleid);
	
	/**
     * 根据功能模块组ID获取关系数
     * @param umodulegroupid
     * @return
     * @author Liu bo
     */
    public int getModuleGroupModuleCountByUModuleGroupId(String umodulegroupid);
}
