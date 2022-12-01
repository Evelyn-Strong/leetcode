package com.eve.leetcode.competition;

import java.util.*;

public class _20221103 {

    public static int minSum(List<Integer> num, int k) {
        int len = num.size();
        Integer[] sorted = num.toArray(new Integer[num.size()]);
        Arrays.sort(sorted);
        while(k>0){
           sorted[len-1] = Math.round(sorted[len-1]/2);
           Arrays.sort(sorted);
           k--;
        }
        return Arrays.stream(sorted).mapToInt(Integer::intValue).sum();
    }


}
