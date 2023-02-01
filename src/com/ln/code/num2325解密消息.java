package com.ln.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class num2325解密消息 {
    public static String decodeMessage(String key,String message){
        Map<Character,Character> duizhao= new HashMap<Character,Character>();
        char[] keyChar = key.toCharArray();
        char[] messageChar = message.toCharArray();
        char cur = 'a';
        for(char c : keyChar){
            if (c == ' ')
                continue;
            if (!duizhao.containsKey(c))
                duizhao.put(c,cur++);
        }
        StringBuilder sb = new StringBuilder();
        for(char m : messageChar){
            if (m == ' '){
                sb.append(m);
                continue;
            }
            sb.append(duizhao.get(m));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog","vkbs bs t suepuv"));
    }
}
