package com.eve.leetcode.面试经典.medium;

/**
 * Created by Eve on 2022/9/14.
 */

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2：
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0108_setZeros {

    public void setZeroes(int[][] matrix) {
        int rlen = matrix.length;
        int clen = matrix[0].length;
        boolean[][] original = new boolean[rlen][clen];

        for (int m = 0; m < rlen; m++) {
            for (int n = 0; n < clen; n++) {
                if (matrix[m][n] == 0) original[m][n] = true;
            }
        }

        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                if (original[i][j]) {
                    matrix[i] = new int[clen];
                    int n = rlen - 1;
                    while (n >= 0) {
                        matrix[n][j] = 0;
                        n--;
                    }
                }
            }
        }

    }


    //标记法

    public void _setZeroes(int[][] matrix) {
        int rlen = matrix.length;
        int clen = matrix[0].length;
        boolean[] r = new boolean[rlen];
        boolean[] c = new boolean[clen];

        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                if (matrix[i][j] == 0) {
                    r[i] = true;
                    c[j] = true;
                }
            }
        }

        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                if (r[i] || c[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
