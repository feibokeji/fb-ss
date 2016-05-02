package com.fb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fb.core.utils.QMap;
import com.fb.dao.TAccountOrderDetailDao;
import com.fb.domain.po.TAccountOrderDetail;

/**
 * 单据明细操作
 * @since 2016年4月11日 下午6:06:07
 * @author Liu bo
 */
@Service
public class TAccountOrderDetailDaoImpl extends SimpMapper<TAccountOrderDetail> implements TAccountOrderDetailDao {
    
    
    public int addAccountOrderDetail(TAccountOrderDetail accountOrderDetail) {
        return this.save(accountOrderDetail);
    }
    
    public int updateAccountOrderDetail(TAccountOrderDetail accountOrderDetail) {
        return this.update(accountOrderDetail);
    }

    public List<TAccountOrderDetail> getAccountOrderDetailByUAccountOrderId(String uaccountorderid) {
        String sql = "select * from t_account_order_detail t where t.uaccountorderid = :uaccountorderid order by t.isort asc";
        return findList(sql, new QMap("uaccountorderid",uaccountorderid));
    }
    
}
