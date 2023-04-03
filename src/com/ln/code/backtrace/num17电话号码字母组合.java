package com.ln.code.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 */
public class num17电话号码字母组合 {
    //存放结果集合
    List<String> result = new ArrayList<>();
    //满足条件结果
    StringBuilder s = new StringBuilder();
    //数字字母映射表
    String[] letters = {"","","abc","def","ghi","jkl",
            "mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return result;
        }
        backtrace(digits, 0);
        return result;
    }
    //回溯逻辑
    public void backtrace(String digits,int index){
        //终止条件
        if(index == digits.length()){
            result.add(s.toString());
            return;
        }
        int num = digits.charAt(index)-'0';
        String letter = letters[num];
        for(int i = 0;i<letter.length();i++){
            s.append(letter.charAt(i));
            backtrace(digits, index + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
