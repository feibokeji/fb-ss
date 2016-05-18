package com.fb.service;

import java.util.List;

import com.fb.domain.po.TAccount;
import com.fb.domain.vo.Combobox;

/**
 * 账户管理
 * @since 2016年5月17日 下午1:34:14
 * @author Liu bo
 */
public interface AccountService {
    
    /**
     * 新增
     * @param account
     * @return
     * @author Liu bo
     */
    public int add(TAccount account);
    
    /**
     * 删除
     * @param uid
     * @return
     * @author Liu bo
     */
    public int del(String uid);
    
    /**
     * 修改
     * @param account
     * @return
     * @author Liu bo
     */
    public int mod(TAccount account);
    
    /**
     * 修改
     * @param uid
     * @param cname
     * @return
     * @author Liu bo
     */
    public int mod(String uid, String cno, String cname);
    
    /**
     * 获取
     * @param uid
     * @return
     * @author Liu bo
     */
    public TAccount get(String uid);
    
    /**
     * 查询
     * @return
     * @author Liu bo
     */
    public List<TAccount> getList();
    
    /**
     * 下拉框
     * @return
     * @author Liu bo
     */
    public List<Combobox> getCombobox();
}
