package com.ln.code.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class num111二叉树的最小深度 {
    public int minDepth(TreeNode root) {
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
                if(node.left == null&&node.right == null&&deep > 1)
                    return deep;
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
