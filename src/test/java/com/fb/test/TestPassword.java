package com.fb.test;
import java.util.Date;

import org.junit.Test;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.EncryptionUtils;
import com.fb.core.utils.FormatUtils;


public class TestPassword {
    
    @Test
    public void test() {
    	System.out.println("---密码测试---");
        System.out.println(EncryptionUtils.MD5("123"));
        System.out.println("---end---");
        /*System.out.println(DataUtils.newUUID());*/
        String cno = FormatUtils.formatDate(new Date(), "yyyy-MM-dd-HH-mm-ss");
        //int i = (int)(1+Math.random()*(20-1+1));
        System.out.println(cno);
        /*System.out.println(i);*/
        
        String[] c_k = {"0","00","000","0000","00000","000000","0000000","00000000","000000000","0000000000"};
        int max = 5;
        String c_no = c_k[max-String.valueOf(12).length()] + FormatUtils.formatDate(new Date(), "yyMMdd") + String.valueOf(12);
        String c_no1 = c_k[max-String.valueOf(122).length()] + FormatUtils.formatDate(new Date(), "yyMMdd") + String.valueOf(122);
        System.out.println(c_no);
        System.out.println(c_no1);
        
        
    }
}
