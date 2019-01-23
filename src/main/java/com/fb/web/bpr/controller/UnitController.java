package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TUnit;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月22日 下午8:32:21 
* 类说明:单位信息控制器
*/
@Controller
@RequestMapping("/bpr/unit")
public class UnitController extends SimpController {
	
	/**
	 * 打开：单位信息列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String list()
	{
		return customPage();
	}
	
	/**
	 * 获取：单位信息JSON数据
	 * @return
	 */
	@RequestMapping("getUnitJSON")
	@ResponseBody
	public String getUnitJSON()
	{
		List<TUnit> list = getService().getUnitService().getUnitList();
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 打开：单位信息新增页面
	 * @return
	 */
	@RequestMapping("add")
	public String add()
	{
		return customPage();
	}
	
	/**
	 * 保存：新增单位信息
	 * @param unit
	 * @return
	 */
	@RequestMapping("addSave")
	@ResponseBody
	public String addSave(TUnit unit)
	{
		unit.setUid(DataUtils.newUUID());
		int count = getService().getUnitService().addUnit(unit);
		if(count > 0)
		{
			addOperateLog("新增", "t_unit", unit.getUid(), null, null, null, "新增单位信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 打开：单位信息修改页面
	 * @param uid
	 * @param map
	 * @return
	 */
	@RequestMapping("modify")
	public String modify(String uid,ModelMap map)
	{
		map.put("unit", getService().getUnitService().getUnit(uid));
		return customPage();
	}
	
	/**
	 * 保存：修改单位信息
	 * @param unit
	 * @return
	 */
	@RequestMapping("modifySave")
	@ResponseBody
	public String modifySave(TUnit unit)
	{
		int count = getService().getUnitService().modifyUnit(unit);
		if(count > 0)
		{
			addOperateLog("修改", "t_unit", unit.getUid(), null, null, null, "修改单位信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 删除：单位信息
	 * @param uid
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(String uid)
	{
		int useNumber = getService().getUnitService().getUseNumber(uid);
		if(useNumber > 0)
			return "此单位信息已使用！不能删除。";
		else
		{
			int count = getService().getUnitService().deleteUnit(uid);
			if(count > 0)
			{
				addOperateLog("删除", "t_unit", uid, null, null, null, "删除单位信息成功！");
				return "success";
			}
		}
		return "fail";
	}
}
