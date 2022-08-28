package com.eve.leetcode.medium.topology;

/**
 * Created by Eve on 2022/8/27.
 */
public class _207_canFinish {

    //判断是不是有环形链表。

    public static  boolean canFinish(int numCourses, int[][] prerequisites) {


       return false;

    }


    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,0},{0,1}};

        System.out.println(canFinish(2,prerequisites));
    }
}
