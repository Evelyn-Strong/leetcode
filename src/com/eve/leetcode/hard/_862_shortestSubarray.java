package com.eve.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _862_shortestSubarray {

    //状态转移方程：
    // dp[n] = min(dp[n-1],(n-i+1)), ps:sum(nums[n]....nums[i])=k
    // 单调递归栈：
    // 当
    public int shortestSubarray(int[] nums, int k) {

        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 1; i < len; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        int min = Integer.MAX_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i <= len; i++) {
            int curSum = preSum[i];
            while (!stack.isEmpty() && curSum - preSum[stack.peekFirst()] >= k) {
                min = Math.min(min, i - stack.pollFirst());
            }
            while (!stack.isEmpty() && preSum[stack.peekLast()] >= curSum) {
                stack.pollLast();
            }
            stack.offerLast(i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
