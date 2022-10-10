package com.eve.leetcode.easy;

/**
 * Created by Eve on 2022/9/22.
 */
public class _1640_canFormArray {

    public boolean canFormArray(int[] arr, int[][] pieces) {

        boolean find = false;

        for (int i = 0; i < arr.length; i++) {
            find = false;
            for (int j = 0; j < pieces.length; j++) {
                if (arr[i] != pieces[j][0]) {
                    continue;
                } else {
                    int len = pieces[j].length;

                    int x = 0;
                    while (x < len && arr[i] == pieces[j][x]) {
                        x++;
                        i++;
                    }
                    if (x == len) {
                        find = true;
                    } else {
                        find = false;
                    }
                    i--;
                }
            }
            if (!find) return false;
        }

        return true;
    }
}
