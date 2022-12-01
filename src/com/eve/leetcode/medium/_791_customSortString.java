package com.eve.leetcode.medium;

import java.util.*;

public class _791_customSortString {

    public String customSortString(String order, String s) {
        Map<Character,Integer> map = new HashMap<>();
        int index = 0;
        for(Character c: order.toCharArray()){
            map.put(c,index);
            index++;
        }
        Queue<Character> queue =  new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.getOrDefault(o1,27) - map.getOrDefault(o2,27);
            }
        });

        for(Character c: s.toCharArray()){
            queue.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    //自定义排序方法
    public String _customSortString(String order, String s) {
        int[] val = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            val[order.charAt(i) - 'a'] = i + 1;
        }
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, (c0, c1) -> val[c0 - 'a'] - val[c1 - 'a']);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            ans.append(arr[i]);
        }
        return ans.toString();
    }

}
