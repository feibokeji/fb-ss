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
import com.fb.domain.po.TModule;
import com.fb.domain.vo.ExcelProductSell;
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
                        if (dataList.size() > 0) {
                            Map<String, List<ExcelProductSell>> map = validationExcel(dataList);
                            for (String key : map.keySet()) {
                                System.out.println(key);
                                System.out.println("************************************************");
                                if (DataUtils.isNullOrEmpty(key)) {} else {
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
     * 验证上传的文件内容
     * @param dataList
     * @return
     * @author Liu bo
     */
    private Map<String, List<ExcelProductSell>> validationExcel(ArrayList<ArrayList<String>> dataList) {
        Map<String, List<ExcelProductSell>> map = new HashMap<String, List<ExcelProductSell>>();
        StringBuilder result = new StringBuilder();
        List<ExcelProductSell> list = new ArrayList<ExcelProductSell>();
        String[] columnName = {"序号", "类别", "商品编码", "商品名称", "销售数量", "销售金额", "退货数量", "退货金额", "赠送数量", "赠送金额", "数量小计", "金额小计", "参考进价", "进价金额", "参考利润", "当前主供应商", "品牌"};
        try {
            if (dataList.get(0) != null) {// 获取第一行数据验证表头
                if (dataList.get(0).size() < columnName.length) {
                    result.append("上传的文档不是正确的【前台销售按商品汇总】文件!<br/>");
                } else {
                    if (DataUtils.isNullOrEmpty(result.toString())) {// 详细判断
                        int i = 0;
                        for (ArrayList<String> data : dataList) {
                            if (i == 0) {
                                for (int a = 1; a <= columnName.length; a++) {
                                    if (DataUtils.isNullOrEmpty(data.get(a).trim()) || !data.get(a).trim().equals(columnName[a - 1])) {
                                        result.append("[第1行]的[第" + (a + 1) + "列]存在问题!必须为：" + columnName[a - 1] + "<br/>");
                                    }
                                }
                            } else {
                                // 验证文档中的数据
                                for (int a = 1; a <= columnName.length; a++) {
                                    if (i != (dataList.size() - 1) && a != 2 && DataUtils.isNullOrEmpty(data.get(a).trim())) {
                                        result.append("[序号:" + i + "]的[" + columnName[a - 1] + "]存在问题,不能为空!<br/>");
                                    } else {
                                        
                                    }
                                }
                            }
                            i++;
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
}
