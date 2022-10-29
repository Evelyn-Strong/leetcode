package com.eve.leetcode.面试经典.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _面试题1610_maxAliveYear {

    public static int maxAliveYear(int[] birth, int[] death) {
        int pnum = birth.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < pnum; i++) {
            set.add(birth[i]);
            set.add(death[i]);
        }
        Integer[] years = set.toArray(new Integer[set.size()]);
        Arrays.sort(years);
        Arrays.sort(birth);
        Arrays.sort(death);
        int max = 0;
        int ans = 0;
        for (int i = 0; i < years.length; i++) {
            int alive = binarySearch(years[i], birth, true) - binarySearch(years[i], death, false);
            if (alive > max) {
                ans = years[i];
                max = alive;
            }
        }
        return ans;
    }

    private static int binarySearch(int target, int[] arr, boolean alive) {
        int left = 0;
        int right = arr.length - 1;
        int mid = left + (right - left) / 2;
        while (left < right) {
            if (right - left == 1) {
                if (alive) {
                    if (arr[right] <= target) return right + 1;
                    else return left + 1;
                } else {
                    if (target > arr[right]) return right + 1;
                    else if (target <= arr[right] && target > arr[left]) return left + 1;
                    else if (target == arr[left]) return left;
                }
            }
            if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
            mid = left + (right - left) / 2;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(maxAliveYear(new int[]{1900, 1901, 1950}, new int[]{1950, 1951, 2000}));
    }
}
