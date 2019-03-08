package com.fb.web.bpr.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.FormatUtils;
import com.fb.domain.po.TCustomer;
import com.fb.domain.po.TCustomerOrder;
import com.fb.domain.po.TOtherGoods;
import com.fb.domain.po.TPaymentMethod;
import com.fb.web.SimpController;

import net.sf.json.JSONArray;


/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年3月5日 下午4:14:56
 * 客户商品单据控制器
 */
@Controller
@RequestMapping("/bpr/customerOrder")
public class CustomerOrderController extends SimpController {
    
    /**
     * 商品销售页面
     * @return
     * @author Liu bo
     */
    @RequestMapping("goodsSell")
    public String goodsSell(){
        return customPage();
    }
    
    /**
     * 收银台
     * @param goodsId
     * @param ucustomerid
     * @return
     * @author Liu bo
     */
    @RequestMapping("checkStand")
    public String checkStand(String goodsId,String ucustomerid,ModelMap map){
        List<TOtherGoods> list = new ArrayList<TOtherGoods>();
        TCustomer customer = getService().getCustomerService().getCustomer(ucustomerid);
        List<TPaymentMethod> paymentMethodList = getService().getPaymentMethodService().getPaymentMethodList();
        double namount = 0.00;
        JSONArray goodsIdJSONArray = JSONArray.fromObject(goodsId);
        for(int i = 0; i < goodsIdJSONArray.size(); i++){
            TOtherGoods goods = getService().getOtherGoodsService().getOtherGoods(goodsIdJSONArray.getString(i));
            namount+= goods.getNretailprice();
            list.add(goods);
        }
        map.put("goodsList", list);
        map.put("customer", customer);
        map.put("quantity", list.size());
        map.put("namount", namount);
        map.put("paymentMethodList", paymentMethodList);
        return customPage();
    }
    
    /**
     * 保存 客户单据
     * @param order
     * @return
     * @author Liu bo
     */
    @RequestMapping("saveCustomerOrder")
    @ResponseBody
    public String saveCustomerOrder(TCustomerOrder order){
        String cno = "SL" + FormatUtils.formatDate(new Date(), "yyyyMMddhhmmss");
        order.setCno(cno);
        order.setItype(0);
        order.setIstatus(1);
        order.getOrderReceivable().setCtype("AR");
        order.getOrderReceipts().setCtype("AR");
        int count = getService().getCustomerOrderService().addOrder(order, getSessionContainer().getUser(), getIP(), getURL());
        if(count > 0)
            return "success";
        return "fail";
    }
}
