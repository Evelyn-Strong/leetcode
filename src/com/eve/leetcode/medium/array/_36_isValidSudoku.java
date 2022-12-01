package com.eve.leetcode.medium.array;

/**
 * Created by Eve on 2022/9/22.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *  
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board =
 * [["5','3','.','.','7','.','.','.','."]
 * ,["6','.','.','1','9','5','.','.','."]
 * ,[".','9','8','.','.','.','.','6','."]
 * ,["8','.','.','.','6','.','.','.','3"]
 * ,["4','.','.','8','.','3','.','.','1"]
 * ,["7','.','.','.','2','.','.','.','6"]
 * ,[".','6','.','.','.','.','2','8','."]
 * ,[".','.','.','4','1','9','.','.','5"]
 * ,[".','.','.','.','8','.','.','7','9"]]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board =
 * [["8','3','.','.','7','.','.','.','."]
 * ,["6','.','.','1','9','5','.','.','."]
 * ,[".','9','8','.','.','.','.','6','."]
 * ,["8','.','.','.','6','.','.','.','3"]
 * ,["4','.','.','8','.','3','.','.','1"]
 * ,["7','.','.','.','2','.','.','.','6"]
 * ,[".','6','.','.','.','.','2','8','."]
 * ,[".','.','.','4','1','9','.','.','5"]
 * ,[".','.','.','.','8','.','.','7','9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 *  
 * <p>
 * 提示：
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _36_isValidSudoku {

    public static  boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) return false;
            if (!isValidColumn(board, i)) return false;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValid33(board, i * 3, j * 3)) return false;
            }
        }
        return true;

    }

    private static boolean isValid33(char[][] board, int i, int j) {

        Set<Integer> set = new HashSet<>();
        for (int n = i; n < i + 3; n++) {
            for (int m = j; m < j + 3; m++) {
                if ('.' == board[n][m]) continue;
                Integer value = Integer.valueOf(board[n][m]);
                if (set.contains(value)) return false;
                else set.add(value);
            }

        }
        return true;

    }

    private static  boolean isValidRow(char[][] board, int i) {
        Set<Integer> set = new HashSet<>();
        for (int n = 0; n < 9; n++) {
            if ('.' == board[i][n]) continue;
            Integer value = Integer.valueOf(board[i][n]);
            if (set.contains(value)) return false;
            else set.add(value);
        }
        return true;
    }

    private static boolean isValidColumn(char[][] board, int i) {
        Set<Integer> set = new HashSet<>();
        for (int n = 0; n < 9; n++) {
            if ('.' == board[n][i]) continue;
            Integer value = Integer.valueOf(board[n][i]);
            if (set.contains(value)) return false;
            else set.add(value);
        }
        return true;
    }


    class Solution {
        //Hash表，一次遍历

        /**
         * 方法一：一次遍历
         有效的数独满足以下三个条件：

         同一个数字在每一行只能出现一次；

         同一个数字在每一列只能出现一次；

         同一个数字在每一个小九宫格只能出现一次。

         可以使用哈希表记录每一行、每一列和每一个小九宫格中，每个数字出现的次数。只需要遍历数独一次，在遍历的过程中更新哈希表中的计数，并判断是否满足有效的数独的条件即可。

         对于数独的第 ii 行第 jj 列的单元格，其中 0 \le i, j < 90≤i,j<9，该单元格所在的行下标和列下标分别为 ii 和 jj，该单元格所在的小九宫格的行数和列数分别为 \Big\lfloor \dfrac{i}{3} \Big\rfloor⌊
         3
         i
         ​
         ⌋ 和 \Big\lfloor \dfrac{j}{3} \Big\rfloor⌊
         3
         j
         ​
         ⌋，其中 0 \le \Big\lfloor \dfrac{i}{3} \Big\rfloor, \Big\lfloor \dfrac{j}{3} \Big\rfloor < 30≤⌊
         3
         i
         ​
         ⌋,⌊
         3
         j
         ​
         ⌋<3。

         由于数独中的数字范围是 11 到 99，因此可以使用数组代替哈希表进行计数。

         具体做法是，创建二维数组 \textit{rows}rows 和 \textit{columns}columns 分别记录数独的每一行和每一列中的每个数字的出现次数，创建三维数组 \textit{subboxes}subboxes 记录数独的每一个小九宫格中的每个数字的出现次数，其中 \textit{rows}[i][\textit{index}]rows[i][index]、\textit{columns}[j][\textit{index}]columns[j][index] 和 \textit{subboxes}\Big[\Big\lfloor \dfrac{i}{3} \Big\rfloor\Big]\Big[\Big\lfloor \dfrac{j}{3} \Big\rfloor\Big]\Big[\textit{index}\Big]subboxes[⌊
         3
         i
         ​
         ⌋][⌊
         3
         j
         ​
         ⌋][index] 分别表示数独的第 ii 行第 jj 列的单元格所在的行、列和小九宫格中，数字 \textit{index} + 1index+1 出现的次数，其中 0 \le \textit{index} < 90≤index<9，对应的数字 \textit{index} + 1index+1 满足 1 \le \textit{index} + 1 \le 91≤index+1≤9。

         如果 \textit{board}[i][j]board[i][j] 填入了数字 nn，则将 \textit{rows}[i][n - 1]rows[i][n−1]、\textit{columns}[j][n - 1]columns[j][n−1] 和 \textit{subboxes}\Big[\Big\lfloor \dfrac{i}{3} \Big\rfloor\Big]\Big[\Big\lfloor \dfrac{j}{3} \Big\rfloor\Big]\Big[n - 1\Big]subboxes[⌊
         3
         i
         ​
         ⌋][⌊
         3
         j
         ​
         ⌋][n−1] 各加 11。如果更新后的计数大于 11，则不符合有效的数独的条件，返回 \text{false}false。

         如果遍历结束之后没有出现计数大于 11 的情况，则符合有效的数独的条件，返回 \text{true}true。

         JavaC#JavaScriptC++Golang


         作者：LeetCode-Solution
         链接：https://leetcode.cn/problems/valid-sudoku/solution/you-xiao-de-shu-du-by-leetcode-solution-50m6/
         来源：力扣（LeetCode）
         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * @param board
         * @return
         */
        public boolean isValidSudoku(char[][] board) {
            int[][] rows = new int[9][9];
            int[][] columns = new int[9][9];
            int[][][] subboxes = new int[3][3][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c != '.') {
                        int index = c - '0' - 1;
                        rows[i][index]++;
                        columns[j][index]++;
                        subboxes[i / 3][j / 3][index]++;
                        if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public boolean isPalindrome(int x) {
            String num = x+"";
            int i = 0,j = num.length()-1;
            while(i<j){
                if(num.charAt(i) != num.charAt(j)) return false;
                else {
                    ++i;--j;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}}));
    }
}
