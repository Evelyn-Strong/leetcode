package com.eve.leetcode.medium.array;

import java.util.HashMap;
import java.util.Map;

public class _523_checkSubarraySum {


    //0(n)
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 1; i <= len; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        for (int i = 0; i <= len; i++) {
            int index = i-1;
            int curSum = preSum[i+1];
            while(index >0 && curSum - preSum[index] % k != 0){
                index--;
            }
            if((index==0 && curSum - preSum[index] % k == 0 )|| index !=0 ) return true;
        }
        return false;
    }

    //前缀和 + hash表 （不错的题）
    public boolean _checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
