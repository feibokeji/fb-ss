package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.dao.TOperateLogDao;
import com.fb.domain.po.TOperateLog;

/**
 * 操作日志表控制
 * @since 2016年5月3日 下午7:51:01
 * @author Liu bo
 */
@Service
public class TOperateLogDaoImpl extends SimpMapper<TOperateLog>implements TOperateLogDao {
    
    public int addOperateLog(TOperateLog operateLog) {
        return super.save(operateLog);
    }
    
    public List<TOperateLog> getOperateLogList() {
        String sql = "select t.uid,t.ctype,t.doperatetime,t.uuserid,(select u.cname from t_user u where u.uid = t.uuserid) as cusername,t.coperateip,t.coperateurl,t.clinktable,t.ulinktableid,t.cstatus,t.cchoice,t.ccancel,t.cmemo  from t_operate_log t order by t.doperatetime desc";
        return findList(sql, null);
    }
    
}
