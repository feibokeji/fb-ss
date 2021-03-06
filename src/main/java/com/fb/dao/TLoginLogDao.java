package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TLoginLog;

/**
 * 登录日志操作
 * @since 2016年4月11日 下午4:13:52
 * @author Liu bo
 */
public interface TLoginLogDao {
    
    /**
     * 新增登录日志
     * @param loginLog
     * @return
     * @author Liu bo
     */
    public int addLoginLog(TLoginLog loginLog);
    
    /**
     * 登录日志列表
     * @return
     * @author Liu bo
     */
    public List<TLoginLog> getLoginLogList();
}
