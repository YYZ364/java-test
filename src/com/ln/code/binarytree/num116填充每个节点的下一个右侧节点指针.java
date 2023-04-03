package com.ln.code.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class num116填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if(root == null)return root;
        Deque<Node> dq = new LinkedList<>();
        dq.offer(root);
        int len = dq.size();
        while(!dq.isEmpty()){
            len = dq.size();
            while(len > 0){
                Node node = dq.poll();
                if(!dq.isEmpty())
                    node.next = dq.peek();
                if(node.left != null)
                    dq.offer(node.left);
                if(node.right != null)
                    dq.offer(node.right);
                len --;
                if(len == 0){
                    node.next = null;
                }
            }
        }
        return root;
    }
}
