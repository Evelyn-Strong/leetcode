package com.eve.leetcode.medium.dp;

import java.util.Arrays;

/**
 * Created by Eve on 2022/9/3.
 *
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。

  

 示例 1:

 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 输出: 1
 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 示例 2:

 输入: intervals = [ [1,2], [1,2], [1,2] ]
 输出: 2
 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 示例 3:

 输入: intervals = [ [1,2], [2,3] ]
 输出: 0
 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
  

 提示:

 1 <= intervals.length <= 105
 intervals[i].length == 2
 -5 * 104 <= starti < endi <= 5 * 104

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/non-overlapping-intervals
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _435_eraseOverlapIntervals {





    //dp[i] 为 intervals[i]为结尾的最长数对
    //dp[i] = dp[j]+1 , dp[j]intervals[i][0] > intervals[j][1]的最长序列
    //但是 intervals 要先排序
    //dp[] 初始都为1 (根据dp[i]的定义，intervals[i]为结尾的最长数对，所以起始值至少为1)
    //=======
    //优化后的
    //当dj最大且满足情况下，无需在比较更短总间距内的


    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        int[] dp = new int[len];
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        Arrays.fill(dp,1);
        for(int i = 0 ; i < len ; i++){
            for(int j = i-1 ; j >= 0 ; j--){
                if(intervals[i][0] >= intervals[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    break;
                }
            }
        }
        return len - dp[len-1];

    }

    //需要优化
    public int _eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        int[] dp = new int[len];
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        Arrays.fill(dp,1);
        for(int i = 0 ; i < len ; i++){
            for(int j= 0 ; j < i; j++){
                if(intervals[i][0] >= intervals[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return len - dp[len-1];
    }


}
