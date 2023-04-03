package com.test;

public class Main {
    public static double getMaxProfit(double M, double[] arr, int K) {
        int n = arr.length;
        if (n == 0) return 0;
        // Initialize dp array
        double[][] dp = new double[n][K+1];
        for (int k = 0; k <= K; k++) {
            dp[0][k] = M;
        }
        // Fill in dp array
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= K; k++) {
                double maxVal = dp[i-1][k];
                for (int j = 0; j < i; j++) {
                    double temp = (dp[j][k-1] / arr[j]) * arr[i];
                    maxVal = Math.max(maxVal, temp);
                }
                dp[i][k] = maxVal;
            }
        }
        // Find maximum profit
        double maxProfit = 0;
        for (int k = 0; k <= K; k++) {
            maxProfit = Math.max(maxProfit, dp[n-1][k]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        double M = 10000;
        double[] arr = {1.0, 2.0, 1.0, 2.0, 2.0, 5.0, 2.0};
        int K = 2;
        double maxProfit = getMaxProfit(M, arr, K);
        System.out.printf("%.4f", maxProfit - M);
    }
}
//class MaxProfit {
//    public static void main(String[] args) {
//        int M = 10000;
//        double[] arr = {1.0, 2.0, 1.0, 2.0, 2.0, 3.0, 2.0};
//        int K = 2;
//        double maxProfit = getMaxProfit(M, arr, K);
//        System.out.printf("%.4f", maxProfit);
//    }
//
//    public static double getMaxProfit(int M, double[] arr, int K) {
//        int N = arr.length;
//        double[][] dp = new double[K + 1][N];
//        for (int k = 1; k <= K; k++) {
//            double maxDiff = -arr[0];
//            for (int i = 1; i < N; i++) {
//                dp[k][i] = Math.max(dp[k][i - 1], (maxDiff + arr[i]) * M);
//                maxDiff = Math.max(maxDiff, dp[k - 1][i] - arr[i] * M);
//            }
//        }
//        return dp[K][N - 1];
//    }
//}

