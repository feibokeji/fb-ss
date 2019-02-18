package com.fb.util;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author 作者：Liu bo
 * @version 创建时间：2019年1月30日 下午2:57:42
 * 字符集自动检测
 */
public class CharsetDetector {
    private static final int CHUNK_SIZE = 2000;
    private static Pattern metaPattern = Pattern.compile("<meta\\s+([^>]*http-equiv=(\"|')?content-type(\"|')?[^>]*)>",Pattern.CASE_INSENSITIVE);
    private static Pattern charsetPattern = Pattern.compile("charset=\\s*([a-z][_\\-0-9a-z]*)",Pattern.CASE_INSENSITIVE);
    private static Pattern charsetPatternHTML5 = Pattern.compile("<meta\\s+charset\\s*=\\s*[\"']?([a-z][_\\-0-9a-z]*)[^>]*>",Pattern.CASE_INSENSITIVE);
    private static String guessEncodingByNutch(byte[] content){
        int length = Math.min(content.length, CHUNK_SIZE);
        String str = "";
        try{
            str = new String(content,"ascii");
        }catch(UnsupportedEncodingException e){
            return null;
        }
        Matcher metaMatcher = metaPattern.matcher(str);
        String encoding = null;
        if(metaMatcher.find()){
            Matcher charsetMatcher = charsetPattern.matcher(metaMatcher.group(1));
            if(charsetMatcher.find()){
                encoding = new String(charsetMatcher.group(1));
            }
        }
        if(encoding == null){
            metaMatcher = charsetPatternHTML5.matcher(str);
            if(metaMatcher.find()){
                encoding = new String(metaMatcher.group(1));
            }
        }
        if(encoding == null){
            if(length >= 3 && content[0] == (byte)0xEF && content[1] == (byte)0xBB && content[2] == (byte)0xBF){
                encoding = "UTF-8";
            }else if(length >= 2){
                if(content[0] == (byte)0xFF && content[1] == (byte)0xFE){
                    encoding = "UTF-16LE";
                }else if(content[0] == (byte)0xFE && content[1] == (byte)0xFF){
                    encoding = "UTF-16BE";
                }
            }
        }
        return encoding;
    }
    public static String guessEncodingByMozilla(byte[] bytes){
        String DEFAULT_ENCODING = "UTF-8";
        UniversalDetector detector = new UniversalDetector(null);
        detector.handleData(bytes, 0, bytes.length);
        detector.dataEnd();
        String encoding = detector.getDetectedCharset();
        detector.reset();
        if(encoding == null){
            encoding = DEFAULT_ENCODING;
        }
        return encoding;
    }
    public static String guessEncoding(byte[] content){
        String encoding;
        try{
            encoding = guessEncodingByNutch(content);
        }catch(Exception e){
            return guessEncodingByMozilla(content);
        }
        if(encoding == null){
            encoding = guessEncodingByMozilla(content);
            return encoding;
        }else{
            return encoding;
        }
    }
}
