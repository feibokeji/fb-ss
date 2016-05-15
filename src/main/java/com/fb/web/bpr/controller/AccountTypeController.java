package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TAccountType;
import com.fb.domain.vo.Combobox;
import com.fb.web.SimpController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 账务类型管理
 * @since 2016年4月18日 下午7:20:51
 * @author Liu bo
 */
@Controller
@RequestMapping("/bpr/lovelysnow")
public class AccountTypeController extends SimpController {
    
    /**
     * 页面
     * @param map
     * @return
     * @author Liu bo
     */
    @RequestMapping("accountType")
    public String lsAccountType(ModelMap map) {
        return customPage();
    }
    
    /**
     * 获取财务类型JSON数据
     * @return
     * @author Liu bo
     */
    @RequestMapping("getAccountTypeJSON")
    @ResponseBody
    public JSONObject getAccountTypeJSON() {
        List<TAccountType> list = getService().getAccountTypeService().getAccountTypeList();
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        JSONObject json = JSONObject.fromObject(map);
        return json;
    }
    
    /**
     * 获取财务类型JSON数据
     * @return
     * @author Liu bo
     */
    @RequestMapping("getAccountTypeJSONArray")
    @ResponseBody
    public JSONArray getAccountTypeJSONArray(String ctype){
        List<Combobox> boxList = getService().getAccountTypeService().getCombobox(ctype);
        return JSONArray.fromObject(boxList);
    }
    
    /**
     * 新增财务类型数据
     * @param accountType
     * @return
     * @author Liu bo
     */
    @RequestMapping("addAccountType")
    @ResponseBody
    public String addAccountType(TAccountType accountType) {
        if (accountType != null) {
            accountType.setUid(DataUtils.newUUID());
            int count = getService().getAccountTypeService().addAccountType(accountType);
            if (count > 0) {
                addOperateLog("新增", "t_account_type", accountType.getUid(), null, null, null, "新增财务类型数据成功");
                return "success";
            } else
                return "fail";
        }
        return "fail";
    }
    
    /**
     * 修改财务类型数据
     * @param accountType
     * @return
     * @author Liu bo
     */
    @RequestMapping("modifyAccountType")
    @ResponseBody
    public String modifyAccountType(TAccountType accountType) {
        if (accountType != null) {
            int count = getService().getAccountTypeService().updateAccountType(accountType);
            if (count > 0) {
                addOperateLog("修改", "t_account_type", accountType.getUid(), null, null, null, "修改财务类型数据成功");
                return "success";
            } else
                return "fail";
        }
        return "fail";
    }
    
    /**
     * 删除财务类型数据
     * @param uid
     * @return
     * @author Liu bo
     */
    @RequestMapping("deleteAccountType")
    @ResponseBody
    public String deleteAccountType(String uid) {
        if (DataUtils.isUid(uid)) {
            int count = getService().getAccountOrderService().getAccountOrderByType(uid);
            if (count > 0)
                return "have";
            else {
                int res = getService().getAccountTypeService().deleteAccountType(uid);
                if (res > 0)
                    return "success";
                else
                    return "fail";
            }
        }
        return "fail";
    }
}
