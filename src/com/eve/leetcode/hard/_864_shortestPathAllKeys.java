package com.eve.leetcode.hard;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * https://leetcode.cn/problems/shortest-path-to-get-all-keys/
 * 864. 获取所有钥匙的最短路径
 * 困难
 * 139
 * 相关企业
 * 给定一个二维网格 grid ，其中：
 * <p>
 * '.' 代表一个空房间
 * '#' 代表一堵
 * '@' 是起点
 * 小写字母代表钥匙
 * 大写字母代表锁
 * 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
 * <p>
 * 假设 k 为 钥匙/锁 的个数，且满足 1 <= k <= 6，字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
 * <p>
 * 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = ["@.a.#","###.#","b.A.B"]
 * 输出：8
 * 解释：目标是获得所有钥匙，而不是打开所有锁。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = ["@..aA","..B#.","....b"]
 * 输出：6
 * 示例 3:
 * <p>
 * <p>
 * 输入: grid = ["@Aa"]
 * 输出: -1
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 30
 * grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
 * 钥匙的数目范围是 [1, 6]
 * 每个钥匙都对应一个 不同 的字母
 * 每个钥匙正好打开一个对应的锁
 */
public class _864_shortestPathAllKeys {
    static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0,}, {-1, 0}};

    //解题思路：先找有多少钥匙
    //回溯+bfs(通过bfs 找到最短路径的另一个key， 然后再找下一个key， 也许是a->b->c 也许是b->c->a)
//    public static int shortestPathAllKeys(String[] grid) {
//        int rlen = grid.length;
//        int clen = grid[0].length();
//        char[][] _2dgrid = new char[rlen][clen];
//        int startx = 0;
//        int starty = 0;
//        int totalKeys = 0;
//
//        for (int i = 0; i < rlen; i++) {
//            for (int j = 0; j < clen; j++) {
//                char c = grid[i].charAt(j);
//                _2dgrid[i][j] = c;
//                if (c == '@') {
//                    startx = i;
//                    starty = j;
//                } else if (c - 'z' <= 0 && c - 'a' >= 0) {
//                    totalKeys++;
//                }
//            }
//        }
//        boolean[] kv = new boolean[totalKeys];
//        return findKeys(startx, starty, kv, _2dgrid, 0, totalKeys);
//    }
//
//    private static int findKeys(int startx, int starty, boolean[] keyVisited, char[][] grid, int kcount, int target) {
//        Queue<int[]> queue = new ArrayDeque<>();
//        queue.offer(new int[]{startx, starty});
//        int ans = 0;
//        for (int i = 0; i < keyVisited.length; i++) {
//            int step = 0;
//            int total = 0;
//            if (keyVisited[i] == false) {
//                while (!queue.isEmpty()) {
//                    int[] cell = queue.poll();
//                    int x = cell[0];
//                    int y = cell[1];
//                    for (int k = 0; k < 4; k++) {
//                        int newx = x + directions[k][0];
//                        int newy = y + directions[k][1];
//                        if (isInZone(newx, newy, grid)) {
//                            if (grid[newx][newy] == '.') {
//                                step++;
//                                queue.offer(new int[]{newx, newy});
//                            } else if (grid[newx][newy] <= 'F' && grid[newx][newy] >= 'A') {
//                                if (keyVisited[grid[newx][newy] - 'A']) {
//                                    step++;
//                                    queue.offer(new int[]{newx, newy});
//                                }
//                            } else if (grid[newx][newy] <= 'f' && grid[newx][newy] >= 'a') {
//                                if (i == (grid[newx][newy] - 'a')) {
//                                    keyVisited[i] = true;
//                                    if (kcount + 1 == target) return step;
//                                    else {
//                                        total = step + findKeys(newx, newy, keyVisited, grid, kcount + 1, target);
//                                    }
//                                }
//                            }
//                        }
//
//                    }
//                }
//            }
//            keyVisited[i] = false;
//            ans = Math.min(ans, total);
//        }
//        return ans;
//    }
//
//    private static boolean isInZone(int i, int j, char[][] grid) {
//        return (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length);
//    }

    /**
     * 解题思路是差不多的：bfs 找最小路径，并且标志数组的步数，获得锁的状态用个状态压缩
     *
     * @param grid
     * @return
     */
   //int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPathAllKeys(String[] grid) {
        int rlen = grid.length;
        int clen = grid[0].length();
        int startx = 0, starty = 0;
        Map<Character, Integer> keyToIndex = new HashMap<>();
        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startx = i;
                    starty = j;
                } else if (Character.isLowerCase(c)) {
                    keyToIndex.put(Character.valueOf(c), c - 'a');
                }
            }
        }

        int[][][] distances = new int[rlen][clen][1 << keyToIndex.size()];
        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                Arrays.fill(distances[i][j], -1);
            }
        }
        distances[startx][starty][0] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startx, starty, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1], mask = cell[2];
            for (int k = 0; k < 4; k++) {
                int nx = x + directions[k][0];
                int ny = y + directions[k][1];
                if (nx >= 0 && ny >= 0 && nx < rlen && ny < clen && grid[nx].charAt(ny) != '#') {
                    if (grid[nx].charAt(ny) == '.' || grid[nx].charAt(ny) == '@') {
                        if (distances[nx][ny][mask] == -1) {
                            distances[nx][ny][mask] = distances[x][y][mask] + 1;
                            queue.offer(new int[]{nx, ny, mask});
                        }
                    } else if (Character.isUpperCase(grid[nx].charAt(ny))) {
                        int idx = keyToIndex.get(Character.toLowerCase(grid[nx].charAt(ny)));
                        if ((mask & (1 << idx)) != 0 && distances[nx][ny][mask] == -1) {
                            distances[nx][ny][mask] = distances[x][y][mask] + 1;
                            queue.offer(new int[]{nx, ny, mask});
                        }
                    } else if (Character.isLowerCase(grid[nx].charAt(ny))) {
                        int idx = keyToIndex.get(grid[nx].charAt(ny));
                        int nmask = (mask | (1 << idx));
                        if(distances[nx][ny][nmask] == -1){
                            distances[nx][ny][nmask] = distances[x][y][mask] + 1;
                            if ((nmask == (1 << keyToIndex.size()) - 1)) return distances[nx][ny][nmask];
                            else queue.offer(new int[]{nx, ny, nmask});
                        }

                    }
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println('.' - 'z');
    }
}
