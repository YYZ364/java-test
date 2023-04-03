package com.ln.code.dp.pg;

public class num698划为k个相等的子集 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        if (len < k) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        //dp[j]表示 容量为j的最大价值
        int[] dp = new int[sum + 1];
        boolean[] flag = new boolean[nums.length];
        int smallSum = (sum / k);
        while (k >= 0) {
            for (int i = 0; i < len; i++) {
                if (flag[i]) continue;
                for (int j = sum / k; j >= nums[i]; j--) {
                    if (dp[j] < dp[j - nums[i]] + nums[i]) {
                        dp[j] = dp[j - nums[i]] + nums[i];
                        flag[i] = true;
                    }
                }
                if (dp[sum / k] == sum / k) {
                    k--;
                    if (k == 0) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }
}
