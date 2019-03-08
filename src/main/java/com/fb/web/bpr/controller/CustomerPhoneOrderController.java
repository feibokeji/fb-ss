package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.domain.po.TSupplierPhoneOrder;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月5日 下午4:15:35
 * 客户手机单据控制器
 */
@Controller
@RequestMapping("/bpr/customerPhoneOrder")
public class CustomerPhoneOrderController extends SimpController {
    
    /**
     * 手机销售页面
     * @return
     * @author Liu bo
     */
    @RequestMapping("phoneSell")
    public String phoneSell(){
        return customPage();
    }
    
    /**
     * 获取可销售的手机信息
     * @return
     * @author Liu bo
     */
    @RequestMapping("getPhoneSellJSON")
    @ResponseBody
    public String getPhoneSellJSON(TSupplierPhoneOrder order){
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
     * 手机销售-结账页面
     * @param phoneIMEI 手机串码JSON数据
     * @param ucustomerid 客户表外键
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("checkStand")
    public String checkStand(String phoneIMEI,String ucustomerid,ModelMap map){
        return customPage();
    }
}
