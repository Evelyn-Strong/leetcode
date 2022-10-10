package com.eve.leetcode.medium.iterator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eve on 2022/9/20.
 * <p>
 * 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 每个元素的频率在 [1,4] 范围内
 */

//TODO
public class _698_canPartitionKSubsets {


    //状态压缩和回溯
    public boolean canPartitionKSubsets(int[] nums, int k) {

        Arrays.sort(nums);
        int all = Arrays.stream(nums).sum();//参考
        if (all % k != 0) return false;
        int per = all / k;
        int len = nums.length;
        boolean[] dp = new boolean[len];
        if (nums[len - 1] > per) return false;
        int count = 0;
        if (dfs(nums, dp, len - 1, per, 0)) {
            if (count == k) return true;
        }
        return false;


    }

    private static boolean dfs(int[] nums, boolean[] dp, int cur, int per, int count) {
        while (cur >= 0) {
            if (dp[cur] == true) {
                cur--;
            } else {
                if (nums[cur] == per) {
                    count++;
                    dp[cur] = true;
                    return dfs(nums, dp, cur - 1, per, count);
                } else if (nums[cur] > per) {
                    cur--;
                } else if (nums[cur] < per) {

                    return dfs(nums, dp, cur - 1, per - nums[cur], count);
                }
            }

        }

        return false;

    }


    public static int[] numUsed;
    public static boolean _canPartitionKSubsets(int[] nums, int k) {
        numUsed = new int[nums.length];
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0 || nums[nums.length - 1] > sum / k) return false;
        return divideGroups(nums, nums.length - 1, sum / k, 0, k);
    }

    public static boolean divideGroups(int[] nums, int start, int target, int current, int k) {
        // 分组操作执行k-1次之后，最后剩余的元素，就是最后一组了，不需要再匹配
        if (k == 1) return true;
        // 分组操作执行k-1次后，最后剩余的元素，就是最后一组了，不需要再匹配
        if (current == target)
            return divideGroups(nums, nums.length - 1, target, 0, k - 1);
        for (int i = start; i >= 0; i--) {
            // 被使用的元素，不能再次使用；总和大于目标值，也不能使用
            if (numUsed[i] == 1 || current + nums[i] > target) continue;
            numUsed[i] = 1; // 标记占用
            if (divideGroups(nums, i - 1, target, current + nums[i], k)) return true;
            numUsed[i] = 0; // 撤销标记
            // 例如“12333333...”，假如最右侧的“3”这个值没有匹配上，那么它左侧的剩余五个“3”都不需要再匹配了。
            while (i > 0 && nums[i - 1] == nums[i]) i--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(1<<10);

        System.out.println(10>>1);
    }

}
