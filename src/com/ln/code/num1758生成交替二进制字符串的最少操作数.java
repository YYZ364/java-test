package com.ln.code;

public class num1758生成交替二进制字符串的最少操作数 {
    public static int generateMinOperator(String s){
        int cnt = 0;
        int len = s.length();
        for(int i = 0;i < len;i++){
//            if(i % 2 == 0 && s.charAt(i) == '0')
//                cnt ++;
//            if(i % 2 != 0 && s.charAt(i) == '1')
//                cnt ++;
            cnt += s.charAt(i) ^ '0' ^ (1 & i);
        }
        return Math.min(cnt,len - cnt);
    }

    public static void main(String[] args) {
        System.out.println(generateMinOperator("1001"));
        for (int i = 0; i < 5; i++) {
            System.out.println(1 & i);
        }
    }
}