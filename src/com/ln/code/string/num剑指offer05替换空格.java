package com.ln.code.string;

public class num剑指offer05替换空格 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
