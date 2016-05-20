package com.fb.web.bpr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fb.domain.po.TAccount;
import com.fb.domain.po.TAccountOrder;
import com.fb.web.SimpController;

@Controller
@RequestMapping("/bpr/report")
public class ReportController extends SimpController {
    
    @RequestMapping("account")
    public String account() {
        return customPage();
    }
    
    @RequestMapping("product")
    public String product() {
        return customPage();
    }
    
    @RequestMapping("searchAccountOrder")
    public String searchAccountOrder(TAccountOrder accountOrder, ModelMap map) {
        List<TAccountOrder> accountOrderList = new ArrayList<TAccountOrder>();
        if (getSessionContainer().getRole().getCname().equals("系统管理员")) {
            accountOrderList = getService().getAccountOrderService().getAccountOrderList(accountOrder);
        } else {
            List<TAccount> accountList = getService().getAccountService().getAccountListByUUserId(getSessionContainer().getUser().getUid());
            for (TAccount item : accountList) {
                accountOrder.setUaccountid(item.getUid());
                List<TAccountOrder> n = getService().getAccountOrderService().getAccountOrderList(accountOrder);
                for(TAccountOrder ao : n){
                    accountOrderList.add(ao);
                }
            }
        }
        map.put("accountOrderList", accountOrderList);
        map.put("accountOrder", accountOrder);
        return "/bpr/report/account";
    }
}
