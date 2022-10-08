package com.eve.leetcode.easy;

/**
 * 1784. 检查二进制字符串字段
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * <p>
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 * <p>
 * 如果 s 中 由连续若干个 '1' 组成的字段 数量不超过 1，返回 true​​​ 。否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1001"
 * 输出：false
 * 解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
 * 示例 2：
 * <p>
 * 输入：s = "110"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s[i]​​​​ 为 '0' 或 '1'
 * s[0] 为 '1'
 */
public class _1784_checkOnesSegment {

    public static boolean checkOnesSegment(String s) {

        String[] sa = s.split("0");
        int count = 0;
        for (String line : sa) {
            if (line.length() >= 1) {
                count++;
            }
            if (count >= 2) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkOnesSegment("1001"));
    }
}
