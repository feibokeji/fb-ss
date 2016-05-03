package com.fb.service;

import java.util.List;

import com.fb.domain.po.TOperateLog;

/**
 * 操作日志表控制
 * @since 2016年5月3日 下午7:58:32
 * @author Liu bo
 */
public interface OperateLogService {
    
    /**
     * 新增操作日志数据
     * @param operateLog
     * @return
     * @author Liu bo
     */
    public int addOperateLog(TOperateLog operateLog);
    
    /**
     * 获取操作日志数据
     * @return
     * @author Liu bo
     */
    public List<TOperateLog> getOperateLogList();
}
