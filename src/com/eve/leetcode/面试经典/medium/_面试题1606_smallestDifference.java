package com.eve.leetcode.面试经典.medium;

import java.util.Arrays;

public class _面试题1606_smallestDifference {

    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int ptra = 0;
        int ptrb = 0;
        long min = Integer.MAX_VALUE;
        while(ptra != a.length && ptrb != b.length){
            if(ptra < a.length && ptrb < b.length){
                if(a[ptra] < b[ptrb]){
                    min = Math.min(min,(long)b[ptrb]-(long)a[ptra]);
                    ptra++;
                }else{
                    min = Math.min(min,(long)a[ptra]-(long)b[ptrb]);
                    ptrb++;
                }
            }
        }
        return (int) min;
    }

    public static void main(String[] args) {
        System.out.println(smallestDifference(new int[]{-2147483648,1},new int[]{2147483647,0}));
    }
}
