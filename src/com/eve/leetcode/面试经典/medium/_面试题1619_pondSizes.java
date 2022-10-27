package com.eve.leetcode.面试经典.medium;

import java.util.*;

public class _面试题1619_pondSizes {

    //解题思路：bfs
    public int[] pondSizes(int[][] land) {
        List<Integer> ls = new LinkedList<>();
        int lake = -1;
        int lakeSize = 0;
        int rlen = land.length;
        int clen = land[0].length;
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1},{-1,-1},{1,1},{1,-1},{-1,1}};
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                if (land[i][j] == 0) {
                    land[i][j] = lake;
                    lakeSize++;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int x = cell[0], y = cell[1];
                        for (int k = 0; k < 8; k++) {
                            int nx = x + direction[k][0];
                            int ny = y + direction[k][1];
                            if (nx >= 0 && nx < rlen && ny >= 0 && ny < clen && land[nx][ny] == 0) {
                                queue.offer(new int[]{nx, ny});
                                land[nx][ny] = lake;
                                lakeSize++;
                            }
                        }
                    }
                    // lake--;
                    ls.add(lakeSize);
                    lakeSize = 0;
                }

            }
        }
        int[] ans = new int[ls.size()];
        int index = 0;
        for (int n : ls) {
            ans[index] = n;
            index++;
        }
        Arrays.sort(ans);
        return ans;

    }
}
