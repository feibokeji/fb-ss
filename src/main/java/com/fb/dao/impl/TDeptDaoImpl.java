package com.fb.dao.impl;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TDeptDao;
import com.fb.domain.po.TDept;

@Service
public class TDeptDaoImpl extends SimpMapper<TDept> implements TDeptDao {
    
    public TDept getDeptByUid(String uid) {
        return get(uid);
    }
    
    public int getDeptCountByUCorpId(String ucorpid) {
        String sql = "select count(*) from t_dept t where t.ucorpid = :ucorpid";
        return getInt(sql, new QMap("ucorpid", ucorpid));
    }
    
}
