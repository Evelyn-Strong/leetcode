package com.eve.leetcode.面试经典.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 08.11. 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * <p>
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 * <p>
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= n (总金额) <= 1000000
 */
public class _0811_waysToChange {
//todo
//    public int waysToChange(int n) {
//        List<Integer>[] dp =  new LinkedList[n-1];
//        int[] coins =  new int[]{1,5,10,25};
//        for(int i=0; i<n;i++){
//            for(int x : )
//        }
//
//    }


    //完全背包问题
    //https://leetcode.cn/problems/coin-lcci/
    //https://leetcode.cn/problems/coin-lcci/solution/bei-bao-jiu-jiang-ge-ren-yi-jian-da-jia-fen-xiang-/
    //解题思路理解：
    //dp[6] 的时候， 只能是11111+1 和1+5 （不能出现5+1， 否则重复），所以如果按照coins的大小先小后大排序完在累加成需要的dp数n
    //dp[n] =  dp[n] + dp[n-coins]
    public int waysToChange(int n) {
        int MOD = 10000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] coins = new int[]{1, 5, 10, 25};
        for (int c = 0; c < 4; c++) {
            int coin = coins[c];
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }
        return dp[n];
    }


}
