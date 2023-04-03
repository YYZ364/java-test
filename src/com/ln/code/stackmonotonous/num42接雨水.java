package com.ln.code.stackmonotonous;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class num42接雨水 {
    public int trap(int[] height) {
        int sum = 0, mid, left, right;
        int len = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i = 1;i < len;i++){
            while(stack.peek() != null && height[i] > height[stack.peek()]){
                mid = stack.pop();
                if(stack.peek() != null){
                    left = stack.peek();
                }
                else{
                    break;
                }
                right = i;
                sum += (right - left - 1)*(Math.min(height[right], height[left]) - height[mid]);
            }
            stack.push(i);
        }
        return sum;
    }
}
