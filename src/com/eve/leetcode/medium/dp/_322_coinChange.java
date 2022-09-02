package com.eve.leetcode.medium.dp;

/**
 * Created by Eve on 2022/8/20.
 */

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * <p>
 * Input: coins = [1], amount = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class _322_coinChange {

    //解题思路：
    //f(x) =  f(i) + f(x-i);
    //dp[x] =  dp[i] + dp[x-i];
    //dp[i] is minimum coins count of sum=i

    public static int coinChange(int[] coins, int amount) {
        if( amount == 0 ) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i > coin && dp[i - coin] != 0) {
                    if (dp[i] == 0) {
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }

                }
                if (i == coin) {
                    dp[i] = 1;
                    continue;
                }
            }
        }

        return dp[amount] == 0 ? -1 : dp[amount];

    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 10));
    }

}
