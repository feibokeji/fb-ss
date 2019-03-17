package com.fb.service;

import java.util.List;

import com.fb.domain.po.TSupplierReceipts;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月16日 下午4:43:35
 * 供应商商品单据的实收实付服务接口
 */
public interface SupplierReceiptsService {
   
    /**
     * 获取 实收实付信息集合
     * @param ureceivableid 应收应付表外键
     * @return
     * @author Liu bo
     */
    public List<TSupplierReceipts> getReceiptsListByReceivable(String ureceivableid);
    
    /**
     * 获取 实收/实付 总金额
     * @param ureceivableid 应收/应付表外键
     * @param istatus {@value 0=未结算/1=已结算/-1=全部}
     * @return
     * @author Liu bo
     */
    public double getReceiptsNamountByReceivable(String ureceivableid,int istatus);
    
    /**
     * 新增 实收/实付 信息
     * @param receipts
     * @return
     * @author Liu bo
     */
    public int addReceipts(TSupplierReceipts receipts);
    
}
