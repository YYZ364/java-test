package com.ln.code.greed;

import org.junit.Test;

import java.util.Arrays;

/**
 * 排序数组
 * 情况一 数组中若有负数 k >
 * 情况二 数组中无负数但有0 总和不变
 * 情况三 数组中无负数 且无0 最小的改变k次
 *
 */
public class num1055k次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0, count = 0;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length; i++){
            if(count > k){
                count++;
                break;
            }
            if(nums[i] < 0&&count < k){
                nums[i] = -nums[i];
                count++;
            }
        }
        Arrays.sort(nums);
        k = k - count;
        if(k > 0){
            for(int i = 0;i < k;i++){
                nums[0] = -nums[0];
            }
            return sumArray(nums);
        }
        else{
            return sumArray(nums);
        }
    }

    public int sumArray(int[] nums){
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        return sum;
    }

    @Test
    public void test(){
        int[] nums = {2, -3, -1, 5, -4};
        System.out.println(largestSumAfterKNegations(nums, 2));
    }

}
