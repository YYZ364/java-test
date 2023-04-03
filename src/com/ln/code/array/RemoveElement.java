package com.ln.code.array;

import com.sun.deploy.security.CredentialManager;

public class RemoveElement {
    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex <= nums.length - 1; fastIndex++) {
            if(nums[fastIndex] != val){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,54};
        int num = removeElement(arr,3);
        System.out.println(num);
    }
}
