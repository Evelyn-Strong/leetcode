package com.eve.leetcode.easy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Eve on 2022/8/24.
 */
public class _1460_canBeEqual {

    //如果数字相同样的数组可以反转成相同的数组
    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);


        //双指针
        int arr_len =  arr.length;
        for(int i=0; i<arr_len; i++){
           if(arr[i]==target[i] && arr[arr_len-1-i]==target[arr_len-1-i]){
               if(i == arr_len-i-1 && arr[i+1]==target[i+1]) return true;
               else if( i == arr_len-i) return true;
           }
           else return false;
        }

        return false;

    }

    public static void main(String[] args) {
        int[] target = new int[]{1,2,3,4,4};
        int[] arr =  new int[]{2,1,3,4,4};

        System.out.println(canBeEqual(target,arr));
    }

}
