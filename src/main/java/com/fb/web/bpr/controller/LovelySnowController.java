package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TCategory;
import com.fb.web.SimpController;
import net.sf.json.JSONObject;

/**
 * 可爱雪门店管理
 * @since 2016年4月29日 上午10:55:48
 * @author Liu bo
 */
@Controller
@RequestMapping("/bpr/lovelysnow")
public class LovelySnowController extends SimpController {
    
    @RequestMapping("category")
    public String category(ModelMap map){
        return customPage();
    }
    
    @RequestMapping("listCategory")
    @ResponseBody
    public String listCategory(){
        List<TCategory> list = getService().getCategoryService().getCategoryList();
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        JSONObject _jsonObject = JSONObject.fromObject(map);
        return _jsonObject.toString();
    }
    
    @RequestMapping("addCategory")
    @ResponseBody
    public String addCategory(TCategory category){
        if(category != null){
            category.setUid(DataUtils.newUUID());
            int count = getService().getCategoryService().add(category);
            if(count > 0)
                return "success";
            else
                return "fail";
        }
        return "fail";
    }
}
