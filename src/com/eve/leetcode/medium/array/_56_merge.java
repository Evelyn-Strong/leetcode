package com.eve.leetcode.medium.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eve on 2022/9/5.
 */
public class _56_merge {

    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 1|| intervals.length==0)  return intervals;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> ls = new LinkedList<>();
        boolean finished =  false;
        for(int i = 0 ; i< intervals.length; i++){
           for(int j = i+1; j < intervals.length;j++){
               if(intervals[i][1] >= intervals[j][0] ){
                   if(intervals[i][1] <= intervals[j][1]){
                       intervals[i][1]=intervals[j][1];
                   }
                   if(j == intervals.length-1) {
                       ls.add(intervals[i]);
                       i=j-1;
                       break;
                   }
               }else{
                   ls.add(intervals[i]);
                   if(j == intervals.length-1) {

                       ls.add(intervals[j]);
                   }
                   i=j-1;
                   break;
               }

           }
        }

        int[][] ans = new int[ls.size()][2];
        int index = 0;
        for(int[] row : ls){
            ans[index] =  row;
            index++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(merge(new int[][]{{1,6},{2,4}}));
    }
}
