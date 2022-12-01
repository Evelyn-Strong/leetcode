package com.eve.leetcode.medium.dp;

public class _790_numTilings {
    /**
     * dp[i][0]
     * dp[i][1]
     * dp[i][2]
     * dp[i][3]
     * ​
     *
     * =dp[i−1][3]
     * =dp[i−1][0]+dp[i−1][2]
     * =dp[i−1][0]+dp[i−1][1]
     * =dp[i−1][0]+dp[i−1][1]+dp[i−1][2]+dp[i−1][3]
     * ​
     *
     *
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/domino-and-tromino-tiling/solutions/1962465/duo-mi-nuo-he-tuo-mi-nuo-ping-pu-by-leet-7n0j/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static int numTilings(int n) {
        int[][] dp = new int[n + 1][4];
        int MOD = 1000000007;
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 0;

        for (int i = 2; i <= n; i++) {
           dp[i][0] = dp[i-1][3];
           dp[i][1] = dp[i-1][0] + dp[i-1][2];
           dp[i][2] = dp[i-1][0] + dp[i-1][1];
           dp[i-1][3] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3];
        }
        return dp[n][3];
    }

    public static void main(String[] args) {
        System.out.println(numTilings(5));
    }
}
