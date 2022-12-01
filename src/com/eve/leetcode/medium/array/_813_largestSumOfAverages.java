package com.eve.leetcode.medium.array;

import java.util.Arrays;

public class _813_largestSumOfAverages {

    public static double largestSumOfAverages(int[] nums, int k) {
        double sum = 0;
        double maxavr = 0;
        if(k == 1){
            return (double)Arrays.stream(nums).sum()/(double)nums.length;
        }
        for (int i = 0; i < nums.length - k + 1; ++i) {
            sum += nums[i];
            double avr1 = sum / (double) (i + 1);
            maxavr = Math.max(maxavr, avr1 + largestSumOfAverages(Arrays.copyOfRange(nums, i + 1, nums.length),k-1));
        }
        return maxavr;
    }

    public static void main(String[] args) {

        System.out.println(largestSumOfAverages(new int[]{4663,3020,7789,1627,9668,1356,4207,1133,8765,4649,205,6455,8864,3554,3916,5925,3995,4540,3487,5444,8259,8802,6777,7306,989,4958,2921,8155,4922,2469,6923,776,9777,1796,708,786,3158,7369,8715,2136,2510,3739,6411,7996,6211,8282,4805,236,1489,7698},27));
    }
}
