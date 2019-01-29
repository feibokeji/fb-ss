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
}
