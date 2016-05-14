package com.fb.dao.impl;

import java.util.List;

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
public class TProductDaoImpl extends SimpMapper<TProduct>implements TProductDao {
    
    public int getProductByUCategoryId(String ucategoryid) {
        String sql = "select count(*) from t_product t where t.ucategoryid = :ucategoryid";
        return super.getInt(sql, new QMap("ucategoryid", ucategoryid));
    }
    
    public int addProduct(TProduct product) {
        return super.save(product);
    }
    
    public int deleteProduct(String uid) {
        return super.delete(uid);
    }
    
    public int updateProduct(TProduct product) {
        return super.update(product);
    }
    
    public List<TProduct> getProductList() {
        String sql = "select t.uid,t.ucategoryid,(select c.cname from t_category c where c.uid = t.ucategoryid) as ccategoryname,t.cno,t.cname,t.nprice from t_product t order by t.ucategoryid,t.cno";
        return super.findList(sql, null);
    }
    
    public List<TProduct> getProductByName(String cname) {
        String sql = "select t.uid,t.ucategoryid,(select c.cname from t_category c where c.uid = t.ucategoryid) as ccategoryname,t.cno,t.cname,t.nprice from t_product t where t.cname = :cname";
        return super.findList(sql, new QMap("cname", cname));
    }
    
}
