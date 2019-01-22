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
import com.fb.domain.po.TCustomer;
import com.fb.domain.po.TCustomerType;
import com.fb.web.SimpController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月17日 下午5:01:50 
* 类说明:
* 客户管理控制类
*/
@Controller
@RequestMapping("/bpr/customer")
public class CustomerController extends SimpController {
	
	@RequestMapping("list")
	public String list()
	{
		return customPage();
	}
	
	/**
	 * 获取：客户类型JSON
	 * @return
	 */
	@RequestMapping("getCustomerTypeJSON")
	@ResponseBody
	public String getCustomerTypeJSON()
	{
		List<TCustomerType> list = getService().getCustomerTypeService().getCustomerTypeList();
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 获取：客户类型下拉框JSON
	 * @return
	 */
	@RequestMapping("getCustomerTypeComboBoxJSON")
	@ResponseBody
	public JSONArray getCustomerTypeComboBoxJSON()
	{
		List<TCustomerType> list = getService().getCustomerTypeService().getCustomerTypeList();
		return JSONArray.fromObject(list);
	}
	
	/**
	 * 打开：新增客户类型信息页面
	 * @return
	 */
	@RequestMapping("addCustomerType")
	public String addCustomerType()
	{
		return customPage();
	}
	
	/**
	 * 新增保存：客户类型信息
	 * @param customerType
	 * @return
	 */
	@RequestMapping("addCustomerTypeSave")
	@ResponseBody
	public String addCustomerTypeSave(TCustomerType customerType)
	{
		customerType.setUid(DataUtils.newUUID());
		int count = getService().getCustomerTypeService().addCustomerType(customerType);
		if(count > 0)
		{
			addOperateLog("新增", "t_customer_type", customerType.getUid(), null, null, null, "新增客户类型信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 打开：修改客户类型信息页面
	 * @param uid
	 * @return
	 */
	@RequestMapping("modifyCustomerType")
	public String modifyCustomerType(String uid,ModelMap map)
	{
		map.put("customerType", getService().getCustomerTypeService().getCustomerType(uid));
		return customPage();
	}
	
	/**
	 * 修改保存：客户类型信息
	 * @param customerType
	 * @return
	 */
	@RequestMapping("modifyCustomerTypeSave")
	@ResponseBody
	public String modifyCustomerTypeSave(TCustomerType customerType)
	{
		int count = getService().getCustomerTypeService().modifyCustomerType(customerType);
		if(count > 0)
		{
			addOperateLog("修改", "t_customer_type", customerType.getUid(), null, null, null, "修改客户类型信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 删除：客户类型信息
	 * @param uid
	 * @return
	 */
	@RequestMapping("deleteCustomerType")
	@ResponseBody
	public String deleteCustomerType(String uid)
	{
		int customerNumber = getService().getCustomerTypeService().getCustomerNumber(uid);
		if(customerNumber > 0)
			return "此客户类型已产生客户信息！不能删除";
		else
		{
			int count = getService().getCustomerTypeService().deleteCustomerType(uid);
			if(count > 0)
			{
				addOperateLog("删除", "t_customer_type", uid, null, null, null, "删除客户类型信息成功！");
				return "success";
			}
		}
		return "fail";
	}
	
	/**
	 * 获取：客户信息JSON
	 * @param customer
	 * @return
	 */
	@RequestMapping("getCustomerJSON")
	@ResponseBody
	public String getCustomerJSON(TCustomer customer)
	{
		customer.setUdeptid(getSessionContainer().getDept().getUid());
		List<TCustomer> list = getService().getCustomerService().getCustomerList(customer);
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 打开：新增客户信息页面
	 * @return
	 */
	@RequestMapping("addCustomer")
	public String addCustomer()
	{
		return customPage();
	}
	
	/**
	 * 保存：新增客户信息
	 * @param customer
	 * @return
	 */
	@RequestMapping("addCustomerSave")
	@ResponseBody
	public String addCustomerSave(TCustomer customer)
	{
		customer.setUid(DataUtils.newUUID());
		customer.setUuserid(getSessionContainer().getUser().getUid());
		customer.setUdeptid(getSessionContainer().getDept().getUid());
		customer.setDrecorddate(new Date());
		customer.setDupdatedate(new Date());
		int count = getService().getCustomerService().addCustomer(customer);
		if(count > 0)
		{
			addOperateLog("新增", "t_customer", customer.getUid(), null, null, null, "新增客户信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 打开：修改客户信息页面
	 * @param uid
	 * @param map
	 * @return
	 */
	@RequestMapping("modifyCustomer")
	public String modifyCustomer(String uid,ModelMap map)
	{
		map.put("customer", getService().getCustomerService().getCustomer(uid));
		return customPage();
	}
	
	/**
	 * 保存：修改客户信息保存
	 * @param customer
	 * @return
	 */
	@RequestMapping("modifyCustomerSave")
	@ResponseBody
	public String modifyCustomerSave(TCustomer customer)
	{
		customer.setDrecorddate(FormatUtils.toDateTime(customer.getDrecorddateStr()));
		customer.setDupdatedate(new Date());
		int count = getService().getCustomerService().modifyCustomer(customer);
		if(count > 0)
		{
			addOperateLog("修改", "t_customer", customer.getUid(), null, null, null, "修改客户信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 删除：客户信息
	 * @param uid
	 * @return
	 */
	@RequestMapping("deleteCustomer")
	@ResponseBody
	public String deleteCustomer(String uid)
	{
		int customerBusinessNumber = getService().getCustomerService().getCustomerBusinessNumber(uid);
		if(customerBusinessNumber > 0)
			return "此客户已产生业务！不能删除。";
		else
		{
			int count = getService().getCustomerService().deleteCustomer(uid);
			if(count > 0)
			{
				addOperateLog("删除", "t_customer", uid, null, null, null, "删除客户信息成功！");
				return "success";
			}
		}
		return "fail";
	}
}
