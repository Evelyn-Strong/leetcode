package com.eve.leetcode.medium.array;

/**
 * Created by Eve on 2022/9/16.
 */

import java.util.*;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _179_lagestNumber {
    /**
     *　解题思路：important ！！！！！
     *  进行排序， 两个数分别两成两个字符数组，然后开始从第一位 ，每一位逐个比较
     *  34534 ，与345 比较，前三位相同，会剩下34 与345 比较（较短的数会重回开头比较），那么接下来就是34与5 的比较， 这时候5 大于3 ，比较结束（当两位数不同时），
     *  如果相同就继续比较
     * @param nums
     * @return
     */

    public static String largestNumber(int[] nums) {

        int len = nums.length;
        if (len == 1) return nums[0] + "";
        Integer[] arr = new Integer[len];
        int idx = 0;
        for (int n : nums) {
            arr[idx] = n;
            idx++;
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer nums1, Integer nums2) {
                char[] ch1 = (nums1 + "").toCharArray();
                char[] ch2 = (nums2 + "").toCharArray();
                return helper(ch1, ch2, 0, 0);

            }
        });
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length-1; i >=0; i--) {
            sb.append(arr[i] + "");
        }
        if(sb.toString().charAt(0) == '0') return "0";

        return sb.toString();

    }

    private static int helper(char[] ch1, char[] ch2, int i, int j) {
        int len1 = ch1.length;
        int len2 = ch2.length;
        while (i < len1 && j < len2) {
            if (ch1[i] != ch2[j]) {
                return ch1[i] - ch2[j];
            } else {
                if (len1 > len2) {
                    if (j == len2 - 1) {
                        return helper(Arrays.copyOfRange(ch1, len2, len1), ch2, 0, 0);
                    } else {
                        i++;
                        j++;
                    }
                } else if (len1 < len2) {
                    if (i == len1 - 1) {
                        return helper(ch1, Arrays.copyOfRange(ch2, len1, len2), 0, 0);
                    } else {
                        i++;
                        j++;
                    }
                } else if (len1 == len2) {
                    if (i == len1 - 1) {
                        return ch1[i] - ch2[j];
                    } else {
                        i++;
                        j++;
                    }
                }
            }

        }
        return 0;

    }


   //大神的方法，直接通过string加后的字符进行比较
    public String _largestNumber(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        for(int x: nums) heap.offer(String.valueOf(x));
        String res = "";
        while(heap.size() > 0) res += heap.poll();
        if(res.charAt(0) == '0') return "0";
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{00,00};
        System.out.println(largestNumber(nums));
    }
}
