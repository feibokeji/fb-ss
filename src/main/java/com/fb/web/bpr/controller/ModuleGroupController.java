package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TModule;
import com.fb.domain.po.TModuleGroup;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("bpr/moduleGroup")
public class ModuleGroupController extends SimpController {
    
    @RequestMapping("list")
    public String list() {
        return customPage();
    }
    
    @RequestMapping("getModuleGroupJSON")
    @ResponseBody
    public String getModuleGroupJSON() {
        List<TModuleGroup> list = getService().getModuleGroupService().getModuleGroupJSON();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    @RequestMapping("getModuleListJSON")
    @ResponseBody
    public String getModuleListJSON(String umodulegroupid) {
        List<TModule> list = getService().getModuleService().getModuleListJSON(umodulegroupid);
        for (TModule item : list) {
            item.setUmodulegroupid(umodulegroupid);
        }
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    @RequestMapping("saveModuleGroupModule")
    @ResponseBody
    public String saveModuleGroupModule(String umodulegroupid, String umoduleids) {
        boolean res = getService().getModuleGroupModuleService().saveModuleGroupModule(umodulegroupid, umoduleids);
        if(res) return "success";
        return "fail";
    }
    
    @RequestMapping("save")
    @ResponseBody
    public String save(TModuleGroup moduleGroup) {
        moduleGroup.setUid(DataUtils.newUUID());
        int c = getService().getModuleGroupService().add(moduleGroup);
        if (c > 0) return "success";
        return "fail";
    }
    
    @RequestMapping("delete")
    @ResponseBody
    public String delete(String uid) {
        int h = getService().getModuleGroupModuleService().getModuleGroupModuleCountByUModuleGroupId(uid);
        if (h > 0)
            return "have";
        else {
            int c = getService().getModuleGroupService().del(uid);
            if (c > 0) return "success";
        }
        return "fail";
    }
    
    @RequestMapping("modify")
    @ResponseBody
    public String modify(TModuleGroup moduleGroup) {
        int c = getService().getModuleGroupService().modify(moduleGroup);
        if (c > 0) return "success";
        return "fail";
    }
}
