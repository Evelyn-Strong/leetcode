package com.eve.leetcode.medium.array;

import java.util.Arrays;

/**
 * Created by Eve on 2022/9/3.
 */
public class _287_findDuplicate {




    public int findDuplicate(int[] nums) {


        for(int i = 0 ; i< nums.length;  i++){
             for (int j = i+1; j< nums.length; j++){
                 if(nums[j]== nums[i]) return nums[i];
             }

        }

        return nums[0];
    }


    public int _findDuplicate(int[] nums) {

        Arrays.sort(nums);
        for(int i=1 ; i <nums.length; i++){
            if(nums[i]==nums[i-1]) return nums[i];
        }
        return 0;

    }

    //快慢指针
    //环形链表
    public int __findDuplicate(int[] nums){
        int slow = 0 , fast = 0;
        do {
            slow =  nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        slow = 0;
        while(slow != fast){
            slow =  nums[slow];
            fast =  nums[fast];

        }

        return slow;
    }
}
