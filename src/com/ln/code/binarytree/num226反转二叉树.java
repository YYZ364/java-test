package com.ln.code.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class num226反转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.push(root);
        while(!dq.isEmpty()){
            TreeNode node = dq.pop();
            if(node.right != null)
                dq.push(node.right);
            if(node.left != null)
                dq.push(node.left);
            if(node.left != null||node.right != null){
                TreeNode temp;
                temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
        return root;
    }
//递归方式
    public void tranversal(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        tranversal(root.left);
        tranversal(root.right);
    }
}
