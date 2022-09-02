package com.eve.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eve on 2022/9/1.
 */
public class _202_isHappy {

    public static boolean isHappy(int n) {
        Set<Integer> set =  new HashSet<>();
        set.add(n);
        while(true){
            int next =  bitPlus(n);
            if(next == 1) return true;
            if(set.contains(next)) return false;
            n = next;
            set.add(next);
        }

    }

    private static int bitPlus(int n){
        int sum=0;
        while(n/10 !=0){
            sum = (n%10)*(n%10)+sum;
            n=n/10;
        }
        sum += n*n ;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(21));
    }


}
