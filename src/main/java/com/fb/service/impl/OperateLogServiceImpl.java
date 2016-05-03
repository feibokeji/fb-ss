package com.fb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fb.dao.TOperateLogDao;
import com.fb.domain.po.TOperateLog;
import com.fb.service.OperateLogService;
import com.fb.service.SimpServiceAbstract;

@Service
public class OperateLogServiceImpl extends SimpServiceAbstract implements OperateLogService {
    
    @Autowired
    private TOperateLogDao operateLogDao;
    
    @Transactional
    public synchronized int addOperateLog(TOperateLog operateLog) {
        return operateLogDao.addOperateLog(operateLog);
    }
    
    public List<TOperateLog> getOperateLogList() {
        return operateLogDao.getOperateLogList();
    }
    
}
