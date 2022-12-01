package com.eve.leetcode.easy;

import java.util.Arrays;

public class _1662_arrayStringsAreEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
       // return Arrays.stream(word1).reduce((a,b)-> a+b).get().equals(Arrays.stream(word2).reduce((a,b)-> a+b).get());
       return String.join("",word1).equals(String.join("",word2));
    }
}
