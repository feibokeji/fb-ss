package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TCategoryDao;
import com.fb.domain.po.TCategory;

/**
 * 产品类别
 * @since 2016年4月29日 下午4:43:56
 * @author Liu bo
 */
@Service
public class TCategoryDaoImpl extends SimpMapper<TCategory>implements TCategoryDao {
    
    public int add(TCategory category) {
        return super.save(category);
    }
    
    public int delete(String uid) {
        return super.delete(uid);
    }
    
    public int update(TCategory category) {
        return super.update(category);
    }
    
    public List<TCategory> getCategoryList() {
        String sql = "select * from t_category order by cno";
        return findList(sql, null);
    }
    
    public TCategory getCategoryByName(String cname) {
        String sql = "select top 1 * from t_category where cname = :cname";
        return get(sql, new QMap("cname", cname), TCategory.class);
    }
    
}
