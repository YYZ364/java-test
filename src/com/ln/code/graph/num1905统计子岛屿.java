package com.ln.code.graph;

public class num1905统计子岛屿 {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1[0].length,n = grid1.length;
        int res = 0;
        for(int i = 0;i < n; i++){
            for(int j = 0;j < m; j++){
                if(grid1[i][j] == 0&&grid2[i][j] == 1){
                    dfs(grid2, i, j);
                }
            }
        }
        for(int i = 0;i < n; i++){
            for(int j = 0;j < m; j++){
                if(grid2[i][j] == 1){
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j){
        int m = grid[0].length, n = grid.length;
        if(i < 0||j < 0||i >= n||j >= m){
            return;
        }
        if(grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        for(int[] dir:dirs){
            int line = dir[0], row = dir[1];
            dfs(grid, i + line, j + row);
        }
    }
}
