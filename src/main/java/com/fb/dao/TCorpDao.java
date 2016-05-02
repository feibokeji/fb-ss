package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TCorp;

/**
 * 公司管理
 * @since 2015-6-19 下午6:40:53
 * @author Liu bo
 */
public interface TCorpDao {
    
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
    public int addCorp(TCorp corp);
    
    /**
     * 查询时分页总数
     * @param corp
     * @return
     * @author Liu bo
     */
    public int getCorpCount(TCorp corp);
    
    /**
     * 查询分页
     * @param corp
     * @param startRow
     * @param pageSize
     * @return
     * @author Liu bo
     */
    public List<TCorp> getCorpListPage(TCorp corp, int startRow, int pageSize);
    
    /**
     * 删除公司信息
     * @param uid
     * @return
     * @author Liu bo
     */
    public int deleteCorpByUid(String uid);
    
    /**
     * 更新公司信息
     * @param corp
     * @return
     * @author Liu bo
     */
    public int updateCorp(TCorp corp);
}
