package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TMaterial;

/**
 * 物料类控制
 * @since 2016年5月3日 下午4:13:38
 * @author Liu bo
 */
public interface TMaterialDao {
    
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
     * 获取物料数据分页
     * @param material
     * @return
     * @author Liu bo
     */
    public List<TMaterial> getMaterialList();
    
    /**
     * 获取物料并同时获取物料关联的产品关系
     * @param uproductid
     * @return
     * @author Liu bo
     */
    public List<TMaterial> getMaterialByUProductId(String uproductid);
    
}
