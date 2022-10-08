package com.eve.leetcode.competition;

import java.util.Arrays;

public class _20221002_airwallex {

    public int commonFactors(int a, int b) {
      int min =  Math.min(a,b);
      int ans = 0;
      for(int i = 1; i <=min; i++){
          if(a% i ==0 && b % i == 0 ){
              ans++;
          }
      }
      return ans;
    }

    public static int maxSum(int[][] grid) {
      int rlen = grid.length;
      int clen = grid[0].length;
      int max = 0;
      for(int i  = rlen - 3; i>=0; i --){
          for(int j = clen-3; j >=0; j--){
              max = Math.max(max, cal(grid,i,j));
          }
      }
      return max;
    }

    private static int cal(int[][] grid, int x, int y ){
       int sum  = 0;
       sum = grid[x][y]+ grid[x+2][y]
               +grid[x][y+1]+ grid[x+2][y+1]
               +grid[x][y+2]+ grid[x+2][y+2]
               + grid[x+1][y+1];
       return sum;
    }

    //阶梯思路：
    //
    public static int minimizeXor(int num1, int num2) {
        String b1 = Integer.toBinaryString(num1);
        String b2 = Integer.toBinaryString(num2);
        int zws2 = 0;
        int zws1 = 0;
        for(char c: b1.toCharArray()){
            if(c == '1') zws1++;
        }
        for(char c: b2.toCharArray()){
            if(c == '1') zws2++;
        }
        if(zws2 >= b1.length()){

            int[] ans = new int[zws2];
            Arrays.fill(ans,1);
            String s = "";
            for(int i: ans){
                s+="1";
            }
            return Integer.parseInt(s,2);
        }else if(zws2 >= zws1){
           int diff =  zws2-zws1;
           char[] ch = b1.toCharArray();
           int index = ch.length-1;
           while (diff >0){
               if(ch[index] == '0'){
                   ch[index] = '1';
                   diff--;
               }
               index--;
           }
           String s ="";
           for(char c: ch){
               s+=c;
           }
           return Integer.parseInt(s,2);
        }else{
            char[] ch = b1.toCharArray();
            for(int i  = 0;i < ch.length; i++){
                if(zws2 > 0 && ch[i] == '1'){
                    zws2--;
                }else {
                    ch[i] = '0';
                }
            }
            String s ="";
            for(char c: ch){
                s+=c;
            }
            return Integer.parseInt(s,2);
        }

    }

    /**
     * 6195. 对字母串可执行的最大删除数 显示英文描述
     * 通过的用户数715
     * 尝试过的用户数1405
     * 用户总通过次数959
     * 用户总提交次数3217
     * 题目难度Hard
     * 给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以：
     *
     * 删除 整个字符串 s ，或者
     * 对于满足 1 <= i <= s.length / 2 的任意 i ，如果 s 中的 前 i 个字母和接下来的 i 个字母 相等 ，删除 前 i 个字母。
     * 例如，如果 s = "ababc" ，那么在一步操作中，你可以删除 s 的前两个字母得到 "abc" ，因为 s 的前两个字母和接下来的两个字母都等于 "ab" 。
     *
     * 返回删除 s 所需的最大操作数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "abcabcdabc"
     * 输出：2
     * 解释：
     * - 删除前 3 个字母（"abc"），因为它们和接下来 3 个字母相等。现在，s = "abcdabc"。
     * - 删除全部字母。
     * 一共用了 2 步操作，所以返回 2 。可以证明 2 是所需的最大操作数。
     * 注意，在第二步操作中无法再次删除 "abc" ，因为 "abc" 的下一次出现并不是位于接下来的 3 个字母。
     * 示例 2：
     *
     * 输入：s = "aaabaab"
     * 输出：4
     * 解释：
     * - 删除第一个字母（"a"），因为它和接下来的字母相等。现在，s = "aabaab"。
     * - 删除前 3 个字母（"aab"），因为它们和接下来 3 个字母相等。现在，s = "aab"。
     * - 删除第一个字母（"a"），因为它和接下来的字母相等。现在，s = "ab"。
     * - 删除全部字母。
     * 一共用了 4 步操作，所以返回 4 。可以证明 4 是所需的最大操作数。
     * 示例 3：
     *
     * 输入：s = "aaaaa"
     * 输出：5
     * 解释：在每一步操作中，都可以仅删除 s 的第一个字母。
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 4000
     * s 仅由小写英文字母组成
     * @param s
     * @return
     */
    public int deleteString(String s) {
      //if

        //toDo
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(minimizeXor(65,84));
        //System.out.println(Integer.parseInt("11",2));
        //System.out.println(Integer.toBinaryString(65));
        //System.out.println(Integer.toBinaryString(84));
        //System.out.println(3^3);
        //System.out.println(maxSum(new int[][]{{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}}));

    }
}
