package com.eve.leetcode.easy;

import java.util.Stack;

/**
 * Created by Eve on 2022/9/1.
 */
public class _1475_finalPrices {

    public static int[] _finalPrices(int[] prices) {
        int len = prices.length;
        int[] ans = new int[len];
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            flag = false;
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    ans[i] = prices[i] - prices[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) ans[i] = prices[i];
        }
        return ans;
    }

    //逆向循环 + 单调栈
    //图解： https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/solution/by-muse-77-nh2d/

    public static int[] finalPrices(int[] prices) {

        int len = prices.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < stack.peek()) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(finalPrices(new int[]{8, 4, 6, 2, 3}));
    }
}
