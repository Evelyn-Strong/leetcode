package com.eve.leetcode.medium.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Eve on 2022/8/20.
 */
public class _654_ConstructMaximumBinaryTree {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        if (len == 1) return new TreeNode(nums[0]);

        TreeNode root = null;

        return itrNode(root, nums,0,nums.length-1);

    }
    //递归方法：

    private static TreeNode itrNode(TreeNode root, int[] nums, int start, int end){
        if(nums.length==0) return null;
        int index =  findMaxIndex( nums,start,end);
        root =  new TreeNode(nums[index]);
        if(index-start>0) root.left = itrNode(root.left,nums,start,index-1);
        if(end-index>0) root.right = itrNode(root.right,nums,index+1,end);
        return root;
    }

    private static int findMaxIndex(int[] nums ,int start, int end){
        if(nums.length==1) return start;
        int max = nums[start];
        int maxIndex = start;
        for (int i=start;i <= end;i++){
          if(nums[i]> max){
              maxIndex=i;
              max=nums[i];
          }
        }
        return maxIndex;
    }

    //单调栈方法：

    public static TreeNode constructMaximumBinaryTree_2(int[] nums){
        Deque<TreeNode> queue =  new ArrayDeque();
        queue.offer(new TreeNode(nums[0]));
        TreeNode root = null;
        for(int i = 1;i<nums.length;i++){
            TreeNode node = new TreeNode(nums[i]);
            if(node.val < queue.peekLast().val){
                queue.peekLast().right =  node;
                queue.addLast(node);
            }else if(node.val > queue.peekLast().val)
            {
                while(queue.size()>0){
                    if(node.val > queue.peekLast().val){
                        node.left =  queue.pollLast();
                    }else if(node.val < queue.peekLast().val){
                        queue.peekLast().right = node;
                        queue.addLast(node);
                        break;
                    }
                }
                //注意边界问题
                if(queue.size()==0){
                    queue.addLast(node);
                }

            }
        }

        while (queue.size()>0){
            root =  queue.pollLast();
        }

        return root;

    }

    public static void main(String[] args) {
        int[] nums= new int[]{3,2,1,6,0,5};
        System.out.println(constructMaximumBinaryTree(nums));
        System.out.println(constructMaximumBinaryTree_2(nums));
        System.out.println("finish");
    }
}
