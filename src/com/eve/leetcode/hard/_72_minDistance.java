package com.eve.leetcode.hard;

/**
 * Created by Eve on 2022/9/25.
 *
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

 你可以对一个单词进行如下三种操作：

 插入一个字符
 删除一个字符
 替换一个字符
  

 示例 1：

 输入：word1 = "horse", word2 = "ros"
 输出：3
 解释：
 horse -> rorse (将 'h' 替换为 'r')
 rorse -> rose (删除 'r')
 rose -> ros (删除 'e')
 示例 2：

 输入：word1 = "intention", word2 = "execution"
 输出：5
 解释：
 intention -> inention (删除 't')
 inention -> enention (将 'i' 替换为 'e')
 enention -> exention (将 'n' 替换为 'x')
 exention -> exection (将 'n' 替换为 'c')
 exection -> execution (插入 'u')
  

 提示：

 0 <= word1.length, word2.length <= 500
 word1 和 word2 由小写英文字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/edit-distance
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _72_minDistance {


    public int minDistance(String word1, String word2) {
        //解题思路：
        //如果word1 比word2 长度长则使用替换+删除， 相反则插入+替换
        //word1 == word2 长度的时候 则都有可能
        //确定相同字符的顺序有多少个，再作确定
        //譬如： horse 与 ros ， 可以是os 和rs的顺序
        //例子二：intention 和execution 相吻合的顺序是etion（e 可以是第一位e 也可以是第三位的e），然后再对多余的位数做替换或者删除，或者插入， 这些操作数的和为在这些位数上不同的最大位数
        //譬如 e****tion，那么***e**tion 中e前面有三位都要操作，e后年有二位（但是word2种的额后有四位要操作，那么最小操作数也是4位）总共就是3+4=7次操作
        //但是如果匹配成**e**tion 和***e*tion 那么会有 3+2=5次操作，那么最少操作数位5次

        char[] w1 = word1.toCharArray();
        char[] w2  =word2.toCharArray();


        return 0;//TODO

    }

}
