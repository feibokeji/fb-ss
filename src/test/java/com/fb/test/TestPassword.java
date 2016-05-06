package com.fb.test;
import java.util.Date;

import org.junit.Test;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.EncryptionUtils;
import com.fb.core.utils.FormatUtils;


public class TestPassword {
    
    @Test
    public void test() {
        System.out.println(EncryptionUtils.MD5("123456"));
        System.out.println(DataUtils.newUUID());
        String cno = FormatUtils.formatDate(new Date(), "yyyyMMddHHmmss");
        int i = (int)(1+Math.random()*(10-1+1));
        System.out.println(cno);
        System.out.println(i);
    }
}
