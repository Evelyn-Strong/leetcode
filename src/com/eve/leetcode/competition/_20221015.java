package com.eve.leetcode.competition;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _20221015 {

    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int right = nums.length - 1;
        int left = 0;
        while (nums[left] < 0 && nums[right] > 0 && right > left) {
            if (Math.abs(nums[left]) == nums[right]) {
                return nums[right];
            } else if (Math.abs(nums[left]) > nums[right]) {
                left++;
            } else if (Math.abs(nums[left]) < nums[right]) {
                right--;
            }
        }
        return -1;
    }

    public int countDistinctIntegers(int[] nums) {

        Set<Integer> set = Arrays.stream(nums).distinct().boxed().collect(Collectors.toSet());
        Set<Integer> ans = Arrays.stream(nums).distinct().boxed().collect(Collectors.toSet());
        for (Integer n : set) {
            ans.add(flipnum(n));
        }
        return ans.size();
    }

    private static int flipnum(int n) {
        int sum = 0;
        while (n / 10 != 0) {
            sum = sum * 10 + n % 10;
            n = n / 10;
        }
        sum = n + sum * 10;
        return sum;
    }


    public static boolean sumOfNumberAndReverse(int num) {
        String snum = String.valueOf(num);
        int left = 0;
        int right = snum.length() - 1;
        boolean flag = false;
        if (Math.abs(snum.charAt(0) - snum.charAt(snum.length() - 1)) > 1 && snum.charAt(0) != '1') return false;
        int[] lefts = new int[2];
        if (snum.charAt(0) == '1') {
            lefts = new int[]{0, 1};
        } else {
            lefts = new int[]{0, 0};
        }
        boolean ans = true;
        for (int i = 0; i < 2; i++) {
            ans = true;
            flag = false;
            left = lefts[i];
            right = snum.length() - 1;
            while (left < right) {
                int flagnum = flag ? 1 : 0;
                if (snum.charAt(left) - snum.charAt(right) + flagnum == 0) {
                    flag = false;
                } else if (snum.charAt(left) - snum.charAt(right) + flagnum == 1) {
                    flag = true;
                } else {
                    ans = false;
                    break;
                }
                if (right == snum.length() - 1 && left == 1) {
                    flag = true;
                }
                left++;
                right--;
            }
            if (ans == false) {
                continue;
            }
            if (left == right) {
                int flagnum = flag ? 1 : 0;
                if ((snum.charAt(left) - flagnum) % 2 == 1) {
                    ans = false;
                    continue;
                }
            } else if (flag) {
                ans = false;
                continue;
            }
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        //System.out.println(flipnum(10));
        System.out.println(sumOfNumberAndReverse(443));
    }
}
