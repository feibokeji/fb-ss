package com.fb.dao;

import com.fb.domain.po.TDept;

/**
 * 部门管理
 * @since 2015-6-19 下午6:40:35
 * @author Liu bo
 */
public interface TDeptDao {
    
    /**
     * 根据主键获取部门信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public TDept getDeptByUid(String uid);
    
    /**
     * 根据公司主键查询公司下部门数量
     * @param ucorpid
     * @return
     * @author Liu bo
     */
    public int getDeptCountByUCorpId(String ucorpid);
}
