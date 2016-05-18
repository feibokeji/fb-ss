package com.fb.web.bpr.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.EncryptionUtils;
import com.fb.domain.po.TUser;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/bpr/user")
public class UserController extends SimpController {
    
    @RequestMapping("detail")
    public String detail(ModelMap map) {
        map.put("user", getSessionContainer().getUser());
        return customPage();
    }
    
    @RequestMapping("list")
    public String list(ModelMap map) {
        map.put("user", getSessionContainer().getUser());
        return customPage();
    }
    
    @RequestMapping("mod")
    @ResponseBody
    public String mod(TUser user) {
        TUser old = getService().getUserService().getUser(user.getUid());
        user.setCpassword(old.getCpassword());
        int count = getService().getUserService().modify(user);
        if (count > 0) {
            this.addOperateLog("修改", "t_user", user.getUid(), "成功", null, null, "修改账户信息成功");
            return "success";
        }
        return "fail";
    }
    
    @RequestMapping("save")
    @ResponseBody
    public String save(TUser user) {
        user.setUid(DataUtils.newUUID());
        user.setCpassword(EncryptionUtils.MD5("123"));
        user.setDjoindate(new Date());
        user.setCsex("男");
        int c = getService().getUserService().save(user);
        if (c > 0) return "success";
        return "fail";
    }
    
    @RequestMapping("setPassword")
    @ResponseBody
    public String setPassword(String uid, String password) {
        int count = getService().getUserService().setUserPassword(uid, EncryptionUtils.MD5(password));
        if (count > 0) {
            this.addOperateLog("修改", "t_user", uid, "成功", null, null, "修改账户密码成功");
            return "success";
        }
        return "fail";
    }
    
    @RequestMapping("getUserJSON")
    @ResponseBody
    public String getUserJSON() {
        List<TUser> list = getService().getUserService().getUserList();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
}
