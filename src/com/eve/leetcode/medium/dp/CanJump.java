package com.eve.leetcode.medium.dp;

import java.util.Arrays;

/**
 * Created by Eve on 2022/8/15.
 */
public class CanJump {

    //解题思路：
    //状态转移方程
    public static boolean canJump(int[] nums) {
        int index = 0;
        boolean[] visited =  new boolean[nums.length];
        visited[0] = true;

       return dp(nums,index,visited);

    }

    private static boolean dp(int[] nums,int index, boolean[] visited){
        boolean res =  false;
        if(visited[index]) return false;
        int steps =  nums[0];
        while (steps > 0){
            int tmpIndex = index;
            tmpIndex +=steps;
            visited[tmpIndex]=true;
            int[] tmp = Arrays.copyOfRange(nums,steps, nums.length);
            if(nums.length-1 <= steps) return true;
            else{
                res = dp(tmp,tmpIndex,visited);
            }
            if(!res) steps--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};

        System.out.println(canJump(nums));

    }
}
