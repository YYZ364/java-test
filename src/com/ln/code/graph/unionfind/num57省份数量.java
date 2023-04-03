package com.ln.code.graph.unionfind;

public class num57省份数量 {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        UF uf = new UF(len);
        for(int i = 0; i < len ;i++){
            for(int j = 0; j < i;j++){
                if(isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }
}

class UF{
    private int count;
    private int[] parent;
    public UF(int n){
        this.count = n;
        parent = new int[n];
        for(int i = 0; i < n; i++){
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


