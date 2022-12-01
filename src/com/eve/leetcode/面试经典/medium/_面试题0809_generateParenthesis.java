package com.eve.leetcode.面试经典.medium;

import java.util.*;

public class _面试题0809_generateParenthesis {
    // (a)b
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        if (n == 0) return null;
        else {
            for (int i = 0; i <= n - 1; i++) {
                if (generateParenthesis(i) == null && generateParenthesis(n - 1 - i) == null) {
                    return Arrays.asList(new String[]{"()"});
                } else if (generateParenthesis(i) == null) {
                    for (String s : generateParenthesis(n - 1 - i)) {
                        ans.add("()" + s);
                    }
                } else if (generateParenthesis(n - 1 - i) == null) {
                    for (String s : generateParenthesis(i)) {
                        ans.add("(" + s + ")");
                    }
                } else {
                    for (String a : generateParenthesis(i)) {
                        for (String b : generateParenthesis(n - i - 1)) {
                            ans.add("(" + a + ")" + b);
                        }
                    }
                }

            }
        }
        return ans;
    }
}
