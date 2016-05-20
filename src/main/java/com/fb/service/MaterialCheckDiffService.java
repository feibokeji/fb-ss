package com.fb.service;

import com.fb.domain.po.TMaterialCheckDiff;

/**
 * 盘点差异
 * 
 * @since 2016年5月20日 下午1:15:25
 * @author Liu bo
 */
public interface MaterialCheckDiffService {
    
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
