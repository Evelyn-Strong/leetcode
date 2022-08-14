package com.eve.leetcode.medium.iterator;

/**
 * Created by Eve on 2022/8/13.
 */

/**
 * 79
 */
public class _79_Exist {

    //dfs

    public static boolean exist(char[][] board, String word) {
        if(word.length()>board.length*board[0].length) return false;

        char[] w = word.toCharArray();
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ;j < board[0].length;j++){
                if(board[i][j] == w[0]){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(canFind(board,visited,i,j,w,0))return true;
                }
            }

        }
        return false;

    }

    private static boolean canFind(char[][] board,
                            boolean[][] visited,
                            int r,
                            int c,
                            char[] w,
                            int idx){
        if(!isValid(board,r,c) || visited [r][c]){
            return false;
        }

        if(idx == (w.length-1) && w[idx] == board[r][c]){
            return true;
        }
        visited[r][c] =  true;
        if(w[idx] == board[r][c]){
            if(canFind(board,visited,r-1,c,w,idx+1) ||
            canFind(board,visited,r+1,c,w,idx+1) ||
            canFind(board,visited,r,c+1,w,idx+1) ||
            canFind(board,visited,r,c-1,w,idx+1) ){
                return true;
            }else{
                bactrack(board,visited,r,c);
                return false;
            }

        }else{
            visited[r][c] = false;
            return false;
        }
    }

    private static boolean isValid(char[][] board,int r, int c){
        int rl =  board.length;
        int cl =  board[0].length;
        if (( r>=0 && r < rl) && (c >= 0 && c < cl)){
            return true;
        }else{
            return false;
        }

    }
     private static void bactrack(char[][] board, boolean[][] visited, int r,int c){
         if(isValid(board,r,c)) visited[r][c]= false;
     }


    public static void main(String[] args) {

        //char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = new char[][]{{'a','b'},{'c','d'}};
        //char[][] board =  new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        //char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"cdba"));

    }
}
