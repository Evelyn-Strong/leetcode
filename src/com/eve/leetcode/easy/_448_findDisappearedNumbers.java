package com.eve.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Eve on 2022/9/8.
 */

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[2]
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _448_findDisappearedNumbers {


    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[nums[i] - 1]++;
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) {
                ans.add(i + 1);
            }

        }

        return ans;

    }

    //TODO 进阶O(1)空间
    public List<Integer> _findDisappearedNumbers(int[] nums) {
        //如果某个数据是重读出现的那么其中只留一个数
        //ans 不算在空间中
        //元素组hash，当遍历过后数据为复数（或者加n取模操作）
        List<Integer> ans = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1] > 0 ){
                nums[Math.abs(nums[i])-1] = - nums[Math.abs(nums[i])-1];
            }
        }

        for(int i=0;i<nums.length;i++) {
            if(nums[i]<0){
               ans.add(i+1);
            }
        }
        return ans;

    }


}
