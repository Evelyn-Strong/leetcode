package com.eve.leetcode.hard;

/**
 * Created by Eve on 2022/9/26.
 */
public class _面试题1719_missingTwo {


    //消失数的三种方法（求和，异或，原地hash）
    //https://leetcode.cn/problems/missing-two-lcci/solution/zhuan-zhi-xiao-shi-de-shu-de-san-chong-jie-fa-by-w/



    //原地hash
    //ans 是return不算额外空间
    public static int[] missingTwo(int[] nums) {
        int[] ans = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (Math.abs(nums[i]) <= len) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            } else {
                ans[Math.abs(nums[i]) - len - 1] = -1;
            }

        }
        for (int i = 0; i < 2; i++) {
            ans[i] =  ans[i]<0? -1:(len+i+1);
        }
        for (int i = 0; i < len; i++) {

            if (nums[i] > 0) {
                int index = 0;
                while (index < 2 && ans[index] > 0) {
                    index++;
                }
                ans[index] = i+1;

            }

        }

        return ans;

    }

    public static void main(String[] args) {
        missingTwo(new int[]{2,3});
    }
}
