package com.ln.code.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class num349两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        int[] fre1 = new int[1001];
        int[] fre2 = new int[1001];
        for(int i = 0;i < nums1.length;i++){
            fre1[nums1[i]]++;
        }
        for(int i = 0;i < nums2.length;i++){
            fre2[nums2[i]]++;
        }
        for(int i = 0;i < 1001;i++){
            if(fre1[i] != 0 && fre2[i] != 0){
                res.add(i);
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0;i < res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }

    @Test
    public void test(){
        String[] words = {"bella","label","roller"};
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        intersection(nums1, nums2);
    }
}
