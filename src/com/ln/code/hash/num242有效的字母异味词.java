package com.ln.code.hash;

public class num242有效的字母异味词 {
    public boolean isAnagram(String s, String t) {
        int[] res = new int[26];
        for(int i = 0;i < s.length();i++){
            res[s.charAt(i)-'a']++;
        }
        for(int i = 0;i < t.length();i++){
            res[t.charAt(i)-'a']--;
        }
        for(int re:res){
            if(re != 0){
                return false;
            }
        }
        return true;
    }
}
