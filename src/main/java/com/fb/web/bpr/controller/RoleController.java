package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TModuleGroup;
import com.fb.domain.po.TRole;
import com.fb.domain.po.TRoleModuleGroup;
import com.fb.domain.po.TUser;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("bpr/role")
public class RoleController extends SimpController {
    
    @RequestMapping("list")
    public String list() {
        return customPage();
    }
    
    @RequestMapping("add")
    public String add(){
        return customPage();
    }
    
    @RequestMapping("modify")
    public String modify(String uid,ModelMap map){
        TRole role = getService().getRoleService().getRole(uid);
        map.put("role", role);
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
        TUser user = getService().getUserService().getUser(role.getUuserid());
        role.setUdeptid(user.getUdeptid());
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
    
    @RequestMapping("modifySave")
    @ResponseBody
    public String modifySave(TRole role) {
        int c = getService().getRoleService().modify(role);
        if (c > 0) return "success";
        return "fail";
    }
    
    @RequestMapping("getRoleModuleGroupListJSON")
    @ResponseBody
    public String getRoleModuleGroupListJSON(String uroleid) {
        List<TModuleGroup> mgList = getService().getModuleGroupService().getModuleGroupJSON();
        List<TRoleModuleGroup> rmgList = getService().getRoleService().getRoleModuleGroupByRoleId(uroleid);
        for (TModuleGroup mg : mgList) {
            mg.setUroleid(uroleid);
            for (TRoleModuleGroup rmg : rmgList) {
                if (rmg.getUmodulegroupid().equals(mg.getUid())) {
                    mg.setHaveModuleGroup(1);
                }
            }
        }
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", mgList);
        map.put("Total", mgList.size());
        return JSONObject.fromObject(map).toString();
    }
    
    @RequestMapping("saveRoleModuleGroup")
    @ResponseBody
    public String saveRoleModuleGroup(String uroleid, String umodulegroupids) {
        boolean res = getService().getRoleService().saveRoleModuleGroup(uroleid, umodulegroupids);
        if (res)return "success";else return "fail";
    }
}
