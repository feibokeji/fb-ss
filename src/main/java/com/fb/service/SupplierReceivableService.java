package com.fb.service;

import java.util.List;

import com.fb.domain.po.TSupplierReceivable;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月28日 上午10:18:31 
* 类说明:供应商应收或应付类服务接口
*/
public interface SupplierReceivableService {
    
    /**
     * 获取 应收或应付信息集合
     * @param receivable
     * @return
     * @author Liu bo
     */
    public List<TSupplierReceivable> getReceivableList(TSupplierReceivable receivable);
    
    /**
     * 获取 应收/应付 信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public TSupplierReceivable getReceivable(String uid);
}
