package com.eve.leetcode.medium.array;

import java.util.*;

public class _15_threeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) break;
            for (int j = i + 1; j < len - 1; j++) {
                if (nums[i] + nums[j] > 0) break;
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] > 0) break;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> ls = new LinkedList<>(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]}));
                        if (!ans.contains(ls)) ans.add(ls);
                    }
                }
            }
        }
        return ans;
    }
}
