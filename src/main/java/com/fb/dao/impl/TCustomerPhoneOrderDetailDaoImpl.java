package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TCustomerPhoneOrderDetailDao;
import com.fb.domain.po.TCustomerPhoneOrderDetail;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月8日 下午3:16:39
 * 客户手机单据明细接口实现类
 */
@Service
public class TCustomerPhoneOrderDetailDaoImpl extends SimpMapper<TCustomerPhoneOrderDetail> implements TCustomerPhoneOrderDetailDao {
    
    
    public int add(TCustomerPhoneOrderDetail detail) {
        return super.save(detail);
    }
    
    public int delByOrder(String uorderid) {
        String sql = "delete from t_customer_phone_order_detail where uorderid = :uorderid";
        return super.execute(sql, new QMap("uorderid",uorderid));
    }
    
    public TCustomerPhoneOrderDetail get(String uid) {
        StringBuilder sql = new StringBuilder("select cpod.uid,cpod.uorderid,cpo.cno,cpod.imei,pm.ubrandid,b.cname as cbrandname");
        sql.append(",pm.cname as cphonemodelname,pm.cram,pm.crom,pm.ccpu,pm.ccamera,pm.cscreen,pm.cbattery");
        sql.append(",c.cname as ccolorname,cpod.uuserid,u.cname as cusername,cpod.udeptid,cpod.nprice");
        sql.append(",cpod.ndiscount,cpod.namount,cpod.drecorddate,cpod.dupdatedate,cpod.isort");
        sql.append(" from t_customer_phone_order_detail as cpod");
        sql.append(" left join t_customer_phone_order as cpo on cpo.uid = cpod.uorderid");
        sql.append(" left join t_supplier_phone_order as spo on spo.imei = cpod.imei");
        sql.append(" left join t_phone_model as pm on pm.uid = spo.uphonemodelid");
        sql.append(" left join t_brand as b on b.uid = pm.ubrandid");
        sql.append(" left join t_color as c on c.uid = spo.ucolorid");
        sql.append(" left join t_user as u on u.uid = cpod.uuserid");
        sql.append(" where cpod.uid = :uid");
        return super.get(sql, new QMap("uid",uid), TCustomerPhoneOrderDetail.class);
    }
    
    public List<TCustomerPhoneOrderDetail> getByOrder(String uorderid) {
        StringBuilder sql = new StringBuilder("select cpod.uid,cpod.uorderid,cpo.cno,cpod.imei,pm.ubrandid,b.cname as cbrandname");
        sql.append(",pm.cname as cphonemodelname,pm.cram,pm.crom,pm.ccpu,pm.ccamera,pm.cscreen,pm.cbattery");
        sql.append(",c.cname as ccolorname,cpod.uuserid,u.cname as cusername,cpod.udeptid,cpod.nprice");
        sql.append(",cpod.ndiscount,cpod.namount,cpod.drecorddate,cpod.dupdatedate,cpod.isort");
        sql.append(" from t_customer_phone_order_detail as cpod");
        sql.append(" left join t_customer_phone_order as cpo on cpo.uid = cpod.uorderid");
        sql.append(" left join t_supplier_phone_order as spo on spo.imei = cpod.imei");
        sql.append(" left join t_phone_model as pm on pm.uid = spo.uphonemodelid");
        sql.append(" left join t_brand as b on b.uid = pm.ubrandid");
        sql.append(" left join t_color as c on c.uid = spo.ucolorid");
        sql.append(" left join t_user as u on u.uid = cpod.uuserid");
        sql.append(" where cpod.uorderid = :uorderid");
        sql.append(" order by cpod.isort");
        return super.findList(sql, new QMap("uorderid",uorderid));
    }
    
    public List<TCustomerPhoneOrderDetail> get(TCustomerPhoneOrderDetail detail) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select cpod.uid,cpod.uorderid,cpo.cno,cpod.imei,pm.ubrandid,b.cname as cbrandname");
        sql.append(",pm.cname as cphonemodelname,pm.cram,pm.crom,pm.ccpu,pm.ccamera,pm.cscreen,pm.cbattery");
        sql.append(",c.cname as ccolorname,cpod.uuserid,u.cname as cusername,cpod.udeptid,cpod.nprice");
        sql.append(",cpod.ndiscount,cpod.namount,cpod.drecorddate,cpod.dupdatedate,cpod.isort");
        sql.append(" from t_customer_phone_order_detail as cpod");
        sql.append(" left join t_customer_phone_order as cpo on cpo.uid = cpod.uorderid");
        sql.append(" left join t_supplier_phone_order as spo on spo.imei = cpod.imei");
        sql.append(" left join t_phone_model as pm on pm.uid = spo.uphonemodelid");
        sql.append(" left join t_brand as b on b.uid = pm.ubrandid");
        sql.append(" left join t_color as c on c.uid = spo.ucolorid");
        sql.append(" left join t_user as u on u.uid = cpod.uuserid");
        sql.append(" where 1 = 1");
        if(!DataUtils.isNullOrEmpty(detail.getCno())){
            sql.append(" and cpo.cno like cno");
            map.put("cno", "%" + detail.getCno() + "%");
        }
        if(!DataUtils.isNullOrEmpty(detail.getImei())){
            sql.append(" and cpod.imei like imei");
            map.put("imei", "%" + detail.getImei() + "%");
        }
        if(DataUtils.isUid(detail.getUbrandid())){
            sql.append(" and pm.ubrandid = :ubrandid");
            map.put("ubrandid", detail.getUbrandid());
        }
        if(!DataUtils.isNullOrEmpty(detail.getCphonemodelname())){
            sql.append(" and pm.cname like :cphonemodelname");
            map.put("cphonemodelname", "%" + detail.getCphonemodelname() + "%");
        }
        if(!DataUtils.isNullOrEmpty(detail.getCcolorname())){
            sql.append(" and c.cname like :ccolorname");
            map.put("ccolorname", "%" + detail.getCcolorname() + "%");
        }
        if(DataUtils.isUid(detail.getUdeptid())){
            sql.append(" and cpod.udeptid = :udeptid");
            map.put("udeptid", detail.getUdeptid());
        }
        sql.append(" order by cpod.isort");
        return super.findList(sql, map);
    }
    
}
