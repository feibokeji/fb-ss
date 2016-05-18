package com.fb.web.bpr.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fb.domain.po.TLoginLog;
import com.fb.domain.po.TOperateLog;
import com.fb.web.SimpController;

@Controller
@RequestMapping("/bpr/log")
public class LogController extends SimpController {
    
    @RequestMapping("list")
    public String list(ModelMap map) {
        List<TLoginLog> loginList = getService().getLoginService().getLoginLogList();
        map.put("loginList", loginList);
        List<TOperateLog> operateList = getService().getOperateLogService().getOperateLogList();
        map.put("operateList", operateList);
        return customPage();
    }
}
