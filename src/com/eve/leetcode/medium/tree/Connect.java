package com.eve.leetcode.medium.tree;

/**
 * Created by Eve on 2022/8/7.
 */

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
        填充每个节点的下一个右侧节点指针
        给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

        struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
        }
        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

        初始状态下，所有 next 指针都被设置为 NULL。

         

        示例 1：



        输入：root = [1,2,3,4,5,6,7]
        输出：[1,#,2,3,#,4,5,6,7,#]
        解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
        示例 2:

        输入：root = []
        输出：[]
         

        提示：

        树中节点的数量在 [0, 212 - 1] 范围内
        -1000 <= node.val <= 1000
         

        进阶：

        你只能使用常量级额外空间。
        使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

        作者：力扣 (LeetCode)
        链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvijdh/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Connect {

    //解题思路：
    //dfs
    //找到每一层
    //前序遍历

    //方法一：
    //先遍历一遍，放在map中，再遍历的时候将next从map中取出，关联上
    public Node connect(Node root) {

        if(root == null) return new Node();
        Map<Integer,Queue<Node>> map =  new HashMap<>();
        dfs(root,0,map);
        map.forEach((k,v)->{
            v.poll().next=null;
        });
        return root;
    }


    private void dfs(Node node, int deep, Map<Integer,Queue<Node>> map){

        if(node == null ) return;

        if(map.containsKey(deep)){
            Queue<Node> qn = map.get(deep);
            qn.add(node);
            if(qn.size()>=1){
               qn.poll().next =  node;
            }
            map.put(deep,qn);
        }else{
            Queue<Node> qn = new LinkedBlockingQueue<>();
            qn.add(node);
            map.put(deep,qn);
        }
        //add left node
        dfs(node.left,deep+1,map);

        //add right node
        dfs(node.right,deep+1,map);

    }

    public static void main(String[] args) {

        Queue<Integer> qn = new LinkedBlockingQueue<>();
        qn.add(1);
        System.out.println(qn.poll());
        System.out.println(qn.poll());



    }
}
