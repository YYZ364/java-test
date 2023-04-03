package com.ln.code.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class num222二叉树的完全节点数 {
    public int countNodes(TreeNode root) {
        if(root == null)return 0;
        int sum = 0;
        Deque<TreeNode> dq = new ArrayDeque<>();
        int len;
        dq.offer(root);
        while(!dq.isEmpty()){
            len = dq.size();
            while(len > 0){
                TreeNode node = dq.poll();
                sum++;
                if(node.left != null){
                    dq.offer(node.left);
                }
                if(node.right != null){
                    dq.offer(node.right);
                }
                len--;
            }
        }
        return sum;
    }
}
