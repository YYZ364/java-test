package com.ln.code.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class num210课程表2 {
    boolean[] visited;
    boolean[] path;
    boolean flag = false;
    int num;
    LinkedList<Integer> res = new LinkedList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        num = numCourses;
        LinkedList<Integer>[] graph = buildGraph(prerequisites, numCourses);
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        for (int i = 0;i < numCourses; i++){
            traversal(graph, i);
        }
        System.out.println(res.size());
        int[] result = new int[res.size()];
        for(int i = 0;i < res.size();i++){
            result[i] = res.get(i);
        }
        return result;
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
        if(visited[node]||flag)return;
        visited[node] = true;
        path[node] = true;
        res.add(node);
        if(res.size() == num){
            return;
        }
        for(int i : graph[node]){
            traversal(graph, i);
        }
        path[node] = false;
    }
    @Test
    public void test(){
        int n = 4;
//        int[][] nums = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
        int[][] nums ={{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(findOrder(n, nums)));
    }
}
