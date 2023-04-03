package com.ln.code.greed;

/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 */

/**
 * 如果总油量减去总消耗大于等于零那么一定可以跑完一圈，说明 各个站点的加油站
 * 剩油量rest[i]相加一定是大于等于零的。
 *
 * 每个加油站的剩余量rest[i]为gas[i] - cost[i]。
 *
 * i从0开始累加rest[i]，和记为curSum，一旦curSum小于零，
 * 说明[0, i]区间都不能作为起始位置，因为这个区间选择任何一个位置作为起点，
 * 到i这里都会断油，那么起始位置从i+1算起，再从0计算curSum。
 */
public class num134加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0, totalSum = 0;
        int len = gas.length;
        int index = 0;
        for(int i = 0;i < len;i++){
            curSum += (gas[i] - cost[i]);
            totalSum += (gas[i] - cost[i]);
            if(curSum < 0){
                index = i + 1;
                curSum = 0;
            }
        }
        if(totalSum < 0)
            return -1;
        return index;
    }
}
