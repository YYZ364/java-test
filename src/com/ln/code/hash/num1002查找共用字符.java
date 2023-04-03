package com.ln.code.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class num1002查找共用字符 {
    public List<String> commonChars(String[] words) {
        int len = words.length;
        int[] minFre = new int[26];
        List<String> res = new ArrayList<>();
        for(int i = 0;i <words[0].length();i++){
            minFre[words[0].charAt(i) - 'a']++;
        }
        for(int i = 1;i < len;i++){
            int[] fre = new int[26];
            for(int j = 0;j < words[i].length();j++){
                fre[words[i].charAt(j) - 'a']++;
            }
            for(int index = 0;index < 26;index++){
                minFre[index] = Math.min(minFre[index], fre[index]);
            }
        }
        for(int i = 0;i < 26;i++){
            while(minFre[i] != 0){
                char temp = (char)('a' + i);
                res.add(String.valueOf(temp));
                minFre[i]--;
            }
        }
        return res;
    }
    @Test
    public void test(){
        String[] words = {"bella","label","roller"};
        commonChars(words);
    }

}
