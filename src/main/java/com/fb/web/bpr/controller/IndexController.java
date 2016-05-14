package com.fb.web.bpr.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.FormatUtils;
import com.fb.domain.po.TModule;
import com.fb.domain.po.TOrder;
import com.fb.domain.po.TOrderProduct;
import com.fb.util.PoiExcel2k3Helper;
import com.fb.util.PoiExcel2k7Helper;
import com.fb.util.PoiExcelHelper;
import com.fb.web.SimpController;
import com.fb.web.exception.PoiErrorException;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/bpr")
public class IndexController extends SimpController {
    
    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.put("sessionContainer", getSessionContainer());
        List<TModule> listModule = getService().getLoginService().loadingModule(getRoleContainer());
        map.put("listModule", listModule);
        return customPage();
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return redirect("/bpr/index");
    }
    
    @RequestMapping("/home")
    public String home(ModelMap map) {
        return customPage();
    }
    
    /**
     * 上传：当天前台销售按商品汇总.XLS文件处理
     * @param excelFrontDeskSalesProduct
     * @return
     * @throws Exception
     * @author Liu bo
     */
    @RequestMapping("uploadExcel")
    @ResponseBody
    public JSONObject uploadExcel(MultipartFile excelFrontDeskSalesProduct, String uploadTime) throws PoiErrorException {
        // 存储上传结果
        Map<String, String> result = new HashMap<String, String>();
        // 验证是否为空
        if (excelFrontDeskSalesProduct != null && !excelFrontDeskSalesProduct.isEmpty()) {
            String fileName = excelFrontDeskSalesProduct.getOriginalFilename();
            String path = this.getSession().getServletContext().getRealPath(ExcelFrontDeskSalesProduct);
            File dir = new File(path);
            if (!dir.exists()) dir.mkdirs();
            if (fileName.matches("^.*\\.(?:xls|XLS|xlsx)$")) {
                if (excelFrontDeskSalesProduct.getSize() < 10000 * 1024) {
                    // 创建文件并生成文件
                    File dist = new File(dir, fileName);
                    try {
                        this.copy(excelFrontDeskSalesProduct, dist);
                        // 开始读取文件
                        String filePath = path + "\\" + fileName;
                        PoiExcelHelper helper = getPoiExcelHelper(filePath);
                        // 此系统暂且只支持读取一页的EXCEL文档
                        ArrayList<ArrayList<String>> dataList = helper.readExcel(filePath, 0);
                        String[] columnName = {"序号", "类别", "商品编码", "商品名称", "销售数量", "销售金额", "退货数量", "退货金额", "赠送数量", "赠送金额", "数量小计", "金额小计", "参考进价", "进价金额", "参考利润", "当前主供应商", "品牌"};
                        if (dataList.size() > 0) {
                            Map<String, List<TOrderProduct>> map = validationReadExcel(dataList, columnName);
                            for (String key : map.keySet()) {
                                if (DataUtils.isNullOrEmpty(key)) {
                                    TOrder order = new TOrder();
                                    order.setDordertime(FormatUtils.toDate(uploadTime));
                                    order.setOrderProductDetailList(map.get(key));
                                    boolean ok = getService().getOrderService().addOrderProduct(order, getSessionContainer().getUser(), this.createOperateLog());
                                    if(ok){
                                        result.put("success", printBody(map.get(key), columnName));
                                    }else{
                                        result.put("fail", "excel文件上传失败,请联系管理员!");
                                    }
                                } else {
                                    result.put("fail", key);
                                }
                            }
                        } else {
                            result.put("fail", "请不要上传空白文档!");
                        }
                    } catch (Exception e) {
                        result.put("fail", "上传的文件不符合规范!请重新查看修改后再进行上传.");
                        e.printStackTrace();
                        throw new PoiErrorException("上传的文件不符合规范！");
                    }
                }
            }
        }
        JSONObject object = JSONObject.fromObject(result);
        return object;
    }
    
    // 获取Excel处理类
    private static PoiExcelHelper getPoiExcelHelper(String filePath) {
        PoiExcelHelper helper;
        if (filePath.indexOf(".xlsx") != -1) {
            helper = new PoiExcel2k7Helper();
        } else {
            helper = new PoiExcel2k3Helper();
        }
        return helper;
    }
    
    /**
     * 验证读取上传的文件内容
     * @param dataList
     * @return
     * @author Liu bo
     */
    private Map<String, List<TOrderProduct>> validationReadExcel(ArrayList<ArrayList<String>> dataList, String[] columnName) {
        Map<String, List<TOrderProduct>> map = new HashMap<String, List<TOrderProduct>>();
        StringBuilder result = new StringBuilder();
        List<TOrderProduct> list = new ArrayList<TOrderProduct>();
        try {
            if (dataList.get(0) != null) {// 获取第一行数据验证表头
                if (dataList.get(0).size() < columnName.length) {
                    result.append("上传的文档不是正确的【前台销售按商品汇总】文件!<br/>");
                } else {
                    if (DataUtils.isNullOrEmpty(result.toString())) {// 详细判断
                        int i = 0;// 验证数据正确性时的列数
                        int j = 0;// 读取数据时的列数
                        for (ArrayList<String> data : dataList) {
                            if (i == 0) {// 验证第一行表头的准确性
                                for (int a = 1; a <= columnName.length; a++) {
                                    if (DataUtils.isNullOrEmpty(data.get(a).trim()) || !data.get(a).trim().equals(columnName[a - 1])) {
                                        result.append("[第1行]的[第" + (a + 1) + "列]存在问题!必须为：" + columnName[a - 1] + "<br/>");
                                    }
                                }
                            } else if (i != 0 && i != (dataList.size() - 1)) {// 验证文档中的数据
                                if (DataUtils.isNullOrEmpty(result.toString())) {
                                    for (int a = 1; a <= columnName.length; a++) {
                                        // 找出所有单元数据中的空单元<不包含类别列>
                                        if (a != 2 && DataUtils.isNullOrEmpty(data.get(a).trim())) {
                                            result.append("[序号:" + i + "]的[" + columnName[a - 1] + "]存在问题,不能为空!<br/>");
                                        } else if (a != 2 && !DataUtils.isNullOrEmpty(data.get(a).trim())) {// 找出所有单元数据中的不为空单元<不包含类别列>
                                            // 验证所有数据单元的有效性
                                            if (a == 1) {// 验证[序号]是否正确<只能为正整数>
                                                if (!DataUtils.isUInteger(data.get(a).trim())) {
                                                    result.append("[序号:" + i + "]的[" + columnName[a - 1] + "]存在问题,不是正整数!<br/>");
                                                }
                                            }
                                            if (a >= 5 && a <= 15) {// 验证["销售数量", "销售金额", "退货数量", "退货金额", "赠送数量", "赠送金额", "数量小计", "金额小计", "参考进价", "进价金额", "参考利润"]列数据正确性
                                                if (!DataUtils.isUFloat(data.get(a).trim())) {
                                                    result.append("[序号:" + i + "]的[" + columnName[a - 1] + "]存在问题,不是正小数!<br/>");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            i++;
                        }
                        // 开始读取正确数据
                        if (DataUtils.isNullOrEmpty(result.toString())) {
                            String _category = "";// 记录类别
                            for (ArrayList<String> data : dataList) {
                                if (j != 0 && j != (dataList.size() - 1)) {
                                    TOrderProduct excel = new TOrderProduct();
                                    excel.setIsort(DataUtils.toInteger(data.get(1).trim()));
                                    if (DataUtils.isNullOrEmpty(data.get(2).trim())) {// 类别列为空
                                        if (DataUtils.isNullOrEmpty(_category)) {// 记录类别也为空
                                            result.append("[序号:" + j + "]的[" + columnName[2] + "]存在问题,不能为空!<br/>");
                                        }
                                    } else {// 类别列不为空
                                        _category = data.get(2).trim();
                                    }
                                    excel.setCcategoryname(_category);
                                    excel.setCproductno(data.get(3).trim());
                                    excel.setCproductname(data.get(4).trim());
                                    excel.setNsqty(DataUtils.toDouble(data.get(5).trim()));
                                    excel.setNsamount(DataUtils.toDouble(data.get(6).trim()));
                                    excel.setNbqty(DataUtils.toDouble(data.get(7).trim()));
                                    excel.setNbamount(DataUtils.toDouble(data.get(8).trim()));
                                    excel.setNgqty(DataUtils.toDouble(data.get(9).trim()));
                                    excel.setNgamount(DataUtils.toDouble(data.get(10).trim()));
                                    excel.setNqtysubtotal(DataUtils.toDouble(data.get(11).trim()));
                                    excel.setNamountsubtotal(DataUtils.toDouble(data.get(12).trim()));
                                    excel.setNreferenceprice(DataUtils.toDouble(data.get(13).trim()));
                                    excel.setNpurchaseprice(DataUtils.toDouble(data.get(14).trim()));
                                    excel.setNreferenceprofits(DataUtils.toDouble(data.get(15).trim()));
                                    excel.setCmainsupplier(data.get(16).trim());
                                    excel.setCbrand(data.get(17).trim());
                                    list.add(excel);
                                }
                                j++;
                            }
                        }
                    }
                }
            } else {
                result.append("上传的文档不是正确的【前台销售按商品汇总】文件!<br/>");
            }
            map.put(result.toString(), list);
        } catch (Exception e) {
        
        }
        return map;
    }
    
    /**
     * 打印Excel内容
     * @param list
     * @param columnName
     * @return
     * @author Liu bo
     */
    private static String printBody(List<TOrderProduct> list, String[] columnName) {
        StringBuilder strExcel = new StringBuilder("<table class=\"listTable\">");
        strExcel.append("<tr>");
        for (String header : columnName) {
            strExcel.append("<th>");
            strExcel.append(header);
            strExcel.append("</th>");
        }
        strExcel.append("</tr>");
        for (TOrderProduct item : list) {
            strExcel.append("<tr>");
            
            strExcel.append("<td>");
            strExcel.append(item.getIsort());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getCcategoryname());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getCproductno());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getCproductname());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getNsqty());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getNsamount());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getNbqty());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getNbamount());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getNgqty());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getNgamount());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getNqtysubtotal());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getNamountsubtotal());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getNreferenceprice());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getNpurchaseprice());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getNreferenceprofits());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getCmainsupplier());
            strExcel.append("</td>");
            
            strExcel.append("<td>");
            strExcel.append(item.getCbrand());
            strExcel.append("</td>");
            
            strExcel.append("</tr>");
        }
        strExcel.append("</table>");
        return strExcel.toString();
    }
}
