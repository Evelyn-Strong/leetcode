package com.eve.leetcode.medium.dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by Eve on 2022/8/24.
 */
public class _22_generateParenthesis {

    //解题思路
    //dp【】中元素应该是
    //数学归纳 当n时，= （a）b ，a+b=n-1的组合

    static Map<Integer,List<String>> cache = new HashMap<>();

    public static List<String> generateParenthesis(int n) {

       return _generate(n);


    }

    private static List<String> _generate(int n){
        List<String> res =  new LinkedList<>();

        if(n==0) {
           res.add("");

        }

        if(cache.containsKey(n)){
            return cache.get(n);
        }



        for(int c=0; c<n;c++){

            for(String left: _generate(c)){

                for(String right: _generate(n-c-1)){

                    res.add("("+left+")"+ right);
                }

            }

        }
        cache.put(n,res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
