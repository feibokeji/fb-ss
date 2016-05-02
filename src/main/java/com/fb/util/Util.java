package com.fb.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fb.core.utils.ConstantUtils;

public class Util {
    
    /**
     * 获得日期后几天的日期
     * @param date
     * @param i
     * @return
     */
    public static Date afterDate(Date date, int i) {
        long dates = date.getTime() + 86400000L * i;
        return new Date(dates);
    }
    
    /**
     * 权限过滤条件，添加在where语句中<br>
     * eg: <b>alias</b>.uroleid in (select uroleid from T_RoleAccess where uaccessroleid = :<b>uroleid</b>);
     * 
     * <pre>
     * 使用方法：
     * if (!"".equals(strNull(uroleid))) {
     *      hql.append(" and " + getAccess("t", "uroleid"));
     *      map.add("uroleid", uroleid);
     * }
     * </pre>
     * @param alias 表别名
     * @param uroleid 当前角色ID在SQL中的预处理名字
     * @return
     * @author Jesse Lu
     */
    public static String getAccess(String alias, String uroleid) {
        if (uroleid == null || "".equals(uroleid)) {
            return "1=2";
        }
        StringBuilder strb = new StringBuilder();
        strb.append(" " + alias + ".uroleid in (select uroleid from t_role_access where uaccessroleid = :" + uroleid
                    + " or uaccessroleid in (select upriorroleid from t_role_allot where callottype in('1','3') and (getdate() between dbegindate and denddate) and utargetroleid = :" + uroleid
                    + ")) ");
        return strb.toString();
    }
    
    /**
     * 获取客户端连接系统的mac地址
     * @param ip
     * @return
     */
    public static String getMACAddress(String ip) {
        String str = "", strMAC = "", macAddress = "";
        try {
            Process pp = Runtime.getRuntime().exec("nbtstat -a " + ip);
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (int i = 1; i < 100; i++) {
                str = input.readLine();
                if (str != null) {
                    if (str.indexOf("MAC Address") > 1) {
                        strMAC = str.substring(str.indexOf("MAC Address") + 14, str.length());
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            return "Can't Get MAC Address!";
        }
        if (strMAC.length() < 17) {
            return "Error!";
        }
        macAddress = strMAC.substring(0, 2) + ":" + strMAC.substring(3, 5) + ":" + strMAC.substring(6, 8) + ":" + strMAC.substring(9, 11) + ":" + strMAC.substring(12, 14) + ":"
                     + strMAC.substring(15, 17);
        return macAddress;
    }
    
    protected final static String SessionContainer_Key = ConstantUtils.getConstant("session_container_key");
    
    public static String SessionContainer_Key() {
        
        return SessionContainer_Key;
    }
    
    public static String strNull(String str) {
        if (str == null) {
            return "";
        } else {
            return str;
        }
    }
    
    public static String date2shortstr(java.util.Date date) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat theFormat = new SimpleDateFormat("yyyy-MM-dd");
            return theFormat.format(date);
        }
    }
    
    /**
     * 权限SQL in()部分
     * @param roleId
     * @return
     */
    public static String roleSQL(String roleId) {
        return "select tra.uroleid from t_role_access tra where tra.uaccessroleid='" + roleId + "' or tra.uaccessroleid in (select tra1.upriorroleid from t_role_allot tra1 where "
               + "(tra1.callottype in ('1' , '3')) and (getdate() between tra1.dbegindate and tra1.denddate) and utargetroleid = '" + roleId + "' )";
    }
    
    /**
     * 级联部门SQL in()部分
     * @param deptName
     * @return
     */
    public static String subDeptSQLByName(String deptName) {
        return "select  dpt1.uid from t_dept dpt0,t_dept dpt1 where dpt0.cname='" + deptName + "' and left(dpt1.ccodepath,len(dpt0.ccodepath))=dpt0.ccodepath";
    }
    
    /**
     * 级联部门SQL in()部分
     * @param deptId
     * @return
     */
    public static String subDeptSQL(String deptId) {
        return "select  dpt1.uid from t_dept dpt0,t_dept dpt1 " + "where dpt0.uid='" + deptId + "' and left(dpt1.ccodepath,len(dpt0.ccodepath))=dpt0.ccodepath";
    }
    
    /**
     * 深克隆对象，对象及对象属性必须实现序列化
     * @param o
     * @return
     * @author Jesse Lu
     */
    public static Object deepClone(Object o) {
        if (!(o instanceof Serializable)) {
            return null;
        }
        // 将对象写到流里
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo;
        try {
            oo = new ObjectOutputStream(bo);
            oo.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // 从流里读出来
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi;
        try {
            oi = new ObjectInputStream(bi);
            return oi.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 将长日期字符串转换为Date
     * @param strValue
     * @return java.util.Date
     */
    public static java.util.Date str2date(String strValue) {
        if (strValue == null) return null;
        if (strValue.equals("")) return null;
        java.util.Date theDate;
        try {
            String str = strValue.substring(4, 5);
            SimpleDateFormat theFormat = new SimpleDateFormat("yyyy" + str + "MM" + str + "dd" + " " + "HH" + ":" + "mm" + ":" + "ss");
            theDate = theFormat.parse(strValue);
        } catch (Exception ex) {
            theDate = null;
        }
        return theDate;
    }
    
}
