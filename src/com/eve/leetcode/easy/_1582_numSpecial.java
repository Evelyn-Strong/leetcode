package com.eve.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eve on 2022/9/4.
 */
public class _1582_numSpecial {

    public int numSpecial(int[][] mat){

        int[] row =  new int[mat.length];
        int[] col =  new int[mat[0].length];


        for(int i= 0 ; i < mat.length; i ++){
            for(int j=0; j<mat[0].length;j++){
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }

        }

        int ans = 0;
        for(int i=0 ; i< mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(row[i] * col[j]==1 && mat[i][j]==1){
                    ans++;
                }
            }
        }

        return ans;

    }





}
