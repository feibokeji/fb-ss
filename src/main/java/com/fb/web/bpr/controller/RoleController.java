package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TRole;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("bpr/role")
public class RoleController extends SimpController {
    
    @RequestMapping("list")
    public String list() {
        return customPage();
    }
    
    @RequestMapping("getRoleJSON")
    @ResponseBody
    public String getRoleJSON() {
        List<TRole> list = getService().getRoleService().getRoleList();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    @RequestMapping("save")
    @ResponseBody
    public String save(TRole role) {
        role.setUid(DataUtils.newUUID());
        int c = getService().getRoleService().addRole(role);
        if (c > 0) return "success";
        return "fail";
    }
    
    @RequestMapping("delete")
    @ResponseBody
    public String delete(String uid) {
        int h = getService().getRoleService().getRoleModuleGroupCountByURoleId(uid);
        if (h > 0)
            return "have";
        else {
            int c = getService().getRoleService().delete(uid);
            if (c > 0) return "success";
        }
        return "fail";
    }
    
    @RequestMapping("modify")
    @ResponseBody
    public String modify(TRole role) {
        int c = getService().getRoleService().modify(role);
        if (c > 0) return "success";
        return "fail";
    }
}
