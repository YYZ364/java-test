package com.ln.code;

import java.util.LinkedList;
import java.util.List;

public class num54螺旋矩阵 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new LinkedList<>();
        int loop = 0;
        int start = 0;
        int m = matrix.length;//行数
        int n = matrix[0].length;//列数
        System.out.println("行数m为"+m+"; 列数n为"+n);
        int standard = Math.min(m,n);//考虑行数和列数谁小的情况，这决定了循环次数
        /**
         * 考虑行数或列数为一的情况
         */
        if(standard == 1){
            for (int i = 0; i < matrix.length ; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    ls.add(matrix[i][j]);
                }
            }
            return ls;
        }
        while(loop++ < standard/2){
            for(int i = start;i < n - 1 - start;i ++){
                ls.add(matrix[start][i]);
            }
            for(int i = start;i < m - 1 - start;i ++){
                ls.add(matrix[i][n - 1 - start]);
            }
            for(int i = n - 1 - start;i > start;i --){
                ls.add(matrix[m - 1 - start][i]);
            }
            for(int i = m - 1 - start;i > start;i --){
                ls.add(matrix[i][start]);
            }
            start ++;
        }
        //当行数小且为奇数时，需要单独计算中间一行
        if(standard == m && m % 2 != 0){
            for(int i = start;i <= n - 1 - start;i++){
                ls.add(matrix[start][i]);
            }
        }
        //当列数小且为奇数时，需要单独计算中间一列
        else if (standard == n && n % 2 != 0){
            for (int i = start; i <= m - 1 - start; i++) {
                ls.add(matrix[i][start]);
            }}
        return ls;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,2,3,4,1,3},
//                {5,6,7,8,3,5},
//                {9,10,11,12,4,6},
//                {5,6,7,8,3,5},
//                {9,10,11,12,4,6}};
        int[][] matrix ={
                {1,2,3},
                {5,6,7},
                {1,2,3},
                {9,10,11}};
        List<Integer> ls= spiralOrder(matrix);
        for (int i = 0; i < matrix.length*matrix[0].length; i++) {
            System.out.println(ls.get(i));
        }
    }
}
