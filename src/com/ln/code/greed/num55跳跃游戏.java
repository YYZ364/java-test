package com.ln.code.greed;

public class num55跳跃游戏 {
    public boolean canJump(int[] nums) {
        int maxCover = 0;
        int lastIndex = nums.length - 1;
        for(int i = 0;i < nums.length - 1;i++){
            if(i <= maxCover && i + nums[i] > maxCover){
                maxCover = i + nums[i];
            }
            if(maxCover >= lastIndex)
                break;
        }
        return maxCover >= lastIndex;
    }
}
