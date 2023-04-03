package com.ln.code.array;


/**
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i]是第i棵树上的水果种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 *
 * 你只有两个篮子，并且每个篮子只能装单一类型的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从每棵树（包括开始采摘的树）上恰好摘一个水果。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits，返回你可以收集的水果的最大数目。
 */
public class num904水果成篮 {
    public static int totalFruit(int[] fruits) {
        int len = fruits.length;
        int left = 0;
        int right;
        int basket1Type = -1;
        int basket2Type = -1;
        int Max = 0;
        for(right = 0;right < len;right ++){
            if( basket1Type == -1 || basket1Type == fruits[right]){
                basket1Type = fruits[right];
            }
            else if(basket2Type == -1 || basket2Type == fruits[right]){
                basket2Type = fruits[right];
            }
            else{
                Max = Math.max(Max,right - left);
                basket1Type = fruits[right - 1];
                basket2Type = fruits[right];
                left = right - 1;
                while(fruits[left - 1] == basket1Type){
                    left --;
                }
            }
        }
        return Math.max(Max,right - left);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,1};
        int[] nums = {0,1,0,1,4,1,4,1,2,3};
        System.out.println(totalFruit(nums1));
    }
}


/**
 * [3,3,3,1,2,1,1,2,3,3,4]
 * right 逐渐增加
 * 如果有篮子是空的，放入篮子
 * 如果篮子不为空，判断是哪个篮子里的
 *      如果当前树上的水果是篮子里没有的C
 *
 *{A,B,C}
 *              选择删除不紧挨的篮子的数量A
 *              紧挨着的要减掉B中一些（位于A之前B的数量）
 *
 *      如果当前树上的果子是篮子里有的
 *              当前数量+1
 *
 *
 *
 */


