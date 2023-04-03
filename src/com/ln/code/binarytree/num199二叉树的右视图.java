package com.ln.code.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class num199二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)return res;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        int len = dq.size();
        while(!dq.isEmpty()){

            len = dq.size();
            while(len > 0){
                TreeNode node = dq.poll();
                if(node.left != null)
                    dq.offer(node.left);
                if(node.right != null)
                    dq.offer(node.right);
                len --;
                if(len == 0){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
