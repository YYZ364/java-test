package com.ln.code.binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class num257二叉树的所有路径 {
    List<String> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        path.add(root.val);
        traceBack(root);
        return res;
    }

    public void traceBack(TreeNode node){
        if(node.left == null && node.right == null){
            StringBuilder sb = new StringBuilder();
            //将path转换为字符串
            sb.append(String.valueOf(path.get(0)));
            for(int i = 1;i < path.size();i++){
                sb.append("->").append(String.valueOf(path.get(i)));
            }
            res.add(sb.toString());
        }
        TreeNode cur = node;
        if(cur.left != null){
            path.add(cur.left.val);
            traceBack(cur.left);
            path.removeLast();
        }
        if(cur.right != null){
            path.add(cur.right.val);
            traceBack(cur.right);
            path.removeLast();
        }
    }

    @Test
    public void test(){
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2,  null, five);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1, two, three);
        System.out.println(binaryTreePaths(one));
    }
}
