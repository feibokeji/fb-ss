package com.fb.service;

import com.fb.domain.po.TUser;
import com.fb.domain.vo.SupplierPhoneOrder;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月16日 下午4:57:16
 * 供应商手机单据操作接口
 */
public interface SupplierPhoneOrderService {
    
    /**
     * 新增 供应商手机单据
     * @param order
     * @param user
     * @return
     * @author Liu bo
     */
    public boolean addSupplierPhoneOrder(SupplierPhoneOrder order,TUser user,String ip,String url);
}
