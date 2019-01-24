package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TPaymentMethod;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 上午11:15:43 
* 类说明:付款方式控制器
*/
@Controller
@RequestMapping("/bpr/paymentMethod")
public class PaymentMethodController extends SimpController {
	
	/**
	 * 打开：付款方式列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String list()
	{
		return customPage();
	}
	
	/**
	 * 获取：付款方式JSON数据
	 * @return
	 */
	@RequestMapping("getPaymentMethodJSON")
	@ResponseBody
	public String getPaymentMethodJSON()
	{
		List<TPaymentMethod> list = getService().getPaymentMethodService().getPaymentMethodList();
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 打开：付款方式新增页面
	 * @return
	 */
	@RequestMapping("add")
	public String add()
	{
		return customPage();
	}
	
	/**
	 * 保存：付款方式新增
	 * @param paymentMethod
	 * @return
	 */
	@RequestMapping("addSave")
	@ResponseBody
	public String addSave(TPaymentMethod paymentMethod)
	{
		paymentMethod.setUid(DataUtils.newUUID());
		int count = getService().getPaymentMethodService().addPaymentMethod(paymentMethod);
		if(count > 0)
		{
			addOperateLog("新增", "t_payment_method", paymentMethod.getUid(), null, null, null, "新增付款方式信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 打开：付款方式修改页面
	 * @param uid
	 * @param map
	 * @return
	 */
	@RequestMapping("modify")
	public String modify(String uid,ModelMap map)
	{
		map.put("paymentMethod", getService().getPaymentMethodService().getPaymentMethod(uid));
		return customPage();
	}
	
	/**
	 * 保存：付款方式修改
	 * @param paymentMethod
	 * @return
	 */
	@RequestMapping("modifySave")
	@ResponseBody
	public String modifySave(TPaymentMethod paymentMethod)
	{
		int count = getService().getPaymentMethodService().modifyPaymentMethod(paymentMethod);
		if(count > 0)
		{
			addOperateLog("修改", "t_payment_method", paymentMethod.getUid(), null, null, null, "修改付款方式信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 删除：付款方式
	 * @param uid
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(String uid)
	{
		int useNumber = getService().getPaymentMethodService().getPaymentMethodUseNumber(uid);
		if(useNumber > 0)
			return "此付款方式已被使用！不能删除。";
		else
		{
			int count = getService().getPaymentMethodService().deletePaymentMethod(uid);
			if(count > 0)
			{
				addOperateLog("删除", "t_payment_method", uid, null, null, null, "删除付款方式信息成功！");
				return "success";
			}
		}
		return "fail";
	}
}
