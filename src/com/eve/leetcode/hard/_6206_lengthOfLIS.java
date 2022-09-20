package com.eve.leetcode.hard;

import java.util.Arrays;

/**
 * Created by Eve on 2022/9/11.
 */

/**
 * 6206. 最长递增子序列 II 显示英文描述
 通过的用户数509
 尝试过的用户数2336
 用户总通过次数625
 用户总提交次数6663
 题目难度Hard
 给你一个整数数组 nums 和一个整数 k 。

 找到 nums 中满足以下要求的最长子序列：

 子序列 严格递增
 子序列中相邻元素的差值 不超过 k 。
 请你返回满足上述要求的 最长子序列 的长度。

 子序列 是从一个数组中删除部分元素后，剩余元素不改变顺序得到的数组。



 示例 1：

 输入：nums = [4,2,1,4,3,4,5,8,15], k = 3
 输出：5
 解释：
 满足要求的最长子序列是 [1,3,4,5,8] 。
 子序列长度为 5 ，所以我们返回 5 。
 注意子序列 [1,3,4,5,8,15] 不满足要求，因为 15 - 8 = 7 大于 3 。
 示例 2：

 输入：nums = [7,4,5,1,8,12,4,7], k = 5
 输出：4
 解释：
 满足要求的最长子序列是 [4,5,8,12] 。
 子序列长度为 4 ，所以我们返回 4 。
 示例 3：

 输入：nums = [1,5], k = 1
 输出：1
 解释：
 满足要求的最长子序列是 [1] 。
 子序列长度为 1 ，所以我们返回 1 。


 提示：

 1 <= nums.length <= 105
 1 <= nums[i], k <= 105
 */

//TODO 功能实现了， 但是还需要优化
public class _6206_lengthOfLIS {

    public static int lengthOfLIS(int[] nums, int k) {

        int[] dp = new int[nums.length];
        int[] maxV = new int[nums.length];
        maxV[0] = 1;
        Arrays.fill(dp, 1);
        int max = maxV[0];

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] > 0 && nums[i] - nums[j] <= k) {
                    if (dp[j] == maxV[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                        break;
                    } else {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
            max = Math.max(dp[i], max);
            maxV[i] = max;
        }


        return maxV[nums.length - 1];

    }
}
