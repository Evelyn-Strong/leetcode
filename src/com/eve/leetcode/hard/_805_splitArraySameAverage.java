package com.eve.leetcode.hard;

import java.util.Arrays;

public class _805_splitArraySameAverage {

    //解题思路：
    //s/c= s1/c1 = s2/c2 推导出的数学公式
    //只要找到数组A的满足，那么B数组也会满足
    //问题转换成c1=1时候target=s/c,  c1 = 2的时候 target = 2*s/c, 等等的如此的几数之和的问题
    public boolean splitArraySameAverage(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int len = nums.length;
        double avr = (double) sum / (double) len;
        for (int n = 0; n < len - 1; n++) {
            double target = n * avr;
            if(target - (int) target == 0){
                if(findNSum(n,(int) target, nums)) return true;
            }
        }
        return false;

    }
    private boolean findNSum(int n, int target, int[] nums){
        //但是题目条件是要n<=30 这样的做法肯定会超时
        //转换成了背包算法
        //TODO再想
        return false;

    }
}
