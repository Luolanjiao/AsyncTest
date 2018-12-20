package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

public class AmountExchange {
    public static String[] arrayRMBData = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    public static String[] arrayRMBUnit = new String[]{"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿"};
    public static String[] arrayRMBBigUnit = new String[]{"元", "万", "亿"};

    public String convertToRMB(int amount) {
        StringBuffer stringBuffer = new StringBuffer();
        int unit = 0;
        while (amount > 0) {
            int num = amount % 10;
            stringBuffer.insert(0, arrayRMBData[num] + arrayRMBUnit[unit++]);
            amount = amount / 10;
        }
        int zeroIndex = 0;
        stringBuffer=new StringBuffer( stringBuffer.toString().replaceAll("零+","零"));
        List<String> listBigUnits = Arrays.asList(arrayRMBBigUnit);
        List<String> listUnits = Arrays.asList(arrayRMBUnit);
        while (zeroIndex > -1) {
            zeroIndex = stringBuffer.indexOf("零", zeroIndex + 1);
            //零在元，万，亿前面 则去掉
            if (listBigUnits.contains(String.valueOf(stringBuffer.charAt(zeroIndex + 1)))) {
                stringBuffer.deleteCharAt(zeroIndex);
            }
            try {
                //零在其他单位面前 则去掉这些单位
                if (listUnits.contains(String.valueOf(stringBuffer.charAt(zeroIndex + 1)))) {
                    stringBuffer.deleteCharAt(zeroIndex + 1);
                    if(stringBuffer.charAt(zeroIndex + 1)=='零'){
                        stringBuffer.deleteCharAt(zeroIndex + 1);
                        zeroIndex--;
                    }
                }
            }catch (Exception ex){
            }
        }
        return stringBuffer.toString();
    }
}
