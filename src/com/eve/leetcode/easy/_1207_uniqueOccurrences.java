package com.eve.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class _1207_uniqueOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0)+ 1);
        }

        Integer sum = map.entrySet().stream().map(Map.Entry::getValue).distinct().mapToInt(Integer::intValue).sum();
        return arr.length == sum ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1,2}));
    }
}
