package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.dao.TCorpDao;
import com.fb.domain.po.TCorp;

@Service
public class TCorpDaoImpl extends SimpMapper<TCorp> implements TCorpDao {
    
    public TCorp getCorpByUid(String uid) {
        return get(uid);
    }
    
    public int addCorp(TCorp corp) {
        return save(corp);
    }
    
    public int getCorpCount(TCorp corp) {
        StringBuilder sql = new StringBuilder("select count(*) from t_corp t where 1 = 1");
        if (corp != null) {
            if (!DataUtils.isNullOrEmpty(corp.getCcode())) {
                sql.append(" and t.ccode like '%" + corp.getCcode() + "%'");
            }
            if (!DataUtils.isNullOrEmpty(corp.getCname())) {
                sql.append(" and t.cname like '%" + corp.getCname() + "%'");
            }
            if (!DataUtils.isNullOrEmpty(corp.getCprincipal())) {
                sql.append(" and t.cprincipal like '%" + corp.getCprincipal() + "%'");
            }
        }
        return getInt(sql, null);
    }
    
    public List<TCorp> getCorpListPage(TCorp corp, int startRow, int pageSize) {
        StringBuilder sql = new StringBuilder("select * from t_corp t where 1 = 1");
        if (corp != null) {
            if (!DataUtils.isNullOrEmpty(corp.getCcode())) {
                sql.append(" and t.ccode like '%" + corp.getCcode() + "%'");
            }
            if (!DataUtils.isNullOrEmpty(corp.getCname())) {
                sql.append(" and t.cname like '%" + corp.getCname() + "%'");
            }
            if (!DataUtils.isNullOrEmpty(corp.getCprincipal())) {
                sql.append(" and t.cprincipal like '%" + corp.getCprincipal() + "%'");
            }
        }
        sql.append(" order by t.dcreatetime asc");
        return getPage(sql, null, startRow, pageSize);
    }
    
    public int deleteCorpByUid(String uid) {
        return delete(uid);
    }

    public int updateCorp(TCorp corp) {
        return update(corp);
    }
    
}
