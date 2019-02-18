package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TSupplierPhoneOrderStatusDao;
import com.fb.domain.po.TSupplierPhoneOrderStatus;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月16日 上午10:30:54
 * 供应商手机单据状态操作接口实现类
 */
@Service
public class TSupplierPhoneOrderStatusDaoImpl extends SimpMapper<TSupplierPhoneOrderStatus> implements TSupplierPhoneOrderStatusDao {
    
    public int add(TSupplierPhoneOrderStatus supplierPhoneOrderStatus) {
        return super.save(supplierPhoneOrderStatus);
    }
    
    public int mod(TSupplierPhoneOrderStatus supplierPhoneOrderStatus) {
        return super.update(supplierPhoneOrderStatus);
    }
    
    public int modStatus(String imei, int istatus) {
        QMap map = new QMap();
        String sql = "update t_supplier_phone_order_status set istatus = :istatus where imei = :imei";
        map.put("istatus", istatus);
        map.put("imei", imei);
        return super.execute(sql, map);
    }
    
    public int getCurrentType(String imei) {
        String sql = "select top 1 itype from t_supplier_phone_order_status where istatus = 1 and imei = :imei";
        return getInt(sql, new QMap("imei",imei));
    }
    
    public List<TSupplierPhoneOrderStatus> get(String imei) {
        String sql = "select * from t_supplier_phone_order_status where imei = :imei";
        return super.findList(sql, new QMap("imei",imei));
    }
    
}
