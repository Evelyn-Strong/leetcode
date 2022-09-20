package com.eve.leetcode.面试经典.medium;

/**
 * Created by Eve on 2022/9/19.
 */
public class _0105_oneEditAway {

    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) return false;
        int diff = 0;
        char[] f = first.toCharArray();
        char[] s = second.toCharArray();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (f[i] == s[j]) {
                i++;
                j++;
            } else {
                if (len1 > len2) {
                    i++;
                } else if (len1 < len2) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                diff++;
                if (diff > 1) return false;
            }
        }
        return true;

    }
}
