package com.fb.service;

import java.util.List;

import com.fb.domain.po.TMaterial;

/**
 * 物料类控制
 * @since 2016年5月3日 下午4:26:16
 * @author Liu bo
 */
public interface MaterialService {
    
    /**
     * 新增物料
     * @param material
     * @return
     * @author Liu bo
     */
    public int add(TMaterial material);
    
    /**
     * 删除物料
     * @param uid
     * @return
     * @author Liu bo
     */
    public int delete(String uid);
    
    /**
     * 更新物料
     * @param material
     * @return
     * @author Liu bo
     */
    public int update(TMaterial material);
    
    /**
     * 获取物料分页数据
     * @param material
     * @return
     * @author Liu bo
     */
    public List<TMaterial> getMaterialList();
}
