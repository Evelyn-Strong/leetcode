package com.eve.leetcode.medium.array;

import java.math.BigDecimal;

public class _166_fractionToDecimal {

    //TODO
    public static String fractionToDecimal(int numerator, int denominator) {
        long a = numerator,b=denominator;
        //有循环bigDecimal处理不了。
        BigDecimal num =  BigDecimal.valueOf(numerator).divide(BigDecimal.valueOf(denominator));
        String snum = num.toString();

        return snum;
    }

    public static void main(String[] args) {
        fractionToDecimal(4,8);
    }
}
