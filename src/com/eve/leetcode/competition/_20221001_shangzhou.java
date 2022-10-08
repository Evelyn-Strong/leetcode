package com.eve.leetcode.competition;

import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.stream.Stream;

public class _20221001_shangzhou {

    public static boolean equalFrequency(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        int len = word.length();
        int n = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) n++;
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i : count) {
            if (i != 0) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
        }
        if (map.size() == 1) {
            return map.containsKey(1) ? true : false;
        } else if (map.size() == 2) {
            Integer[][] ans = new Integer[2][2];
            int i = 0;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                ans[i][0] = e.getKey();
                ans[i][1] = e.getValue();
                i++;
            }
            Arrays.sort(ans, (a, b) -> (a[0] - b[0]));
            if (ans[0][0] == 1 && ans[0][1] == 1) {
                return true;
            } else if (ans[1][0] - ans[0][0] == 1) {
                return ans[1][1] == 1 ? true : false;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(equalFrequency("abcd"));
    }
}


class LUPrefix {

    Integer[] arr;
    Stack<Integer> stack;
    int alen = 0;
    int cap;

    public LUPrefix(int n) {
        cap = n;
        arr = new Integer[n];
        Arrays.fill(arr, 1000001);
        stack = new Stack<>();
    }

    public void upload(int video) {
        arr[alen] = video;
        alen++;
        if(alen == 1) return;
        for (int i = alen; i >= 0; i--) {
            if(arr[i] <arr[i-1]){
                int tmp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = tmp;
            }else{
                break;
            }
        }
    }

    public int longest() {
        Integer[] arrtmp = new Integer[cap];

        int ss = stack.size();
        if (alen == 0) return ss;
        int start;
        int pushed = 0;
        if (ss == 0) {
            start = 0;
        } else {
            start = stack.peek();
        }
        for (int num : arr) {
            if (num - start == 1) {
                stack.push(num);
                alen--;
                pushed++;
                start = num;
            } else {
                break;
            }
        }
       // System.arraycopy(arr,0,arrtmp);

        return stack.size();

    }
}