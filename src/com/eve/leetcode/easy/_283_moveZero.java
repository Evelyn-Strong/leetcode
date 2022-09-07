package com.eve.leetcode.easy;

/**
 * Created by Eve on 2022/9/6.
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _283_moveZero {


    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count++;
        }
        int idx = 0;
        while (idx < nums.length-count) {
            if (nums[idx] == 0) {
                for (int j = idx; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
            } else {
                idx++;
            }
        }
    }


    //double pointer alg
    public static void _moveZeroes(int[] nums) {

    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 0, 1});
    }
}
