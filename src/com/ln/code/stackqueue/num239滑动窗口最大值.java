package com.ln.code.stackqueue;

import java.util.*;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 */
public class num239滑动窗口最大值 {
    //解法一
//自定义数组
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyDeque myDeque = new MyDeque();
        int len = nums.length - k + 1;
        int index = 0;
        int[] res = new int[len];
        for(int i = 0; i < k;i ++){
            myDeque.add(nums[i]);
        }
        res[index++] = myDeque.peek();
        for(int i = k;i < nums.length;i++){
            myDeque.poll(nums[i - k]);
            myDeque.add(nums[i]);
            res[index++] = myDeque.peek();
        }
        return res;
    }
}

class MyDeque{
    Deque<Integer> deque = new ArrayDeque<>();
    //弹出元素
    void poll(int val){
        if(!deque.isEmpty() && val == deque.getFirst())
            deque.removeFirst();
    }
    //弹进
    void add(int val){
        while(!deque.isEmpty() && val > deque.getLast()){
            deque.removeLast();
        }
        deque.addLast(val);
    }

    int peek(){
        return deque.peek();
    }
}
