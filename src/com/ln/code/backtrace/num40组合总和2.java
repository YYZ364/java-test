package com.ln.code.backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 *
 *
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class num40组合总和2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backTrace(candidates, target, 0);
        return res;
    }

    public void backTrace(int[] candidates, int target, int startIndex){
        if(sum > target)
            return;
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex;i < candidates.length;i++){
            if(i > 0&&candidates[i - 1]==candidates[i]&&!used[i - 1])
                continue;
            sum += candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            backTrace(candidates, target, i + 1);
            sum -= candidates[i];
            path.removeLast();
            used[i] = false;
        }
    }

    @Test
    public void test(){
        int[] candidates = {3,1,3,5,1,1};
        int target = 8;
        combinationSum2(candidates, target);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
