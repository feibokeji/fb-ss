package com.fb.web.bpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fb.web.SimpController;


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
}
