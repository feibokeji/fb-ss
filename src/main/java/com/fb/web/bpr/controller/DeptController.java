package com.fb.web.bpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fb.web.SimpController;

/**
 * 部门管理
 * @since 2015-6-27 下午1:15:31
 * @author Liu bo
 */
@Controller
@RequestMapping("/bpr/dept")
public class DeptController extends SimpController {
    
    /**
     * 部门管理
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("/list")
    public String list(ModelMap map){
        return customPage();
    }
}
