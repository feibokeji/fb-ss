package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TColor;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 上午11:15:20 
* 类说明:颜色服务控制器
*/
@Controller
@RequestMapping("/bpr/color")
public class ColorController extends SimpController {
	
	/**
	 * 打开：颜色信息列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String list()
	{
		return customPage();
	}
	
	/**
	 * 获取：颜色信息JSON数据
	 * @return
	 */
	@RequestMapping("getColorJSON")
	@ResponseBody
	public String getColorJSON()
	{
		List<TColor> list = getService().getColorService().getColorList();
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 打开：颜色信息新增页面
	 * @return
	 */
	@RequestMapping("add")
	public String add()
	{
		return customPage();
	}
	
	/**
	 * 保存：颜色信息新增
	 * @param color
	 * @return
	 */
	@RequestMapping("addSave")
	@ResponseBody
	public String addSave(TColor color)
	{
		color.setUid(DataUtils.newUUID());
		int count = getService().getColorService().addColor(color);
		if(count > 0)
		{
			addOperateLog("新增", "t_color", color.getUid(), null, null, null, "新增颜色信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 打开：颜色信息修改页面
	 * @param uid
	 * @param map
	 * @return
	 */
	@RequestMapping("modify")
	public String modify(String uid,ModelMap map)
	{
		map.put("color", getService().getColorService().getColor(uid));
		return customPage();
	}
	
	/**
	 * 保存：颜色信息修改
	 * @param color
	 * @return
	 */
	@RequestMapping("modifySave")
	@ResponseBody
	public String modifySave(TColor color)
	{
		int count = getService().getColorService().modifyColor(color);
		if(count > 0)
		{
			addOperateLog("修改", "t_color", color.getUid(), null, null, null, "修改颜色信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 删除：颜色信息
	 * @param uid
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(String uid)
	{
		int useNumber = getService().getColorService().getColorUseNumber(uid);
		if(useNumber > 0)
			return "此颜色已被使用！不能删除。";
		else
		{
			int count = getService().getColorService().deleteColor(uid);
			if(count > 0)
			{
				addOperateLog("删除", "t_color", uid, null, null, null, "删除颜色信息成功！");
				return "success";
			}
		}
		return "fail";
	}
}
