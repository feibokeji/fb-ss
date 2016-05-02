package com.fb.service;

import com.fb.core.utils.Page;
import com.fb.domain.po.TCorp;

/**
 * 公司管理
 * @since 2015-6-19 下午6:30:26
 * @author Liu bo
 */
public interface CorpService {
    
    /**
     * 根据主键获取公司信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public TCorp getCorpByUid(String uid);
    
    /**
     * 新增公司信息
     * @param corp
     * @return
     * @author Liu bo
     */
    public boolean addCorp(TCorp corp);
    
    /**
     * 分页查询公司信息列表
     * @param corp
     * @param currentPage
     * @return
     * @author Liu bo
     */
    public Page<TCorp> getCorpPage(TCorp corp, int currentPage);
    
    /**
     * 根据主键删除公司信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public boolean deleteCorpByUid(String uid);
    
    /**
     * 更新公司信息
     * @param corp
     * @return
     * @author Liu bo
     */
    public boolean updateCorp(TCorp corp);
}
