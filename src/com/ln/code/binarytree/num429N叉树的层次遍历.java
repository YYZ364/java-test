package com.ln.code.binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class num429N叉树的层次遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<Node> dq = new LinkedList<>();
        dq.offer(root);
        int len = dq.size();
        while(!dq.isEmpty()){
            len = dq.size();
            List<Integer> items = new ArrayList<>();
            while(len > 0){
                Node node = dq.poll();
                items.add(node.val);
                for(Node child : node.children){
                    if(child != null)
                        dq.offer(child);
                }
                len --;
            }
            res.add(items);
        }
        return res;
    }
    @Test
    public void test(){

    }
}
