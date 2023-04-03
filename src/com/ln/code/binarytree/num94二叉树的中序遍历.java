package com.ln.code.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class num94二叉树的中序遍历 {

    //解法1
//    List<Integer> res = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        traversal(root);
//        return res;
//    }
//
//    private void traversal(TreeNode root){
//        if(root == null)
//            return;
//        traversal(root.left);
//        res.add(root.val);
//        traversal(root.right);
//    }

    //解法2
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
