package com.fb.util;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年1月30日 下午5:11:21
 * 存储已经访问过得URL路径和待访问的URL路径
 */
public class Links {
    //已访问的URL集合 已经访问过的 主要考虑 不能再重复了
    private static Set visitedUrlSet = new HashSet();
    //待访问的URL集合
    private static LinkedList unVisitedUrlQueue = new LinkedList();
    /**
     * 获取已访问的URL数目
     * @return
     * @author Liu bo
     */
    public static int getVisitedUrlNum(){
        return visitedUrlSet.size();
    }
    /**
     * 添加到访问过的URL
     * @param url
     * @author Liu bo
     */
    public static void addVisitedUrlSet(String url){
        visitedUrlSet.add(url);
    }
    /**
     * 移除访问过得URL
     * @param url
     * @author Liu bo
     */
    public static void removeVisitedUrlSet(String url){
        visitedUrlSet.remove(url);
    }
    /**
     * 获得待访问的URL集合
     * @return
     * @author Liu bo
     */
    public static LinkedList getUnVisitedUrlQueue(){
        return unVisitedUrlQueue;
    }
    /**
     * 添加到待访问的集合中
     * @param url
     * @author Liu bo
     */
    public static void addUnVisitedUrlQueue(String url){
        if(url != null && !url.trim().equals("") && !visitedUrlSet.contains(url) && !unVisitedUrlQueue.contains(url)){
            unVisitedUrlQueue.add(url);
        }
    }
    /**
     * 删除待访问的url
     * @return
     * @author Liu bo
     */
    public static Object removeHeadofUnVisitedUrlQueue(){
        return unVisitedUrlQueue.removeFirst();
    }
    /**
     * 判断未访问的URL列队是否为空
     * @return
     * @author Liu bo
     */
    public static boolean unVisitedUrlQueueIsEmpty(){
        return unVisitedUrlQueue.isEmpty();
    }
}
