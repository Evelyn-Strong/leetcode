package com.eve.leetcode.medium.array;

import java.util.Stack;

/**
 * Created by Eve on 2022/8/1.
 */
public class LongestPalindrome {

    //解题思路
    //最长回文字符串
    //滑动窗口
    //Stack

    public static String longestPalindrome(String s) {

        char[] sc = s.toCharArray();
        int len =  s.length();
        boolean sym = false;
        int maxlen = 0;

        String result = "";
        for(int i = 0 ; i < len ; i++){
            int idx=1;
            Stack<String> temp = new Stack<>();
            if(maxlen/2 + i >=len){
                break;
            }

            while(i+idx<len && i-idx>=1){
                //奇数对称
                if(sc[i-idx+1] == sc[i+idx+1]){
                    sym = false;
                    if(idx==i){
                      temp.push(String.valueOf(sc[i]));
                    }
                    temp.push(String.valueOf(sc[i-idx]));
                    idx++;
                    continue;
                }
                //偶数对称
                if(sc[i-idx+1] == sc[i+idx]) {
                    sym = true;
                    temp.push(String.valueOf(sc[i]));
                    idx++;
                    continue;

                }
                break;
            }

            if(sym){
                int size = temp.size()*2-1;
                if(Math.max(size,maxlen)==size){

                }
            }else{
                int size = temp.size()*2;
                if(Math.max(size,maxlen)==size){

                }
            }

        }

        return result;


    }

    public static void main(String[] args) {

        String s =  "abb";
        System.out.println(longestPalindrome(s));

    }
}
