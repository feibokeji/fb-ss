package com.fb.service;

/**
 * 辅助功能
 * @since 2015-6-21 下午6:39:10
 * @author Liu bo
 */
public interface AuxiliaryService {
    
    /**
     * 验证数据是否重复
     * @param table 表名
     * @param column 列名
     * @param value 值
     * @return
     * @author Liu bo
     */
    public Boolean checkDataRepeat(String table, String column, String value);
}
