package com.ln.code.graph;

public class num1254统计封闭岛屿的数目 {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int closedIsland(int[][] grid) {
        int res = 0;
        int m = grid[0].length, n = grid.length;
        if(m == 1||n == 1){
            return 0;
        }
        for(int i = 0;i < m;i++){
            dfs(grid, 0, i);
            dfs(grid, n - 1, i);
        }
        for(int i = 0;i < n;i++){
            dfs(grid, i, 0);
            dfs(grid, i, m - 1);
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 0){
                    res ++;
                    dfs(grid, i, j);
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
        if(grid[i][j] == 1)
            return;
        grid[i][j] = 1;
        for(int[] dir:dirs){
            int line = dir[0], row = dir[1];
            dfs(grid, i + line, j + row);
        }
    }
}
