package com.eve.leetcode.easy;

import java.util.Arrays;

/**
 * Created by Eve on 2022/9/12.
 */
public class _1608_specialArray {

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = len;
        int idx = len - 1;

        while (ans > 0 && idx >= 0) {
            if (len - idx == ans) return ans;
            if (nums[idx] < ans) {
                ans--;
                if (len - idx == ans) return ans;
                continue;

            } else {
                if (len - idx == ans) return ans;
                idx--;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{1, 0, 0, 6, 4, 9}));
        //System.out.println(specialArray(new int[]{3,5}));
    }
}
