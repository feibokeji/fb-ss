package com.fb.service;

import java.util.List;

import com.fb.domain.po.TAccountOrderDetail;

/**
 * 账务单据明细
 * @since 2016年4月12日 下午4:33:02
 * @author Liu bo
 */
public interface AccountOrderDetailService {
    
    /**
     * 新增单据明细
     * @param accountOrderDetail
     * @return
     * @author Liu bo
     */
    public int addAccountOrderDetail(TAccountOrderDetail accountOrderDetail);
    
    /**
     * 修改单据明细
     * @param accountOrderDetail
     * @return
     * @author Liu bo
     */
    public int updateAccountOrderDetail(TAccountOrderDetail accountOrderDetail);
    
    /**
     * 获取单据明细列表
     * @param uaccountorderid
     * @return
     * @author Liu bo
     */
    public List<TAccountOrderDetail> getAccountOrderDetailByUAccountOrderId(String uaccountorderid);
    
    /**
     * 删除财务单据明细
     * @param uaccountorderid
     * @return
     * @author Liu bo
     */
    public int deleteAccountOrderDetailByUAccountOrderId(String uaccountorderid);
}
