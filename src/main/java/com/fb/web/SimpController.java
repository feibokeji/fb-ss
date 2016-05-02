package com.fb.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.fb.core.utils.ConstantUtils;
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
    
    protected static final int DEFAULT_PAGESIZE = Integer.parseInt(Util.strNull(ConstantUtils.getConstant("default_pagesize")).isEmpty() ? "20" : ConstantUtils.getConstant("default_pagesize"));
    
    protected Logger logger = Logger.getLogger(ConstantUtils.getConstant("log4j.name.service"));
    
    protected ServiceContainer getService() {
        return service;
    }
    
    protected SessionContainer getSessionContainer() {
        return (SessionContainer) getSession().getAttribute(SessionContainer_Key);
    }
    
    protected RoleContainer getRoleContainer(){
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
}
