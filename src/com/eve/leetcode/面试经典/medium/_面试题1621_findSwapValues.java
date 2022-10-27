package com.eve.leetcode.面试经典.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class _面试题1621_findSwapValues {

    public int[] findSwapValues(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        if((sum1+sum2) % 2 ==1) return new int[]{};
        int avr = (sum1+sum2)/2;
        int target =  sum1 - avr;
        Set<Integer> set = new HashSet<>();
        for(int i  = 0; i < array1.length; i++){
           set.add(array1[i] - target);
        }
        for(int j = 0; j < array2.length;j++){
            if (set.contains(array2[j])){
                return new int[]{array2[j]+target, array2[j]};
            }
        }
        return new int[]{};
    }

}
