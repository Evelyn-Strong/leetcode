package com.eve.leetcode.easy;

public class _1705_minOperations {

    public static int minOperations(String s) {
        int len = s.length();
        int count1 = 0, count2 = 0;
        int flag = 0;
        for (int i = 0; i < len; ++i) {
            count1 += Integer.valueOf(s.charAt(i)+"") ^ flag;
            flag = flag ^ 1;
            count2 += Integer.valueOf(s.charAt(i)+"") ^ flag;
        }
        return Math.min(count1,count2);

    }

    public static void main(String[] args) {
        System.out.println(minOperations("0100") );
    }
}
