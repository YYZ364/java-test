package com.ln.code.day;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class num1042不邻接植花 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        //建立邻接表
        List<Integer>[] table= new LinkedList[n];
        for (int i = 0; i < n; i++) {
            table[i] = new LinkedList<>();
        }
        for(int[] path : paths){
            table[path[0] - 1].add(path[1] - 1);
            table[path[1] - 1].add(path[0] - 1);
        }
        int[] res = new int[n];
        //遍历每个节点
        for (int i = 0;i < n ;i++){
            //颜色标记数组
            boolean[] colors = new boolean[5];
            //遍历节点相邻的节点 用过的颜色标记为true
            for(int node : table[i]){
                colors[res[node]] = true;
            }
            //将未使用过的颜色的花种植到花园
            for(int j = 1; j <= 4; j++){
                if(!colors[j]){
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
    @Test
    public void test(){
        int[][] path = {{1,2},{2,3},{3,1}};
        int n = 3;
        System.out.println(Arrays.toString(gardenNoAdj(n, path)));
    }
}
