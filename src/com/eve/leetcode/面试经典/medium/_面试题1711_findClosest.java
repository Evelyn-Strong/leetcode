package com.eve.leetcode.面试经典.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 面试题 17.11. 单词距离
 * 中等
 * 95
 * 相关企业
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 *
 * words.length <= 100000
 */
public class _面试题1711_findClosest {

    public int findClosest(String[] words, String word1, String word2) {
        Map<String, List<Integer>> wmap = new HashMap<>();
        for(int i = 0; i < words.length;i++){
            List<Integer> ls = wmap.getOrDefault(words[i],new LinkedList<>());
            ls.add(i);
            wmap.put(words[i],ls);
        }
        int min = Integer.MAX_VALUE;
        for(int i : wmap.get(word1)){
            for(int j:wmap.get(word2)){
                if(i == j) continue;
                min = Math.min(min,Math.abs(i-j));
            }
        }
        return min;
    }

    //O(n) 双指针
    public int _findClosest(String[] words, String word1, String word2) {
        int length = words.length;
        int ans = length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;
    }



}
