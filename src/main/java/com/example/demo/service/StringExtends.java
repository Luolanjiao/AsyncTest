package com.example.demo.service;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StringExtends {
    /***
     * 根据字节个数取字符
     * @param str
     * @param byteCount
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getCharByByteCount(String str, int byteCount) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("gbk");
        int charCount = 0;
        for (int i = 0; i < byteCount; i++) {
            if (bytes[i] < 0) {
                i++;
            }
            if (i == byteCount) {
                break;
            }
            charCount++;
        }
        return str.substring(0, charCount);
    }

    /***
     * 正则表达式判断字符串中的子字符串出现次数
     * @param str
     * @param regularExg
     * @return
     */
    public int getCoutByRegularExg(String str,String regularExg) {
        Pattern pattern=Pattern.compile(regularExg,Pattern.CASE_INSENSITIVE);
        Matcher matcher= pattern.matcher(str);
        int foundCout=0;
        while (matcher.find()){
            foundCout++;
        }
        return foundCout;
    }
}


