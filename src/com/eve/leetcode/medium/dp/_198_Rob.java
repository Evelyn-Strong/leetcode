package com.eve.leetcode.medium.dp;

/**
 * Created by Eve on 2022/8/19.
 */
public class _198_Rob {

    public int rob(int[] nums) {

        int[] dp = new int[nums.length];

        for(int i = 0 ; i< nums.length; i++){
            dp(dp,nums,i);
        }

        return dp[nums.length-1];

    }
    //状态转移方程
    //f(n)=max(f(n-1),f(n-2)+num[n])
    //注意边界f0，f1
    private int dp(int[] dp, int[] num, int i){
        if(i==0) {
            return dp[0]=num[0];
        } else if( i==1 ){
            return dp[1] = Math.max(num[0],num[1]);
        } else {
            return dp[i] = Math.max(dp[i-1],dp[i-2]+num[i]);
        }

    }
    //test 这才得劲 好像输入
}
