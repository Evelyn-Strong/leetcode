package com.eve.leetcode.medium.array.dfs;

/**
 * Created by Eve on 2022/9/22.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 * <p>
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *  
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */



//https://leetcode.cn/problems/surrounded-regions/solution/bfsdi-gui-dfsfei-di-gui-dfsbing-cha-ji-by-ac_pipe/
public class _130_solve {

    static boolean reset = true;

    public static void solve(char[][] board) {

        int rlen = board.length;
        int clen = board[0].length;

        boolean[][] visited = new boolean[rlen][clen];
        List<int[]> ls = new LinkedList<>();

        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                dfs(board, visited, i, j, ls);
                if (reset) {
                    for (int[] lo : ls) {
                        board[lo[0]][lo[1]] = 'X';
                    }
                }
                reset = true;
                ls =  new LinkedList<>();
            }
        }

    }

    private static void dfs(char[][] board, boolean[][] visited, int i, int j, List<int[]> ls) {
        if (!isInBoard(board, i, j)) {
            reset = false;
            return;
        }
        if (visited[i][j]) return;
        else {
            visited[i][j] = true;
            if (board[i][j] == 'X') return;
            else {
                ls.add(new int[]{i, j});
                dfs(board, visited, i + 1, j, ls);
                dfs(board, visited, i, j + 1, ls);
                dfs(board, visited, i - 1, j, ls);
                dfs(board, visited, i, j - 1, ls);
            }
        }
    }

    private static boolean isInBoard(char[][] board, int i, int j) {
        int rlen = board.length;
        int clen = board[0].length;

        if (i >= 0 && i < rlen && j >= 0 && j < clen) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        solve(new char[][]{{'O','X','O'},{'X','O','X'},{'O','X','O'}});
    }

}
