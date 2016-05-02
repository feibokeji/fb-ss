package com.fb.web.bpr.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fb.domain.po.TModule;
import com.fb.web.SimpController;

@Controller
@RequestMapping("/bpr")
public class IndexController extends SimpController {
    
    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.put("sessionContainer", getSessionContainer());
        List<TModule> listModule = getService().getLoginService().loadingModule(getRoleContainer());
        map.put("listModule", listModule);
        return customPage();
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return redirect("/bpr/index");
    }
    
    @RequestMapping("/home")
    public String home(ModelMap map){
        return customPage();
    }
    
}
