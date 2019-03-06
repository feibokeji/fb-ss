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
import com.fb.domain.po.TOtherGoods;
import com.fb.domain.po.TOtherGoodsPriceRecord;
import com.fb.web.SimpController;

import net.sf.json.JSONObject;

/** 
* @author 作者: LIUBO 
* @version 创建时间：2019年1月23日 下午5:04:56 
* 类说明:其它商品信息控制器
*/
@Controller
@RequestMapping("/bpr/otherGoods")
public class OtherGoodsController extends SimpController {
	
	/**
	 * 打开：其它商品信息列表页面
	 * @return
	 */
	@RequestMapping("list")
	public String list()
	{
		return customPage();
	}
	
	/**
	 * 打开：其他商品选择页面
	 * @return
	 * @author Liu bo
	 */
	@RequestMapping("choose")
	public String choose(){
	    return customPage();
	}
	
	/**
	 * 获取：其它商品信息JSON数据
	 * @param otherGoods
	 * @return
	 */
	@RequestMapping("getOtherGoodsJSON")
	@ResponseBody
	public String getOtherGoodsJSON(TOtherGoods otherGoods)
	{
		List<TOtherGoods> list = getService().getOtherGoodsService().getOtherGoodsList(otherGoods);
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
     * 获取：其它商品信息库存JSON数据
     * @param otherGoods
     * @return
     */
    @RequestMapping("getOtherGoodsInventoryJSON")
    @ResponseBody
	public String getOtherGoodsInventoryJSON(TOtherGoods otherGoods){
	    List<TOtherGoods> list = getService().getOtherGoodsService().getInventory(otherGoods);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 获取：其它商品信息价格记录JSON数据
	 * @param otherGoods
	 * @return
	 */
	@RequestMapping("getOtherGoodsPriceRecordJSON")
	@ResponseBody
	public String getOtherGoodsPriceRecordJSON(String uothergoodsid) {
		List<TOtherGoodsPriceRecord> list = getService().getOtherGoodsService().getListByUOtherGoodsId(uothergoodsid);
		Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("Rows", list);
        map.put("Total", list.size());
        return JSONObject.fromObject(map).toString();
	}
	
	/**
	 * 打开：其它商品信息新增页面
	 * @return
	 */
	@RequestMapping("add")
	public String add() {
		return customPage();
	}
	
	/**
	 * 保存：新增其它商品信息
	 * @param otherGoods
	 * @return
	 */
	@RequestMapping("addSave")
	@ResponseBody
	public String addSave(TOtherGoods otherGoods) {
		otherGoods.setUid(DataUtils.newUUID());
		otherGoods.setUuserid(getSessionContainer().getUser().getUid());
		otherGoods.setUdeptid(getSessionContainer().getDept().getUid());
		Date date = new Date();
		otherGoods.setDrecorddate(date);
		otherGoods.setDupdatedate(date);
		int count = getService().getOtherGoodsService().addOtherGoods(otherGoods);
		if(count > 0) {
			addOperateLog("新增", "t_other_goods", otherGoods.getUid(), null, null, null, "新增其它商品信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 打开：修改其它商品信息页面
	 * @param uid
	 * @param map
	 * @return
	 */
	@RequestMapping("modify")
	public String modify(String uid,ModelMap map)
	{
		map.put("otherGoods", getService().getOtherGoodsService().getOtherGoods(uid));
		return customPage();
	}
	
	/**
	 * 保存：修改其它商品信息
	 * @param otherGoods
	 * @return
	 */
	@RequestMapping("modifySave")
	@ResponseBody
	public String modifySave(TOtherGoods otherGoods)
	{
		otherGoods.setDrecorddate(FormatUtils.toDateTime(otherGoods.getDrecorddateStr()));
		otherGoods.setDupdatedate(new Date());
		int count = getService().getOtherGoodsService().modifyOtherGoods(otherGoods);
		if(count > 0) {
			addOperateLog("修改", "t_other_goods", otherGoods.getUid(), null, null, null, "修改其它商品信息成功！");
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 删除：其它商品信息
	 * @param uid
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(String uid)
	{
		int businessNumber = getService().getOtherGoodsService().getBusinessNumber(uid);
		if(businessNumber > 0) {
			return "此商品信息已产生业务！不能删除。";
		}else {
			int count = getService().getOtherGoodsService().deleteOtherGoods(uid);
			if(count > 0) {
				addOperateLog("删除", "t_other_goods", uid, null, null, null, "删除其它商品信息成功！");
				return "success";
			}
		}
		return "fail";
	}
}
