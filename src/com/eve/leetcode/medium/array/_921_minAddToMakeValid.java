package com.eve.leetcode.medium.array;

public class _921_minAddToMakeValid {

    public int minAddToMakeValid(String s) {

        //解题思路：
        //找到对称的括号对开始消除
       while(s != s.replace("()","")){
          s =s.replace("()","");
       }
        return s.length();
    }
}
