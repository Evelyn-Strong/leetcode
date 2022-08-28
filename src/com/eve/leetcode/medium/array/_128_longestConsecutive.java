package com.eve.leetcode.medium.array;

/**
 * Created by Eve on 2022/8/17.
 *
 */

import java.util.*;

/**
 * 128. 最长连续序列
 难度
 中等

 1366





 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。



 示例 1：

 输入：nums = [100,4,200,1,3,2]
 输出：4
 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 示例 2：

 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 输出：9


 提示：

 0 <= nums.length <= 105
 -109 <= nums[i] <= 109
 */

public class _128_longestConsecutive {

//    public static int longestConsecutive(int[] nums) {
//
//        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//
//        for(int i=0;i<nums.length;i++){
//            queue.offer(nums[i]);
//        }
//
//        int before =  queue.poll();
//        int len = 1;
//        int max = -1;
//        while(queue.size()>0){
//            int next =  queue.poll();
//            if(next-before == 1){
//                len++;
//                if(len>max) max = len;
//            }else{
//                before = next;
//                len = 1;
//            }
//        }
//
//        return max;
//    }

    public static int longestConsecutive(int[] nums){
        Set<Integer> num_set = new HashSet<>();
        for(int num : nums){
            num_set.add(num);
        }
        int longestStreak = 0;

        for(int num : num_set){
            if(!num_set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                while(num_set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums =  new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

}
