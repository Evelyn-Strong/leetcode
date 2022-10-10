package com.eve.leetcode.medium.dp;

/**
 * Created by Eve on 2022/9/22.
 */
public class _91_numDecoding {


    public static int numDecodings(String s) {

        char[] ch = s.toCharArray();
        int len = ch.length;

        if (len == 1) {
            return s.equals("0") ? 0 : 1;
        }
        int[] dp = new int[len];
        if ("0".equals(ch[0]+"")) return 0;
        else {
            dp[0] = 1;
        }
        for (int i = 1; i < len; i++) {

            if ("0".equals(ch[i]+"") && (ch[i - 1] > '2' || ch[i - 1] <= '0')) {
                return 0;
            } else {
                if ("0".equals(ch[i]+"")) {
                    if(i<2){
                        dp[i] = 1;
                    }else{
                        dp[i] = dp[i - 2];
                    }

                } else {
                    String n = "" + ch[i - 1] + ch[i];
                    if (Integer.valueOf(n) <= 26 && Integer.valueOf(n) >=10) {
                        if (i < 2){
                            dp[i] = 2;
                        }else{
                            dp[i] = dp[i - 1] + dp[i - 2];
                        }

                    } else {
                        dp[i] = dp[i - 1];
                    }
                }

            }

        }

       return dp[len-1];
    }


    public int _numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }


    public static void main(String[] args) {
        System.out.println(numDecodings("10011"));
    }
}
