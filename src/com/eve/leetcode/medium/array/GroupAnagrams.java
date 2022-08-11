package com.eve.leetcode.medium.array;

import java.util.*;

/**
 * Created by Eve on 2022/7/31.
 */
public class GroupAnagrams {

    /*
    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvaszc/
    */
    //解题思路：
    //每个string变成array，sort后重组成key
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map =  new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String k = String.valueOf(c);
            if(map.containsKey(k)){
                List<String> l = map.get(k);
                l.add(s);
                map.put(k,l);
            }else{
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(k,l);
            }
        }

        map.forEach((k,v)->{
            res.add(v);
        });

        return res;

    }

    public static void main(String[] args) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));

    }

}
