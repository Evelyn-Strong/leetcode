package com.eve.leetcode.medium.array;

import java.util.LinkedList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * 中等
 * 426
 * 相关企业
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * <p>
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 示例 2:
 * <p>
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 */
public class _784_letterCasePermutation {

    public static List<String> letterCasePermutation(String s) {
        List<String> ls = new LinkedList<>();
        String o = s.charAt(0) + "";
        if (!(s.charAt(0) - '0' <= 9 && s.charAt(0) - '0' >= 0)) {
            ls.add(o);
            ls.add(o.equals(o.toLowerCase()) ? o.toUpperCase() : o.toLowerCase());

        } else {
            ls.add(o);
        }
        for (int i = 1; i < s.length(); i++) {
            List<String> tmp = new LinkedList<>();
            if (!(s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 0)) {
                for (String x : ls) {
                    String c = s.charAt(i) + "";
                    tmp.add(x + c);
                    tmp.add(c.equals(c.toLowerCase()) ? x + c.toUpperCase() : x + c.toLowerCase());
                }

            } else {
                for (String x : ls) {
                    tmp.add(x + s.charAt(i));
                }
            }
            ls.clear();
            ls.addAll(tmp);
            tmp = null;
        }
        return ls;
    }

    public static void main(String[] args) {
        letterCasePermutation("3z4");
    }
}
