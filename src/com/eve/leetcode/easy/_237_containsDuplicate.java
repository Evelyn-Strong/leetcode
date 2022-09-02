package com.eve.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eve on 2022/9/1.
 */
public class _237_containsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set  = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;
    }
}
