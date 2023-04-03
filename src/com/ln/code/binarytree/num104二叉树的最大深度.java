package com.ln.code.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class num104二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        int deep = 0;
        int len = dq.size();
        while(!dq.isEmpty()){
            deep ++;
            len = dq.size();
            while(len > 0){
                TreeNode node = dq.poll();
                if(node.left != null)
                    dq.offer(node.left);
                if(node.right != null)
                    dq.offer(node.right);
                len--;
            }
        }
        return deep;
    }
}
