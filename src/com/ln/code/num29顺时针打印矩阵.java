package com.ln.code;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class num29顺时针打印矩阵 {
    public static int[] spiralOrder1(int[][] matrix) {
        if (matrix.length == 0){
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
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
                    res[index++] = matrix[i][j];
                }
            }
            return res;
        }
        while(loop++ < standard/2){
            for(int i = start;i < n - 1 - start;i ++){
                res[index++] = matrix[start][i];
            }
            for(int i = start;i < m - 1 - start;i ++){
                res[index++] = matrix[i][n - 1 - start];
            }
            for(int i = n - 1 - start;i > start;i --){
                res[index++] = matrix[m - 1 - start][i];
            }
            for(int i = m - 1 - start;i > start;i --){
                res[index++] = matrix[i][start];
            }
            start ++;
        }
        //当行数小且为奇数时，需要单独计算中间一行
        if(standard == m && m % 2 != 0){
            for(int i = start;i <= n - 1 - start;i++){
                res[index++] = matrix[start][i];
            }
        }
        //当列数小且为奇数时，需要单独计算中间一列
        else if (standard == n && n % 2 != 0){
            for (int i = start; i <= m - 1 - start; i++) {
                res[index++] = matrix[i][start];
            }}
        return res;
    }

    /**
     * 新思路！！！！！！
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        /**
         * 判断二维数组为空或者长度为0
         */
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        int index = 0;
        int[] res = new int[(right + 1) * (down + 1)];
        while (true) {
            for (int i = left; i <= right; i++) res[index++] = matrix[up][i];
            if (++up > down) break;
            for (int i = up; i <= down; i++) res[index++] = matrix[i][right];
            if (--right < left) break;
            for (int i = right; i >= left; i--) res[index++] = matrix[down][i];
            if (--down < up) break;
            for (int i = down; i >= up; i--) res[index++] = matrix[i][left];
            if (++left > right) break;
        }
        return res;

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
//        int[][] matrix = {};
        int[] res = spiralOrder(matrix);
        String string = Arrays.toString(res);
        System.out.println(string);
//        for (int i = 0; i < matrix.length*matrix[0].length; i++) {
//            System.out.println(res[i]);
//        }
    }
}
