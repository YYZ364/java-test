package com.ln.code.stackmonotonous;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 *
 */

//即遍历两遍nums数组
public class num503下一个更大元素 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int flag = 0;
        for(int i = 1;i < len;i++){
            while(stack.peek() != null && nums[i] > nums[stack.peek()]){
                res[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
            if(i == len - 1 && flag == 0){
                i = -1;
                flag = 1;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums1 = {5, 4, 3, 2, 1};
        nextGreaterElements(nums1);
    }
}
