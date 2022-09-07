package com.eve.leetcode.medium.dp;

/**
 * Created by Eve on 2022/9/7.
 */
public class _62_uniquePaths {

    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j];
                }
                if (j != 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i][j];
                }
            }
        }

        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }

}
