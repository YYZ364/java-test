package com.ln.code.dp.pg;

import org.junit.Test;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class num416分割等和子集 {
    //二维数组
    public boolean canPartition0(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int num:nums){sum += num;}
        if(sum%2 == 1)return false;
        else sum = sum/2;
        //背包容量为sum 每个元素的weight为其值
        //dp[i][j]表示下标0-i之间随意选取元素容量为j的背包最大和
        //如果dp[i][sum] == sum则返回true
        int[][] dp = new int[len][sum + 1];
        for(int i = nums[0];i <= sum;i++){dp[0][i] = nums[0];}
        for(int i = 0;i < len;i++)dp[i][0] = 0;
        //递推dp
        for(int i = 1;i < len;i++){
            for(int j = 1;j <= sum;j++){
                if(nums[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
            }
            if(dp[i][sum] == sum)
                return true;
//            for (int im = 0; im < len; im++) {
//                for (int jm = 0; jm <= sum; jm++) {
//                    System.out.print(dp[im][jm] + "\t");
//                }
//                System.out.println("\n");
//            }
        }
        return false;
    }
//一维数组
    public boolean canPartition1(int[] nums) {
        int len = nums.length;
        if(len == 1)return false;
        int sum = 0;
        for(int num:nums)sum += num;
        if(sum % 2 == 1)return false;
        else sum = sum/2;
        //dp[j]表示 容量为j的最大价值
        int[] dp = new int[sum + 1];
        for(int i = 0;i < len;i++){
            for(int j = sum;j >= 0;j--){
                if(j >= nums[i])
                    dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
            }
            if(dp[sum] == sum)return true;
        }
        return false;
    }

    @Test
    public void test(){
        int[] nums = {1,5,11,5};
        canPartition0(nums);
    }
}
