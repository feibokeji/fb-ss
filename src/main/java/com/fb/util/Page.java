package com.fb.util;

import java.io.UnsupportedEncodingException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年1月30日 上午10:49:56
 * 保存获取到的响应的相关内容
 */
public class Page {
    private byte[] content;
    /**
     * 网页源码字符串
     */
    private String html;
    /**
     * 网页Dom文档
     */
    private Document doc;
    /**
     * 字符编码
     */
    private String charset;
    /**
     * url路径
     */
    private String url;
    /**
     * 内容类型
     */
    private String contentType;
    
    public Page(byte[] content,String url,String contentType){
        this.content = content;
        this.url = url;
        this.contentType = contentType;
    }
    
    public byte[] getContent() {
        return content;
    }
    
    
    public void setContent(byte[] content) {
        this.content = content;
    }
    
    /**
     * 返回网页的源码字符串
     * @return 网页源码
     * @author Liu bo
     */
    public String getHtml() {
        if(html != null)
            return html;
        if(content == null)
            return null;
        if(charset == null)
            charset = CharsetDetector.guessEncoding(content);
        try{
            this.html = new String(content,charset);
            return html;
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }
    }
    
    
    public void setHtml(String html) {
        this.html = html;
    }
    
    
    public Document getDoc() {
        if(doc != null)
            return doc;
        try{
            this.doc = Jsoup.parse(getHtml(),url);
            return doc;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    
    public void setDoc(Document doc) {
        this.doc = doc;
    }
    
    
    public String getCharset() {
        return charset;
    }
    
    
    public void setCharset(String charset) {
        this.charset = charset;
    }
    
    
    public String getUrl() {
        return url;
    }
    
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    
    public String getContentType() {
        return contentType;
    }
    
    
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
}
