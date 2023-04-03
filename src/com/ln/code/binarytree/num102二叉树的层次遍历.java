package com.ln.code.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class num102二叉树的层次遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        int len;
        while(!dq.isEmpty()){
            len = dq.size();
            List<Integer> path= new ArrayList<>();
            while(len > 0){
                TreeNode node = dq.poll();
                path.add(node.val);
                if(node.left != null)
                    dq.offer(node.left);
                if(node.right != null)
                    dq.offer(node.right);
                len--;
            }
            res.add(new ArrayList<>(path));
        }
        return res;
    }
}

