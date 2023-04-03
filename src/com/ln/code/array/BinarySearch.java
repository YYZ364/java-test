package com.ln.code.array;

import com.sun.org.apache.xpath.internal.operations.Equals;
import com.utils.Tools;

import java.util.Arrays;

/**
 * 升序数组
 * 无重复元素
 */
public class BinarySearch {

    /**
     * 左闭右闭写法
     * @param nums 升序数组
     * @param target 目标值
     * @return 目标值的下标
     */
    public static int search1(int[] nums,int target){
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int middle = left + ((right - left) >> 1);
            if(nums[middle] == target){
                System.out.println("left = "+ left +"; right = "+right);
                return middle;
            }
            else if (nums[middle] > target){
                right = middle - 1;
            }
            else if (nums[middle] < target){
                left =  middle + 1;
            }
        }
        System.out.println("left = "+ left +"; right = "+right);
        return -1;
    }

    /**
     * 左闭右开写法
     * @param nums 升序数组
     * @param target 目标值
     * @return 目标值的下标
     */
    public static int search2(int[] nums,int target){
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while(left < right){
            int middle = left + ((right - left) >> 1);
            if(nums[middle] == target){
                return middle;
            }
            else if (nums[middle] > target){
                right = middle;
            }
            else if (nums[middle] < target){
                left =  middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,8,99};
        System.out.println(search1(arr,99));
    }
}
