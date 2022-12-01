package com.eve.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class _1742_countBalls {

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer,Integer> map =  new HashMap<>();
        for (int i = lowLimit; i <= highLimit; ++i) {
            int k = sum(i);
            map.put(k,map.getOrDefault(k,0)+1);
        }
        int max = 0;
        int res = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > max) res = entry.getKey();
        }
        return res;
    }
    private int sum(int i){
       char[] ch = (i+"").toCharArray();
       int ans = 0;
       for(char c : ch){
           ans += Integer.valueOf(c+"");
       }
       return ans;
    }
}
