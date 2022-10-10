package com.eve.leetcode.easy;

/**
 * Created by Eve on 2022/9/21.
 */
public class _69_mySqrt {
    //TODO

    public static int mySqrt(int x) {
        int ans = 1;
        while ((ans * ans) <= x) {
            if(ans == 46339){
                System.out.println("");
            }
            ans++;
        }

        return ans - 1;
    }


    public static void main(String[] args) {

        System.out.println(mySqrt(2147395600));

    }
}
