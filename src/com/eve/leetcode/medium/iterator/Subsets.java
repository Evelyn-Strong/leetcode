package com.eve.leetcode.medium.iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Eve on 2022/8/11.
 */
public class Subsets {
    //回溯算法
    //优化的话 就是选n个元素和length-n个元素是互补的。
    //譬如：【1，2，3】选1个元素和选2个元素可以分别为：
    //【1】，【2，3】；【2】，【1，3】；【3】，【1，2】
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> result0= new LinkedList<>();
        result.add(result0);
        if(nums == null || nums.length == 0) return result.stream().collect(Collectors.toList());


        boolean[] visited = new boolean[nums.length];

        for(int i=0; i<nums.length;i++){
            itersets(nums,i+1,visited,new LinkedList<>(),result);
        }
        return result;

    }

    private static void itersets(int[] nums, int n, boolean[] visited, List<Integer> set, List<List<Integer>> result ){
        if(set.size() == n){
            List<Integer> temp = new LinkedList<>();
            temp.addAll(set);
            result.add(temp);
        }

        if(n<0) return;
        for(int i=0; i< nums.length; i++)
               if(visited[i]) break;
               else{
                   set.add(nums[i]);
                   visited[i] = true;
                   itersets(nums,n,visited,set,result);
                   set.remove((Integer)nums[i]);
                   visited[i] =false;
               }

    }

    public static void main(String[] args) {
        int[] nums =  new int[]{1,2,3};
        System.out.println(subsets(nums));
    }
}
