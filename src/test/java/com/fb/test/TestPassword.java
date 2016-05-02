package com.fb.test;
import org.junit.Test;

import com.fb.core.utils.DataUtils;
import com.fb.core.utils.EncryptionUtils;


public class TestPassword {
    
    @Test
    public void test() {
        System.out.println(EncryptionUtils.MD5("123456"));
        System.out.println(DataUtils.newUUID());
    }
}
