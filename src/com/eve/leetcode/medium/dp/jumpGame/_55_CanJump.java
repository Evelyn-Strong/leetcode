package com.eve.leetcode.medium.dp.jumpGame;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _55_CanJump {
    //解题思路
    //只有当数组中有0（不为最后），且所有的跳转方案只会到0这个下标的时候才会使无法跳转到最后
    //如果找到0 后， 往后倒序看是否可以超过0 （ℹ）跳转到i+1的位置
    public static boolean canJump(int[] nums) {
        List<Integer> ls = new LinkedList<>();
        int len = nums.length;
        if (len == 1) return true;
        if (nums[0] == 0) return false;
        for (int i = 1; i < len; i++) {
            if (nums[i] == 0 && i != len - 1) {
                ls.add(i);
            }
        }
        if (ls.size() == 0) return true;
        else {
            int right = 0;
            for (int i : ls) {
                right = i + 1;
                if (!_jump(nums, right)) return false;
            }
        }
        return true;
    }

    private static boolean _jump(int[] nums, int right) {
        for (int i = right - 2; i >= 0; i--) {
            if (nums[i] + i >= right) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5}));
        // canJump(new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5});
    }
}
