package com.fb.web.bpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fb.web.SimpController;

/**
 * 账务类型管理
 * @since 2016年4月18日 下午7:20:51
 * @author Liu bo
 */
@Controller
@RequestMapping("/bpr")
public class AccountTypeController extends SimpController{
    
    /**
     * 
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("/lovelysnow/accountType")
    public String lsAccountType(ModelMap map){
        return customPage();
    }
}
