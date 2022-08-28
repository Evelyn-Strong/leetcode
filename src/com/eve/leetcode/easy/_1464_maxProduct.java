package com.eve.leetcode.easy;

/**
 * Created by Eve on 2022/8/26.
 */
public class _1464_maxProduct {



    //双指针

    public static  int maxProduct(int[] nums) {
        int max = -1;
        int max_1= -1;
        int left = 0;
        int right = nums.length-1;
        while (left < right ){
             if(nums[right] >= max) {
                 max_1= max;
                 max = nums[right];
             }else if(nums[right]>=max_1){
                 max_1 = nums[right];
             }

            if(nums[left] >= max) {
                max_1= max;
                max = nums[left];
            }else if(nums[left]>=max_1){
                max_1 = nums[left];
            }
            left++;
            right--;
        }
        if(nums.length%2==1){
            if(nums[left] >= max) {
                max_1= max;
                max = nums[left];
            }else if(nums[left]>=max_1){
                max_1 = nums[left];
            }
        }

        return (max-1)*(max_1-1);

    }

    public static void main(String[] args) {

        int[] nums = new int[]{3,4,5,2};
        System.out.println(maxProduct(nums));
    }

}
