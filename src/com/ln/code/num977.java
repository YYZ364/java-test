package com.ln.code;

import com.utils.Tools;

/**
 * 977、有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class num977 {
    public static int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int index = length - 1;
        int leftIndex;
        int rightIndex;
        for(leftIndex = 0,rightIndex = length - 1;leftIndex <= rightIndex;){
            if(nums[leftIndex] * nums[leftIndex] > nums[rightIndex] * nums[rightIndex]){
                result[index--] = nums[leftIndex] * nums[leftIndex];
                if(index == length-1)
                    result[index] = nums[rightIndex] * nums[rightIndex];
                leftIndex ++;

            }
            else{
                result[index--] = nums[rightIndex] * nums[rightIndex];
                if(index == length-1)
                    result[index] = nums[leftIndex] * nums[leftIndex];
                rightIndex --;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-1,0,1,5};
        int[] result = sortedSquares(nums);
        Tools.printArraySelf(result);
    }

}
