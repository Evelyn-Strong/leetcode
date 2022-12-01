package com.eve.leetcode.medium.array;

import java.util.*;

/**
 * 792. 匹配子序列的单词数
 * 中等
 * 278
 * 相关企业
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * <p>
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * <p>
 * 例如， “ace” 是 “abcde” 的子序列。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * Example 2:
 * <p>
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 */
public class _792_numMatchingSubseq {
    //会超时
    public static int numMatchingSubseq(String s, String[] words) {
        int res = 0;
        Queue<int[]>[] p = new Queue[26];
        for (int i = 0; i < 26; i++) {
            p[i] = new ArrayDeque<int[]>();
        }
        //将每一个word字符串的首字母加到p的数组里
        for (int i = 0; i < words.length; ++i) {
            p[words[i].charAt(0) - 'a'].offer(new int[]{i, 0});
        }
        //遍历s，将符合的字符串匹配到对应字符
        for (char c : s.toCharArray()) {
            Queue<int[]> q = p[c - 'a'];
            int len = q.size();
            //所有符合这个字符的字符串都进行判断
            while (len > 0) {
                int[] t = q.poll();
                //如果已经是字符串的最后一位match，那么res++
                if (t[1] == words[t[0]].length() - 1) {
                    ++res;
                    //如果不是，那么将字符串中的后一位放入queue中。
                } else if (t[1] + 1 < words[t[0]].length()) {
                    ++t[1];
                    p[words[t[0]].charAt(t[1]) - 'a'].offer(t);
                }
                --len;
            }
        }
        return res;

    }

//    private static boolean isSubseq(String s, String word) {
//        int idx = 0;
//        char[] ch = word.toCharArray();
//        for (int i = 0; i < ch.length; i++) {
//            while (idx < s.length() && s.charAt(idx) != ch[i]) {
//                idx++;
//            }
//            if (i == ch.length - 1 && idx < s.length()) return true;
//            idx++;
//            if (idx >= s.length() && i < ch.length) return false;
//        }
//        return false;
//    }

    //预处理+hash+二分
    public int _numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        //先将s拆解放入字符串组（26位）
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        //循环遍历word 是不是s的字串
        for (String w : words) {
            if (w.length() > s.length()) {
                --res;
                continue;
            }
            int p = -1;
            //word的每一位递增去差是否在hash数组中，
            // 并且对应的index（p）是不是存在 且 必须比当前index要大（用二分查找法，找到最近的符合条件的index）
            for (int i = 0; i < w.length(); ++i) {
                char c = w.charAt(i);
                if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    --res;
                    break;
                }
                p = binarySearch(pos[c - 'a'], p);
            }
        }
        return res;
    }

    public int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }

    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }



}
