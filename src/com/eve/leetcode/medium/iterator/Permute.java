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
    //当n-1的时候也是一个全排列,元素是原先nums减少某个数

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result =  new LinkedList<>();

        iternums(nums,result);

        return result;

    }

    private static void iternums(int[] nums, List<List<Integer>> result){
        List<List<Integer>> tmp = new LinkedList<>();
        if(nums.length < 1) return;
        if(nums.length == 1){
            for (Iterator<List<Integer>> itr = result.iterator(); itr.hasNext(); ) {
                List<Integer> l = itr.next();
                l.add(nums[0]);
                tmp.add(l);
            }
            result = tmp;
            return;
        }

        for(int i=0; i< nums.length;i++){

            int[] tmpA = new int[]{} ;
            if(i==0) tmpA = Arrays.copyOfRange(nums,1,nums.length);
            else if(i==nums.length) tmpA = Arrays.copyOfRange(nums,0,nums.length-1);
            else {
                int[] array1 = Arrays.copyOfRange(nums,0,i-1);
                int[] array2 = Arrays.copyOfRange(nums,i+1,nums.length);
                System.arraycopy(array1, 0, tmpA, 0, array1.length);
                System.arraycopy(array2, 0, tmpA, array1.length, array2.length);
            }

            if(result.size()<1){
                List ls = new LinkedList<>();
                ls.add(nums[i]);
                result.add(ls);
            }else{
                for (Iterator<List<Integer>> itr = result.iterator(); itr.hasNext(); ) {
                    List<Integer> l = itr.next();
                    l.add(nums[i]);
                    tmp.add(l);
                }
                result=tmp;
            }
            iternums(tmpA,result);
        }


//
////        for(int i=0;i<nums.length;i++) {
////
////            if (idx == 0) {
////                List<Integer> l = new LinkedList<>();
////                l.add(nums[i]);
////                result.add(l);
////            } else {
////                for (Iterator<List<Integer>> itr = result.iterator(); itr.hasNext(); ) {
////                    if(i == idx ) break;
////                    List<Integer> l = itr.next();
////                    l.add(nums[i]);
////                    tmp.add(l);
////                }
////            }
////
////            iternums(nums,idx+1,result);
////        }
//        result = tmp;
    }


    public static void main(String[] args) {

        int[] inputs = new int[]{1,2,3};

        System.out.println(permute(inputs));

    }
}
