package com.ln.code.graph.unionfind;

public class num684冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length,index = 0;
        UF1 uf = new UF1(len);
        for(int[] edge : edges){
            int temp = uf.count();
            uf.union(edge[0], edge[1]);
            if(uf.count() == temp)
                return edge;
        }
        return edges[0];
    }
}

class UF1{
    private int count;
    private int[] parent;
    public UF1(int n){
        this.count = n;
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
    }

    public void union(int p, int q){
        if(find(p) == find(q))
            return;
        else{
            count --;
            parent[parent[q]] = parent[p];
        }
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean connected(int p, int q){
        int a = find(p);
        int b = find(q);
        return a == b;
    }

    public int count(){
        return count;
    }
}
