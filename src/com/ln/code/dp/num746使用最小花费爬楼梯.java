package com.ln.code.dp;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 示例 1：
 *
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 *
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 */
public class num746使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if(len == 2){
            return Math.min(cost[1], cost[0]);
        }
        //从第i层往上爬需要的最低花费
        int[] dpCost = new int[cost.length];
        dpCost[0] = cost[0];
        dpCost[1] = cost[1];
        for(int i = 2;i < len - 1;i++){
            dpCost[i] = Math.min(dpCost[i - 1], dpCost[i - 2]) + cost[i];
        }
        return Math.min(dpCost[len - 2], dpCost[len - 3] + cost[len - 1]);
    }
}
