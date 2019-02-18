package com.fb.util;
import com.fb.util.Links;
import com.fb.util.Page;
import com.fb.util.PageParserTool;
import com.fb.util.RequestAndResponseTool;
import com.fb.util.FileTool;
import org.jsoup.select.Elements;
/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年1月30日 下午7:39:31
 */
public class Crawler {
    private String dirPath;
    /**
     * 使用种子初始化URL列队
     * @param seeds
     * @author Liu bo
     */
    private void initCrawlerWithSeeds(String[] seeds){
        for(int i = 0; i < seeds.length; i++)
            Links.addUnVisitedUrlQueue(seeds[i]);
    }
    public void setDirPath(String path){
        dirPath = path;
    }
    public void crawling(String[] seeds){
        //初始化URL列队
        initCrawlerWithSeeds(seeds);
        //循环条件：待抓取的链接不空且抓取的网页不多于2000
        while(!Links.unVisitedUrlQueueIsEmpty() && Links.getVisitedUrlNum() <= 2000){
            //先从待访问的序列中取出第一个
            String visitUrl = (String)Links.removeHeadofUnVisitedUrlQueue();
            if(visitUrl == null)
                continue;
            //根据URL得到Page
            Page page = RequestAndResponseTool.sendRequestAndGetResponse(visitUrl);
            //对page进行处理：访问DOM的某个标签
            Elements es = PageParserTool.select(page, "p.price");
            if(!es.isEmpty()){
                System.out.println("下面将打印所有p标签：");
                System.out.println(es);
                System.out.println(es.size());
                for(int i = 0; i < 10; i++){
                    System.out.println(es.get(i).text());
                }
            }
            Elements goodsEs = PageParserTool.select(page, "div.title");
            if(!goodsEs.isEmpty()){
                System.out.println("下面将打印所有div标签");
                System.out.println(goodsEs);
                System.out.println(goodsEs.size());
                for(int i = 0; i < 10; i++){
                    System.out.println(goodsEs.get(i).text());
                }
            }
            //保存文件
            FileTool.setDirPath(dirPath);
            FileTool.saveToLocal(page);
            //将已经访问过的链接放入已访问的链接中
            Links.addVisitedUrlSet(visitUrl);
        }
    }
}
