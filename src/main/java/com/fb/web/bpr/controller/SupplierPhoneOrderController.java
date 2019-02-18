package com.fb.web.bpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TSupplierPhoneOrder;
import com.fb.domain.vo.SupplierPhoneOrder;
import com.fb.web.SimpController;


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
}
