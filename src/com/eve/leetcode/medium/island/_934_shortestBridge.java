package com.eve.leetcode.medium.island;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 934. 最短的桥
 * 中等
 * 315
 * 相关企业
 * 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
 * <p>
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
 * <p>
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
 * <p>
 * 返回必须翻转的 0 的最小数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] 为 0 或 1
 * grid 中恰有两个岛
 */
public class _934_shortestBridge {

    //解体思路：
    //先找到两个岛屿的坐标数据，然后最短路径是island1（x，y）- island2（i，j）中 min（abs（x-i）- abs（y-j））
    // OR 广度优先+广度优先 (先找到一个岛屿再bfs 向外拓展一层)
    public static int shortestBridge(int[][] grid) {
        List<int[]> island1 = new LinkedList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int minPath = Integer.MAX_VALUE;
        int step = 0;
        int rlen = grid.length;
        int clen = grid[0].length;

        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                if (grid[i][j] == 1 && island1.size() == 0) {
                    grid[i][j] = -1;
                    queue.offer(new int[]{i, j});
                    island1.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + directions[k][0];
                            int ny = y + directions[k][1];
                            if (nx >= 0 && nx < rlen && ny >= 0 && ny < clen && grid[nx][ny] == 1) {
                                grid[nx][ny] = -1;
                                queue.offer(new int[]{nx, ny});
                                island1.add(new int[]{nx, ny});
                            }
                        }
                    }
                    for (int[] cell : island1) {
                        queue.offer(cell);
                    }
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + directions[d][0];
                                int ny = y + directions[d][1];
                                if (nx >= 0 && nx < rlen && ny >= 0 && ny < clen) {
                                    if (grid[nx][ny] == 1) {
                                        return step;
                                    }
                                    if (grid[nx][ny] == 0) {
                                        grid[nx][ny] = -1;
                                        queue.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;


    }

    private static boolean inIsland1(int i, int j, int[][] grid) {
        int rlen = grid.length;
        int clen = grid[0].length;
        if (i < rlen && i >= 0 && j < clen && j >= 0 && grid[i][j] == -1) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        System.out.println(shortestBridge(new int[][]{{0, 0, 1, 0, 1}, {0, 1, 1, 0, 1}, {0, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}));
    }
}
