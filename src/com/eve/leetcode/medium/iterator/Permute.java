package com.eve.leetcode.medium.iterator;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Eve on 2022/8/8.
 */
/*      全排列
        您已有成功提交记录，请确认是否跳过？

        跳过即视为本节
        已完成

        跳过

        重新做题
        给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

         

        示例 1：

        输入：nums = [1,2,3]
        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        示例 2：

        输入：nums = [0,1]
        输出：[[0,1],[1,0]]
        示例 3：

        输入：nums = [1]
        输出：[[1]]
         

        提示：

        1 <= nums.length <= 6
        -10 <= nums[i] <= 10
        nums 中的所有整数 互不相同

        作者：力扣 (LeetCode)
        链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvqup5/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Permute {

    //解题思路
    //迭代函数，当有全排列的时候
    //回溯算法， 而且记录已经visited 数据
    public static List<List<Integer>> result =  new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {

        List<Integer> reo = new LinkedList<>();
        boolean[] visited =  new boolean[nums.length];
        iternums(nums,0,reo,visited);
        return result;

    }

    private static void iternums(int[] nums, int deep, List<Integer> reo, boolean[] visited){

        if(reo.size() == nums.length){
            List<Integer> tmp = new LinkedList<>();
            tmp.addAll(reo);
            result.add(tmp);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if (visited[i]) continue;
            reo.add(nums[i]);
            visited[i] = true;
            iternums(nums,deep+1,reo,visited);
            reo.remove((Integer) nums[i]);
            visited[i] = false;
        }

    }


    public static void main(String[] args) {

        int[] inputs = new int[]{0,1};

        System.out.println(permute(inputs));

    }
}
