package com.fb.service;

import com.fb.core.base.service.BaseServiceAbstract;
import com.fb.core.utils.ConstantUtils;

/**
 * 接口平台业务抽象类，所有业务实现类都必须实现该基类
 * @since 2015-6-18 下午6:07:28
 * @author Liu bo
 */
public class SimpServiceAbstract extends BaseServiceAbstract {
    
    /**
     * 页面默认大小
     */
    private final static int default_pagesize = Integer.valueOf(ConstantUtils.getConstant("default_pagesize"));
    
    /**
     * 获取 页面默认大小
     * @return defaultPagesize
     */
    public static int getDefaultPagesize() {
        return default_pagesize;
    }
    
}
