package com.fb.web.bpr.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.FormatUtils;
import com.fb.domain.po.TSupplier;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月15日 下午7:05:40 
* 类说明:
* 供应商信息操作控制 
*/
@Controller
@RequestMapping("/bpr/supplier")
public class SupplierController extends SimpController {
	
	@RequestMapping("list")
    public String list(ModelMap map) {
        map.put("user", getSessionContainer().getUser());
        return customPage();
    }
	
	@RequestMapping("getSupplierJSON")
	@ResponseBody
	public String getSupplierJSON(TSupplier supplier)
	{
		List<TSupplier> list = getService().getSupplierService().getSupplierList(supplier);
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	@RequestMapping("add")
	public String add()
	{
		return customPage();
	}
	
	@RequestMapping("addSave")
	@ResponseBody
	public String addSave(TSupplier supplier)
	{
		supplier.setUid(DataUtils.newUUID());
		supplier.setUuserid(getSessionContainer().getUser().getUid());
		supplier.setUdeptid(getSessionContainer().getDept().getUid());
		supplier.setDrecorddate(new Date());
		supplier.setDupdatedate(new Date());
		int count = getService().getSupplierService().addSupplier(supplier);
		if(count > 0) {
			this.addOperateLog("新增", "t_supplier", supplier.getUid(), null, null, null, "新增供应商信息成功！");
			return "success";
		}
		return "fail";
	}
	
	@RequestMapping("modify")
	public String modify(String uid,ModelMap map)
	{
		map.put("supplier", getService().getSupplierService().getSupplier(uid));
		return customPage();
	}
	
	@RequestMapping("modifySave")
	@ResponseBody
	public String modifySave(TSupplier supplier)
	{
		supplier.setDrecorddate(FormatUtils.toDateTime(supplier.getDrecorddateStr()));
		supplier.setDupdatedate(new Date());
		int count = getService().getSupplierService().modifySupplier(supplier);
		if(count > 0) {
			this.addOperateLog("修改", "t_supplier", supplier.getUid(), null, null, null, "修改供应商信息成功！");
			return "success";
		}
		return "fail";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(String uid)
	{
		int businessNumber = getService().getSupplierService().getSupplierBusinessNumber(uid);
		if(businessNumber > 0) return "此供应商已产生业务！不能删除。";
		else
		{
			int count = getService().getSupplierService().deleteSupplier(uid);
			if(count == 0) return "fail";
		}
		this.addOperateLog("修改", "t_supplier", uid, null, null, null, "删除供应商信息成功！");
		return "success";
	}
}
