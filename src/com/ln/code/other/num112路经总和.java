package com.ln.code.other;

import com.ln.code.binarytree.TreeNode;

import java.util.LinkedList;

public class num112路经总和 {
    LinkedList<TreeNode> path = new LinkedList<>();
    int sum = 0,flag = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        backTrace(root, targetSum);
        return flag == 1;

    }
    public void backTrace(TreeNode root, int targetSum){
        if(root == null)return;
        TreeNode cur = root;
        sum += cur.val;
        if(sum == targetSum&&root.left == null&&root.right == null){
            flag = 1;
            return;
        }
        if(root.left != null)
            backTrace(root.left, targetSum);
        if(root.right != null)
            backTrace(root.right, targetSum);
        sum -= cur.val;
    }
}
