package com.eve.leetcode.medium.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eve on 2022/9/26.
 */
public class _118_generate {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(Arrays.asList(new Integer[]{1}));
        if (numRows == 1) {
            return ans;
        }
        List<Integer> ls = Arrays.asList(new Integer[]{1});
        for (int i = 2; i <= numRows; i++) {
            List<Integer> tmp = new LinkedList<>();
            for (int j = 0; j < ls.size()+1; j++) {
                if (j == 0 || j == ls.size() ) {
                    tmp.add(1);
                } else {
                    tmp.add(ls.get(j- 1) + ls.get(j));
                }
            }
            ls = tmp;
            ans.add(tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        generate(5);
    }
}
