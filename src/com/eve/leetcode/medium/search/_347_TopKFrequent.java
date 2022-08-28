package com.eve.leetcode.medium.search;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Eve on 2022/8/15.
 */

//
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//
//         
//
//        示例 1:
//
//        输入: nums = [1,1,1,2,2,3], k = 2
//        输出: [1,2]
//        示例 2:
//
//        输入: nums = [1], k = 1
//        输出: [1]
//         
//
//        提示：
//
//        1 <= nums.length <= 105
//        k 的取值范围是 [1, 数组中不相同的元素的个数]
//        题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
//         
//
//        进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小
//
//        作者：力扣 (LeetCode)
//        链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvzpxi/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class _347_TopKFrequent {


    //时间复杂度要优于O（nlogn）
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new ConcurrentHashMap<>();
        Integer minVal = -1;
        Integer minKey = -1;
        int index = 0;

        for(int i=0;i<nums.length;i++){
            if(map.containsKey((Integer)nums[i])){
                map.put((Integer)nums[i],map.get(nums[i])+1);
            }else{
                map.put((Integer)nums[i],1);
            }
        }
        int[] top = new int[k];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        //堆的方式
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(queue.size() == k){
               if(queue.peek()[1] < entry.getValue()){
                   queue.poll();
                   queue.offer(new int[]{entry.getKey(),entry.getValue()});
               }
            }else{
                queue.offer(new int[]{entry.getKey(),entry.getValue()});
            }


        }

        while(queue.size()>0){

            top[--k] = queue.poll()[0];
        }

      return top;
    }

    //快速排序
    private static int[] qsort(int[] nums){

        return null;

    }

    public static void main(String[] args) {

        int[] a = new int[]{5,2,5,3,5,3,1,1,3};
        int k =2;
        System.out.println(topKFrequent(a,k));
    }

}
