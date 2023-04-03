package com.ln.code.stackmonotonous;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class num496下一个更大元素1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        stack.push(0);
        for(int i = 0;i < nums1.length;i++){
            hashMap.put(nums1[i], i);
        }
        for(int i = 1;i < nums2.length;i++){
            while(stack.peek() != null && nums2[i] > nums2[stack.peek()]){
                if(hashMap.containsKey(nums2[stack.peek()])){
                    result[hashMap.get(nums2[stack.peek()])] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    @Test
    public void test(){
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        nextGreaterElement(nums1, nums2);
    }
}
