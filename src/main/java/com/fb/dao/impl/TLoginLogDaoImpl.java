package com.fb.dao.impl;

import org.springframework.stereotype.Service;

import com.fb.dao.TLoginLogDao;
import com.fb.domain.po.TLoginLog;

/**
 * 登录日志操作
 * @since 2016年4月11日 下午4:15:58
 * @author Liu bo
 */
@Service
public class TLoginLogDaoImpl extends SimpMapper<TLoginLog> implements TLoginLogDao {
    
    
    public int addLoginLog(TLoginLog loginLog) {
        return save(loginLog);
    }
    
}
