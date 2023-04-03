package com.ln.code.binarytree;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class num107二叉树的层次遍历2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        int len = dq.size();
        while(!dq.isEmpty()){
            List<Integer> items = new ArrayList<>();
            len = dq.size();
            while(len > 0){
                TreeNode node = dq.poll();
                items.add(node.val);
                if(node.left != null)
                    dq.offer(node.left);
                if(node.right != null)
                    dq.offer(node.right);
                len--;
            }
            res.add(items);
        }
        Collections.reverse(res);
        return res;
    }
}
