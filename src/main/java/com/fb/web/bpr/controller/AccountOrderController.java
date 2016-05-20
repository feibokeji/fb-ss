package com.fb.web.bpr.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TAccount;
import com.fb.domain.po.TAccountOrder;
import com.fb.domain.po.TAccountOrderDetail;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

/**
 * 财务单据
 * <li>只开发:新增/删除/审核/反审核功能
 * @since 2016年5月15日 下午5:05:12
 * @author Liu bo
 */
@Controller
@RequestMapping("/bpr/lovelysnow")
public class AccountOrderController extends SimpController {
    
    /**
     * 财务单据页面
     * @return
     * @author Liu bo
     */
    @RequestMapping("accountOrder")
    public String accountOrder(String ctype, ModelMap map) {
        map.put("ctype", ctype);
        map.put("user", getSessionContainer().getUser());
        return customPage();
    }
    
    /**
     * 根据类别获取单据
     * @param ctype
     * @return
     * @author Liu bo
     */
    @RequestMapping("getAccountOrder")
    @ResponseBody
    public String getAccountOrder(String ctype) {
        TAccountOrder accountOrder = new TAccountOrder();
        accountOrder.setCtype(ctype);
        List<TAccountOrder> list = new ArrayList<TAccountOrder>();
        if (getSessionContainer().getRole().getCname().equals("系统管理员")) {
            list = getService().getAccountOrderService().getAccountOrderList(accountOrder);
        } else {
            List<TAccount> accountList = getService().getAccountService().getAccountListByUUserId(getSessionContainer().getUser().getUid());
            for (TAccount item : accountList) {
                accountOrder.setUaccountid(item.getUid());
                List<TAccountOrder> n = getService().getAccountOrderService().getAccountOrderList(accountOrder);
                for(TAccountOrder ao : n){
                    list.add(ao);
                }
            }
        }
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
    }
    
    /**
     * 获取单据详细
     * @param uid
     * @return
     * @author Liu bo
     */
    @RequestMapping("getAccountOrderDetail")
    @ResponseBody
    public TAccountOrder getAccountOrderDetail(String uid) {
        TAccountOrder accountOrder = getService().getAccountOrderService().getAccountOrder(uid);
        List<TAccountOrderDetail> detailList = getService().getAccountOrderDetailService().getAccountOrderDetailByUAccountOrderId(uid);
        accountOrder.setAccountOrderDetailList(detailList);
        return accountOrder;
    }
    
    /**
     * 新增财务单据
     * @param accountOrder
     * @return
     * @author Liu bo
     */
    @RequestMapping("addAccountOrder")
    @ResponseBody
    public String addAccountOrder(TAccountOrder accountOrder) {
        accountOrder.setUid(DataUtils.newUUID());
        accountOrder.setUcorpid(getSessionContainer().getCorp().getUid());
        accountOrder.setUdeptid(getSessionContainer().getDept().getUid());
        accountOrder.setUuserid(getSessionContainer().getUser().getUid());
        Date date = new Date();
        accountOrder.setDcreatetime(date);
        accountOrder.setDupdatetime(date);
        int count = getService().getAccountOrderService().addAccountOrder(accountOrder);
        if (count > 0) {
            this.addOperateLog("新增", "t_account_order", accountOrder.getUid(), null, null, null, "新增财务单据成功!");
            return "success";
        }
        return "fail";
    }
    
    /**
     * 删除财务单据
     * @param uid
     * @return
     * @author Liu bo
     */
    @RequestMapping("deleteAccountOrder")
    @ResponseBody
    public String deleteAccountOrder(String uid) {
        int count = 0;
        count = count + getService().getAccountOrderDetailService().deleteAccountOrderDetailByUAccountOrderId(uid);
        count = count + getService().getAccountOrderService().deleteAccountOrder(uid);
        if (count > 0) {
            this.addOperateLog("删除", "t_account_order", uid, null, null, null, "删除财务单据成功!");
            return "success";
        }
        return "fail";
    }
    
    /**
     * 审核/反审核财务单据
     * @param uid 单据主键
     * @param iaudit 审核标志
     * @return
     * @author Liu bo
     */
    @RequestMapping("auditAccountOrder")
    @ResponseBody
    public String auditAccountOrder(String uid, int iaudit) {
        int count = getService().getAccountOrderService().auditAccountOrder(uid, iaudit);
        if (count > 0) {
            this.addOperateLog("审核", "t_account_order", uid, null, null, null, "审核/反审核财务单据成功!");
            return "success";
        }
        return "fail";
    }
    
}
