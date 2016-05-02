package com.fb.service;

import java.util.List;

import com.fb.domain.po.TAccountType;

/**
 * 账务类型
 * @since 2016年4月11日 下午5:38:09
 * @author Liu bo
 */
public interface AccountTypeService {
    
    /**
     * 新增账务类型
     * @param accountType
     * @return
     * @author Liu bo
     */
    public int addAccountType(TAccountType accountType);
    
    /**
     * 更新账务类型
     * @param accountType
     * @return
     * @author Liu bo
     */
    public int updateAccountType(TAccountType accountType);
    
    /**
     * 获取账务类型
     * @param uid
     * @return
     * @author Liu bo
     */
    public TAccountType getAccountType(String uid);
    
    /**
     * 获取账务类型列表
     * @return
     * @author Liu bo
     */
    public List<TAccountType> getAccountTypeList();
}
