package com.eve.leetcode.medium.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eve on 2022/9/8.
 */
public class _416_canPartition {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum % 2==1) return false;
        sum = sum/2;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int i = 0; i< nums.length;i++ ){
            if(set.contains(sum-nums[i])) return true;
            Set<Integer> tmp = new HashSet<>();
            tmp.addAll(set);
            for(Integer s: tmp){
                set.add(s+nums[i]);
            }
        }

        return false;
    }

    //TODO dp方法

}
