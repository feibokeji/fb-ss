package com.fb.web.bpr.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.FormatUtils;
import com.fb.domain.po.TCategory;
import com.fb.domain.po.TMaterial;
import com.fb.domain.po.TOrder;
import com.fb.domain.po.TOrderMaterial;
import com.fb.domain.po.TProduct;
import com.fb.domain.vo.Tree;
import com.fb.web.SimpController;

import net.sf.json.JSONArray;
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
     * 打开产品页面
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("product")
    public String product(ModelMap map) {
        return customPage();
    }
    
    /**
     * 物料采购
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("procurement")
    public String procurement(String type, String uid, ModelMap map) {
        map.put("user", getRoleContainer().getUser());
        map.put("type", type);
        TOrder order = new TOrder();
        List<TOrderMaterial> orderMaterialList = new ArrayList<TOrderMaterial>();
        if (!DataUtils.isNullOrEmpty(type) && DataUtils.isUid(uid)) {
            order = getService().getOrderService().getOrder(uid);
            orderMaterialList = getService().getOrderMaterialService().getOrderMaterialList(uid);
        }
        map.put("order", order);
        map.put("orderMaterialList", orderMaterialList);
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
        map.put("Total", list.size());
        JSONObject _jsonObject = JSONObject.fromObject(map);
        return _jsonObject.toString();
    }
    
    @RequestMapping("listMaterialByUProductId")
    @ResponseBody
    public String listMaterialByUProductId(String uproductid) {
        List<TMaterial> list = getService().getMaterialService().getMaterialByUProductId(uproductid);
        for (TMaterial item : list) {
            item.setUproductid(uproductid);
        }
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        JSONObject _jsonObject = JSONObject.fromObject(map);
        return _jsonObject.toString();
    }
    
    @RequestMapping("saveProductMaterial")
    @ResponseBody
    public String saveProductMaterial(String uproductid, String umaterialids) {
        boolean result = getService().getProductMaterialService().saveProductMaterial(uproductid, umaterialids);
        if (result) return "success";
        return "fail";
    }
    
    /**
     * 获取产品分页数据
     * @return
     * @author Liu bo
     */
    @RequestMapping("listProduct")
    @ResponseBody
    public String listProduct() {
        List<TProduct> list = getService().getProductService().getProductList();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
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
            if (count > 0) {
                addOperateLog("新增", "t_category", category.getUid(), null, null, null, "新增产品类别数据成功");
                return "success";
            } else
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
                addOperateLog("新增", "t_material", material.getUid(), null, null, null, "新增物料数据成功");
                return "success";
            } else
                return "fail";
        }
        return "fail";
    }
    
    /**
     * 新增产品信息
     * @param product
     * @return
     * @author Liu bo
     */
    @RequestMapping("addProduct")
    @ResponseBody
    public String addProduct(TProduct product) {
        if (product != null) {
            product.setUid(DataUtils.newUUID());
            int count = getService().getProductService().addProduct(product);
            if (count > 0) {
                addOperateLog("新增", "t_product", product.getUid(), null, null, null, "新增产品数据成功");
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
            if (count > 0) {
                addOperateLog("修改", "t_category", category.getUid(), null, null, null, "修改产品类别数据成功");
                return "success";
            } else
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
                addOperateLog("修改", "t_material", material.getUid(), null, null, null, "修改物料数据成功");
                return "success";
            } else
                return "fail";
        }
        return "fail";
    }
    
    /**
     * 修改产品信息
     * @param product
     * @return
     * @author Liu bo
     */
    @RequestMapping("modifyProduct")
    @ResponseBody
    public String modifyProduct(TProduct product) {
        if (product != null) {
            int count = getService().getProductService().updateProduct(product);
            if (count > 0) {
                addOperateLog("修改", "t_product", product.getUid(), null, null, null, "修改产品信息成功");
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
                if (count > 0) {
                    addOperateLog("删除", "t_category", uid, null, null, null, "删除类别数据成功");
                    return "success";
                } else
                    return "fail";
            }
        }
        return "fail";
    }
    
    /**
     * 删除物料信息
     * @param uid
     * @return
     * @author Liu bo
     */
    @RequestMapping("deleteMaterial")
    @ResponseBody
    public String deleteMaterial(String uid) {
        if (DataUtils.isUid(uid)) {
            int productMaterialCount = getService().getProductMaterialService().getProductMaterialByUMaterialId(uid);
            if (productMaterialCount > 0)
                return "have";
            else {
                int count = getService().getMaterialService().delete(uid);
                if (count > 0) {
                    addOperateLog("删除", "t_material", uid, null, null, null, "删除物料数据成功");
                    return "success";
                } else
                    return "fail";
            }
        }
        return "fail";
    }
    
    /**
     * 删除产品信息
     * @param uid
     * @return
     * @author Liu bo
     */
    @RequestMapping("deleteProduct")
    @ResponseBody
    public String deleteProduct(String uid) {
        if (DataUtils.isUid(uid)) {
            int productMaterialCount = getService().getProductMaterialService().getProductMaterialByUMaterialId(uid);
            if (productMaterialCount > 0) {
                return "have";
            } else {// 此处需要添加验证是否有产品订单信息
                int count = getService().getProductService().deleteProduct(uid);
                if (count > 0) {
                    addOperateLog("删除", "t_product", uid, null, null, null, "删除产品信息成功");
                    return "success";
                } else {
                    return "fail";
                }
            }
        }
        return "fail";
    }
    
    /**
     * 获取物料订单分组tree
     * @return
     * @author Liu bo
     */
    @RequestMapping("getOrderMaterialGroup")
    @ResponseBody
    public String getOrderMaterialGroup(TOrder order) {
        order.setCtype("00");
        List<TOrder> list = getService().getOrderService().getOrderList(order);
        Map<String, List<TOrder>> map = new TreeMap<String, List<TOrder>>(new Comparator<String>() {
            
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for (TOrder item : list) {
            String key = FormatUtils.formatDate(item.getDordertime(), "yyyy-MM");
            if (map.get(key) == null) {
                List<TOrder> l = new ArrayList<TOrder>();
                l.add(item);
                map.put(key, l);
            } else {
                map.get(key).add(item);
            }
        }
        List<Tree> treeList = new ArrayList<Tree>();
        Iterator<Map.Entry<String, List<TOrder>>> entries = map.entrySet().iterator();
        int i = 0;
        while (entries.hasNext()) {
            Map.Entry<String, List<TOrder>> entry = entries.next();
            i++;
            Tree p = new Tree();
            p.setId(String.valueOf(i));
            p.setPid("0");
            p.setText(entry.getKey());
            treeList.add(p);
            for (TOrder item : entry.getValue()) {
                Tree e = new Tree();
                e.setId(item.getUid());
                e.setPid(p.getId());
                String audit = item.getCstatus().equals("00") ? "未审核" : "已审核";
                String color = item.getCstatus().equals("00") ? "red" : "green";
                e.setText((item.getCno() + "[<label style=\'color:" + color + "\'>" + audit + "</label>]"));
                treeList.add(e);
            }
        }
        JSONArray arry = JSONArray.fromObject(treeList);
        return arry.toString();
    }
    
    /**
     * 保存物料订单
     * @param order
     * @return
     * @author Liu bo
     */
    @RequestMapping("saveOrderMaterial")
    @ResponseBody
    public String saveOrderMaterial(TOrder order) {
        if (order != null) {
            boolean isHaveData = false;
            for (TOrderMaterial item : order.getOrderMaterialDetailList()) {
                if (DataUtils.isUid(item.getUmaterialid())) // 验证是否有数据
                    isHaveData = true;
            }
            if (isHaveData) {
                boolean result = getService().getOrderService().addOrderMaterial(order, getRoleContainer().getUser(), this.createOperateLog());
                if (result) return "success";
            } else
                return "nHave";
        }
        return "fail";
    }
    
    /**
     * 审核订单
     * @param uid 主键
     * @param cstatus 状态
     * @return
     * @author Liu bo
     */
    @RequestMapping("auditOrder")
    @ResponseBody
    public boolean auditOrder(String uid, String cstatus) {
        if (DataUtils.isUid(uid)) {
            int count = getService().getOrderService().auditOrder(uid, cstatus);
            if (count > 0) {
                this.addOperateLog("审核", "t_order", uid, cstatus, null, null, "审核/反审核成功!");
                return true;
            } else
                return false;
        }
        return false;
    }
}
