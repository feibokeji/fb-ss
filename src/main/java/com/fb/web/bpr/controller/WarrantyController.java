package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TWarranty;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 上午11:16:09 
* 类说明:保修政策控制器
*/
@Controller
@RequestMapping("/bpr/warranty")
public class WarrantyController extends SimpController {
	
	/**
	 * 打开：保修政策列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String list()
	{
		return customPage();
	}
	
	/**
	 * 获取：保修政策JSON数据
	 * @return
	 */
	@RequestMapping("getWarrantyJSON")
	@ResponseBody
	public String getWarrantyJSON()
	{
		List<TWarranty> list = getService().getWarrantyService().getWarrantyList();
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 打开：保修政策新增页面
	 * @return
	 */
	@RequestMapping("add")
	public String add()
	{
		return customPage();
	}
	
	/**
	 * 保存：保修政策新增
	 * @param warranty
	 * @return
	 */
	@RequestMapping("addSave")
	@ResponseBody
	public String addSave(TWarranty warranty)
	{
		warranty.setUid(DataUtils.newUUID());
		int count = getService().getWarrantyService().addWarranty(warranty);
		if(count > 0)
		{
			addOperateLog("新增", "t_warranty", warranty.getUid(), null, null, null, "新增保修政策信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 打开：保修政策修改页面
	 * @param uid
	 * @param map
	 * @return
	 */
	@RequestMapping("modify")
	public String modify(String uid,ModelMap map)
	{
		map.put("warranty", getService().getWarrantyService().getWarranty(uid));
		return customPage();
	}
	
	/**
	 * 保存：保修政策修改
	 * @param warranty
	 * @return
	 */
	@RequestMapping("modifySave")
	@ResponseBody
	public String modifySave(TWarranty warranty)
	{
		int count = getService().getWarrantyService().modifyWarranty(warranty);
		if(count > 0)
		{
			addOperateLog("修改", "t_warranty", warranty.getUid(), null, null, null, "修改保修政策信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 删除：保修政策
	 * @param uid
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(String uid)
	{
		int useNumber = getService().getWarrantyService().getWarrantyUseNumber(uid);
		if(useNumber > 0)
			return "此保修政策已被使用！不能删除。";
		else
		{
			int count = getService().getWarrantyService().deleteWarranty(uid);
			if(count > 0)
			{
				addOperateLog("删除", "t_warranty", uid, null, null, null, "删除保修政策信息成功！");
				return "success";
			}
		}
		return "fail";
	}
}
