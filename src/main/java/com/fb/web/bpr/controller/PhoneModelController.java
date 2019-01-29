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
import com.fb.domain.po.TPhoneModel;
import com.fb.domain.po.TPhoneModelColor;
import com.fb.domain.po.TPhoneModelPriceRecord;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月25日 上午11:07:38 
* 类说明:手机类型服务控制器
*/
@Controller
@RequestMapping("/bpr/phoneModel")
public class PhoneModelController extends SimpController {

	/**
	 * 打开：手机型号列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String list() {
		return customPage();
	}
	
	/**
	 * 获取：手机型号JSON数据
	 * @param phoneModel
	 * @return
	 */
	@RequestMapping("getPhoneModelJSON")
	@ResponseBody
	public String getPhoneModelJSON(TPhoneModel phoneModel) {
		List<TPhoneModel> list = getService().getPhoneModelService().getPhoneModelList(phoneModel);
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 获取：手机型号颜色JSON数据
	 * @param uphonemodelid
	 * @return
	 */
	@RequestMapping("getPhoneModelColorJSON")
	@ResponseBody
	public String getPhoneModelColorJSON(String uphonemodelid) {
		List<TPhoneModelColor> list = getService().getPhoneModelService().getPhoneModelColorList(uphonemodelid);
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 获取：手机型号价格记录JSON数据
	 * @param uphonemodelid
	 * @return
	 */
	@RequestMapping("getPhoneModelPriceRecordJSON")
	@ResponseBody
	public String getPhoneModelPriceRecordJSON(String uphonemodelid) {
		List<TPhoneModelPriceRecord> list = getService().getPhoneModelService().getPhoneModelPriceRecordList(uphonemodelid);
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 打开：新增手机型号页面
	 * @return
	 */
	@RequestMapping("add")
	public String add() {
		return customPage();
	}
	
	/**
	 * 保存：新增手机型号信息
	 * @param phoneModel
	 * @return
	 */
	@RequestMapping("addSave")
	@ResponseBody
	public String addSave(TPhoneModel phoneModel) {
		phoneModel.setUid(DataUtils.newUUID());
		phoneModel.setUuserid(getSessionContainer().getUser().getUid());
		Date date = new Date();
		phoneModel.setDrecorddate(date);
		phoneModel.setDupdatedate(date);
		int count = getService().getPhoneModelService().addPhoneModel(phoneModel);
		if(count > 0) {
			addOperateLog("新增", "t_phone_model", phoneModel.getUid(), "成功", null, null, "新增手机型号信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 打开：修改手机型号页面
	 * @param uid
	 * @param map
	 * @return
	 */
	@RequestMapping("modify")
	public String modify(String uid,ModelMap map) {
		map.put("phoneModel", getService().getPhoneModelService().getPhoneModel(uid));
		return customPage();
	}
	
	/**
	 * 保存：修改手机型号信息
	 * @param phoneModel
	 * @return
	 */
	@RequestMapping("modifySave")
	@ResponseBody
	public String modifySave(TPhoneModel phoneModel) {
		phoneModel.setDrecorddate(FormatUtils.toDateTime(phoneModel.getDrecorddateStr()));
		phoneModel.setDupdatedate(new Date());
		phoneModel.setUuserid(getSessionContainer().getUser().getUid());
		int count = getService().getPhoneModelService().modifyPhoneModel(phoneModel);
		if(count > 0) {
			addOperateLog("修改", "t_phone_model", phoneModel.getUid(), "成功", null, null, "修改手机型号信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 删除：手机型号信息
	 * @param uid
	 * @return
	 */
	@RequestMapping("deletePhoneModel")
	@ResponseBody
	public String deletePhoneModel(String uid) {
		int useNumber = getService().getPhoneModelService().getUseNumber(uid);
		if(useNumber > 0) {
			return "此手机型号已产生业务！不能删除。";
		}else {
			int count = getService().getPhoneModelService().deletePhoneModel(uid);
			if(count > 0) {
				addOperateLog("删除", "t_phone_model", uid, "成功", null, null, "删除手机型号信息成功！");
				return "success";
			}
		}
		return "fail";
	}
	
	/**
	 * 删除：手机型号颜色信息
	 * @param uid
	 * @return
	 */
	@RequestMapping("deletePhoneModelColor")
	@ResponseBody
	public String deletePhoneModelColor(String uid) {
		TPhoneModelColor phoneModelColor = getService().getPhoneModelService().getPhoneModelColor(uid);
		int useNumber = getService().getPhoneModelService().getPhoneModelColorUseNumber(phoneModelColor.getUphonemodelid(), phoneModelColor.getUcolorid());
		if(useNumber > 0) {
			return "此手机型号颜色已产生业务！不能删除。";
		}else {
			int count = getService().getPhoneModelService().deletePhoneModelColor(uid);
			if(count > 0) {
				addOperateLog("删除", "t_phone_model_color", uid, "成功", null, null, "删除手机型号颜色信息成功！");
				return "success";
			}
		}
		return "fail";
	}
}
