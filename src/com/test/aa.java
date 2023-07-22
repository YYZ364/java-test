package com.test;

public class aa{
    public static int calculateMinTime(String A, String B, int x, int y, int z) {
        int m = A.length();
        int n = B.length();

        int[][] dp = new int[m + 1][n + 1];

        // 初始化第一行和第一列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i * y;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j * x;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + z, Math.min(dp[i][j - 1] + x, dp[i - 1][j] + y));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String A = "finereport";
        String B = "fanruan666";
        int x = 2;
        int y = 4;
        int z = 8;

        int minTime = calculateMinTime(A, B, x, y, z);
        System.out.println(minTime);
    }
}
