package com.fb.service;

import com.fb.domain.po.TDept;

/**
 * 部门管理
 * @since 2015-6-19 下午6:28:30
 * @author Liu bo
 */
public interface DeptService {
    
    /**
     * 根据主键获取部门信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public TDept getDeptByUid(String uid);
}
