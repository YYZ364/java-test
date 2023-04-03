package com.ln.code.greed;

import org.junit.Test;

import java.util.Arrays;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */

/**
 * 先确定右边评分大于左边的情况（也就是从前向后遍历）
 *
 * 此时局部最优：只要右边评分比左边大，右边的孩子就多一个糖果，全局最优：
 * 相邻的孩子中，评分高的右孩子获得比左边孩子更多的糖果
 *
 * 再确定左孩子大于右孩子的情况（从后向前遍历）
 */
public class num135分发糖果 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] leftToRight = new int[len];
        int[] rightToLeft = new int[len];
        Arrays.fill(leftToRight, 1);
        Arrays.fill(rightToLeft, 1);
        for(int i = 1;i < len;i++){
            if(ratings[i] > ratings[i - 1])
                leftToRight[i] = leftToRight[i - 1] + 1;
        }
        rightToLeft[len - 1] = Math.max(1, leftToRight[len - 1]);
        for(int i = len - 2;i >= 0;i--){
            if(ratings[i] > ratings[i + 1])
                rightToLeft[i] = Math.max(rightToLeft[i + 1] + 1, leftToRight[i]);
            else
                rightToLeft[i] = Math.max(rightToLeft[i], leftToRight[i]);
        }
        int res = 0;
        for(int item : rightToLeft){
            res += item;
        }
        return res;
    }

    @Test
    public void test(){
        int[] ratings = {1, 2, 87, 87, 87, 2, 1};
        System.out.println(candy(ratings));
    }
}
