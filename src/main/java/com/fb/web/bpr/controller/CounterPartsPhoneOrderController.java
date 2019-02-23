package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
}
