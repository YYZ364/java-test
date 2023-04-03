package com.ln.code.binarytree;

import org.springframework.cache.interceptor.CacheableOperation;

import java.util.*;

public class num145二叉树的后序遍历 {
    //解法1
//    List<Integer> res = new ArrayList<>();
//    public List<Integer> postorderTraversal(TreeNode root) {
//        traversal(root);
//        return res;
//    }
//
//    private void traversal(TreeNode root){
//        if(root == null)
//            return;
//        traversal(root.left);
//        traversal(root.right);
//        res.add(root.val);
//    }

    //解法2
    //后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            stack.pop();
            res.add(node.val);
            if(node.left != null) stack.push(node.right);
            if(node.right !=null) stack.push(node.left);
        }
        Collections.reverse(res);
        return res;
    }
}
