package com.eve.leetcode.medium.array;

import java.util.*;

/**
 * Created by Eve on 2022/7/31.
 */
public class LengthOfLongestSubstring {

    //解题思路：
    //双指针
    //滑动窗口

    public static int lengthOfLongestSubstring(String s) {

        char[] sc = s.toCharArray();
        int len =  sc.length;
        int max = 0;
        for(int i=0;i<len;i++){
            List<String> sl =  new LinkedList<>();
            sl.add(String.valueOf(sc[i]));
            for(int j=i+1;j<len;j++){
                if(!sl.contains(String.valueOf(sc[j]))){
                    sl.add(String.valueOf(sc[j]));
                    if(max<sl.size()){
                        max=sl.size();
                    }
                }else{
                    if(max<sl.size()){
                        max=sl.size();
                    }
                    break;
                }
            }
            if(max<sl.size()){
                max=sl.size();
            }
        }
        return max;

    }

    public static void main(String[] args) {

        String test ="aab";
        System.out.println(lengthOfLongestSubstring(test));

    }

    //比较的方法Math.max库等
}
