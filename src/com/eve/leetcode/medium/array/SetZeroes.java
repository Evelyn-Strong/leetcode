package com.eve.leetcode.medium.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Eve on 2022/7/31.
 */
public class SetZeroes {

    //解题思路，先找到0的标记点，
    //然后再根据行和列重制数据。
    public static int[][] setZeroes(int[][] matrix) {
        int leny = matrix[0].length;
        int lenx = matrix.length;
        Set<Integer> rowsWith0 = new HashSet<>();
        Set<Integer> columnWith0 = new HashSet<>();
        int i=0;
        int j=0;

        for(i=0;i < lenx; i++) {
            for(j=0; j < leny; j++) {
               if(matrix[i][j] == 0) {
                   rowsWith0.add(i);
                   columnWith0.add(j);
               }
            }
        }
        rowsWith0.forEach((r)-> {
            int y=0;
            while(y<leny){
                matrix[r][y] = 0;
                y++;

        }});

        columnWith0.forEach((c)-> {
            int x=0;
            while(x<lenx){
                matrix[x][c] = 0;
                x++;

            }});

        return matrix;

    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println(setZeroes(test));
    }
}
