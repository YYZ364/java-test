package com.ln.code.backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class num93复原ip地址 {
//    public List<List<String>> res = new ArrayList<>();
    public LinkedList<String> ip = new LinkedList<>();
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12)
            return res;
        backTrace(s,0);
        return res;
    }

    public void backTrace(String s,int index){
        if(ip.size() == 4&&index == s.length() - 1)
            return;
        if(index > s.length())
            return;
        if(ip.size() == 4 && index == s.length()){
            //
            String str = toIp(ip);
            res.add(str);
            return;
        }
        for(int i = index; i < s.length();i++){
            String str = s.substring(index,i + 1);
            if(isLegal(str)){
                ip.add(str);
            }
            else{
                continue;
            }
            backTrace(s,i + 1);
            ip.removeLast();
        }
    }

    public boolean isLegal(String str){
        if(str.length() > 1&&str.charAt(0) == '0')
            return false;
        if(toNum(str) >= 0 && toNum(str) <= 255)
            return true;
        else
            return false;
    }

    public int toNum(String s){
        int len = s.length();
        int sum = 0,beishu = 1;
        for (int i = len - 1; i >= 0 ; i--) {
            sum += (s.charAt(i) - '0') * beishu;
            beishu *= 10;
        }
        return sum;
    }

    public String toIp(List<String> ls){
        String str = "";
        for(int i = 0;i < 4;i++){
            str += ls.get(i);
            if(i < 3){
                str += '.';
            }
        }
        return str;
    }
    @Test
    public void test(){
//        int[] candidates = {3,1,3,5,1,1};
//        int target = 8;
        String s = "25525511135";
        restoreIpAddresses(s);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
