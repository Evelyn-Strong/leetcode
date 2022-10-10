package com.eve.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eve on 2022/9/23.
 */
public class _1_twoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}
