package com.eve.leetcode.medium.array;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _面试题0108_setZeros {

    public void setZeroes(int[][] matrix) {
        int rlen =  matrix.length;
        int clen = matrix[0].length;

         boolean[] row = new boolean[rlen];
         boolean[] col = new boolean[clen];
         for(int i = 0 ; i < rlen ; i++){
             for(int j=0; j< clen; j++){
                 if(matrix[i][j] == 0){
                     row[i] = true;
                     col[i] = true;
                 }
             }
         }
         for(int i = 0 ; i < rlen ; i++){
             for(int j = 0; j < clen ; j++){
                 if(row[i] || col[i]){
                     matrix[i][j] = 0;
                 }
             }
         }


    }
}
