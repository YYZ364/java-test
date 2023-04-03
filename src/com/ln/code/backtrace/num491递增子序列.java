package com.ln.code.backtrace;

import org.junit.Test;

import java.util.*;

public class num491递增子序列 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrace(nums, 0);
        return res;
    }

    public void backTrace(int[] nums, int startIndex){
        if(startIndex == nums.length){
            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = startIndex;i < nums.length;i++){
            if(i > startIndex)
                set.add(nums[i - 1]);
            if(i > startIndex && set.contains(nums[i])){
                continue;
            }
            if(path.size() == 0){
                path.add(nums[i]);
                backTrace(nums, i + 1);
                path.removeLast();
            }
            else if(nums[i] >= path.getLast()){
                path.add(nums[i]);
                res.add(new ArrayList(path));
                backTrace(nums, i + 1);
                path.removeLast();
            }
        }
    }

    @Test
    public void test(){
        int[] nums = {1,2,1,1};
        System.out.println(findSubsequences(nums));
    }
}
