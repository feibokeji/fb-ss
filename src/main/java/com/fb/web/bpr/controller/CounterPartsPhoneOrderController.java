package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.domain.po.TCounterPartsPhoneOrder;
import com.fb.domain.po.TCounterPartsPhoneReceivable;
import com.fb.domain.po.TSupplierPhoneOrder;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年2月20日 下午2:07:09
 * 同行手机单据控制
 */
@Controller
@RequestMapping("/bpr/counterPartsPhoneOrder")
public class CounterPartsPhoneOrderController extends SimpController {
    
    /**
     * 打开 可以被调出的手机信息列表页面
     * @return
     * @author Liu bo
     */
    @RequestMapping("outOrder")
    public String outOrder(){
        return customPage();
    }
    
    /**
     * 获取 可以被调出的手机信息集合JSON数据
     * @return
     * @author Liu bo
     */
    @RequestMapping("outOrderJSON")
    @ResponseBody
    public String outOrderJSON(TSupplierPhoneOrder order){
        Integer [] itypeArray = {0,3,5};
        order.setUdeptid(getSessionContainer().getDept().getUid());
        order.setItypeArray(itypeArray);
        order.setIstatus(1);
        List<TSupplierPhoneOrder> list = getService().getSupplierPhoneOrderService().getSupplierPhoneOrderList(order);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    /**
     * 验证 当前手机信息是否可以被同行调出
     * @param imei
     * @return
     * @author Liu bo
     */
    @RequestMapping("validOutOrder")
    @ResponseBody
    public String validOutOrder(String imei){
        TSupplierPhoneOrder order = getService().getSupplierPhoneOrderService().getSupplierPhoneOrder(imei);
        if(order.getItype() != 0 && order.getItype() != 3 && order.getItype() != 5)
            return "n";
        return "y";
    }
    
    /**
     * 执行 当前手机信息调出给同行
     * @param ucounterpartsid
     * @param imei
     * @return
     * @author Liu bo
     */
    @RequestMapping("executeOutOrder")
    @ResponseBody
    public String executeOutOrder(String ucounterpartsid,String imei){
        boolean result = getService().getCounterPartsPhoneOrderService().executePhoneOut(ucounterpartsid, imei, getSessionContainer().getUser(), getIP(), getURL());
        if(result)
            return "success";
        return "fail";
    }
    
    /**
     * 打开 已调出手机信息页面
     * @return
     * @author Liu Bo
     */
    @RequestMapping("hasOut")
    public String hasOut(){
        return customPage();
    }
    
    /**
     * 打开 调入手机信息页面
     * @return
     * @author Liu Bo
     */
    @RequestMapping("hasIn")
    public String hasIn(){
        return customPage();
    }
    
    /**
     * 获取 同行手机单据信息集合的JSON数据
     * @param order
     * @return
     * @author Liu Bo
     */
    @RequestMapping("getCounterPartsPhoneOrderJSON")
    @ResponseBody
    public String getCounterPartsPhoneOrderJSON(TCounterPartsPhoneOrder order){
        order.setUdeptid(getSessionContainer().getDept().getUid());
        List<TCounterPartsPhoneOrder> list = getService().getCounterPartsPhoneOrderService().getPhoneOrder(order);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    /**
     * 获取 单据的应收应付款信息
     * @param uorderid
     * @return
     * @author Liu Bo
     */
    @RequestMapping("getOrderReceivableListJSON")
    @ResponseBody
    public String getOrderReceivableListJSON(String uorderid){
        List<TCounterPartsPhoneReceivable> list = getService().getCounterPartsPhoneReceivableService().getByUorderid(uorderid);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    /**
     * 执行 单据调入业务
     * @param uid
     * @return
     * @author Liu Bo
     */
    @RequestMapping("executeInOrder")
    @ResponseBody
    public String executeInOrder(String uid){
        TCounterPartsPhoneOrder order = getService().getCounterPartsPhoneOrderService().getPhoneOrder(uid);
        if(order.getIstatus() == 0)
            return "此调出单据未审核，不能办理调入业务！";
        else{
            boolean result = getService().getCounterPartsPhoneOrderService().executePhoneIn(uid, getSessionContainer().getUser(), getIP(), getURL());
            if(result)
                return "success";
        }
        return "fail";
    }
    
    /**
     * 审核 单据
     * @param uid
     * @return
     * @author Liu Bo
     */
    @RequestMapping("auditOrder")
    @ResponseBody
    public String auditOrder(String uid){
        TCounterPartsPhoneOrder order = getService().getCounterPartsPhoneOrderService().getPhoneOrder(uid);
        if(order.getIstatus() == 1)
            return "此单据已审核，不能重复审核！";
        else{
            boolean result = getService().getCounterPartsPhoneOrderService().auditOrder(uid, getSessionContainer().getUser(), getIP(), getURL());
            if(result)
                return "success";
        }
        return "fail";
    }
    
    /**
     * 反审核 单据
     * @param uid
     * @return
     * @author Liu Bo
     */
    @RequestMapping("reverseAuditOrder")
    @ResponseBody
    public String reverseAuditOrder(String uid){
        TCounterPartsPhoneOrder order = getService().getCounterPartsPhoneOrderService().getPhoneOrder(uid);
        if(order.getIstatus() == 0)
            return "此单据未审核，不能进行反审核！";
        else{
            int orderReceiptsNum = getService().getCounterPartsPhoneReceiptsService().getOrderReceiptsNum(uid);
            if(orderReceiptsNum > 0)
                return "此单据已产出收付款，不能进行反审核！";
            else{
                boolean result = getService().getCounterPartsPhoneOrderService().reverseAuditOrder(uid, getSessionContainer().getUser(), getIP(), getURL());
                if(result)
                    return "success";
            }
        }
        return "fail";
    }
}
