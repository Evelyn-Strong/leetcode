package com.eve.leetcode.medium.array;

/**
 * Created by Eve on 2022/9/8.
 */

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _238_productExceptSelf {
    //难点o(n)
    //解题思路：空间换时间
    //双指针：从前往后的乘积，一个从后往前的乘积 （左右乘积）
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[len - 1];
        right[0] = nums[0];
        for (int i = 1, j = len - 2; i < len && j >= 0; i++, j--) {
            left[i] = nums[j] * left[i - 1];
            right[i] = nums[i] * right[i - 1];
        }
        int[] ans  =  new int[len];
        ans[0] = left[len-2];
        ans[len-1] = right[len-2];
        for (int i=1; i<len-1;i++){
            ans[i]= right[i-1] * left[len-i-2];
        }

        return ans;

    }
}
