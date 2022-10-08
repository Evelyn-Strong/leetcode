package com.eve.leetcode.easy;


public class _面试题0109_isFlipedString {


    //搜索字符串
    public boolean isFlipedString(String s1, String s2) {
       if(s1.length() != s2.length()) return false;
       String s = s2+s2;
       return s.contains(s1)? true: false;
    }
}
