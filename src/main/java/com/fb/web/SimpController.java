package com.fb.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.fb.core.utils.ConstantUtils;
import com.fb.core.utils.DataUtils;
import com.fb.domain.po.TOperateLog;
import com.fb.domain.vo.RoleContainer;
import com.fb.domain.vo.SessionContainer;
import com.fb.service.ServiceContainer;
import com.fb.util.Util;
import com.fb.web.base.BaseController;

public class SimpController extends BaseController {
    
    @Autowired
    private ServiceContainer service;
    
    protected final static int BUFFER_SIZE = 16 * 1024;
    
    protected final static String SessionContainer_Key = ConstantUtils.getConstant("session_container_key");
    
    protected final static String RoleContainer_Key = ConstantUtils.getConstant("role_container_key");
    
    protected final static String ExcelFrontDeskSalesProduct = ConstantUtils.getConstant("excel_front_desk_sales_product");
    
    protected final static String CRAWLER = ConstantUtils.getConstant("crawler");
    
    protected static final int DEFAULT_PAGESIZE = Integer.parseInt(Util.strNull(ConstantUtils.getConstant("default_pagesize")).isEmpty() ? "20" : ConstantUtils.getConstant("default_pagesize"));
    
    protected Logger logger = Logger.getLogger(ConstantUtils.getConstant("log4j.name.service"));
    
    protected ServiceContainer getService() {
        return service;
    }
    
    protected SessionContainer getSessionContainer() {
        return (SessionContainer) getSession().getAttribute(SessionContainer_Key);
    }
    
    protected RoleContainer getRoleContainer() {
        return (RoleContainer) getSession().getAttribute(RoleContainer_Key);
    }
    
    /**
     * 文件上传方法
     * @param f
     * @param fFileName
     * @return 文件名
     * @author Liu Bo
     */
    protected void copy(MultipartFile src, File dist) throws Exception {
        try {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new BufferedInputStream(src.getInputStream(), BUFFER_SIZE);
                out = new BufferedOutputStream(new FileOutputStream(dist), BUFFER_SIZE);
                byte[] buf = new byte[BUFFER_SIZE];
                while (in.read(buf) > 0) {
                    out.write(buf);
                }
                out.close();
                in.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) in.close();
                if (out != null) out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
    
    /**
     * 新增操作日志
     * @param ctype 操作类型
     * @param clinktable 关联数据表
     * @param ulinktableid 关联数据表主键
     * @param cstatus 状态
     * @param cchoice 操作选项
     * @param ccancel 取消标志
     * @param cmemo 日志说明
     * @author Liu bo
     */
    protected void addOperateLog(String ctype, String clinktable, String ulinktableid, String cstatus, String cchoice, String ccancel, String cmemo) {
        TOperateLog operateLog = new TOperateLog();
        operateLog.setUid(DataUtils.newUUID());
        operateLog.setCtype(ctype);
        operateLog.setDoperatetime(new Date());
        operateLog.setUuserid(getSessionContainer().getUser().getUid());
        String ip = "";
        String[] temp = {getRequest().getHeader("x-forwarded-for"), getRequest().getHeader("Proxy-Client-IP"), getRequest().getHeader("WL-Proxy-Client-IP"), getRequest().getRemoteAddr()};
        for (int i = 0; i < temp.length; i++) {
            if (!"".equals(DataUtils.defaultString(temp[i])) && !"unknown".equalsIgnoreCase(temp[i])) {
                ip += temp[i] + "|";
            }
        }
        operateLog.setCoperateip(ip);
        operateLog.setCoperateurl(getRequest().getRequestURI().toString());
        operateLog.setClinktable(clinktable);
        operateLog.setUlinktableid(ulinktableid);
        operateLog.setCstatus(cstatus);
        operateLog.setCchoice(cchoice);
        operateLog.setCcancel(ccancel);
        operateLog.setCmemo(cmemo);
        getService().getOperateLogService().addOperateLog(operateLog);
    }
    
    /**
     * 创建操作日志对象
     * @param ctype 操作类型
     * @param clinktable 关联数据表
     * @param ulinktableid 关联数据表主键
     * @param cstatus 状态
     * @param cchoice 操作选项
     * @param ccancel 取消标志
     * @param cmemo 日志说明
     * @author Liu bo
     */
    protected TOperateLog createOperateLog() {
        TOperateLog operateLog = new TOperateLog();
        operateLog.setUid(DataUtils.newUUID());
        operateLog.setDoperatetime(new Date());
        operateLog.setUuserid(getSessionContainer().getUser().getUid());
        String ip = "";
        String[] temp = {getRequest().getHeader("x-forwarded-for"), getRequest().getHeader("Proxy-Client-IP"), getRequest().getHeader("WL-Proxy-Client-IP"), getRequest().getRemoteAddr()};
        for (int i = 0; i < temp.length; i++) {
            if (!"".equals(DataUtils.defaultString(temp[i])) && !"unknown".equalsIgnoreCase(temp[i])) {
                ip += temp[i] + "|";
            }
        }
        operateLog.setCoperateip(ip);
        operateLog.setCoperateurl(getRequest().getRequestURI().toString());
        return operateLog;
    }
    
    /**
     * 获取 当前IP地址
     * @return
     * @author Liu bo
     */
    protected String getIP(){
        String ip = "";
        String[] temp = {getRequest().getHeader("x-forwarded-for"), getRequest().getHeader("Proxy-Client-IP"), getRequest().getHeader("WL-Proxy-Client-IP"), getRequest().getRemoteAddr()};
        for (int i = 0; i < temp.length; i++) {
            if (!"".equals(DataUtils.defaultString(temp[i])) && !"unknown".equalsIgnoreCase(temp[i])) {
                ip += temp[i] + "|";
            }
        }
        return ip;
    }
    
    /**
     * 获取 当前访问路径
     * @return
     * @author Liu bo
     */
    protected String getURL(){
        return getRequest().getRequestURI().toString();
    }
}
