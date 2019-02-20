package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TSupplierPhoneOrder;
import com.fb.domain.po.TSupplierPhoneOrderReceivable;
import com.fb.domain.po.TSupplierPhoneOrderStatus;
import com.fb.domain.vo.SupplierPhoneOrder;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月16日 下午5:56:03
 * 供应商手机单据控制器
 */
@Controller
@RequestMapping("/bpr/supplierPhoneOrder")
public class SupplierPhoneOrderController extends SimpController {
    
    /**
     * 打开 新增页面
     * @param itype
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("add")
    public String add(int itype,ModelMap map){
        map.put("itype", itype);
        map.put("user", getSessionContainer().getUser());
        return customPage();
    }
    
    /**
     * 保存 单据
     * @param orderDetailList
     * @param itype
     * @param istatus
     * @param usupplierid
     * @param drecorddateStr
     * @return
     * @author Liu bo
     */
    @RequestMapping("addSave")
    @ResponseBody
    public String addSave(SupplierPhoneOrder supplierPhoneOrder){
        System.out.println(supplierPhoneOrder.getDrecorddateStr());
        boolean isHaveData = false;
        for (TSupplierPhoneOrder detail : supplierPhoneOrder.getOrderDetailList()) {
            if(DataUtils.isUid(detail.getUphonemodelid()) && DataUtils.isUid(detail.getUcolorid()) && !DataUtils.isNullOrEmpty(detail.getImei()) && detail.getNcostprice() != null && detail.getNretailprice() != null) {
                isHaveData = true;
            }
        }
        if (isHaveData) {
            String ip = "";
            String[] temp = {getRequest().getHeader("x-forwarded-for"), getRequest().getHeader("Proxy-Client-IP"), getRequest().getHeader("WL-Proxy-Client-IP"), getRequest().getRemoteAddr()};
            for (int i = 0; i < temp.length; i++) {
                if (!"".equals(DataUtils.defaultString(temp[i])) && !"unknown".equalsIgnoreCase(temp[i])) {
                    ip += temp[i] + "|";
                }
            }
            String url = getRequest().getRequestURI().toString();
            if (getService().getSupplierPhoneOrderService().addSupplierPhoneOrder(supplierPhoneOrder, getSessionContainer().getUser(),ip,url)) {
                return "success";
            }
        } else
            return "nHave";
        return "fail";
    }
    
    /**
     * 打开 供应商手机单据列表
     * @return
     * @author Liu bo
     */
    @RequestMapping("list")
    public String list(){
        return customPage();
    }
    
    /**
     * 获取 供应商手机单据JSON数据
     * @param order
     * @return
     * @author Liu bo
     */
    @RequestMapping("getOrderListJSON")
    @ResponseBody
    public String getOrderListJSON(TSupplierPhoneOrder order){
        order.setUdeptid(getSessionContainer().getDept().getUid());
        List<TSupplierPhoneOrder> list = getService().getSupplierPhoneOrderService().getSupplierPhoneOrderList(order);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    /**
     * 获取 供应商手机单据应收应付JSON数据
     * @param imei
     * @return
     * @author Liu bo
     */
    @RequestMapping("getOrderReceivableListJSON")
    @ResponseBody
    public String getOrderReceivableListJSON(String imei){
        List<TSupplierPhoneOrderReceivable> list = getService().getSupplierPhoneOrderService().getSupplierPhoneOrderReceivableList(imei);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    /**
     * 获取 供应商手机单据状态JSON数据
     * @param imei
     * @return
     * @author Liu bo
     */
    @RequestMapping("getOrderStatusListJSON")
    @ResponseBody
    public String getOrderStatusListJSON(String imei){
        List<TSupplierPhoneOrderStatus> list = getService().getSupplierPhoneOrderService().getSupplierPhoneOrderStatusList(imei);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    /**
     * 验证 是否可退库
     * @param imei
     * @return
     * @author Liu bo
     */
    @RequestMapping("validReturn")
    @ResponseBody
    public String validReturn(String imei){
        TSupplierPhoneOrder order = getService().getSupplierPhoneOrderService().getSupplierPhoneOrder(imei);
        if(order.getItype() == 0 && order.getIstatus() == 1)
            return "y";
        return "n";
    }
    
    /**
     * 退库
     * @param imei
     * @return
     * @author Liu bo
     */
    @RequestMapping("returnOrder")
    @ResponseBody
    public String returnOrder(String imei){
        boolean result = getService().getSupplierPhoneOrderService().returnSupplierPhoneOrder(imei, getSessionContainer().getUser(), getIP(), getURL());
        if(result)
            return "success";
        return "fail";
    }
    
    /**
     * 验证 是否可以审核
     * @param imei
     * @return
     * @author Liu bo
     */
    @RequestMapping("validAudit")
    @ResponseBody
    public String validAudit(String imei){
        TSupplierPhoneOrder order = getService().getSupplierPhoneOrderService().getSupplierPhoneOrder(imei);
        if(order.getIstatus() == 0 && order.getItype() == 0)
            return "y";
        return "n";
    }
    
    /**
     * 审核 单据
     * @param imei
     * @return
     * @author Liu bo
     */
    @RequestMapping("audit")
    @ResponseBody
    public String audit(String imei){
        boolean result = getService().getSupplierPhoneOrderService().auditSupplierPhoneOrder(imei, getSessionContainer().getUser(), getIP(), getURL());
        if(result)
            return "success";
        return "fail";
    }
    
    /**
     * 验证 是否可以反审核
     * @param imei
     * @return
     * @author Liu bo
     */
    @RequestMapping("validReverseAudit")
    @ResponseBody
    public String validReverseAudit(String imei){
        TSupplierPhoneOrder order = getService().getSupplierPhoneOrderService().getSupplierPhoneOrder(imei);
        if(order.getIstatus() == 0)//未审核的单据不能反审核
            return "n";
        else if(order.getItype() != 0){
            return "n";
        }else{
            //查询是否存在实收实付
            int receiptsNum = getService().getSupplierPhoneOrderReceiptsService().getSupplierPhoneOrderReceiptsNum(imei);
            if(receiptsNum > 0)
                return "n";
        }
        return "y";
    }
    
    /**
     * 反审核 单据
     * @param imei
     * @return
     * @author Liu bo
     */
    @RequestMapping("reverseAudit")
    @ResponseBody
    public String reverseAudit(String imei){
        boolean result = getService().getSupplierPhoneOrderService().reverseAuditSupplierPhoneOrder(imei, getSessionContainer().getUser(), getIP(), getURL());
        if(result)
            return "success";
        return "fail";
    }
    
    /**
     * 验证 是否可以删除
     * @param imei
     * @return
     * @author Liu bo
     */
    @RequestMapping("validDelete")
    @ResponseBody
    public String validDelete(String imei){
        TSupplierPhoneOrder order = getService().getSupplierPhoneOrderService().getSupplierPhoneOrder(imei);
        if(order.getIstatus() != 0)
            return "n";
        else if(order.getItype() != 0){
            return "n";
        }else{
            //查询是否存在实收实付
            int receiptsNum = getService().getSupplierPhoneOrderReceiptsService().getSupplierPhoneOrderReceiptsNum(imei);
            if(receiptsNum > 0)
                return "n";
        }
        return "y";
    }
    
    /**
     * 删除 单据
     * @param imei
     * @return
     * @author Liu bo
     */
    @RequestMapping("delete")
    @ResponseBody
    public String delete(String imei){
        boolean result = getService().getSupplierPhoneOrderService().deleteSupplierPhoneOrder(imei, getSessionContainer().getUser(), getIP(), getURL());
        if(result)
            return "success";
        return "fail";
    }
}
