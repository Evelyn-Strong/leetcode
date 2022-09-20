package com.eve.leetcode.medium.tree;

/**
 * Created by Eve on 2022/9/10.
 */

/**
 * 669. 修剪二叉搜索树
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 * <p>
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,0,2], low = 1, high = 2
 * 输出：[1,null,2]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * 输出：[3,2,null,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数在范围 [1, 104] 内
 * 0 <= Node.val <= 104
 * 树中每个节点的值都是 唯一 的
 * 题目数据保证输入是一棵有效的二叉搜索树
 * 0 <= low <= high <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/trim-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _669_trimBST {

//    static TreeNode ans;
//
//    public static TreeNode trimBST(TreeNode root, int low, int high) {
//        ans = root;
//        if (root == null) return root;
//        helper(null, root, low, high);
//        return ans;
//
//    }
//
//    private static TreeNode helper(TreeNode parent, TreeNode child, int low, int high) {
//        if (parent == null) {
//            if (child == null) return null;
//            if (child.val < low) {
//                ans = helper(null, child.right, low, high);
//            }
//            if (child.val > high) {
//                ans = helper(null, child.left, low, high);
//                ;
//            }
//        }
//        if (child == null) return null;
//        if (child.val < low) {
//            child.left = null;
//            child.right = helper(child, child.right, low, high);
//            if (child.right != null) {
//                return child.right;
//            } else {
//                return null;
//            }
//        } else {
//            child.left = helper(child, child.left, low, high);
//        }
//
//        if (child.val > high) {
//            child.right = null;
//            child.left = helper(child, child.left, low, high);
//            if (child.left != null) {
//                return child.left;
//            } else {
//                return null;
//            }
//        } else {
//            child.right = helper(child, child.right, low, high);
//        }
//        return child;
//    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val < low){
            return trimBST(root.right,low,high);
        }else if( root.val > high){
            return trimBST(root.left,low,high);
        }else{
            root.right = trimBST(root.right,low,high);
            root.left = trimBST(root.left,low,high);
            return root;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        trimBST(root, 6, 7);
        System.out.println(1);
    }

}
