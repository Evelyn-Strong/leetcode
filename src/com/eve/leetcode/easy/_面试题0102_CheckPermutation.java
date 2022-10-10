package com.eve.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eve on 2022/9/27.
 */
public class _面试题0102_CheckPermutation {

    public static boolean CheckPermutation(String s1, String s2) {
        //hash & 计数法
        if (s1 == null || s2 == null) {
            return s1 == s2 ? true : false;
        }
        if (s1.length() != s2.length()) return false;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i) + "")) {
                map.put(s1.charAt(i) + "", map.get(s1.charAt(i) + "") + 1);
            } else {
                map.put(s1.charAt(i) + "", 1);
            }

            if (map.containsKey(s2.charAt(i) + "")) {
                map.put(s2.charAt(i) + "", map.get(s2.charAt(i) + "") - 1);
            } else {
                map.put(s2.charAt(i) + "", -1);
            }
        }
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if (entry.getValue() != 0) return false;
        }
        return true;
    }


    //排序
    //时间复杂度：O(nlogn)，其中 n 为 s1 的长度。
/*
        ​
    排序的时间复杂度为 O(nlogn)，比较两个字符串是否相等时间复杂度为 O(n)，因此总体时间复杂度为 O(nlogn)+O(n)=O(nlogn)。

    空间复杂度：O(logn)。排序需要 O(logn) 的空间复杂度。注意，在某些语言（比如 Java & JavaScript）中字符串是不可变的，
    因此我们需要额外的 O(n)O(n) 的空间来拷贝字符串。但是我们忽略这一复杂度分析，因为：

    这依赖于语言的细节；
    这取决于函数的设计方式，例如，可以将函数参数类型更改为 char[]。
*/
    public boolean _CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


    public static void main(String[] args) {
        CheckPermutation("adQ","adq");
    }
}
