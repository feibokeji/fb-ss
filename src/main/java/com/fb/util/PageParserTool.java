package com.fb.util;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年1月30日 下午4:51:11
 * 根据选择器来选取元素、属性
 */
public class PageParserTool {
    
    /**
     * 通过选择器来选取页面
     * @param page
     * @param cssSelector
     * @return
     * @author Liu bo
     */
    public static Elements select(Page page,String cssSelector){
        return page.getDoc().select(cssSelector);
    }
    
    /**
     * 通过css选择器来得到指定元素
     * @param page
     * @param cssSelector
     * @param index
     * @return
     * @author Liu bo
     */
    public static Element select(Page page,String cssSelector,int index){
        Elements eles = select(page,cssSelector);
        int realIndex = index;
        if(index < 0){
            realIndex = eles.size() + index;
        }
        return eles.get(realIndex);
    }
    
    /**
     * 获取满足选择器的元素中的连接 选择器cssSelector必须定位到具体的超链接
     * 例如：我们想抽取id为content的div中的所有超链接，这里就要将
     * cssSelector定义为div[id=content] a
     * 放入set中放置重复
     * @param page
     * @param cssSelector
     * @return
     * @author Liu bo
     */
    public static Set<String> getLinks(Page page,String cssSelector){
        Set<String> links = new HashSet<String>();
        Elements es = select(page,cssSelector);
        Iterator iterator = es.iterator();
        while(iterator.hasNext()){
            Element element = (Element)iterator.next();
            if(element.hasAttr("href"))
                links.add(element.attr("abs:href"));
            else if(element.hasAttr("src"))
                links.add(element.attr("abs:src"));
        }
        return links;
    }
    
    /**
     * 获取网页中满足指定css选择器的所有元素的指定属性的集合
     * 例如：通过getAttrs("img[src]","abs:src");可获取网页中所有图片的链接
     * @param page
     * @param cssSelector
     * @param attrName
     * @return
     * @author Liu bo
     */
    public static ArrayList<String> getAttrs(Page page,String cssSelector,String attrName){
        ArrayList<String> result = new ArrayList<String>();
        Elements eles = select(page,cssSelector);
        for(Element ele : eles){
            if(ele.hasAttr(attrName)){
                result.add(ele.attr(attrName));
            }
        }
        return result;
    }
}
