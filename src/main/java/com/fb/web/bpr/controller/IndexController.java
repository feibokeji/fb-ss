package com.fb.web.bpr.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fb.domain.po.TModule;
import com.fb.util.PoiExcel2k3Helper;
import com.fb.util.PoiExcel2k7Helper;
import com.fb.util.PoiExcelHelper;
import com.fb.web.SimpController;
import com.fb.web.exception.PoiErrorException;

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
    public String uploadExcel(MultipartFile excelFrontDeskSalesProduct, String uploadTime) throws PoiErrorException {
        // 存储上传结果
        StringBuilder strExcel = new StringBuilder();
        System.out.println(uploadTime);
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
                        PoiExcelHelper helper = getPoiExcelHelper(path + "\\" + fileName);
                        List<String> sheetNameList = helper.getSheetList(path + "\\" + fileName);
                        for (int k = 0; k < sheetNameList.size(); k++) {
                            ArrayList<ArrayList<String>> dataList = helper.readExcel(path + "\\" + fileName, k);
                        }
                        strExcel.append("读取成功！");
                    } catch (Exception e) {
                        strExcel.append("上传的文件不符合规范!请重新查看修改后再进行上传。");
                        e.printStackTrace();
                        throw new PoiErrorException("上传的文件不符合规范!");
                    }
                    /*
                     * if (dist.exists()) { dist.delete(); }
                     */
                }
            }
        }
        return strExcel.toString();
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
}
