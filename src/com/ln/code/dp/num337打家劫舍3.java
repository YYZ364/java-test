package com.ln.code.dp;

import com.ln.code.binarytree.TreeNode;

public class num337打家劫舍3 {
    public int rob(TreeNode root) {
        int res[] = robb(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robb(TreeNode root){
        int res[] = new int[2];
        if(root == null){
            return res;
        }
        int left[] = robb(root.left);
        int right[] = robb(root.right);
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
