package com.fb.web.bpr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TBrand;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月22日 下午5:51:52 
* 类说明:品牌信息操作控制器
*/
@Controller
@RequestMapping("/bpr/brand")
public class BrandController extends SimpController {
	
	/**
	 * 打开：品牌信息列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String list()
	{
		return customPage();
	}
	
	/**
	 * 获取：品牌信息JSON数据
	 * @param brand
	 * @return
	 */
	@RequestMapping("getBrandJSON")
	@ResponseBody
	public String getBrandJSON(TBrand brand)
	{
		List<TBrand> list = getService().getBrandService().getBrandList(brand);
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 打开：品牌信息新增页面
	 * @return
	 */
	@RequestMapping("add")
	public String add()
	{
		return customPage();
	}
	
	/**
	 * 新增保存
	 * @param brand
	 * @return
	 */
	@RequestMapping("addSave")
	@ResponseBody
	public String addSave(TBrand brand)
	{
		brand.setUid(DataUtils.newUUID());
		brand.setIsort(0);
		int count = getService().getBrandService().addBrand(brand);
		if(count > 0)
		{
			addOperateLog("新增", "t_brand", brand.getUid(), null, null, null, "新增品牌信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 打开：品牌信息修改页面
	 * @param uid
	 * @param map
	 * @return
	 */
	@RequestMapping("modify")
	public String modify(String uid,ModelMap map)
	{
		map.put("brand", getService().getBrandService().getBrand(uid));
		return customPage();
	}
	
	/**
	 * 修改保存
	 * @param brand
	 * @return
	 */
	@RequestMapping("modifySave")
	@ResponseBody
	public String modifySave(TBrand brand)
	{
		int count = getService().getBrandService().modifyBrand(brand);
		if(count > 0)
		{
			addOperateLog("修改", "t_brand", brand.getUid(), null, null, null, "修改品牌信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 删除品牌信息
	 * @param uid
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(String uid)
	{
		int phoneBusinessNumber = getService().getBrandService().getPhoneBusinessNumber(uid);
		int otherBusinessNumber = getService().getBrandService().getOtherBusinessNumber(uid);
		if(phoneBusinessNumber + otherBusinessNumber > 0)
			return "此品牌已产生业务！不能删除。";
		else
		{
			int count = getService().getBrandService().deleteBrand(uid);
			if(count > 0)
			{
				addOperateLog("删除", "t_brand", uid, null, null, null, "删除品牌信息成功！");
				return "success";
			}
		}
		return "fail";
	}
}
