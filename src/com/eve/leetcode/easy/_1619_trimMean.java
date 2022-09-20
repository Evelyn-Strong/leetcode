package com.eve.leetcode.easy;

import java.util.Arrays;

/**
 * Created by Eve on 2022/9/14.
 */
public class _1619_trimMean {

    public double trimMean(int[] arr) {
        int len =  arr.length;
        int left =  len/20;
        int right =  len-1-len/20;
        Arrays.sort(arr);
        double sum = 0;
        for(int i =left; i<=right;i++){
           sum += arr[i];
        }

        return (double)sum/(right-left+1);

    }
}
