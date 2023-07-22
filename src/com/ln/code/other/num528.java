package com.ln.code.other;

public class num528 {
    int[] presum;
    public void Solution(int[] w) {
        int len = w.length;
        presum = new int[len + 1];
        presum[0] = 0;
        for(int i = 1;i <= len;i++){
            presum[i] = presum[i - 1] + w[i - 1];
        }
    }

    public int left_bound(int[] nums, int target){
        int left = 0,right = nums.length;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] ==  target){
                right = mid - 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else if(nums[mid] <  target){
                left = mid + 1;
            }
        }
        if(left >= nums.length) return -1;
        return target == nums[left]? left:-1;
    }
}
