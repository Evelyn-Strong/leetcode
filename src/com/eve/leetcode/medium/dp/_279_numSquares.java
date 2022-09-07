package com.eve.leetcode.medium.dp;

import java.util.Arrays;

/**
 * Created by Eve on 2022/9/6.
 */
public class _279_numSquares {

    //dp[i] = n*n+ dp[j]
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j*j<=i; j++) {
                    dp[i]=Math.min(dp[i-j*j]+1,dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(1000));
    }
}
