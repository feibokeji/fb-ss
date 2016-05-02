package com.fb.web.exception;

import com.fb.core.exception.FbException;

/**
 * POI操作EXCEL文件异常处理
 * @since 2016年4月29日 上午9:41:21
 * @author Liu bo
 */
public class PoiErrorException extends FbException {
    
    
    /**
     * 
     */
    private static final long serialVersionUID = 8353900951074871691L;
    
    public PoiErrorException() {
        super("EXCEL文件操作错误!");
    }
    
    public PoiErrorException(String message) {
        super(message);
    }
}
