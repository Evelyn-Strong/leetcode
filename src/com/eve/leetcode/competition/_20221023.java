package com.eve.leetcode.competition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _20221023 {

    public static boolean haveConflict(String[] event1, String[] event2) {
        return compare(event1[0], event2[1]) && compare(event2[0], event1[1]);

    }

    private static boolean compare(String time1, String time2) {
        String[] times1 = time1.split(":");
        String[] times2 = time2.split(":");
        for (int i = 0; i < 2; i++) {
            if (Integer.valueOf(times1[i]) > Integer.valueOf(times2[i])) {
                return false;
            } else if (Integer.valueOf(times1[i]) < Integer.valueOf(times2[i])) {
                return true;
            }
        }
        return true;
    }


    public static int subarrayGCD(int[] nums, int k) {
        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % k == 0) {
                nums[i] = nums[i] / k;
            } else {
                nums[i] = 0;
            }
        }
        int left = 0;
        int right = 0;
        List<Integer> ls = new LinkedList<>();
        int count = 0;
        while ( right >= 0 && right < len) {
            if (nums[right] == 1) {
                ls.add(right);
                left = right - 1;
                while (left >= 0 && nums[left] !=0) {
                   left --;
                }
                while(right < len && nums[right] !=0){
                    if(nums[right] == 1){
                        ls.add(right);
                    }
                    right++;
                }
                for(int i :ls){
                    count += (i-left)*(right-i);
                }
                ls.clear();
            }
            right++;
        }
        return count;
    }

//    public long makeSimilar(int[] nums, int[] target) {
//        Arrays.sort(nums);
//        Arrays.sort(target);
//        int len = nums.length;
//        int[] diff = new int[len];
//        for (int i = 0; i < len; i++) {
//            diff[i] = nums[i] - target[i];
//        }
//
//    }

    public static void main(String[] args) {
       // System.out.println(haveConflict(new String[]{"10:13", "13:02"}, new String[]{"13:17", "21:38"}));
        subarrayGCD(new int[]{9,3,1,2,6,3},3);
    }


}
