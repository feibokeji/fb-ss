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
import com.fb.domain.po.TMaterial;
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
    
    /**
     * 打开产品类别页面
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("category")
    public String category(ModelMap map) {
        return customPage();
    }
    
    /**
     * 打开物料页面
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("material")
    public String material(ModelMap map) {
        return customPage();
    }
    
    /**
     * 获取产品类别分页数据
     * @return
     * @author Liu bo
     */
    @RequestMapping("listCategory")
    @ResponseBody
    public String listCategory() {
        List<TCategory> list = getService().getCategoryService().getCategoryList();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        JSONObject _jsonObject = JSONObject.fromObject(map);
        return _jsonObject.toString();
    }
    
    /**
     * 获取物料分页数据
     * @return
     * @author Liu bo
     */
    @RequestMapping("listMaterial")
    @ResponseBody
    public String listMaterial() {
        List<TMaterial> list = getService().getMaterialService().getMaterialList();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Rows", list.size());
        JSONObject _jsonObject = JSONObject.fromObject(map);
        return _jsonObject.toString();
    }
    
    /**
     * 新增产品类别
     * @param category
     * @return
     * @author Liu bo
     */
    @RequestMapping("addCategory")
    @ResponseBody
    public String addCategory(TCategory category) {
        if (category != null) {
            category.setUid(DataUtils.newUUID());
            int count = getService().getCategoryService().add(category);
            if (count > 0)
                return "success";
            else
                return "fail";
        }
        return "fail";
    }
    
    /**
     * 新增物料
     * @param material
     * @return
     * @author Liu bo
     */
    @RequestMapping("addMaterial")
    @ResponseBody
    public String addMaterial(TMaterial material) {
        if (material != null) {
            material.setUid(DataUtils.newUUID());
            int count = getService().getMaterialService().add(material);
            if (count > 0) {
                return "success";
            } else
                return "fail";
        }
        return "fail";
    }
    
    /**
     * 修改产品类别
     * @param category
     * @return
     * @author Liu bo
     */
    @RequestMapping("modifyCategory")
    @ResponseBody
    public String modifyCategory(TCategory category) {
        if (category != null) {
            int count = getService().getCategoryService().update(category);
            if (count > 0)
                return "success";
            else
                return "fail";
        }
        return "fail";
    }
    
    /**
     * 修改物料
     * @param material
     * @return
     * @author Liu bo
     */
    @RequestMapping("modifyMaterial")
    @ResponseBody
    public String modifyMaterial(TMaterial material) {
        if (material != null) {
            int count = getService().getMaterialService().update(material);
            if (count > 0) {
                return "success";
            } else
                return "fail";
        }
        return "fail";
    }
    
    /**
     * 删除产品类别
     * @param uid
     * @return
     * @author Liu bo
     */
    @RequestMapping("deleteCategory")
    @ResponseBody
    public String deleteCategory(String uid) {
        if (DataUtils.isUid(uid)) {
            int productCount = getService().getProductService().getProductByUCategoryId(uid);
            if (productCount > 0)
                return "have";
            else {
                int count = getService().getCategoryService().delete(uid);
                if (count > 0)
                    return "success";
                else
                    return "fail";
            }
        }
        return "fail";
    }
    
    @RequestMapping("deleteMaterial")
    @ResponseBody
    public String deleteMaterial(String uid) {
        if (DataUtils.isUid(uid)) {
            int productMaterialCount = getService().getProductMaterialService().getProductMaterialByUMaterialId(uid);
            if (productMaterialCount > 0)
                return "have";
            else {
                int count = getService().getProductMaterialService().deleteProductMaterial(uid);
                if (count > 0) {
                    return "success";
                } else
                    return "fail";
            }
        }
        return "fail";
    }
    
}
