package com.fb.dao.impl;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TMaterialCheckDiffDao;
import com.fb.domain.po.TMaterialCheckDiff;

@Service
public class TMaterialCheckDiffDaoImpl extends SimpMapper<TMaterialCheckDiff>implements TMaterialCheckDiffDao {
    
    public int addMaterialCheckDiff(TMaterialCheckDiff diff) {
        return super.save(diff);
    }

    public int getMaterialCheckDiffByUOrderId(String uorderid) {
        String sql = "select count(*) from t_material_check_diff where uorderid = :uorderid";
        return getInt(sql, new QMap("uorderid",uorderid));
    }
    
}
