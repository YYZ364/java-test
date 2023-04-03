package com.ln.code.stackqueue;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 */
public class num20有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> result = new Stack<>();
        char temp;
        for(int i = 0;i < s.length(); i++){
            temp = s.charAt(i);
            if(temp == '(')
                result.push(')');
            else if(temp == '{')
                result.push('}');
            else if(temp == '[')
                result.push(']');
            else if(result.size()!=0&&result.peek()==temp)
                result.pop();
            else
                return false;
        }
        return result.size()==0;
    }
}
