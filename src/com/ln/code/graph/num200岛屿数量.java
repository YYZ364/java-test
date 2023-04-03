package com.ln.code.graph;

public class num200岛屿数量 {
    int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid[0].length,n = grid.length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == '1'){
                    res ++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j){
        int m = grid[0].length,n = grid.length;
        if(j < 0||j >= m||i < 0||i >= n){
            return;
        }
        if(grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        for(int[] dir:dirs){
            int line = dir[0], row = dir[1];
            dfs(grid,i + line,j + row);
        }
    }
}
