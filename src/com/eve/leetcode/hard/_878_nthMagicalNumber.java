package com.eve.leetcode.hard;

/**
 * 878. 第 N 个神奇数字
 * 困难
 * 167
 * 相关企业
 * 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
 * <p>
 * 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 109 + 7 取模 后的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, a = 2, b = 3
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 4, a = 2, b = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * 2 <= a, b <= 4 * 104
 */
public class _878_nthMagicalNumber {

    //   public int nthMagicalNumber(int n, int a, int b) {
//        int MOD = 1000000007;
//        int min = Math.min(a, b);
//        int max = Math.max(a, b);
//        int power = 0;
//        double left = max / min;
//        while (left > 1) {
//            power++;
//            left /= min;
//        }
//        int[] dp = new int[n + 1];
//        dp[1] = min;
//        for (int i = 2; i <= n; ++i) {
//            int rep = dp[i - 1];
//            int p =  power;
//            dp[i] = Math.min(dp[i - 1] * a % MOD, rep);
//        }
    public int nthMagicalNumber(int n, int a, int b) {
        // a、b有倍数关系，可直接O(1)内返回。
        if (a % b == 0) return nthMagicalNumber(n, b);
        if (b % a == 0) return nthMagicalNumber(n, a);

        //求a和b的最公倍数p
        int p = a, i = 1;
        while (p * i % b != 0) i++;
        p = p * i;

        //二分查找，直到某个数之前恰好有n个神奇数字。
        long l = 1, r = (long) n * Math.min(a, b);
        while (l <= r) {
            long m = l + (r - l) / 2;
            // 求m之前的神奇数字的个数：a的倍数的数量，加上b的倍数的数量，再减去a和b的公倍数的数量
            if (m / a + m / b - m / p >= n) r = --m;
            else l = ++m;
        }

        return (int) (l % 1000000007);
    }

    public int nthMagicalNumber(int n, int a) {
        return (int) ((long) n * a % 1000000007);
    }
}
