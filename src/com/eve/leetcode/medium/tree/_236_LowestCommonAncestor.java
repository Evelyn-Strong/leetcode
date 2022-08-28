package com.eve.leetcode.medium.tree;

/**
 * Created by Eve on 2022/8/15.
 */
public class _236_LowestCommonAncestor {

    //后续遍历组成的List是先子后父的顺序

    //递归
    //简介代码
//    解题思路：
//
//    两个节点 p,q 分为两种情况：
//
//    p 和 q 在相同子树中
//    p 和 q 在不同子树中
//    从根节点遍历，递归向左右子树查询节点信息
//    递归终止条件：如果当前节点为空或等于 p 或 q，则返回当前节点
//
//    递归遍历左右子树，如果左右子树查到节点都不为空，则表明 p 和 q 分别在左右子树中，因此，当前节点即为最近公共祖先；
//    如果左右子树其中一个不为空，则返回非空节点。
//
//    作者：guohaoding
//    链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-jian-j/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q ){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(right != null && left != null){
            return root;
        }else if(right != null){
            return right;
        }else if( left != null){
            return left;
        }

        return null;


    }


}
