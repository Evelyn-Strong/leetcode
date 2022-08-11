package com.eve.leetcode.medium.tree;

/**
 * Created by Eve on 2022/8/7.
 */

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

        此外，你可以假设该网格的四条边均被水包围。

         

        示例 1：

        输入：grid = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
        ]
        输出：1
        示例 2：

        输入：grid = [
        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"]
        ]
        输出：3
         

        提示：

        m == grid.length
        n == grid[i].length
        1 <= m, n <= 300
        grid[i][j] 的值为 '0' 或 '1'
        相关标签

        Java



        作者：力扣 (LeetCode)
        链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvtsnm/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

public class NumIslands {


    //图
    //解题思路
    //dfs
    //1.当grid为1的时候开始dfs遍历，然后将遍历过的地方都设置为0
    //2.当周围为1的都遍历成0后直接返回，count++，岛的数加1
    //3。
    public static  int numIslands(char[][] grid) {
        int count=0;

        for(int i=0 ; i<grid.length;i++){
            for (int j=0; j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;

    }

    private static void dfs (char[][] grid, int r,int c){

        if(!inArea(grid,r,c)) return;
        if(grid[r][c] == '0' )return;
        if(grid[r][c] == '1') grid[r][c]='0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    private static boolean inArea(char[][] grid, int r, int c) {
        int rl =  grid.length;
        int cl = grid[0].length;
        if((r>=0&& r<rl )&&(c>=0 && c<cl)) return true;
        else return false;
    }


    public static void main(String[] args) {
      char[][] grid  = new char[][]{{'1','1','1','1','0'},
                                    {'1','1','0','0','0'},
                                    {'1','1','0','0','0'},
                                    {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
}
