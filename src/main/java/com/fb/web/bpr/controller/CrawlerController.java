package com.fb.web.bpr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fb.util.Crawler;
import com.fb.web.SimpController;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年1月29日 下午8:00:45
 * 网络爬虫控制器
 */
@Controller
@RequestMapping("/bpr/crawler")
public class CrawlerController extends SimpController {
    
    /**
     * 抓取
     * @return
     * @author Liu bo
     */
    @RequestMapping("capture")
    @ResponseBody
    public String capture(){
        String path = this.getSession().getServletContext().getRealPath(CRAWLER);
        Crawler crawler = new Crawler();
        crawler.setDirPath(path);
        crawler.crawling(new String[]{"https://www.mi.com/"});
        return null;
    }
}
