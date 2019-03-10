package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TCustomerOrderDetailDao;
import com.fb.domain.po.TCustomerOrderDetail;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月2日 上午9:24:33
 * 客户商品单据明细接口实现类
 */
@Service
public class TCustomerOrderDetailDaoImpl extends SimpMapper<TCustomerOrderDetail> implements TCustomerOrderDetailDao {
    
    
    public int add(TCustomerOrderDetail detail) {
        return super.save(detail);
    }
    
    public int delOrderDetail(String uorderid) {
        String sql = "delete from t_customer_order_detail where uorderid = :uorderid";
        return super.execute(sql, new QMap("uorderid",uorderid));
    }
    
    public List<TCustomerOrderDetail> getOrderList(String uorderid) {
        StringBuilder sql = new StringBuilder("select cod.uid,cod.uorderid,cod.uothergoodsid,c.cname as ccategoryname");
        sql.append(",b.cname as cbrandname,og.cno as cothergoodsno,og.cbarcode as cothergoodsbarcode");
        sql.append(",og.cname as cothergoodsname,og.cfullname as cothergoodsfullname,og.cspecifications,cod.uuserid,cod.udeptid");
        sql.append(",u.cname as cunitname,cod.nprice,cod.nquantity,cod.namount,cod.drecorddate");
        sql.append(",cod.dupdatedate,cod.isort");
        sql.append(" from t_customer_order_detail as cod");
        sql.append(" left join t_other_goods as og on og.uid = cod.uothergoodsid");
        sql.append(" left join t_category as c on c.uid = og.ucategoryid");
        sql.append(" left join t_brand as b on b.uid = og.ubrandid");
        sql.append(" left join t_unit as u on u.uid = og.uunitid");
        sql.append(" where cod.uorderid = :uorderid");
        sql.append(" order by cod.isort asc");
        return super.findList(sql, new QMap("uorderid",uorderid));
    }
    
}
