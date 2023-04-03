package com.ln.code.string;

import java.util.Arrays;

public class num541反转字符串2 {
    public static String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int len = s.length();
        for(int i = 0;i < len;i += 2*k){
            int start = i;
            int end = Math.min(len - 1, i + k - 1);
            while(start < end){
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        return new String(ch);
    }



    public static void main(String[] args) {
        System.out.println(reverseStr("ajshah", 2));
    }

    public static String numberToChinese(int num) {
        String[] units = {"", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿"};
        String[] nums = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String result = "";
        int unitIndex = 0;
        boolean isZero = true;
        while (num > 0) {
            int n = num % 10;
            if (n > 0) {
                isZero = false;
                result = nums[n] + units[unitIndex] + result;
            } else {
                if (!isZero) {
                    isZero = true;
                    result = nums[n] + result;
                }
            }
            unitIndex++;
            num /= 10;
        }
        return result;
    }
}
