package com.fb.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    
    @org.junit.Test
    public void testCon() {
        System.out.println("开始测试连接...");
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
        }
    }
}
