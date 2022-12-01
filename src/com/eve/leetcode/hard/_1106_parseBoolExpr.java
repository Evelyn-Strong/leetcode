package com.eve.leetcode.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _1106_parseBoolExpr {

    public static boolean parseBoolExpr(String expression) {
        switch (expression.charAt(0)) {
            case '!':
                return notExpress(parseBoolExpr(expression.substring(2, expression.length() - 1)));
            case '&': {
                String[] expressions = splitExpress(expression.substring(2, expression.length() - 1));
                Boolean[] res = new Boolean[expressions.length];
                int i = 0;
                for (String e : expressions) {
                    res[i] = parseBoolExpr(e);
                    i++;
                }
                return andExpress(res);
            }
            case '|': {
                String[] expressions = splitExpress(expression.substring(2, expression.length() - 1));
                Boolean[] res = new Boolean[expressions.length];
                int i = 0;
                for (String e : expressions) {
                    res[i] = parseBoolExpr(e);
                    i++;
                }
                return orExpress(res);
            }
            case 't':
                return true;
            case 'f':
                return false;
        }
        return true;
    }

    private static boolean notExpress(Boolean x) {
        return !x;
    }

    private static boolean andExpress(Boolean[] x) {
        for (boolean o : x) {
            if (!o) return false;
        }
        return true;
    }

    private static boolean orExpress(Boolean[] x) {
        for (boolean o : x) {
            if (o) return true;
        }
        return false;
    }

    private static String[] splitExpress(String expression) {
        Stack<String> stack = new Stack<>();
        List<Integer> indexs = new LinkedList<>();
        int index = 0;
        for (char c : expression.toCharArray()) {
            if (c == ',' && stack.isEmpty()) indexs.add(index);
            else if (c == '(') stack.push("(");
            else if (c == ')') stack.pop();
            index++;
        }
        String[] ans = new String[indexs.size() + 1];
        int start = 0;
        int count = 0;
        for (int i : indexs) {
            ans[count] = expression.substring(start, i);
            start = i + 1;
            count++;
        }
        ans[count] =  expression.substring(start, expression.length());
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(parseBoolExpr("|(&(t,f,t),!(t))"));
    }

}
