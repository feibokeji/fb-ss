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
import com.fb.domain.po.TCounterParts;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月22日 上午10:27:21 
* 类说明:同行信息操作控制
*/
@Controller
@RequestMapping("/bpr/counterParts")
public class CounterPartsController extends SimpController {
	
	/**
	 * 打开：同行信息列表
	 * @return
	 */
	@RequestMapping("list")
	public String list()
	{
		return customPage();
	}
	
	/**
	 * 打开 同行信息选择页面
	 * @return
	 * @author Liu Bo
	 */
	@RequestMapping("choose")
	public String choose(){
	    return customPage();
	}
	
	/**
	 * 获取：同行信息json数据
	 * @param counterParts
	 * @return
	 */
	@RequestMapping("getCounterPartsJSON")
	@ResponseBody
	public String getCounterPartsJSON(TCounterParts counterParts)
	{
		counterParts.setUdeptid(getSessionContainer().getDept().getUid());
		List<TCounterParts> list = getService().getCounterPartsService().getCounterPartsList(counterParts);
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 打开：新增同行信息页面
	 * @return
	 */
	@RequestMapping("add")
	public String add()
	{
		return customPage();
	}
	
	/**
	 * 新增：同行信息
	 * @param counterParts
	 * @return
	 */
	@RequestMapping("addSave")
	@ResponseBody
	public String addSave(TCounterParts counterParts)
	{
		counterParts.setUid(DataUtils.newUUID());
		counterParts.setUuserid(getSessionContainer().getUser().getUid());
		counterParts.setUdeptid(getSessionContainer().getDept().getUid());
		Date date = new Date();
		counterParts.setDrecorddate(date);
		counterParts.setDupdatedate(date);
		int count = getService().getCounterPartsService().addCounterParts(counterParts);
		if(count > 0)
		{
			addOperateLog("新增", "t_counterparts", counterParts.getUid(), null, null, null, "新增同行信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 打开：修改同行信息页面
	 * @param uid
	 * @param map
	 * @return
	 */
	@RequestMapping("modify")
	public String modify(String uid,ModelMap map)
	{
		map.put("counterParts", getService().getCounterPartsService().getCounterParts(uid));
		return customPage();
	}
	
	/**
	 * 保存：修改的同行信息
	 * @param counterParts
	 * @return
	 */
	@RequestMapping("modifySave")
	@ResponseBody
	public String modifySave(TCounterParts counterParts)
	{
		counterParts.setDrecorddate(FormatUtils.toDateTime(counterParts.getDrecorddateStr()));
		counterParts.setDupdatedate(new Date());
		int count = getService().getCounterPartsService().modifyCounterParts(counterParts);
		if(count > 0)
		{
			addOperateLog("修改", "t_counterparts", counterParts.getUid(), null, null, null, "修改同行信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 删除：同行信息
	 * @param uid
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(String uid)
	{
		int phoneNumber = getService().getCounterPartsService().getPhoneBusinessNumber(uid);
		if(phoneNumber > 0)
			return "此同行已产生业务！不能删除。";
		else
		{
			int count = getService().getCounterPartsService().deleteCounterParts(uid);
			if(count > 0)
			{
				addOperateLog("删除", "t_counterparts", uid, null, null, null, "删除同行信息成功！");
				return "success";
			}
		}
		return "fail";
	}
}
