package com.fb.util;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年1月30日 下午5:31:29
 * 下载那些已经访问过得文件
 */
public class FileTool {
    private static String dirPath;
    private static void mkdir(){
        File fileDir = new File(dirPath);
        if(!fileDir.exists())
            fileDir.mkdir();
    }
    public static void setDirPath(String path){
        dirPath = path;
    }
    public static String getFileNameByUrl(String url,String contentType){
        //去除http://
        url = url.substring(7);
        //text/html类型
        if(contentType.indexOf("html") != -1){
            url = url.replaceAll("[\\?/:*|<>\"]","_") + ".html";
            return url;
        }else{
            //如application/pdf类型
            return url.replaceAll("[\\?/:*|<>\"]", "_") + "." + contentType.substring(contentType.lastIndexOf("/") + 1);
        }
    }
    public static void saveToLocal(Page page){
        mkdir();
        String fileName = getFileNameByUrl(page.getUrl(),page.getContentType());
        String filePath = dirPath + "\\" + fileName;
        byte[] data = page.getContent();
        try{
            DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(filePath)));
            for(int i = 0; i < data.length; i++)
                out.write(data[i]);
            out.flush();
            out.close();
            System.out.println("文件：" + fileName + "已经被储存在" + filePath);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
