package com.fb.test;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.fb.core.utils.DataUtils;

public class Test {
    
    @org.junit.Test
    public void testCon() {
        /*System.out.println("开始测试连接...");
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            System.out.println("00000000000000000000000000");
            String url = "jdbc:jtds:sqlserver://127.0.0.1:1433/fb-ss";
            String username = "sa";
            String password = "sa";
            System.out.println("000000001111110000000");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("--------------------------");
            Statement st = conn.createStatement();
            ResultSet set = st.executeQuery("select * from t_user");
            while (set.next()) {
                System.out.println(set.getString(0));
            }
            set.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }*/
        /*System.out.println(DataUtils.isInteger("-1"));
        System.out.println(DataUtils.isUInteger("-1"));
        System.out.println((new BigDecimal(1.161876832844575)).setScale(0, BigDecimal.ROUND_UP).doubleValue());*/
        
        System.out.println(Math.abs(-10-5));
    }
}
