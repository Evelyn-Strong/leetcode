//package com.eve.leetcode.medium.tree;
//
//import javafx.util.Pair;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * Created by Eve on 2022/8/27.
// */
//public class _662_widthOfBinaryTree {
//
//    /**
//     * 效率不高，但可以实现
//     */
////    static boolean finishFlag = false;
////
////    public static int widthOfBinaryTree(TreeNode root) {
////        Stack<TreeNode> stack = new Stack<>();
////        int max = 1;
////        stack.push(root);
////        if(root.left == null && root.right == null) return max;
////        while(stack.size()>0 && !finishFlag){
////            int len =  findNextLevel(stack);
////            if(max < len){
////                max = len;
////            }
////        }
////
////        return max;
////
////
////    }
////
////    private static int findNextLevel(Stack<TreeNode> stack){
////        int left=-1;
////        int right=-1;
////        int ssize = stack.size();
////        int count = 1;
////        boolean flag = false;
////        Stack<TreeNode> tmp = new Stack<>();
////        while(ssize>0){
////            TreeNode node = stack.pop();
////            if(node != null){
////                flag = true;
////                if(left == -1){
////                    left = count;
////                }
////                right = count;
////                tmp.push(node.left);
////                tmp.push(node.right);
////            }else{
////                tmp.push(null);
////                tmp.push(null);
////            }
////            count++;
////            ssize--;
////        }
////
////        while(!tmp.isEmpty()){
////            stack.push(tmp.pop());
////        }
////
////        if(flag) {
////            return right - left + 1;
////        }else{
////            finishFlag = true;
////            return 0;
////        }
/////**/
////    }
//
//    public static int widthOfBinaryTree(TreeNode root){
//        int max = 1;
//        if(root.left == null && root.right == null) return max;
//        List<Pair<TreeNode,Integer>> arr = new ArrayList<Pair<TreeNode,Integer>>();
//        arr.add(new Pair<TreeNode,Integer>(root,1));
//        while(!arr.isEmpty()){
//            List<Pair<TreeNode,Integer>> tmp = new ArrayList<>();
//            for(Pair<TreeNode,Integer> pair : arr){
//                TreeNode node = pair.getKey();
//                int index = pair.getValue();
//                if( node.left != null){
//                    tmp.add(new Pair<TreeNode,Integer>(node.left, index * 2));
//                }
//                if( node.right != null){
//                    tmp.add(new Pair<TreeNode,Integer>(node.right, index * 2 +1));
//                }
//            }
//            max = Math.max(max,arr.get(arr.size()-1).getValue() - arr.get(0).getValue() + 1);
//            arr = tmp;
//        }
//        return max;
//    }
//
//    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.left.left = new TreeNode(3);
//        node.left.right = new TreeNode(4);
//        node.right =  new TreeNode(5);
//        node.right.right = new TreeNode(6);
//
//
//        System.out.println(widthOfBinaryTree(node));
//    }
//}
