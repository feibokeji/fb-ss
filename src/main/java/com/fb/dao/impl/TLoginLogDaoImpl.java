package com.fb.dao.impl;

import java.util.List;

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

    public List<TLoginLog> getLoginLogList() {
        String sql = "select t.uid,t.ctype,t.dlogintime,t.uuserid,(select u.cname from t_user u where u.uid = t.uuserid) as cusername,t.cloginip,t.cloginurl,t.cmemo,t.cmac from t_login_log t order by dlogintime desc";
        return super.findList(sql, null);
    }
    
}
