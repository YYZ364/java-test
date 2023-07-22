package com.ln.code.day;

import com.ln.code.binarytree.TreeNode;

public class num1026节点和其祖先之间的最大差值 {
    public int sum = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return sum;
    }

    public void dfs(TreeNode node, int max, int min){
        if(node == null)
            return;
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        if (node.left == null && node.right == null){
            sum = Math.max(sum, Math.abs(max - min));
        }
        dfs(node.left, max, min);
        dfs(node.right, max, min);
    }
}
