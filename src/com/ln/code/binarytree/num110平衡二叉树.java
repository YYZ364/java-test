package com.ln.code.binarytree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class num110平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return treeHeight(root) != -1;
    }

    public int treeHeight(TreeNode root){
        if(root == null)return 0;
        int leftHeight = treeHeight(root.left);
        if(leftHeight == -1)return -1;
        int rightHeight = treeHeight(root.right);
        if(rightHeight == -1)return -1;

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        else
            return 1 + Math.max(leftHeight, rightHeight);
    }
}
