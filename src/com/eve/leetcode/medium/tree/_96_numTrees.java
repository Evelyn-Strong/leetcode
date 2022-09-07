package com.eve.leetcode.medium.tree;

/**
 * Created by Eve on 2022/9/7.
 */

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class _96_numTrees {

    public static int numTrees(int n) {
        //dp[n]= dp[i-1]*dp[n-i-1];(如果选择i为root，i可以是从1->n)
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int  i = 2;i <= n ;i++){
            for(int j=1; j <= i; j++){
                dp[i] = dp[i] + (dp[j-1]*dp[i-j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(19));
    }
}
