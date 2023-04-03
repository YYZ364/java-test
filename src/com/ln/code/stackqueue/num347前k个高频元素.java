package com.ln.code.stackqueue;

import javafx.scene.layout.Priority;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class num347前k个高频元素 {
//    public int[]  topKElement(int[] nums,int k){
//        //nums放入map中
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//        }
//        //优先级队列创建
//        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair1[1] - pair2[1]);
//        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
//            if (pq.size() < k){
//                pq.add(new int[]{entry.getKey(),entry.getValue()});
//            }
//            else{
//                if (entry.getValue() > pq.peek()[1]){
//                    pq.poll();
//                    pq.add(new int[]{entry.getKey(),entry.getValue()});
//                }
//            }
//        }
//
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = pq.poll()[0];
//        }
//        return res;
//    }
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(hash.containsKey(nums[i])){
                hash.put(nums[i], hash.get(nums[i]) + 1);
            }
            hash.put(nums[i], 1);
        }
        for(HashMap.Entry<Integer, Integer> entry : hash.entrySet()){
            if(entry.getValue() > (nums.length/2))
                return entry.getKey();
        }
        return 0;
    }
}
