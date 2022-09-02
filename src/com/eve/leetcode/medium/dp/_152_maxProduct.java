package com.eve.leetcode.medium.dp;

import java.util.Arrays;

/**
 * Created by Eve on 2022/9/1.
 */
public class _152_maxProduct {

    public static int maxProduct(int[] nums) {

        //dp解题思路：
        //dp[nums_len][2] : dp[i][0] max; dp[i][1] min;
        int len =  nums.length;
        int[][] dp = new int[len][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int ans = dp[0][0];
        for(int i = 1 ;i < len ; i++){
            helper(dp,nums,i);
            ans =  Math.max(ans,dp[i][0]);
        }

        return ans;

    }

    private static void helper(int[][] dp, int[] nums, int i){
        dp[i][0] = Math.max(Math.max(dp[i-1][0] * nums[i], dp[i-1][1] * nums[i]),nums[i]);
        dp[i][1] = Math.min(Math.min(dp[i-1][0] * nums[i], dp[i-1][1] * nums[i]),nums[i]);

    }

    /**
     * 空间优化，采用了滚动数组
     * @param nums
     * @return
     */
    public static int _maxProduct(int[] nums){

        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,-2};
        System.out.println(maxProduct(nums));
    }
}
