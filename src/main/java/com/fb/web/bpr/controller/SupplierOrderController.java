package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TSupplierOrder;
import com.fb.domain.po.TSupplierOrderDetail;
import com.fb.domain.po.TSupplierReceipts;
import com.fb.domain.po.TSupplierReceivable;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月28日 上午10:22:42 
* 类说明:供应商单据控制器
*/
@Controller
@RequestMapping("/bpr/supplierOrder")
public class SupplierOrderController extends SimpController {
	
	/**
	 * 打开：新增供应商单据页面
	 * @param itype
	 * {@value 0-入库单}
	 * {@value 1-退库单}
	 * {@value 2-报损单}
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public String add(int itype,ModelMap map) {
		map.put("itype", itype);
		map.put("user", getSessionContainer().getUser());
		return customPage();
	}
	
	/**
	 * 保存：新增供应商单据
	 * @param supplierOrder
	 * @return 结果
	 */
	@RequestMapping("addSave")
	@ResponseBody
	public String addSave(TSupplierOrder supplierOrder) {
		supplierOrder.setUid(DataUtils.newUUID());
		supplierOrder.setUuserid(getSessionContainer().getUser().getUid());
		supplierOrder.setUdeptid(getSessionContainer().getDept().getUid());
		boolean isHaveData = false;
		for (TSupplierOrderDetail detail : supplierOrder.getOrderDetailList()) {
			if(DataUtils.isUid(detail.getUothergoodsid()) && detail.getNquantity() != null && detail.getNprice() != null && detail.getNamount() != null) {
				isHaveData = true;
			}
		}
		if (isHaveData) {
            int count = getService().getSupplierOrderService().addSupplierOrder(supplierOrder);
            if (count > 0) {
            	addOperateLog("新增", "t_supplier_order", supplierOrder.getUid(), "成功", null, null, "新增供应商单据成功！");
            	return "success";
            }
        } else
            return "nHave";
		return "fail";
	}
	
	/**
	 * 打开：供应商单据管理页面
	 * @return
	 */
	@RequestMapping("list")
	public String list() {
		return customPage();
	}
	
	/**
	 * 获取：供应商单据集合JSON数据
	 * @param supplierOrder
	 * @return
	 */
	@RequestMapping("getSupplierOrderJSON")
	@ResponseBody
	public String getSupplierOrderJSON(TSupplierOrder supplierOrder) {
		supplierOrder.setUdeptid(getSessionContainer().getDept().getUid());
		List<TSupplierOrder> list = getService().getSupplierOrderService().getSupplierOrder(supplierOrder);
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 获取：供应商单据明细集合JSON数据
	 * @param uorderid 单据表外键
	 * @return
	 */
	@RequestMapping("getSupplierOrderDetailJSON")
	@ResponseBody
	public String getSupplierOrderDetailJSON(String uorderid) {
		List<TSupplierOrderDetail> list = getService().getSupplierOrderService().getSupplierOrderDetail(uorderid);
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 获取：供应商单据应付集合JSON数据
	 * @param uorderid 单据表外键
	 * @return
	 */
	@RequestMapping("getSupplierReceivableJSON")
	@ResponseBody
	public String getSupplierReceivableJSON(String uorderid) {
		List<TSupplierReceivable> list = getService().getSupplierOrderService().getSupplierReceivable(uorderid);
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 查看 商品单据
	 * @param uorderid
	 * @param map
	 * @return
	 * @author Liu bo
	 */
	@RequestMapping("view")
	public String view(String uorderid,ModelMap map){
	    TSupplierOrder order = getService().getSupplierOrderService().getSupplierOrder(uorderid);
	    order.setOrderDetailList(getService().getSupplierOrderService().getSupplierOrderDetail(uorderid));
	    List<TSupplierReceivable> orderReceivableList = getService().getSupplierOrderService().getSupplierReceivable(uorderid);
	    List<TSupplierReceipts> orderReceiptsList = getService().getSupplierOrderService().getSupplierOrderReceipts(uorderid);
	    map.put("order", order);
	    map.put("orderReceivableList", orderReceivableList);
	    map.put("orderReceiptsList", orderReceiptsList);
	    return customPage();
	}
	
	/**
	 * 打开：修改供应商单据信息页面
	 * @param uorderid
	 * @return
	 * @author Liu bo
	 */
	@RequestMapping("modify")
	public String modify(String uorderid,ModelMap map){
	    TSupplierOrder order = getService().getSupplierOrderService().getSupplierOrder(uorderid);
	    order.setOrderDetailList(getService().getSupplierOrderService().getSupplierOrderDetail(uorderid));
	    map.put("order", order);
	    return customPage();
	}
	
	/**
	 * 保存：修改供应商信息
	 * @param supplierOrder
	 * @return
	 * @author Liu bo
	 */
	@RequestMapping("modifySave")
	@ResponseBody
	public String modifySave(TSupplierOrder supplierOrder){
	    boolean isHaveData = false;
        for (TSupplierOrderDetail detail : supplierOrder.getOrderDetailList()) {
            if(DataUtils.isUid(detail.getUothergoodsid()) && detail.getNquantity() != null && detail.getNprice() != null && detail.getNamount() != null) {
                isHaveData = true;
            }
        }
        if (isHaveData) {
            int count = getService().getSupplierOrderService().modifySupplierOrder(supplierOrder);
            if (count > 0) {
                addOperateLog("修改", "t_supplier_order", supplierOrder.getUid(), "成功", null, null, "修改供应商单据成功！");
                return "success";
            }
        } else
            return "nHave";
	    return "fail";
	}
	
	/**
	 * 审核：供应商单据
	 * @param uid
	 * @return
	 * @author Liu bo
	 */
	@RequestMapping("audit")
	@ResponseBody
	public String audit(String uid){
	    int count = getService().getSupplierOrderService().auditSupplierOrder(uid, getSessionContainer().getUser().getUid(), getSessionContainer().getDept().getUid());
	    if(count > 0){
	        addOperateLog("审核", "t_supplier_order", uid, "成功", null, null, "审核供应商单据成功！");
	        return "success";
	    }
	    return "fail";
	}
	
	/**
	 * 反审核：供应商单据
	 * @param uid
	 * @return
	 * @author Liu bo
	 */
	@RequestMapping("unAudit")
    @ResponseBody
	public String unAudit(String uid){
	    int orderReceiptsNumber = getService().getSupplierOrderService().getSupplierReceiptsNumber(uid);
        if(orderReceiptsNumber > 0)
            return "此单据已产生收付款业务！不能反审核。";
        else{
            int count = getService().getSupplierOrderService().unAuditSupplierOrder(uid, getSessionContainer().getUser().getUid(), getSessionContainer().getDept().getUid());
            if(count > 0){
                addOperateLog("反审核", "t_supplier_order", uid, "成功", null, null, "反审核供应商单据成功！");
                return "success";
            }
        }
	    return "fail";
	}
	
	/**
	 * 删除：供应商单据
	 * @param uorderid
	 * @return
	 * @author Liu bo
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(String uid){
	    int orderReceiptsNumber = getService().getSupplierOrderService().getSupplierReceiptsNumber(uid);
	    if(orderReceiptsNumber > 0)
	        return "此单据已产生收付款业务！不能删除。";
	    else{
	        int count = getService().getSupplierOrderService().deleteSupplierOrder(uid);
	        if(count > 0){
	            addOperateLog("删除", "t_supplier_order", uid, "成功", null, null, "删除供应商单据成功！");
                return "success";
	        }
	    }
	    return "fail";
	}
}
