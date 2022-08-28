package com.eve.leetcode.medium.search;

/**
 * Created by Eve on 2022/8/15.
 */
public class FindPeekElement {

    public static int findPeakElement(int[] nums) {
        int left ,right;
        if(nums.length<2) return 0;
        if(nums.length ==2){
            if (nums[0] > nums[1]) {
                return 0;
            }else{
                return 1;
            }
        }
        for(int i=1;i<nums.length-1;i++){
            left = nums[i-1];
            right = nums[i+1];
            if(nums[i]>left && nums[i]>right) return i;
        }
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-2]<nums[nums.length-1]) return nums.length-1;
        return 0;
    }

    //优化用2分法

    public static void main(String[] args) {

        int[] test = new int[]{1,2,3,4,3};

        System.out.println(findPeakElement(test));

    }
}
