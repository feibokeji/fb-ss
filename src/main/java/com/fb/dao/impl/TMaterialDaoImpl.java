package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TMaterialDao;
import com.fb.domain.po.TMaterial;

/**
 * 物料类控制
 * 
 * @since 2016年5月3日 下午4:22:20
 * @author Liu bo
 */
@Service
public class TMaterialDaoImpl extends SimpMapper<TMaterial>implements TMaterialDao {
    
    public int add(TMaterial material) {
        return super.save(material);
    }
    
    public int delete(String uid) {
        return super.delete(uid);
    }
    
    public int update(TMaterial material) {
        return super.update(material);
    }
    
    public List<TMaterial> getMaterialList() {
        String sql = "select * from t_material order by cno";
        return super.findList(sql, null);
    }

    public List<TMaterial> getMaterialByUProductId(String uproductid) {
        StringBuilder sql = new StringBuilder("select t.uid,t.cno,t.cname,t.cspecifications,t.nprice,");
        sql.append("(select count(*) from t_product_material pm where pm.umaterialid = t.uid and pm.uproductid = :uproductid) as haveProduct,");
        sql.append("(select top 1 pm.nqty from t_product_material pm where pm.umaterialid = t.uid and pm.uproductid = :uproductid) as nqty");
        sql.append(" from t_material t order by t.cno");
        return findList(sql, new QMap("uproductid",uproductid));
    }

    public List<TMaterial> getMaterialInventory(TMaterial material) {
        StringBuilder sql = new StringBuilder();
        sql.append("select t.uid,t.cno,t.cname,t.cspecifications,t.nprice,");
        sql.append("(select sum(om.nqty) from t_order_material om where om.umaterialid = t.uid and om.uorderid in (select o.uid from t_order o where o.uid = om.uorderid and o.ctype = '00' and o.cstatus = '01')) as nqty,");
        sql.append("(select sum(op.nqtysubtotal) from t_order_product op where op.uproductid in (select pm.uproductid from t_product_material pm where pm.umaterialid = t.uid and pm.uproductid = op.uproductid) and op.uorderid in (select o.uid from t_order o where o.uid = op.uorderid and o.ctype = '01' and o.cstatus = '01')) as nsqty");
        sql.append(" from t_material t where 1 = 1 ");
        sql.append(" order by t.cno");
        return findList(sql, null);
    }
    
}
