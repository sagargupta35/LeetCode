class Solution {
    public int cherryPickup(int[][] grid) {
        Integer [][][] dp = new Integer 
            [grid.length][grid[0].length][grid[0].length];
        return cherryPickUp(grid, dp, 0, 0, grid[0].length-1, 
                        grid.length, grid[0].length);
    }   
        
    public static int cherryPickUp(int [][] mat, 
        Integer [][][] dp, int i, int j1, int j2, int n, int m){
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return -1;
        if(i == n-1){
            if(j1 == j2) return mat[i][j1];
            return mat[i][j1] + mat[i][j2];
        }
        if(dp[i][j1][j2] != null) return dp[i][j1][j2];
        int max = -1;
        for(int i1 = -1; i1<2; i1++){
            for(int j = -1; j<2; j++){
                max = Math.max(
                    cherryPickUp(mat, dp, i+1, j1+i1, j2+j, n, m), max);
            }
        }
        if(j1 == j2) return dp[i][j1][j2] = mat[i][j1] + max;
        return dp[i][j1][j2] = mat[i][j1] + mat[i][j2] + max;
    }   
}       
