package com.eve.leetcode.面试经典.medium;

import java.util.*;
import java.util.stream.Stream;

public class _面试题1002_groupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            List<String> ls = new LinkedList<>();
            if (ans.containsKey(key)) {
                ls = ans.get(key);
            }
            ls.add(s);
            ans.put(key, ls);
        }
        List<List<String>> result =  new LinkedList<>();
        for(Map.Entry<String,List<String>> entry : ans.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
