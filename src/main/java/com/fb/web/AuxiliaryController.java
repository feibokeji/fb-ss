package com.fb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auxiliary")
public class AuxiliaryController extends SimpController {
    
    /**
     * 全局检查编码的合法性
     * @param table 表名
     * @param column 列名
     * @param code 编码
     * @return 检查结果
     * @author Liu bo
     */
    @RequestMapping("/checkDataRepeat")
    @ResponseBody
    public String checkDataRepeat(String table, String column, String value) {
        return getService().getAuxiliaryService().checkDataRepeat(table, column, value).toString();
    }
    
}
