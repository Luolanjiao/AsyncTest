package com.example.demo;

import com.example.demo.service.AmountExchange;
import com.example.demo.service.StringExtends;

import java.io.UnsupportedEncodingException;

public class StringApplication {


    public static void main(String[] args) throws UnsupportedEncodingException {
        StringExtends stringExtends=new StringExtends();
        //根据字节个数取字符
       // System.out.println( stringExtends.getCharByByteCount("abc我是罗兰娇",5));
        //正则表达式判断字符串中的子字符串出现次数
        String matchObjectStr="123abcd我是罗兰娇";
        System.out.println("数字个数匹配："+stringExtends.getCoutByRegularExg(matchObjectStr,"\\d"));
        System.out.println("字母个数匹配："+stringExtends.getCoutByRegularExg(matchObjectStr,"[a-z]"));
        System.out.println("汉字个数匹配："+stringExtends.getCoutByRegularExg(matchObjectStr,"[\\u0391-\\uFFE5]"));

        AmountExchange amountExchanger=new AmountExchange();
        System.out.println(amountExchanger.convertToRMB(1000000));
        System.out.println(amountExchanger.convertToRMB(1100001));
        System.out.println(amountExchanger.convertToRMB(1010010));
        System.out.println(amountExchanger.convertToRMB(1001000));
        System.out.println(amountExchanger.convertToRMB(1000100));
        System.out.println(amountExchanger.convertToRMB(1111111));
    }
}
