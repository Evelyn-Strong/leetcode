package com.eve.leetcode.easy;

/**
 * Created by Eve on 2022/9/11.
 */
public class _2379_minimumRecolors {

    public int minimumRecolors(String blocks, int k) {

        char[] ch = blocks.toCharArray();
        int len = ch.length;
        int min = 0;
        int index = 0;
        do{
            if(ch[index] == 'W'){
                min++;
            }
            index ++;
        }while(index == k);
        int ans = Integer.MAX_VALUE;
        for(int i=k;i<len;i++){
          if(ch[i-k]!='W' && ch[i-k+1]=='W'){
              min++;
          }
          if(ch[k]!='W' && ch[k-1]=='W'){
              min++;
          }

          ans =  Math.min(ans, min);
        }

        return ans;

    }
}
