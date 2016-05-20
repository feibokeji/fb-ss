package com.fb.dao;

import com.fb.domain.po.TMaterialCheckDiff;

public interface TMaterialCheckDiffDao {
    
    /**
     * 信息差异
     * @param diff
     * @return
     * @author Liu bo
     */
    public int addMaterialCheckDiff(TMaterialCheckDiff diff);
    
    /**
     * 获取订单盘点差异数量
     * @param uorderid
     * @return
     * @author Liu bo
     */
    public int getMaterialCheckDiffByUOrderId(String uorderid);
}
