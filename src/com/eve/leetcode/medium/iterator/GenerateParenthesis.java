package com.eve.leetcode.medium.iterator;

import java.util.List;

/**
 * Created by Eve on 2022/8/8.
 */

/**
 *      括号生成
        数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

         

        示例 1：

        输入：n = 3
        输出：["((()))","(()())","(())()","()(())","()()()"]
        示例 2：

        输入：n = 1
        输出：["()"]
         

        提示：

        1 <= n <= 8

        作者：力扣 (LeetCode)
        链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xv33m7/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

public class GenerateParenthesis {
    //解题思路：
    //第一个必是left，最后一个必是right
    //数学归纳 dp（n）dp(n-1)
    //深度遍历 + 广度遍历
    //
    public static List<String> generateParenthesis(int n) {
        String left =  "(";
        String right = ")";

        return null;

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
