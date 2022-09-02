package com.eve.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Eve on 2022/8/31.
 */
public class _349_intersection {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for(int i = 0;i < nums1.length;i++){
           set.add(nums1[i]);
        }
        for(int i = 0;i < nums2.length;i++){
           if(set.contains(nums2[i])){
               ans.add(nums2[i]);
           }
        }
        int[] a = new int[ans.size()];
        int index = 0;
        for(int v: ans){
            a[index] =  v;
            index++;
        }
        return a;

    }
}
