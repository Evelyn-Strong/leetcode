package com.eve.leetcode.medium.array;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class _799_kthGrammar {

    public  static int kthGrammar(int n, int k) {
        List<Integer> ls = new LinkedList<>();
        while (k > 1) {
            ls.add(k % 2);
            k = k / 2;
        }
        int[] cal = new int[2];
        cal[0] = 0;
        cal[1] = 1;
        Integer[] arr = ls.stream().toArray(Integer[]::new);
        if(Stream.of(arr).mapToInt(Integer::intValue).sum()-arr[arr.length-1] == 0 && arr.length > 2) return 0;
        for (int i = arr.length-1; i >=0; i--) {
            if (arr[i] == 0) {
                if(cal[0] != 0){
                    cal[0] = 1;
                    cal[1] = 0;
                }
            }else{
               int tmp = cal[0];
               cal[0] = cal[1];
               cal[1] = tmp;
            }
            if(i == 0) return cal[arr[i]];
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(2,4));
    }
}
