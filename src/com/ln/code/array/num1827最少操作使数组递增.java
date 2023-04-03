package com.ln.code.array;

public class num1827最少操作使数组递增 {
    public static int minOperations(int[] nums){
        int length = nums.length;
        if (length <= 1)
            return 0;
        int currentIndex;
        int totalOperations = 0;
        if (nums[1] <= nums[0]){
            currentIndex = nums[0] + 1;
            totalOperations = nums[0] + 1 - nums[1];
        }
        else{
            currentIndex = nums[1];
            totalOperations = 0;
        }
        for (int i = 2; i < length; i++) {
            currentIndex ++;
            if (nums[i] > currentIndex)
                currentIndex = nums[i];
            totalOperations += currentIndex - nums[i];
        }
        return totalOperations;
    }

    public static void main(String[] args) {
        int[] nums = {6,8,10,1,4,3,9,10,3,2};
        System.out.println(minOperations(nums));
    }
}
