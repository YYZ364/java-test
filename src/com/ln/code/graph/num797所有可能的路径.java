package com.ln.code.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class num797所有可能的路径 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        traversal(graph, 0);
        return res;
    }
    public void traversal(int[][] graph, int s){
        path.add(s);
        int len = graph.length;
        if(s == len - 1){
            res.add(new ArrayList<>(path));
        }
        for(int i :graph[s]){
            traversal(graph, i);
        }
        path.removeLast();
    }
}
