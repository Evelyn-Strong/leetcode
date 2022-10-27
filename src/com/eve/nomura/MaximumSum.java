package com.eve.nomura;

import java.util.*;
import java.util.stream.Stream;

/**
 * 在数组中，两个树的各位digits相加和相等的两个数，return 最大和； 如果不存在之前描述条件的两个数，则返回-1
 */
public class MaximumSum {
    public static  int maximumSum(int[] A) {
        int max = -1;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int ds = digitsum(A[i]);
            if (map.containsKey(ds)) {
                for (int n : map.get(ds)) {
                    max = Math.max(max, n + A[i]);
                }

                List<Integer> ls = map.get(ds);
                ls.add(A[i]);
                map.put(ds,ls);

            } else {
                List<Integer> ls = new LinkedList<>();
                ls.add(A[i]);
                map.put(ds,ls);
            }

        }
        return max;
    }

    private static int digitsum(int num) {
        char[] ch = (num + "").toCharArray();
        int sum = 0;
        for (char c : ch) {
            sum += Integer.valueOf(c + "");
        }
        return sum;
    }

    public static void main(String[] args) {
       // System.out.println(digitsum(11));
        System.out.println(maximumSum(new int[]{51,32,37,71}));
    }
}
