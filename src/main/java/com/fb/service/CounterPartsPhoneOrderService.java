package com.fb.service;

import java.util.List;

import com.fb.domain.po.TCounterPartsPhoneOrder;
import com.fb.domain.po.TUser;

/**
 * @author 作者：Liu Bo
 * @version 创建时间：2019年2月23日 下午1:19:56
 * 同行手机单据服务接口
 */
public interface CounterPartsPhoneOrderService {
    
    /**
     * 新增 同行手机单据
     * @param order
     * @return
     * @author Liu bo
     */
    public int addPhoneOrder(TCounterPartsPhoneOrder order);
    
    /**
     * 删除 同行手机单据
     * @param uid
     * @return
     * @author Liu bo
     */
    public int delPhoneOrder(String uid);
    
    /**
     * 修改 同行手机单据
     * @param order
     * @return
     * @author Liu bo
     */
    public int modPhoneOrder(TCounterPartsPhoneOrder order);
    
    /**
     * 修改 同行手机单据状态
     * @param uid
     * @param istatus {@value 0 = 未审核}{@value 1 = 已审核}
     * @return
     * @author Liu bo
     */
    public int modPhoneOrderStatus(String uid,Integer istatus);
    
    /**
     * 获取 同行手机单据信息
     * @param uid
     * @return
     * @author Liu Bo
     */
    public TCounterPartsPhoneOrder getPhoneOrder(String uid);
    
    /**
     * 获取 同行手机单据信息集合
     * @param order
     * @return
     * @author Liu Bo
     */
    public List<TCounterPartsPhoneOrder> getPhoneOrder(TCounterPartsPhoneOrder order);
    
    /**
     * 执行 同行手机调出业务
     * @param ucounterpartsid 同行表外键
     * @param imei 手机串号
     * @param user 当前用户
     * @param ip 当前ip
     * @param url 当前地址
     * @return
     * @author Liu Bo
     */
    public boolean executePhoneOut(String ucounterpartsid,String imei,TUser user,String ip,String url);
}
