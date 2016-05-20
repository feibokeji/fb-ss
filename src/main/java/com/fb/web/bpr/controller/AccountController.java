package com.fb.web.bpr.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TAccount;
import com.fb.domain.po.TCorp;
import com.fb.domain.po.TDept;
import com.fb.domain.po.TUser;
import com.fb.domain.vo.Combobox;
import com.fb.web.SimpController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/bpr/lovelysnow")
public class AccountController extends SimpController {
    
    /**
     * 账户页面
     * @return
     * @author Liu bo
     */
    @RequestMapping("account")
    public String account() {
        return customPage();
    }
    
    /**
     * 账户列表
     * @return
     * @author Liu bo
     */
    @RequestMapping("accountList")
    @ResponseBody
    public String accountList() {
        List<TAccount> list = new ArrayList<TAccount>();
        if (getSessionContainer().getRole().getCname().equals("系统管理员")) {
            list = getService().getAccountService().getList();
        } else {
            list = getService().getAccountService().getAccountListByUUserId(getSessionContainer().getUser().getUid());
        }
        
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    /**
     * 获取账户JSON数据
     * @return
     * @author Liu bo
     */
    @RequestMapping("getAccountJSONArray")
    @ResponseBody
    public JSONArray getAccountJSONArray() {
        List<Combobox> boxList = new ArrayList<Combobox>();
        if (getSessionContainer().getRole().getCname().equals("系统管理员")) {
            boxList = getService().getAccountService().getCombobox(null);
        } else {
            boxList = getService().getAccountService().getCombobox(getSessionContainer().getUser().getUid());
        }
        return JSONArray.fromObject(boxList);
    }
    
    /**
     * 新增账户
     * @param account
     * @return
     * @author Liu bo
     */
    @RequestMapping("accountAdd")
    @ResponseBody
    public String accountAdd(TAccount account) {
        account.setUid(DataUtils.newUUID());
        TUser user = getService().getUserService().getUser(account.getUuserid());
        TDept dept = getService().getDeptService().getDeptByUid(user.getUdeptid());
        TCorp corp = getService().getCorpService().getCorpByUid(dept.getUcorpid());
        account.setUdeptid(dept.getUid());
        account.setCdeptname(dept.getCname());
        account.setUcorpid(corp.getUid());
        account.setCcorpname(corp.getCname());
        int count = getService().getAccountService().add(account);
        if (count > 0) return "success";
        return "fail";
    }
    
    /**
     * 删除账户
     * @param uid
     * @return
     * @author Liu bo
     */
    @RequestMapping("accountDel")
    @ResponseBody
    public String accountDel(String uid) {
        int count = getService().getAccountOrderService().getAccountOrderByUAccountId(uid);
        if (count > 0)
            return "have";
        else {
            int res = getService().getAccountService().del(uid);
            if (res > 0) return "success";
        }
        return "fail";
    }
    
    /**
     * 修改账户
     * @param uid
     * @param cname
     * @return
     * @author Liu bo
     */
    @RequestMapping("accountMod")
    @ResponseBody
    public String accountMod(TAccount account) {
        int count = getService().getAccountService().mod(account);
        if (count > 0) return "success";
        return "fail";
    }
}
