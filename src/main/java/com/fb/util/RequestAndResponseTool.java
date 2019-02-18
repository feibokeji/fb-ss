package com.fb.util;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年1月30日 下午4:21:35
 */
public class RequestAndResponseTool {
    public static Page sendRequestAndGetResponse(String url){
        Page page = null;
        //1、生成HttpClient对象并设置参数
        HttpClient httpClient = new HttpClient();
        //设置http连接超时5S
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
        //2、生成GetMethod对象并设置参数
        GetMethod getMethod = new GetMethod(url);
        //设置Get请求超时5S
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        //设置请求重试处理
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        //3、执行HTTP GET请求
        try{
            int statusCode = httpClient.executeMethod(getMethod);
            //判断访问状态
            if(statusCode != HttpStatus.SC_OK){
                System.err.println("Method failed:" + getMethod.getStatusCode());
            }
            //4、处理HTTP响应内容
            byte[] responseBody = getMethod.getResponseBody();
            String contentType = getMethod.getResponseHeader("Content-Type").getValue();
            page = new Page(responseBody,url,contentType);
        }catch(HttpException e){
            //发生致命的异常，可能是协议不对或者返回的内容有问题
            System.out.println("Please check your provided http address!");
            e.printStackTrace();
        }catch(IOException e){
            //发生网络异常
            e.printStackTrace();
        }finally {
            //释放连接
            getMethod.releaseConnection();
        }
        return page;
    }
}
