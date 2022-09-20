package com.eve.leetcode.medium.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eve on 2022/9/8.
 */
public class _406_reconstructQueue {
    //解题思路：
    //数学分析（总结归纳），先排序再插入
    //由高到低排序
    public static int[][] reconstructQueue(int[][] people) {
        List<int[]> ans = new LinkedList<>();

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        //list.add(index,element)
        //index有效的话会替换原有元素的位置（原有元素index会靠后一个下标-->index + 1）
        for (int i = 0; i < people.length; i++) {
            ans.add(people[i][1], people[i]);
        }

        return ans.toArray(new int[people.length][]);

    }

    //从低到高排序
    public static int[][] _reconstructQueue(int[][] people) {
        int[][] ans = new int[people.length][];

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });

        for(int[] p : people){
            int space = p[1];
            for(int i = 0; i < people.length;i++){
                if(space == 0 && ans[i] == null){
                    ans[i] = p;
                    break;
                }else{
                    if(ans[i] == null || ans[i][0] == p[0]) {
                        space--;
                    }
                }
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] people = new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };
        System.out.println(_reconstructQueue(people));
    }
}
