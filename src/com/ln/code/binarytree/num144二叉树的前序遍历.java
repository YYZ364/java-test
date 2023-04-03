package com.ln.code.binarytree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num144二叉树的前序遍历 {
    //解法1
//    List<Integer> res = new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        traversal(root);
//        return res;
//    }
//
//    private void traversal(TreeNode root){
//        if(root == null)
//            return;
//        res.add(root.val);
//        traversal(root.left);
//        traversal(root.right);
//    }
    //解法2
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
            if(node.right != null) stack.push(node.right);
            if(node.left !=null) stack.push(node.left);
        }
        return res;
    }
}
