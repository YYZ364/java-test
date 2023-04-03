package com.ln.code.array;


/**
 * 问题1：如何确定字串s中包含字符串t
 * 通过判断子串和字符串的字符频数比较
 * 通过汉明距离引入distance：
 * 当窗口右边界移动时，窗口右边界字符在窗口中的频数小于在T中的频数时，distance + 1 ,若等于，则不变
 * 直到distance等于T的长度的时候停止移动
 * 当窗口左边界移动时，窗口左边界字符在窗口中的频数等于在T中的频数时，distance - 1 ,若大于，则不变
 *
 * 问题2：窗口滑动过程中，如何保存最小字符子串
 * 通过最短长度 和 一个起始位置
 *
 * 问题3：滑动窗口区间问题
 * right = 0
 * left = 0
 * 左闭右开 原因
 * 1 right - left = 窗口的长度
 * 2 初始状态就为空区间（方便空区间的表示）
 */
public class num76最小覆盖子串 {
    public static String minWindow(String s,String t){
        int sLen = s.length();
        int tLen = t.length();

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int minLen = sLen + 1;
        int begin = 0;
        int distance = 0;

        int left = 0;
        int right = 0;

        int[] winFreq = new int[128];
        int[] tFreq = new int[128];

        for(char c : tArray){
            tFreq[c] ++;
        }

        while (right < sLen){
            if (tFreq[sArray[right]] == 0){
                right ++;
                continue;
            }
            if (winFreq[sArray[right]] < tFreq[sArray[right]])
                distance ++;

            winFreq[sArray[right]] ++;
            right ++;

            while(distance == tLen){
                if(right - left < minLen){
                    minLen = right - left;
                    begin = left;
                }

                if (tFreq[sArray[left]] == 0){
                    left ++;
                    continue;
                }
                if (winFreq[sArray[left]] == tFreq[sArray[left]])
                    distance --;

                winFreq[sArray[left]] --;
                left ++;
            }
        }

        if (minLen == sLen + 1)
            return "";
        return s.substring(begin,begin + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
