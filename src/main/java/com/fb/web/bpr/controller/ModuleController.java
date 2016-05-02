package com.fb.web.bpr.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.Page;
import com.fb.domain.po.TModule;
import com.fb.web.SimpController;

/**
 * 功能模块管理
 * @author Liu bo
 */
@Controller
@RequestMapping("/bpr/module")
public class ModuleController extends SimpController {
    
    /**
     * 功能模块集合
     * @return
     */
    @RequestMapping(value = "list")
    public String list(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage, ModelMap map) {
        List<TModule> list = getService().getModuleService().getModuleList();
        Page<TModule> page = new Page<TModule>(list.size(), currentPage, list.size());
        page.setResultRows(list);
        map.put("page", page);
        return customPage();
    }
    
    /**
     * 新增功能模块
     * @param uid
     * @param map
     * @return
     */
    @RequestMapping("add")
    public String add(String uid, ModelMap map) {
        TModule parentModule = null;
        if (DataUtils.isUid(uid)) {
            parentModule = getService().getModuleService().getModuleByUid(uid);
        }
        map.put("parentModule", parentModule);
        Date timeToken = new Date();
        getSession().setAttribute("timeToken", timeToken);
        map.put("timeToken", timeToken);
        return customPage();
    }
    
    /**
     * 新增功能模块-保存数据
     * @param module
     * @param map
     * @return
     */
    @RequestMapping("addSave")
    public String addSave(String timeToken, TModule module, ModelMap map) {
        if (timeToken.equals(getSession().getAttribute("timeToken").toString())) {
            module.setUid(DataUtils.newUUID());
            getService().getModuleService().addModule(module);
            map.put("msg", "操作成功!");
            Date _timeToken = new Date();
            getSession().setAttribute("timeToken", _timeToken);
            map.put("timeToken", _timeToken);
        }
        TModule parentModule = new TModule();
        parentModule.setCtype(module.getCtype());
        parentModule.setCcode(module.getCparent());
        if (!DataUtils.isNullOrEmpty(module.getCparent())) {
            String ccodepath = module.getCcodepath().substring(0, module.getCcodepath().length() - (module.getCcode().length() + 1));
            parentModule.setCcodepath(ccodepath);
        }
        parentModule.setIlevel(module.getIlevel() > 1 ? (module.getIlevel() - 1) : 1);
        map.put("parentModule", parentModule);
        return "/bpr/module/add";
    }
    
    /**
     * 删除功能模块
     * @param uid
     * @param map
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public Integer delete(String uid, ModelMap map) {
        int count = 0;
        int moduleGroupModuleCount = getService().getModuleGroupModuleService().getModuleGroupModuleCountByUModuleId(uid);
        if (moduleGroupModuleCount == 0) {
            count = getService().getModuleService().deleteModule(uid);
        }
        return count;
    }
    
    /**
     * 编辑功能模块
     * @param uid
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("edit")
    public String edit(String uid, ModelMap map) {
        Date timeToken = new Date();
        getSession().setAttribute("timeToken", timeToken);
        map.put("timeToken", timeToken);
        map.put("module", getService().getModuleService().getModuleByUid(uid));
        return customPage();
    }
}
