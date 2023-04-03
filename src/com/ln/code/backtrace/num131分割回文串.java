package com.ln.code.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class num131分割回文串 {
    public List<List<String>> res = new ArrayList<>();
    public LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s){
        backTrace(0, s);
        return res;
    }

    public void backTrace(int index, String s){
        if (index >= s.length()){
            res.add(new ArrayList<>(path));
        }
        for(int i = index;i < s.length();i++){
            String str = s.substring(index, i);
            if(isBackString(s, index, i - 1)){
                path.add(str);
            }
            else
                continue;
            backTrace(i, s);
            path.removeLast();
        }
    }

    public boolean isBackString(String s, int start, int end){
        for(int i = start, j= end;i < j;i++, j--){
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
