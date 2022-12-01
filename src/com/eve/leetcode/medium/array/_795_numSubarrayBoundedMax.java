package com.eve.leetcode.medium.array;


public class _795_numSubarrayBoundedMax {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int last1 = -1, last2 = -2, res = 0;
        for (int i = 0; i < nums.length; ++i) {
           if(left <= nums[i] && right >= nums[i]){
               last1= i;
           }else if(right < nums[i]){
               last1 = -1;
               last2 = i;
           }
            if(last1 != -1 ){
                res += last1-last2;
            }
        }
        return res;
    }
}
