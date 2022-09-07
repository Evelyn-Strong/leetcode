package com.eve.leetcode.medium.dp;

/**
 * Created by Eve on 2022/9/6.
 */

import java.util.*;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

  

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

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/longest-consecutive-sequence
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _128_longestConsecutive {

    //查并集-Union Found
    public static int longestConsecutive(int[] nums) {

     Set<Integer> set  = new HashSet<>();
        for(int i =0 ; i < nums.length;i++){
            set.add(nums[i]);
        }
        int ans = 1;
        int cur = 1;
        for(int i: set){
            if(!set.contains(i-1)){
               while(set.contains(i+1)){
                   cur++;
                   ans =  Math.max(ans,cur);
                   i++;
               }
               cur = 1;
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

}
