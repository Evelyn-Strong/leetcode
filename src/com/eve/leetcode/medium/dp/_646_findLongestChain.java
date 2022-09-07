package com.eve.leetcode.medium.dp;

/**
 * Created by Eve on 2022/9/3.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 646. 最长数对链
 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。

 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。

 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。



 示例：

 输入：[[1,2], [2,3], [3,4]]
 输出：2
 解释：最长的数对链是 [1,2] -> [3,4]


 提示：

 给出数对的个数在 [1, 1000] 范围内。


 related to Question:435
 */

public class _646_findLongestChain {

    //dp[i] 为 pairs[i]为结尾的最长数对
    //dp[i] = dp[j]+1 , dp[j]是比pairs[i][0] > pairs[j][1]的最长序列
    //但是pairs 要先排序
    //dp[] 初始都为1
    //https://leetcode.cn/problems/maximum-length-of-pair-chain/solution/zui-chang-shu-dui-lian-by-leetcode-solut-ifpn/

    public int findLongestChain(int[][] pairs) {

        int[] dp = new int[pairs.length];
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        Arrays.fill(dp,1);

        for (int i = 0 ; i < pairs.length; i++){
            for(int j= i - 1; j>=0 ; j--){
               if(pairs[i][0]> pairs[j][1]){
                   dp[i] = Math.max(dp[j]+1,dp[i]);
               }
            }

        }
        return dp[pairs.length -1];

    }

}
