package com.fb.dao.impl;

import org.springframework.stereotype.Service;

import com.fb.core.base.domain.BaseDomain;
import com.fb.core.utils.QMap;
import com.fb.dao.AuxiliaryDao;

@Service
public class AuxiliaryDaoImpl extends SimpMapper<BaseDomain> implements AuxiliaryDao {
    
    public Integer checkDataRepeat(String table, String column, String value) {
        String sql = "select count(*) from " + table + " where " + column + " = :value";
        QMap map = new QMap();
        map.put("value", value);
        return getInt(sql, map);
    }
    
}
