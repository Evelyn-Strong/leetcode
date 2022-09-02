package com.eve.leetcode.medium.dp;

/**
 * Created by Eve on 2022/8/28.
 */
public class _221_maximalSquare {

    //dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
    //dp(i,j)表示以matrix(i,j)为右下角边界的最大正方形数

    public static int maximalSquare(char[][] matrix) {
        int rlen = matrix.length;
        int clen = matrix[0].length;
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0 ; i < rlen; i++){
            for (int j = 0 ; j < clen ; j++){
                if(matrix[i][j] == '1' ){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] =  Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }

                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix =  new char[][]{{'0','1','1','1','0'},{'1','1','1','1','0'},{'0','1','1','1','1'},{'0','1','1','1','1'},{'0','0','1','1','1'}};
        System.out.println(maximalSquare(matrix));
    }
}
