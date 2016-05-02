package com.fb.dao.impl;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TProductDao;
import com.fb.domain.po.TProduct;

/**
 * 产品控制
 * @since 2016年5月2日 下午9:57:24
 * @author Liu bo
 */
@Service
public class TProductDaoImpl extends SimpMapper<TProduct> implements TProductDao {
    
    
    public int getProductByUCategoryId(String ucategoryid) {
        String sql = "select count(*) from t_product t where t.ucategoryid = :ucategoryid";
        return getInt(sql, new QMap("ucategoryid", ucategoryid));
    }
    
}
