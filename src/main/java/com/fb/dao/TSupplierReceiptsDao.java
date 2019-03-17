package com.fb.dao;

import java.util.List;

import com.fb.domain.po.TSupplierReceipts;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月1日 下午7:19:41
 * 供应商实收实付表操作接口
 */
public interface TSupplierReceiptsDao {
    /**
     * 新增：供应商实付实收
     * @param supplierReceipts
     * @return 受影响行数
     * @author Liu bo
     */
    public int add(TSupplierReceipts supplierReceipts);
    /**
     * 删除：供应商实付实收
     * @param uid
     * @return
     * @author Liu bo
     */
    public int del(String uid);
    /**
     * 删除：供应商应收应付下所有实收实付
     * @param ureceivableid
     * @return
     * @author Liu bo
     */
    public int delAll(String ureceivableid);
    /**
     * 修改：供应商实收实付
     * @param supplierReceipts
     * @return
     * @author Liu bo
     */
    public int mod(TSupplierReceipts supplierReceipts);
    /**
     * 修改：供应商实收实付状态
     * @param uid
     * @param istatus
     * @return
     * @author Liu bo
     */
    public int modStatus(String uid,int istatus);
    /**
     * 获取：供应商实收实付
     * @param uid
     * @return
     * @author Liu bo
     */
    public TSupplierReceipts get(String uid);
    /**
     * 获取：供应商应收应付对应下的实收实付集合
     * @param ureceivableid
     * @return
     * @author Liu bo
     */
    public List<TSupplierReceipts> getAll(String ureceivableid);
    /**
     * 获取：供应商实收实付列表
     * @param supplierReceipts
     * @return
     * @author Liu bo
     */
    public List<TSupplierReceipts> getList(TSupplierReceipts supplierReceipts);
    /**
     * 获取：供应商单据的实收实付量
     * @param uorderid {@value 单据主键}
     * @param istatus {@value 0=未审核 1=已审核}
     * @return
     * @author Liu bo
     */
    public int getOrderReceiptsNumber(String uorderid,int istatus);
    
    /**
     * 获取 供应商单据实收实付信息集合
     * @param uorderid 单据表外键
     * @return
     * @author Liu bo
     */
    public List<TSupplierReceipts> getReceiptsListByOrder(String uorderid);
    
    /**
     * 获取 实收/实付 金额
     * @param ureceivableid 应收/应付表外键
     * @param istatus {@value 0=未结算/1=已结算/-1=全部}
     * @return
     * @author Liu bo
     */
    public double getNamountByReceivable(String ureceivableid,int istatus);
}
