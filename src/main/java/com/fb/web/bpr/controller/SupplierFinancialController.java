package com.fb.web.bpr.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TSupplierReceipts;
import com.fb.domain.po.TSupplierReceivable;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月16日 下午2:45:54
 * 供应商财务管理
 */
@Controller
@RequestMapping("/bpr/supplier/financial")
public class SupplierFinancialController extends SimpController {
    
    /**
     * 商品类应收或应付信息页面
     * @param ctype {@value AR=应收/AP=应付}
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("/goods/receivable")
    public String receivable(String ctype,ModelMap map){
        map.put("ctype", ctype);
        return customPage();
    }
    
    /**
     * 商品类应收或应付信息集合JSON数据
     * @param receivable
     * @return
     * @author Liu bo
     */
    @RequestMapping("/goods/receivableListJSON")
    @ResponseBody
    public String receivableListJSON(TSupplierReceivable receivable){
        List<TSupplierReceivable> list = getService().getSupplierReceivableService().getReceivableList(receivable);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    /**
     * 获取商品类应收应付对应的实收实付信息集合JSON数据
     * @param ureceivableid
     * @return
     * @author Liu bo
     */
    @RequestMapping("/goods/receiptsListByReceivableJSON")
    @ResponseBody
    public String receiptsListByReceivableJSON(String ureceivableid){
        List<TSupplierReceipts> list = getService().getSupplierReceiptsService().getReceiptsListByReceivable(ureceivableid);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    /**
     * 获取 未结算金额
     * @param ureceivableid 应收/应付表外键
     * @return
     * @author Liu bo
     */
    @RequestMapping("/goods/getOutstandingAmount")
    @ResponseBody
    public String getOutstandingAmount(String ureceivableid){
        TSupplierReceivable receivable = getService().getSupplierReceivableService().getReceivable(ureceivableid);
        double namount = getService().getSupplierReceiptsService().getReceiptsNamountByReceivable(ureceivableid, -1);
        double outstandingAmount = receivable.getNamount() - namount;
        return String.valueOf(outstandingAmount);
    }
    
    /**
     * 新增 实收/实付 页面
     * @param ureceivableid
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("/goods/addReceipts")
    public String addReceipts(String ureceivableid,ModelMap map){
        TSupplierReceivable receivable = getService().getSupplierReceivableService().getReceivable(ureceivableid);
        double namount = getService().getSupplierReceiptsService().getReceiptsNamountByReceivable(ureceivableid, -1);
        double addNamount = receivable.getNamount() - namount;
        map.put("receivable", receivable);
        map.put("addNamount", addNamount);
        map.put("user", getSessionContainer().getUser());
        return customPage();
    }
    
    /**
     * 保存 供应商商品单据 实收/实付
     * @param receipts
     * @return
     * @author Liu bo
     */
    @RequestMapping("/goods/saveReceipts")
    @ResponseBody
    public String saveReceipts(TSupplierReceipts receipts){
        Date date = new Date();
        receipts.setUid(DataUtils.newUUID());
        receipts.setUuserid(getSessionContainer().getUser().getUid());
        receipts.setUdeptid(getSessionContainer().getDept().getUid());
        receipts.setDrecorddate(date);
        receipts.setDupdatedate(date);
        int count = getService().getSupplierReceiptsService().addReceipts(receipts);
        if(count > 0){
            addOperateLog("新增", "t_supplier_receipts", receipts.getUid(), "成功", "", "", "新增供应商商品款项成功！");
            return "success";
        }
        return "fail";
    }
}
