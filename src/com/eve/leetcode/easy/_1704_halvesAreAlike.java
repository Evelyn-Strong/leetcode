package com.eve.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
public class _1704_halvesAreAlike {
    Set<Character> vowels = Arrays.stream(new Character[]{'a', 'e', 'i', 'o', 'u'}).distinct().collect(Collectors.toSet());

    public boolean halvesAreAlike(String s) {
        int count = 0;
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (vowels.contains(Character.valueOf(s.charAt(i)))) count++;
            if (vowels.contains(Character.valueOf(s.charAt(j)))) count--;
        }
        return count == 0 ? true : false;
    }
}
