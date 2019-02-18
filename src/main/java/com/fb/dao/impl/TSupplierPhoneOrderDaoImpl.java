package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.QMap;
import com.fb.dao.TSupplierPhoneOrderDao;
import com.fb.domain.po.TSupplierPhoneOrder;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月15日 下午8:11:43
 * 供应商手机单据操作接口实现类
 */
@Service
public class TSupplierPhoneOrderDaoImpl extends SimpMapper<TSupplierPhoneOrder> implements TSupplierPhoneOrderDao {
    
    
    public int add(TSupplierPhoneOrder supplierPhoneOrder) {
        return super.save(supplierPhoneOrder);
    }
    
    public int del(String imei) {
        return super.delete(imei);
    }
    
    public int mod(TSupplierPhoneOrder supplierPhoneOrder) {
        return super.update(supplierPhoneOrder);
    }
    
    public int modStatus(String imei, int istatus) {
        QMap map = new QMap();
        String sql = "update t_supplier_phone_order set istatus = :istatus where imei = :imei";
        map.put("istatus", istatus);
        map.put("imei", imei);
        return super.execute(sql, map);
    }
    
    public TSupplierPhoneOrder get(String imei) {
        StringBuilder sql = new StringBuilder("select spo.imei,spo.usupplierid,s.cname as csuppliername,");
        sql.append("spo.uphonemodelid,b.cname as cbrandname,pm.cname as cphonemodelname,");
        sql.append("pm.cram,pm.crom,pm.ccpu,pm.ccamera,pm.cscreen,pm.cbattery,spo.ucolorid,");
        sql.append("c.cname as ccolorname,spo.uuserid,u.cname as cusername,spo.udeptid,");
        sql.append("spo.ncostprice,spo.nretailprice,spo.istatus,spo.drecorddate,spo.dupdatedate");
        sql.append(",(select top 1 spos.itype from t_supplier_phone_order_status as spos where spos.istatus = 1 and spos.IMEI = spo.IMEI) as itype");
        sql.append(" from t_supplier_phone_order as spo");
        sql.append(" left join t_supplier as s on s.uid = spo.usupplierid");
        sql.append(" left join t_phone_model as pm on pm.uid = spo.uphonemodelid");
        sql.append(" left join t_brand as b on b.uid = pm.ubrandid");
        sql.append(" left join t_color as c on c.uid = spo.ucolorid");
        sql.append(" left join t_user as u on u.uid = spo.uuserid");
        sql.append(" where spo.imei = :imei");
        return super.get(sql, new QMap("imei",imei), TSupplierPhoneOrder.class);
    }
    
    public List<TSupplierPhoneOrder> get(TSupplierPhoneOrder supplierPhoneOrder) {
        QMap map = new QMap();
        StringBuilder sql = new StringBuilder("select spo.imei,spo.usupplierid,s.cname as csuppliername,");
        sql.append("spo.uphonemodelid,b.cname as cbrandname,pm.cname as cphonemodelname,");
        sql.append("pm.cram,pm.crom,pm.ccpu,pm.ccamera,pm.cscreen,pm.cbattery,spo.ucolorid,");
        sql.append("c.cname as ccolorname,spo.uuserid,u.cname as cusername,spo.udeptid,");
        sql.append("spo.ncostprice,spo.nretailprice,spo.istatus,spo.drecorddate,spo.dupdatedate");
        sql.append(",(select top 1 spos.itype from t_supplier_phone_order_status as spos where spos.istatus = 1 and spos.IMEI = spo.IMEI) as itype");
        sql.append(" from t_supplier_phone_order as spo");
        sql.append(" left join t_supplier as s on s.uid = spo.usupplierid");
        sql.append(" left join t_phone_model as pm on pm.uid = spo.uphonemodelid");
        sql.append(" left join t_brand as b on b.uid = pm.ubrandid");
        sql.append(" left join t_color as c on c.uid = spo.ucolorid");
        sql.append(" left join t_user as u on u.uid = spo.uuserid");
        sql.append(" where 1 = 1");
        if(!DataUtils.isNullOrEmpty(supplierPhoneOrder.getImei())){
            sql.append(" and spo.imei like :imei");
            map.put("imei", "%" + supplierPhoneOrder.getImei() + "%");
        }
        if(DataUtils.isUid(supplierPhoneOrder.getUsupplierid())){
            sql.append(" and spo.usupplierid = :usupplierid");
            map.put("usupplierid", supplierPhoneOrder.getUsupplierid());
        }
        if(DataUtils.isUid(supplierPhoneOrder.getUbrandid())){
            sql.append(" and b.uid = :ubrandid");
            map.put("ubrandid", supplierPhoneOrder.getUbrandid());
        }
        if(DataUtils.isUid(supplierPhoneOrder.getUphonemodelid())){
            sql.append(" and spo.uphonemodelid = :uphonemodelid");
            map.put("uphonemodelid", supplierPhoneOrder.getUphonemodelid());
        }
        if(DataUtils.isUid(supplierPhoneOrder.getUcolorid())){
            sql.append(" and spo.ucolorid = :ucolorid");
            map.put("ucolorid", supplierPhoneOrder.getUcolorid());
        }
        if(DataUtils.isUid(supplierPhoneOrder.getUdeptid())){
            sql.append(" and spo.udeptid = :udeptid");
            map.put("udeptid", supplierPhoneOrder.getUdeptid());
        }
        if(supplierPhoneOrder.getIstatus() != null && supplierPhoneOrder.getIstatus() != -1){
            sql.append(" and spo.istatus = :istatus");
            map.put("istatus", supplierPhoneOrder.getIstatus());
        }
        if(!DataUtils.isNullOrEmpty(supplierPhoneOrder.getDrecorddateStrMin())){
            sql.append(" and spo.drecorddate >= :drecorddateStrMin");
            map.put("drecorddateStrMin", supplierPhoneOrder.getDrecorddateStrMin() + " 00:00:00");
        }
        if(!DataUtils.isNullOrEmpty(supplierPhoneOrder.getDrecorddateStrMax())){
            sql.append(" and spo.drecorddate <= :drecorddateStrMax");
            map.put("drecorddateStrMax", supplierPhoneOrder.getDrecorddateStrMax() + " 23:59:59");
        }
        if(supplierPhoneOrder.getItype() != null){
            sql.append(" and (select top 1 spos.itype from t_supplier_phone_order_status as spos where spos.istatus = 1 and spos.IMEI = spo.IMEI) = :itype");
            map.put("itype", supplierPhoneOrder.getItype());
        }
        sql.append(" order by spo.drecorddate desc");
        return findList(sql, map);
    }
    
}
