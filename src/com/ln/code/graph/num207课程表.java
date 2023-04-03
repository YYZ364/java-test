package com.ln.code.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class num207课程表 {
    boolean[] visited;
    boolean[] path;
    boolean flag = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = buildGraph(prerequisites, numCourses);
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        for (int i = 0;i < numCourses; i++){
            traversal(graph, i);
            Arrays.fill(visited, false);
        }
        return !flag;
    }

    public LinkedList<Integer>[] buildGraph(int[][] preprerequisites, int numCources){
        LinkedList<Integer>[] graph = new LinkedList[numCources];
        for(int i = 0;i < numCources;i++){
            graph[i] = new LinkedList<>();
        }
        for(int[] edge : preprerequisites){
            int to = edge[0],from = edge[1];
            graph[from].add(to);
        }
        return graph;
    }

    public void traversal(LinkedList<Integer>[] graph, int node){
        if(path[node]){
            flag = true;
            return;
        }
        if(visited[node])return;
        if(graph[node].size()==0)
            return;
        visited[node] = true;
        path[node] = true;
        for(int i : graph[node]){
            traversal(graph, i);
        }
        path[node] = false;
    }

    @Test
    public void test(){
        int n = 2;
//        int[][] nums = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
        int[][] nums ={{1,0},{0,1}};
        canFinish(n, nums);
        LinkedList<Integer> res = new LinkedList<>();
    }
}
