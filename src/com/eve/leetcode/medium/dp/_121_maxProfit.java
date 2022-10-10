package com.eve.leetcode.medium.dp;

/**
 * Created by Eve on 2022/9/23.
 */
public class _121_maxProfit {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        int[] dp = new int[len];

        dp[0] = 0;
        int minIdx = 0;

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(prices[i] - prices[minIdx], dp[i - 1]);
            minIdx = prices[i] < prices[minIdx] ? i : minIdx;
        }

        return dp[len-1];
    }
}
