package com.eve.leetcode.medium.array;

/**
 * Created by Eve on 2022/9/14.
 */
public class _33_search {

    //O(logn)
    //解题思路：二分法
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right == left) {
            return nums[0] == target ? 0 : -1;
        }

        while (right >= left) {
            if (right == left) {
                return nums[right] == target ? right : -1;
            }
            if (right - left == 1) {
                if (target == nums[right]) return right;
                if (target == nums[left]) return left;
                return -1;
            }
            int mid = (right - left) / 2 + left;
            if ((nums[mid] > nums[left] && target <= nums[mid] && target >= nums[left])
                    || (nums[mid] < nums[left]) && (target <= nums[mid] || target >= nums[left])) {
                right = mid;

            } else {
                left = mid + 1;
            }

        }
        return -1;

    }

    public static void main(String[] args) {

        System.out.println(search(new int[]{1, 2, 3}, 3));
    }
}
