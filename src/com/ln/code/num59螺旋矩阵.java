package com.ln.code;

public class num59螺旋矩阵 {
    public static int[][] generateMatrix(int n){
        int loop = 0;
        int count = 1;
        int start = 0;
        int[][] res = new int[n][n];
        while(loop++ <= n/2){
            for(int i = start;i < n - start - 1;i ++){
                res[start][i] = count ++;
            }
            for(int i = start;i < n - start - 1;i ++){
                res[i][n - 1- start] = count ++;
            }
            for(int i = n - start - 1;i > start;i --){
                res[n - 1 - start][i] = count ++;
            }
            for(int i = n - start - 1;i > start;i --){
                res[i][start] = count ++;
            }
            start ++;
        }
        if(n%2!=0)
            res[n/2][n/2] = count;
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] res = generateMatrix(n);
        for(int i = 0;i < n;i++){
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
