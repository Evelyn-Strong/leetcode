package com.eve.leetcode.medium.iterator;

/**
 * Created by Eve on 2022/8/24.
 */
public class _64_minPathSum {

    //解题思路：
    //暴力求解
    //dfs + 回溯

    //func: dp[n][m] = dp[n-i][m-j] + dp[i][j]

    /**
     需要优化，速度慢
     * @param args
     */

//    public static int minPathSum(int[][] grid) {
//
//        List<Integer> ls = new LinkedList<>();
//        ls.add(0);
//
//       ls = _genDP(grid,0,0,ls);
//
//        Object[] arr = ls.toArray();
//
//        Arrays.sort(arr);
//
//        return (int) arr[0];
//
//    }
//
//    public static List<Integer> _genDP(int[][] grid, int n,int m, List<Integer> res){
//        List<Integer> path1 = new LinkedList<>();
//        List<Integer> path2 = new LinkedList<>();
//         List<Integer> total = new LinkedList<>();
//
//         int r_len = grid.length;
//         int c_len = grid[0].length;
//         if( n==r_len || m==c_len) return res;
//
//
//         // bianjie
//
//        if(n == r_len-1 && m == c_len-1){
//            for(Integer sum : res){
//                total.add(sum + grid[n][m]);
//
//            }
//            return total;
//        }else if(n == r_len-1){
//            int s =0;
//            while (m<c_len){
//                s+=grid[n][m];
//                m++;
//            }
//            for(Integer sum : res){
//                total.add(sum + s);
//
//            }
//            return total;
//        }else if(m == c_len-1){
//            int s =0;
//            while (n<r_len){
//                s+=grid[n][m];
//                n++;
//            }
//            for(Integer sum : res){
//                total.add(sum + s);
//
//            }
//            return total;
//        }
//        path1=res;
//        path2=res;
//
//        for(Integer sum : res){
//            for (Integer child_right : _genDP(grid,n,m+1,path1)){
//                total.add(sum+child_right+grid[n][m]);
//            }
//            for(Integer child_down : _genDP(grid,n+1,m,path2)){
//                total.add(sum+child_down+grid[n][m]);
//            }
//
//        }
//
//
//
//        return total;
//
//         }

    /**
     * 状态转移方程
     * @param args
     */
    //

//    public static int minPathSum(int[][] grid){
//
//        int[][] dp = new int[grid.length][grid[0].length];
//        dp[0][0] = grid[0][0];
//
//
//        return helper(grid,dp,grid.length-1,grid[0].length-1);
//
//
//    }
//
//    private static int helper(int[][] grid, int[][] dp, int r, int c){
//
//        int r_len=grid.length;
//        int c_len=grid[0].length;
//
//        if(r==0 && c==0){
//
//            return grid[0][0];
//        }
//
//        if(r_len == 1){
//            dp[r][c] = helper(grid,dp,r,c-1)+grid[r][c];
//        }else if(c_len == 1){
//            dp[r][c] = helper(grid,dp,r-1,c)+grid[r][c];
//        }else{
//            if(r>=1 && c>=1){
//                dp[r][c] = Math.min(helper(grid,dp, r-1,c),helper(grid,dp,r,c-1))+ grid[r][c];
//            }else if(r == 0){
//                dp[r][c]= helper(grid,dp,r,c-1)+ grid[r][c];
//
//            }else if(c == 0){
//                dp[r][c]= helper(grid,dp,r-1,c)+ grid[r][c];
//            }
//
//        }
//
//        return dp[r][c];
//
//
//
//    }

    public static int minPathSum(int[][] grid){
        int grlen=grid.length;
        int gclen=grid[0].length;
        int[][] dp = new int[grlen][gclen];

        dp[0][0]= grid[0][0];

        for (int i=1;i<grlen;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int j=1;j<gclen;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i=1;i<grlen;i++){
            for(int j=1;j<gclen;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[grlen-1][gclen-1];
    }





    public static void main(String[] args) {
        int[][] grid =  new int[][]{{7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},{9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},{8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},{6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},{7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},{9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},{1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},{3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},{1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},{5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},{2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},{0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}};

        System.out.println(minPathSum(grid));
    }



}
