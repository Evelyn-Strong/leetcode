package com.eve.leetcode.medium.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _54_sprialOrder {

//    public List<Integer> spiralOrder(int[][] matrix) {
//        //解题思路：
//        //right,down,left,up依次检查
//        int rlen = matrix.length;
//        int clen = matrix[0].length;
//
//        boolean[][] visited = new boolean[rlen][clen];
//        visited[0][0] = true;
//        List<Integer> ans = new LinkedList<>();
//        int i = 0;
//        int j = 0;
//        int ops = 1;
//        while (!visited[i][j]) {
//            visited[i][j] = true;
//            ans.add(matrix[0][0]);
//            if(isInZone(matrix, i, j + 1) && visited[i][j + 1] && isInZone(matrix, i + 1, j) && visited[i + 1][j]
//            && isInZone(matrix, i, j - 1) && visited[i][j - 1] && isInZone(matrix, i - 1, j) && visited[i - 1][j])
//                return ans;
//            switch (ops) {
//                //right
//                case 1: {
//                    if (isInZone(matrix, i, j + 1) && !visited[i][j + 1]) {
//                        j++;
//                        continue;
//                    }
//                    ops = 2;
//                }
//                //down
//                case 2: {
//                    if (isInZone(matrix, i + 1, j) && !visited[i + 1][j]) {
//                        i++;
//                        break;
//                    }
//                    ops = 3;
//                }
//                case 3: {
//                    if (isInZone(matrix, i, j - 1) && !visited[i][j - 1]) {
//                        j--;
//                        break;
//                    }
//                    ops = 4;
//                }
//                case 4: {
//                    if (isInZone(matrix, i - 1, j) && !visited[i - 1][j]) {
//                        i--;
//                        continue;
//                    }
//                    ops = 1;
//                }
//            }
//        }
//       return ans;
//    }
//
//    private boolean isInZone(int[][] matrix, int i, int j) {
//        int rlen = matrix.length;
//        int clen = matrix[0].length;
//
//        if (i >= 0 && i < rlen && j >= 0 && j < clen) {
//            return true;
//        }
//        return false;
//    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
