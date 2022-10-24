package com.eve.leetcode.medium.array;

public class _915_partitionDisjoint {

    public int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] minArr = new int[len];
        int[] maxArr = new int[len];
        maxArr[0] = nums[0];
        minArr[len - 1] = nums[len - 1];
        for (int i = 1, j = len - 2; i < len && j >= 0; i++, j--) {
            maxArr[i] = Math.max(maxArr[i - 1], nums[i]);
            minArr[j] = Math.min(minArr[j + 1], nums[j]);
        }
        for(int i = 0 ; i < len-1 ;i++){
            if(maxArr[i]<=minArr[i+1]){
                return i+1;
            }
        }
        return len;
    }

    public int _partitionDisjoint(int[] nums) {
        int len = nums.length;
        int leftPos = 0,maxLeft = nums[0],currentMax = nums[0];
        for(int i =1; i < len-1;i++){
            currentMax = Math.max(nums[i],currentMax);
            if(nums[i]<maxLeft){
                leftPos = i;
                maxLeft = currentMax;
            }
        }
        return leftPos+1;
    }

}
