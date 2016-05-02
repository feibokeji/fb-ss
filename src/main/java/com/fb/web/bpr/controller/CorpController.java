package com.fb.web.bpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.Page;
import com.fb.domain.po.TCorp;
import com.fb.web.SimpController;

@Controller
@RequestMapping("/bpr/corp")
public class CorpController extends SimpController {
    
    /**
     * 打开公司信息新增页面
     * @return
     * @author Liu bo
     */
    @RequestMapping("/add")
    public String add() {
        return customPage();
    }
    
    /**
     * 公司信息保存
     * @param corp
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("/addSave")
    public String addSave(TCorp corp, ModelMap map) {
        if (corp != null) {
            if (getService().getCorpService().addCorp(corp)) map.put("addOK", true);
        }
        return "/bpr/corp/add";
    }
    
    /**
     * 公司信息列表查询
     * @param corp
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("/list")
    public String list(TCorp corp, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage, ModelMap map) {
        Page<TCorp> page = getService().getCorpService().getCorpPage(corp, currentPage);
        map.put("corp", corp);
        map.put("page", page);
        return customPage();
    }
    
    /**
     * 删除公司信息
     * @param uid
     * @return
     * @author Liu bo
     */
    @RequestMapping("delete")
    @ResponseBody
    public boolean delete(String uid) {
        boolean result = getService().getCorpService().deleteCorpByUid(uid);
        return result;
    }
    
    /**
     * 编辑公司信息
     * @param uid
     * @return
     * @author Liu bo
     */
    @RequestMapping("/edit")
    public String edit(String uid, ModelMap map) {
        TCorp corp = getService().getCorpService().getCorpByUid(uid);
        map.put("corp", corp);
        return customPage();
    }
    
    /**
     * 公司信息编辑保存
     * @param corp
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("/editSave")
    public String editSave(TCorp corp, ModelMap map) {
        map.put("updateOK", getService().getCorpService().updateCorp(corp));
        map.put("corp", getService().getCorpService().getCorpByUid(corp.getUid()));
        return "/bpr/corp/edit";
    }
}
