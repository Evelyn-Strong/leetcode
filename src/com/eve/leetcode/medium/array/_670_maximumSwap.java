package com.eve.leetcode.medium.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eve on 2022/9/13.
 */
public class _670_maximumSwap {

    public static int maximumSwap(int num) {
        List<Integer> nums = new LinkedList<>();
        while (num > 0) {
            nums.add(num % 10);
            num = num / 10;
        }
        Integer[] n = nums.toArray(new Integer[nums.size()]);
        if(nums.size()==1) return nums.get(0);
        Integer[] desc = Arrays.copyOf(n,n.length);
        Arrays.sort(desc,Comparator.reverseOrder());
        int idx = 0;
        int right = 0;
        int count = 0;
        for (int i = n.length - 1; i >= 0; i--) {
            if (n[i] >= desc[idx]) {
                idx++;
                continue;
            } else {
                right = i;
                while (idx <= n.length - 2 && desc[idx] == desc[idx + 1]) {
                    count++;
                    idx++;
                }
                while (count >=0) {
                    if (n[i] == desc[idx]) {
                        count--;
                        if(count < 0) break;
                    }
                    i--;
                }
                int tmp = n[i];
                n[i] = n[right];
                n[right] = tmp;
                break;
            }

        }
        int ans = n[n.length-1];
        for(int j = n.length-2;j>=0;j--){
            ans = ans*10+n[j];
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(90014));
    }
}
