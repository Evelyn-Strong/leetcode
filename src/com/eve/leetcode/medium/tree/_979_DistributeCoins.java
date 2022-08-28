package com.eve.leetcode.medium.tree;

/**
 * Created by Eve on 2022/8/20.
 */
public class _979_DistributeCoins {

    //解题思路：
    //分治（拆分为子树，后续遍历，子节点上的节点）

    public int distributeCoins(TreeNode root) {
        childMoreCoins(root);
        return moveCount;
    }

    private int moveCount = 0;

    /**
     * 递归统计多余的硬币数
     * @param root
     * @return
     */
    private int childMoreCoins(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = childMoreCoins(root.left);
        int right = childMoreCoins(root.right);
        moveCount += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1;
    }

}
