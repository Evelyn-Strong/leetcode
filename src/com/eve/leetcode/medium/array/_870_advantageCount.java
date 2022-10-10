package com.eve.leetcode.medium.array;

import java.util.Arrays;

/**
 * 870. 优势洗牌
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 * <p>
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 * <p>
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length <= 105
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 109
 */
public class _870_advantageCount {
    //贪心+二分法
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;
        Arrays.sort(nums1);
        boolean[] visited = new boolean[len];
        int[] ans = new int[len];
        Arrays.fill(ans, 100001);
        for (int i = 0; i < len; i++) {
            int index = findIndex(nums1, visited, nums2[i]);
            if (index < len) {
                visited[index] = true;
                ans[i] = nums1[index];
            }
        }
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (ans[i] == 100001) {
                while (index < len && visited[index]) {
                    index++;
                }
                ans[i] = nums1[index];
                visited[index] = true;
            }
        }

        return ans;
    }

    //二分法
    private static int findIndex(int[] nums, boolean[] visited, int target) {
        int left = 0;
        int len = nums.length;
        int right = len - 1;
        int mid = left + (right - left) / 2;
        int index = 0;
        while (right > left) {
            if (right - left == 1) {
                if (nums[left] > target) {
                    index = left;
                } else {
                    index = right;
                }
                break;
            }
            if (nums[mid] <= target) {
                left = mid;
            }
            if (nums[mid] > target) {
                right = mid;
            }
            mid = left + (right - left) / 2;

        }
        while (index < len && (nums[index] <= target || visited[index])) {
            index++;
        }
        return index;
    }

    // sort index of nums1,nums2
    public int[] _advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; ++i) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                ans[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                ans[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //advantageCount(new int[]{12,24,8,32},new int[]{13,25,32,11});
        advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11});
    }
}
