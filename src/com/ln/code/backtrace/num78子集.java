package com.ln.code.backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class num78子集 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> first = new LinkedList<>();
        res.add(new ArrayList<>(path));
        backTrace(nums, 0);
        return res;
    }

    public void backTrace(int[] nums, int startIndex){
        if(startIndex == nums.length){
            return;
        }
        for(int i = startIndex;i < nums.length;i++){
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            backTrace(nums, i + 1);
            path.removeLast();
        }
    }

    @Test
    public void test(){
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(subsets(nums).toArray()));
    }
}
